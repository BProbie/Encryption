package com.probie.encryption.Encrypter;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import com.probie.encryption.Encryption.Encryption;

public class MapEncrypter {

    private volatile static MapEncrypter INSTANCE;

    public synchronized static MapEncrypter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MapEncrypter();
        }
        return INSTANCE;
    }

    public String encryptByMap(Object visibleText) {
        // 获取映射表
        Object object = Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(Encryption.getKeyMap());
        HashMap<Character, Character> encryptMap = new HashMap<>();
        if (object == null) {
            ArrayList<Integer> values = new ArrayList<>();
            for (int i = Encryption.getAscllMin(); i <= Encryption.getAscllMax(); i++) {
                values.add(i);
            }
            Collections.shuffle(values);
            for (int i = Encryption.getAscllMin(); i <= Encryption.getAscllMax(); i++) {
                encryptMap.put((char) i, (char) ((int) values.toArray()[i-Encryption.getAscllMin()]));
            }
            Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().set(Encryption.getKeyMap(), Encryption.getInstance().getEncoderFactory().getSerializeEncoder().encodeSerialize(encryptMap));
        } else {
            encryptMap = (HashMap<Character, Character>) Encryption.getInstance().getDecoderFactory().getSerializeEncoder().decodeSerialize(object);
        }

        // 映射加密
        char[] chars = visibleText.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = encryptMap.getOrDefault(chars[i], chars[i]);
        }
        return new String(chars);
    }

}
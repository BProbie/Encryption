package com.probie.encryption.Decrypter;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import com.probie.encryption.Encryption.Encryption;

public class MapDecrypter {

    private volatile static MapDecrypter INSTANCE;

    public synchronized static MapDecrypter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MapDecrypter();
        }
        return INSTANCE;
    }

    public String decryptByMap(Object invisibleText) {
        // 获取映射表
        Object object = Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(Encryption.getKeyMap());
        HashMap<Character, Character> encryptMap = new HashMap<>();
        HashMap<Character, Character> decryptMap = new HashMap<>();
        if (object == null) {
            ArrayList<Integer> values = new ArrayList<>();
            for (int i = Encryption.getAscllMin(); i <= Encryption.getAscllMax(); i++) {
                values.add(i);
            }
            Collections.shuffle(values);
            for (int i = Encryption.getAscllMin(); i <= Encryption.getAscllMax(); i++) {
                encryptMap.put((char) i, (char) ((int) values.toArray()[i-Encryption.getAscllMin()]));
                decryptMap.put((char) ((int) values.toArray()[i-Encryption.getAscllMin()]), (char) i);
            }
            Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().set(Encryption.getKeyMap(), Encryption.getInstance().getEncoderFactory().getSerializeEncoder().encodeSerialize(encryptMap));
        } else {
            encryptMap = (HashMap<Character, Character>) Encryption.getInstance().getDecoderFactory().getSerializeEncoder().decodeSerialize(object);
            Object[] keys = encryptMap.keySet().toArray();
            Object[] values = encryptMap.values().toArray();
            for (int i = 0; i < keys.length; i++) {
                decryptMap.put(values[i].toString().toCharArray()[0], keys[i].toString().toCharArray()[0]);
            }
        }

        // 映射解密
        char[] chars = invisibleText.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = decryptMap.getOrDefault(chars[i], chars[i]);
        }
        return new String(chars);
    }

}
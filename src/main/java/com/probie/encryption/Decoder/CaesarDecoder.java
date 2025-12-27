package com.probie.encryption.Decoder;

import com.probie.encryption.Encryption.Encryption;

public class CaesarDecoder {

    private volatile static CaesarDecoder INSTANCE;

    public static CaesarDecoder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CaesarDecoder();
        }
        return INSTANCE;
    }

    public String decodeCaesar(Object invisibleText) {
        return decodeCaesar(invisibleText, Integer.parseInt(Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(Encryption.getKeyCaesar(), 3).toString()));
    }

    public String decodeCaesar(Object invisibleText, int index) {
        char[] chars = invisibleText.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] - index);
        }
        return new String(chars);
    }

    public String decodeCaesarUnsigned(Object invisibleTextUnsigned) {
        return decodeCaesarUnsigned(invisibleTextUnsigned, Integer.parseInt(Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(Encryption.getKeyCaesar(), 3).toString()));
    }

    public String decodeCaesarUnsigned(Object invisibleTextUnsigned, int index) {
        String invisibleText = Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(invisibleTextUnsigned, invisibleTextUnsigned).toString();
        char[] chars = invisibleText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] - index);
        }
        return new String(chars);
    }

}
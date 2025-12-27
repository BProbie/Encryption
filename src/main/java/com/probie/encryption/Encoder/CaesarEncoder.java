package com.probie.encryption.Encoder;

import com.probie.encryption.Encryption.Encryption;

public class CaesarEncoder {

    private volatile static CaesarEncoder INSTANCE;

    public static CaesarEncoder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CaesarEncoder();
        }
        return INSTANCE;
    }

    public String encodeCaesar(Object visibleText) {
        return encodeCaesar(visibleText, Integer.parseInt(Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(Encryption.getKeyCaesar(), 3).toString()));
    }

    public String encodeCaesar(Object visibleText, int index) {
        if (Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(Encryption.getKeyCaesar(), Encryption.getKeyCaesar()).equals(Encryption.getKeyCaesar())) {
            Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().set(Encryption.getKeyCaesar(), index);
        }
        char[] chars = visibleText.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + index);
        }
        return new String(chars);
    }

    public String encodeCaesarUnsigned(Object visibleText) {
        return encodeCaesarUnsigned(visibleText, Integer.parseInt(Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(Encryption.getKeyCaesar(), 3).toString()));
    }

    public String encodeCaesarUnsigned(Object visibleText, int index) {
        if (Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(Encryption.getKeyCaesar(), Encryption.getKeyCaesar()).equals(Encryption.getKeyCaesar())) {
            Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().set(Encryption.getKeyCaesar(), index);
        }
        char[] chars = visibleText.toString().toCharArray();
        String invisibleText = "";
        String invisibleTextUnsigned = "";
        for (char aChar : chars) {
            invisibleTextUnsigned += (char) (aChar + index);
        }
        for (char aChar : chars) {
            invisibleTextUnsigned += Encryption.getInstance().getWorderFactory().getUnsigneder().unsignedAscll(aChar + index);
        }
        Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().set(invisibleTextUnsigned, invisibleText);
        return invisibleTextUnsigned;
    }

}
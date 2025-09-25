package com.probie.encryption.Encoder;

import com.probie.encryption.Encryption;

public class XOEncoder {

    private volatile static XOEncoder INSTANCE;

    public synchronized static XOEncoder getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new XOEncoder();
        }
        return INSTANCE;
    }

    public String encodeXO(Object visibleText) {
        Object xor = Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(Encryption.getKeyXO());
        if (xor == null) {
            return encodeXO(visibleText, Encryption.getInstance().getWorderFactory().getRandomer().getRandomAscll());
        } else {
            return encodeXO(visibleText, xor.toString().toCharArray()[0]);
        }
    }

    public String encodeXO(Object visibleText, int xor) {
        return encodeXO(visibleText, (char) xor);
    }

    public String encodeXO(Object visibleText, char xor) {
        if (!Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(Encryption.getKeyXO(), Encryption.getKeyXO()).equals(xor)) {
            Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().set(Encryption.getKeyXO(), xor);
        }
        char[] chars = visibleText.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] ^= xor;
        }
        return new String(chars);
    }

    public String encodeXOUnsigned(Object visibleText) {
        Object xor = Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(Encryption.getKeyXO());
        if (xor == null) {
            return encodeXOUnsigned(visibleText, Encryption.getInstance().getWorderFactory().getRandomer().getRandomAscll());
        } else {
            return encodeXOUnsigned(visibleText, xor.toString().toCharArray()[0]);
        }
    }

    public String encodeXOUnsigned(Object visibleText, int xor) {
        return encodeXOUnsigned(visibleText, (char) xor);
    }

    public String encodeXOUnsigned(Object visibleText, char xor) {
        if (Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(Encryption.getKeyXO(), Encryption.getKeyXO()).equals(Encryption.getKeyXO())) {
            Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().set(Encryption.getKeyXO(), xor);
        }
        char[] chars = visibleText.toString().toCharArray();
        String invisibleText = "";
        String invisibleTextUnsigned = "";
        for (char aChar : chars) {
            invisibleText += (char) (aChar ^ xor);
        }
        for (char aChar : chars) {
            invisibleTextUnsigned += (char) Encryption.getInstance().getWorderFactory().getUnsigneder().unsignedAscll(aChar ^ xor);
        }
        Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().set(invisibleTextUnsigned, invisibleText);
        return invisibleTextUnsigned;
    }

}
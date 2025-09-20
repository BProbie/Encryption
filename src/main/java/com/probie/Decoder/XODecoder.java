package com.probie.Decoder;

import com.probie.Encryption;

public class XODecoder {

    private volatile static XODecoder INSTANCE;

    public synchronized static XODecoder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new XODecoder();
        }
        return INSTANCE;
    }

    public String decodeXO(String invisibleText) {
        Object xor = Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(Encryption.getKeyXO());
        if (xor != null) {
            return decodeXO(invisibleText, xor.toString().toCharArray()[0]);
        }
        return null;
    }

    public String decodeXO(String invisibleText, int xor) {
        return decodeXO(invisibleText, (char) xor);
    }

    public String decodeXO(String invisibleText, char xor) {
        char[] chars = invisibleText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ xor);
        }
        return new String(chars);
    }

    public String decodeXOUnsigned(String invisibleTextUnsigned) {
        Object xor = Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(Encryption.getKeyXO());
        if (xor != null) {
            return decodeXOUnsigned(invisibleTextUnsigned, xor.toString().toCharArray()[0]);
        }
        return null;
    }

    public String decodeXOUnsigned(String invisibleTextUnsigned, int xor) {
        return decodeXOUnsigned(invisibleTextUnsigned, (char) xor);
    }

    public String decodeXOUnsigned(String invisibleTextUnsigned, char xor) {
        String invisibleText = Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().get(invisibleTextUnsigned, invisibleTextUnsigned).toString();
        char[] chars = invisibleText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) Encryption.getInstance().getWorderFactory().getUnsigneder().unsignedAscll(chars[i] ^ xor);
        }
        return new String(chars);
    }

}
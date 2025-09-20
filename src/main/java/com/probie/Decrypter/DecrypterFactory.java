package com.probie.Decrypter;

public class DecrypterFactory {

    private volatile static DecrypterFactory INSTANCE;

    public synchronized static DecrypterFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DecrypterFactory();
        }
        return INSTANCE;
    }

    public MapDecrypter getMapDecrypter() {
        return MapDecrypter.getInstance();
    }

}
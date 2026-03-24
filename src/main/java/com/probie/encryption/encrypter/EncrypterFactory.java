package com.probie.encryption.encrypter;

public class EncrypterFactory {

    private volatile static EncrypterFactory INSTANCE;

    public synchronized static EncrypterFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EncrypterFactory();
        }
        return INSTANCE;
    }

    public MapEncrypter getMapEncrypter() {
        return MapEncrypter.getInstance();
    }

}
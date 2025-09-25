package com.probie.encryption.Config;

public class ConfigFactory {

    private volatile static ConfigFactory INSTANCE;

    public synchronized static ConfigFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConfigFactory();
        }
        return INSTANCE;
    }

    public KeyConfig getKeyConfig() {
        return KeyConfig.getInstance();
    }

}
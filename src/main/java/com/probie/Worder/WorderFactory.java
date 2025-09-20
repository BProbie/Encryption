package com.probie.Worder;

public class WorderFactory {

    private volatile static WorderFactory INSTANCE;

    public synchronized static WorderFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WorderFactory();
        }
        return INSTANCE;
    }

    public Randomer getRandomer() {
        return Randomer.getInstance();
    }

    public Unsigneder getUnsigneder() {
        return Unsigneder.getInstance();
    }

}
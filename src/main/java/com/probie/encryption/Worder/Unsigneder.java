package com.probie.encryption.Worder;

import com.probie.encryption.Encryption.Encryption;

public class Unsigneder {

    private volatile static Unsigneder INSTANCE;

    public synchronized static Unsigneder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Unsigneder();
        }
        return INSTANCE;
    }

    public int unsignedAscll(int ascllCode) {
        while (ascllCode < Encryption.getAscllMin()) {
            ascllCode += Encryption.getAscllMin();
        }
        while (ascllCode > Encryption.getAscllMax()) {
            ascllCode -= Encryption.getAscllMax();
        }
        return ascllCode;
    }

    public char unsignedAscll(char ascllChar) {
        return (char) unsignedAscll((int) ascllChar);
    }

}
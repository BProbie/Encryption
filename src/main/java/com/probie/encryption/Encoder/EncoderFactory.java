package com.probie.encryption.Encoder;

public class EncoderFactory {

    private volatile static EncoderFactory INSTANCE;

    public synchronized static EncoderFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EncoderFactory();
        }
        return INSTANCE;
    }

    public XOEncoder getXOEncoder() {
        return XOEncoder.getINSTANCE();
    }

    public Base64Encoder getBase64Encoder() {
        return Base64Encoder.getInstance();
    }

    public CaesarEncoder getCaesarEncoder() {
        return CaesarEncoder.getInstance();
    }

    public SerializeEncoder getSerializeEncoder() {
        return SerializeEncoder.getInstance();
    }

}
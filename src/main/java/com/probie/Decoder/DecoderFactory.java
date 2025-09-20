package com.probie.Decoder;

public class DecoderFactory {

    private volatile static DecoderFactory INSTANCE;

    public synchronized static DecoderFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DecoderFactory();
        }
        return INSTANCE;
    }

    public XODecoder getXODecoder() {
        return XODecoder.getInstance();
    }

    public Base64Decoder getBase64Decoder() {
        return Base64Decoder.getInstance();
    }

    public CaesarDecoder getCaesarDecoder() {
        return CaesarDecoder.getInstance();
    }

    public SerializeDecoder getSerializeEncoder() {
        return SerializeDecoder.getInstance();
    }

}
package com.probie.encryption.Decoder;

import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Base64Decoder {

    private volatile static Base64Decoder INSTANCE;

    public synchronized static Base64Decoder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Base64Decoder();
        }
        return INSTANCE;
    }

    public String decodeBase64(Object invisibleText) {
        return new String(Base64.getDecoder().decode(invisibleText.toString()), StandardCharsets.UTF_8);
    }

}
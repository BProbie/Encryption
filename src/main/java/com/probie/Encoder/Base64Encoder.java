package com.probie.Encoder;

import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Base64Encoder {

    private volatile static Base64Encoder INSTANCE;

    public synchronized static Base64Encoder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Base64Encoder();
        }
        return INSTANCE;
    }

    public String encodeBase64(Object visibleText) {
        return Base64.getEncoder().encodeToString(visibleText.toString().getBytes(StandardCharsets.UTF_8));
    }

}
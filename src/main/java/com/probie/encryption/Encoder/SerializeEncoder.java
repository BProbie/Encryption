package com.probie.encryption.Encoder;

import java.util.Base64;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ByteArrayOutputStream;

public class SerializeEncoder {

    private volatile static SerializeEncoder INSTANCE;

    public static SerializeEncoder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SerializeEncoder();
        }
        return INSTANCE;
    }

    public Object encodeSerialize(Object visibleText) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(visibleText);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
    }

}
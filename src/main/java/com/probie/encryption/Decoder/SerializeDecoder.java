package com.probie.encryption.Decoder;

import java.util.Base64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ByteArrayInputStream;

public class SerializeDecoder {

    private volatile static SerializeDecoder INSTANCE;

    public static SerializeDecoder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SerializeDecoder();
        }
        return INSTANCE;
    }

    public Object decodeSerialize(Object invisibleText) {
        byte[] bytes = Base64.getDecoder().decode(invisibleText.toString());
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }

}
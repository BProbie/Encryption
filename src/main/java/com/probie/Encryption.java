package com.probie;

import com.probie.Worder.WorderFactory;
import com.probie.Config.ConfigFactory;
import com.probie.Encoder.EncoderFactory;
import com.probie.Decoder.DecoderFactory;
import com.probie.Decrypter.DecrypterFactory;
import com.probie.Encrypter.EncrypterFactory;


public class Encryption {

    private volatile static Encryption INSTANCE;

    private volatile static String filePath = System.getProperty("user.dir") + "\\" + "Key";
    private volatile static int ascllMin = 33;
    private volatile static int ascllMax = 126;

    private volatile static String keyMap = "map";
    private volatile static String keyXO = "xor";
    private volatile static String keyCaesar = "caesar";

    public synchronized static Encryption getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Encryption();
        }
        return INSTANCE;
    }

    public WorderFactory getWorderFactory() {
        return WorderFactory.getInstance();
    }

    public ConfigFactory getConfigFactory() {
        return ConfigFactory.getInstance();
    }

    public EncoderFactory getEncoderFactory() {
        return EncoderFactory.getInstance();
    }

    public DecoderFactory getDecoderFactory() {
        return DecoderFactory.getInstance();
    }

    public EncrypterFactory getEncrypterFactory() {
        return EncrypterFactory.getInstance();
    }

    public DecrypterFactory getDecrypterFactory() {
        return DecrypterFactory.getInstance();
    }

    public static void setFilePath(String filePath) {
        Encryption.filePath = filePath;
        Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().setFilePath(filePath).connect();
    }

    public static String getFilePath() {
        return filePath;
    }

    public static void setAscllMin(int ascllMin) {
        Encryption.ascllMin = ascllMin;
    }

    public static int getAscllMin() {
        return ascllMin;
    }

    public static void setAscllMax(int ascllMax) {
        Encryption.ascllMax = ascllMax;
    }

    public static int getAscllMax() {
        return ascllMax;
    }

    public static void setKeyMap(String keyMap) {
        Encryption.keyMap = keyMap;
    }

    public static String getKeyMap() {
        return keyMap;
    }

    public static void setKeyXO(String keyXO) {
        Encryption.keyXO = keyXO;
    }

    public static String getKeyXO() {
        return keyXO;
    }

    public static void setKeyCaesar(String keyCaesar) {
        Encryption.keyCaesar = keyCaesar;
    }

    public static String getKeyCaesar() {
        return keyCaesar;
    }

}
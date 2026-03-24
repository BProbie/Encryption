package com.probie.encryption.encryption;

import java.io.File;
import java.lang.management.ManagementFactory;
import com.probie.encryption.config.ConfigFactory;
import com.probie.encryption.worder.WorderFactory;
import com.probie.encryption.encoder.EncoderFactory;
import com.probie.encryption.decoder.DecoderFactory;
import com.probie.encryption.decrypter.DecrypterFactory;
import com.probie.encryption.encrypter.EncrypterFactory;

public class Encryption {

    private final String NAME = "Encryption";
    private final String VERSION = "v2.5.0";

    private volatile static Encryption INSTANCE;

    public synchronized static Encryption getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Encryption();
        }
        return INSTANCE;
    }

    private volatile static String filePath = System.getProperty("user.dir")+File.separator+"Key";
    private volatile static int ascllMin = 33;
    private volatile static int ascllMax = 126;

    private volatile static String keyMap = "map";
    private volatile static String keyXO = "xor";
    private volatile static String keyCaesar = "caesar";

    public boolean isDebug() {
        for (String arg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            if (arg.contains("-agentlib:jdwp") || arg.contains("Xdebug") || arg.contains("-Xrunjdwp")) {
                return true;
            }
        }
        return false;
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
        Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().setFullFilePath(filePath);
        Encryption.getInstance().getConfigFactory().getKeyConfig().getLocalDB().connect();
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
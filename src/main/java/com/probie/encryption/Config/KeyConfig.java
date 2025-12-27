package com.probie.encryption.Config;

import com.probie.easydb.EasyDB.EasyDB;
import com.probie.encryption.Encryption.Encryption;
import com.probie.easydb.Database.Local.LocalDB;

/**
 * 密钥配置文件
 * */
public class KeyConfig {

    private volatile static KeyConfig INSTANCE;
    public volatile static LocalDB localDB;

    public synchronized static KeyConfig getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new KeyConfig();
        }
        return INSTANCE;
    }

    public synchronized LocalDB getLocalDB() {
        if (localDB == null) {
            localDB = EasyDB.getInstance().getLocalDatabaseFactory().buildLocalDB();
            localDB.setFullFilePath(Encryption.getFilePath());
            localDB.connect();
        }
        return localDB;
    }

}
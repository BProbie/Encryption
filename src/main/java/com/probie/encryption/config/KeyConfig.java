package com.probie.encryption.config;

import com.probie.easydb.easydb.EasyDB;
import com.probie.easydb.database.local.LocalDB;
import com.probie.encryption.encryption.Encryption;

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
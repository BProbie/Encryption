package com.probie.Config;

import com.probie.EasyDB;
import com.probie.Encryption;
import com.probie.Database.Local.LocalDB;

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
            localDB.setFilePath(Encryption.getFilePath());
            localDB.connect();
        }
        return localDB;
    }

}
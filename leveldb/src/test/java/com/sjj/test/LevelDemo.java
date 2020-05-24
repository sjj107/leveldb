package com.sjj.test;

import org.iq80.leveldb.DB;
import org.iq80.leveldb.DBFactory;
import org.iq80.leveldb.Options;
import org.iq80.leveldb.impl.Iq80DBFactory;

import java.io.File;
import java.io.IOException;

/**
 * @Description TODO
 * @Author sjj
 * @Date 2019/9/11 23:45
 */
public class LevelDemo {
    public static void main(String[] args) {
        String FILE_DIR = "E:\\data\\leveldb";
        DBFactory factory = new Iq80DBFactory();
        Options options = new Options();
        DB db;
        try {
            db = factory.open(new File(FILE_DIR), options);
            db.put("key".getBytes(),"value".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

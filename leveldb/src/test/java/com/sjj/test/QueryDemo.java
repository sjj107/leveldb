package com.sjj.test;

import org.iq80.leveldb.DB;
import org.iq80.leveldb.DBFactory;
import org.iq80.leveldb.DBIterator;
import org.iq80.leveldb.Options;
import org.iq80.leveldb.impl.Iq80DBFactory;

import java.io.File;
import java.io.IOException;

import static org.iq80.leveldb.impl.Iq80DBFactory.asString;

public class QueryDemo {
    public static void main(String[] args) throws IOException {

        String FILE_DIR = "E:\\data\\leveldb";
        DBFactory factory = new Iq80DBFactory();
        Options options = new Options();
        DB db = null;
        try {
            db = factory.open(new File(FILE_DIR), options);
            db.put("key1".getBytes(),"valu11e".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        DBIterator iterator = db.iterator();
        try {
            for(iterator.seekToFirst(); iterator.hasNext(); iterator.next()) {
                String key = asString(iterator.peekNext().getKey());
                String value = asString(iterator.peekNext().getValue());
                System.out.println(key+" = "+value);
            }
        } finally {
            // Make sure you close the iterator to avoid resource leaks.
            iterator.close();
        }
    }
}

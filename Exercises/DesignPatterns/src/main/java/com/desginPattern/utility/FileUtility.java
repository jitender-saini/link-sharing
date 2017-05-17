package com.desginPattern.utility;

class FileUtility {
    private static FileUtility fileInstance;

    private FileUtility() {
    }

    static FileUtility getInstance() {
        if(fileInstance ==null) {
            synchronized (FileUtility.class) {
                if(fileInstance==null) {
                    fileInstance=new FileUtility();
                }
            }
        }
        return fileInstance;
    }
    void readFile() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("reading file.....");
    }
}
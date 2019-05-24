package util;

import org.junit.Test;

public class FileTests {
    //~ Methods ----------------------------------------------------------------
    @Test
    public void createFile() {
        FileUtil.createFolder("playground/aaa");
        FileUtil.createFile("playground/bbb", "aaaa");
        FileUtil.createFile("playground/ccc/c1", "aaaa");
        FileUtil.createFile("playground/ccc/c2", "aaaa");

        System.out.println(FileUtil.exist("playground/aaa"));
        System.out.println(FileUtil.exist("playground/bbb"));
    }

    @Test
    public void delFile() {
        FileUtil.delFile("playground/bbb");
        FileUtil.delFolder("playground/aaa");
        FileUtil.delAllFiles("playground/ccc");
    }

    @Test
    public void moveFolder() {
        FileUtil.createFile("playground/ccc/c1", "aaaa");
        FileUtil.createFile("playground/ccc/c2", "aaaa");
        FileUtil.moveFolder("playground/ccc", "playground/ddd");
    }
}

// End FileTests.java

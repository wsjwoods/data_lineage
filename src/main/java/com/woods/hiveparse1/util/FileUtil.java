package com.woods.hiveparse1.util;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

    //~ Constructors -----------------------------------------------------------

    private FileUtil() {
    }

    //~ Methods ----------------------------------------------------------------

    @NotNull
    public static String read(String filePathAndName) {
        return read(filePathAndName, "utf-8");
    }

    /**
     * 读取文本文件内容
     *
     * @param filePathAndName 带有完整绝对路径的文件名
     * @param encoding        文本文件打开的编码方式
     * @return 返回文本文件的内容
     */
    @org.jetbrains.annotations.NotNull
    public static String read(String filePathAndName, String encoding) {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(filePathAndName);
             InputStreamReader isr = Check.isEmpty(encoding) ? new InputStreamReader(fis)
                     : new InputStreamReader(fis, encoding.trim());
             BufferedReader br = new BufferedReader(isr)) {

            String data;
            while ((data = br.readLine()) != null) {
                sb.append(data).append('\n');
            }
            return sb.toString();
        } catch (IOException es) {
            es.printStackTrace();
            return "";
        }
    }

    public static boolean exist(String file) {
        return new File(file).exists();
    }

    public static boolean createFolder(String folderPath) {
        try {
            Files.createDirectories(Paths.get(folderPath));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 新建文件
     *
     * @param filePathAndName 文本文件完整绝对路径及文件名
     * @param fileContent     文本文件内容
     * @return True if successfully created the file and write the content to the file.
     */
    public static boolean createFile(String filePathAndName, String fileContent) {
        return createFile(filePathAndName, fileContent, StandardCharsets.UTF_8);
    }

    /**
     * 有编码方式的文件创建
     *
     * @param filePathAndName 文本文件完整绝对路径及文件名
     * @param fileContent     文本文件内容
     * @param encoding        编码方式 例如 GBK 或者 UTF-8
     * @return True if successfully created the file and write the content to the file.
     */
    public static boolean createFile(String filePathAndName, String fileContent, Charset encoding) {
        File file = new File(filePathAndName);
        boolean success = file.getParentFile().mkdirs();
        try (BufferedWriter bw = Files.newBufferedWriter(file.toPath(), encoding)) {
            bw.write(fileContent);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    public static boolean delFile(String file) {
        return new File(file).delete();
    }

    public static boolean delFolder(String folder) {
        try {
            FileUtils.deleteDirectory(new File(folder));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delAllFiles(String folder) {
        try {
            FileUtils.cleanDirectory(new File(folder));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void copyFolder(String sourceFolder, String destFolder) {
        File source = new File(sourceFolder);
        File dest = new File(destFolder);
        try {
            FileUtils.copyDirectory(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void moveFolder(String sourceFolder, String destFolder) {
        copyFolder(sourceFolder, destFolder);
        delFolder(sourceFolder);
    }
}

// End FileUtil.java

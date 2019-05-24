package util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HDPFileUtil {
    //~ Constructors -----------------------------------------------------------

    private HDPFileUtil() {
    }

    //~ Methods ----------------------------------------------------------------

    @NotNull
    public static String read(String file) {
        StringBuilder sb = new StringBuilder();
        Configuration conf = new Configuration();
        try (FileSystem fs2 = FileSystem.get(conf);
             FSDataInputStream fsDataInputStream = fs2.open(new Path(file));
             InputStreamReader isr = new InputStreamReader(fsDataInputStream, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @NotNull
    public static String read4Linux(String file) {
        StringBuilder sb = new StringBuilder();
        Process pro;
        try {
            pro = Runtime.getRuntime().exec("hadoop fs -cat " + file);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        try (InputStream is = pro.getInputStream();
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

// End HDPFileUtil.java

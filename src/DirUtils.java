/**
 * @author riddleli
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirUtils {
    public static List<File> javaFind(String dirName) {
        List<File> results = new ArrayList<>();
        File dir = new File(dirName);
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                if (file.getName().endsWith(".java")) {
                    results.add(file);
                }
            }
            if (file.isDirectory()) {
                results.addAll(javaFind(file.getName()));
            }
        }

        return results;
    }

    public static List<File> txtFind(String dirName) {
        List<File> results = new ArrayList<>();
        File dir = new File(dirName);
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                if (file.getName().endsWith(".txt")) {
                    results.add(file);
                }
            }
            if (file.isDirectory()) {
                results.addAll(txtFind(file.getName()));
            }
        }

        return results;
    }

    public static void main(String[] args) {
        String path = "/home/riddleli/testdir/day0730/";
        System.out.println("Searching on " + path + " ...");
        List<File> d = javaFind(path);
        for (File f : d)
            System.out.println(f.getName());
    }

}

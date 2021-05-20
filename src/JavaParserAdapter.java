import oreo_java_parser.FolderInputProcessor;
import oreo_java_parser.MainApplication;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author riddleli
 */
public class JavaParserAdapter {
    public static String getVector(SourceCode code) {
        MainApplication.status = 0;
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("temp.txt", false));
            out.write("public class M {\n");
            for(String s : code.getCode()) {
                out.write(s + "\n");
            }
            out.write("}");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FolderInputProcessor fip = new FolderInputProcessor();
        File f = new File("temp.txt");
        try {
            fip.metricalize(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(MainApplication.status == 1) {
            code.setVector(MainApplication.mem);
            return MainApplication.mem;
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        String sourcePath = "/home/riddleli/testdir/day0730/";
        SourceCode code = new SourceCode(sourcePath, "try.java", 14, 20);
        code.findCode();
        List<String> list = code.getCode();
//        for (String s : list) {
//            System.out.println(s);
//        }
        System.out.println(JavaParserAdapter.getVector(code));
        List<String> list2 = new ArrayList<>();
        list2.add(list.get(0));
        list2.add("\t\tint x;");
        for(int i = 1; i < list.size(); i++) {
            list2.add(list.get(i));
        }
        code.setCode(list2);
        System.out.println(JavaParserAdapter.getVector(code));
        List<String> list3 = new ArrayList<>();
        list3.add(list.get(0));
        list3.add("\t\tint x = 1;");
        for(int i = 1; i < list.size(); i++) {
            list3.add(list.get(i));
        }
        code.setCode(list3);
        System.out.println(JavaParserAdapter.getVector(code));
    }
}

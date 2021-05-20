import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main_AddInt {
    public static void main(String[] args) {
        for(int i = 2; i <= 45; i++) {
//        for(int i = 2; i <= 3; i++) {
            System.out.println(i);
            if(i == 16) {
                continue;
            }
            String predPath = "/home/linyu/oreo222/oreo/bcb_prediction/predictions" + i + "/";
            String srcPath = "/home/linyu/BigCloneEval/ijadataset/bcb_reduced/" + i + "/";
//            String predPath = "/home/riddleli/bcb_test/predictions" + i;
//            String srcPath = "/home/riddleli/testdir/";
            func(i, predPath, srcPath);
        }
    }

    public static void func(int index, String predPath, String srcPath) {
        //deal with one specific subdir
        List<File> list = DirUtils.txtFind(predPath);
        for (File file : list) {
            if(file.getName().contains("type3")) {
                System.out.println(file.getName());
                try {
                    Scanner scanner = new Scanner(file);
                    while(scanner.hasNextLine()) {
                        String s = scanner.nextLine();
                        System.out.println(s);
                        String[] arr = s.split(",");
                        String path1 = srcPath + arr[0] + "/";
                        int startLine1 = Integer.parseInt(arr[2]);
                        int endLine1 = Integer.parseInt(arr[3]);
                        SourceCode c1 = new SourceCode(path1, arr[1], startLine1, endLine1);
                        c1.findCode();

                        c1 = ReviseUtils.addIntWithOutValue(c1);

                        String v1 = JavaParserAdapter.getVector(c1);
                        String path2 = srcPath + arr[4] + "/";
                        int startLine2 = Integer.parseInt(arr[6]);
                        int endLine2 = Integer.parseInt(arr[7]);
                        SourceCode c2 = new SourceCode(path2, arr[5], startLine2, endLine2);
                        c2.findCode();
                        String v2 = JavaParserAdapter.getVector(c2);
                        StringBuilder k = new StringBuilder();
                        k.append("3.1$#$").append(arr[0]).append(",")
                                .append(arr[1]).append(",").append(arr[2]).append(",")
                                .append(arr[3]).append("~~").append(arr[4]).append(",")
                                .append(arr[5]).append(",").append(arr[6]).append(",")
                                .append(arr[7]);
                        String[] g1 = v1.split(",");
                        String[] g2 = v2.split(",");
                        for(int j = 0; j < 24; j++) {
                            k.append("~~").append(g1[j]).append("~~").append(g2[j]);
                        }
                        FileUtils.writeCandidatePair(index, k.toString());
                        System.out.println(k);
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

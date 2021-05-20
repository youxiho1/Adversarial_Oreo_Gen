import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static int lastInd = -1;
    public static int count = 0;
    public static int fileCount = 1;

    public static List<String> getS2ELines(String filePath, int startLine, int endLine) {
        List<String> result = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            int lineCount = 0;
            while(lineCount < startLine - 1) {
                scanner.nextLine();
                lineCount++;
            }
            for(lineCount = startLine; lineCount <= endLine; lineCount++) {
                result.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void writeCandidatePair(int index, String s) {
        if(lastInd != index) {
            count = 0;
            lastInd = index;
            fileCount = 1;
        }
        count++;
        if(count > 100000) {
            count = 1;
            fileCount++;
        }
        File f = new File("./addIntCands"+index+"/");
        if(!f.exists()) {
            f.mkdir();
        }
        f = new File("./addIntCands"+index+"/9900:"+fileCount+".txt");
        try {
            FileWriter fw = new FileWriter(f, true);
            fw.write(s+"\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "/home/riddleli/testdir/day0730/try.java";
        List<String> list = FileUtils.getS2ELines(filePath, 1, 11);
        for (String s: list
             ) {
            System.out.println(s);
        }
    }
}



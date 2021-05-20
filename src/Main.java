import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * @author riddleli
 */
public class Main {
    public static final String[] COLNAMES = {"COMP", "NOS", "HVOC", "HEFF", "CREF", "XMET",
            "LMET", "NOA", "HDIF", "VDEC", "EXCT", "EXCR",
            "CAST", "NAND", "VREF", "NOPR", "MDN", "NEXP",
            "LOOP", "NBLTRL", "NCLTRL", "NNLTRL", "NNULLTRL", "NSLTRL"};

    public static void main(String[] args) {
        String gradientsPath = "/home/riddleli/oreo-master/oreo/bcb_predictions/";
//        String gradientsPath = "";
        String sourcePath = "/home/riddleli/BigCloneEval/ijadataset/bcb_reduced/";
//        String sourcePath = "/home/linyu/BigCloneEval/ijadataset/bcb_reduced/";
        for(int ii = 2; ii <= 45; ii++) {
            if(ii == 16) {
                continue;
            }
            String gradientDirPath = gradientsPath + "predictions" + ii + "/";
            List<File> list = DirUtils.txtFind(gradientDirPath);
            for(File f : list) {
                if(f.getName().contains("type3")) {
                    //type 3 only
                    try {
                        Scanner scanner = new Scanner(f);
                        while(scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            String[] arr = line.split("$;$");
                            //arr[0]: clone pairs
                            //arr[1]: cost
                            //arr[2]: gradient1
                            //arr[3]: gradient2
                            String[] grad1 = arr[2].split(",");
                            double minV = Double.MAX_VALUE;
                            int minInd = 0;
                            for(int i = 0; i < grad1.length; i++) {
                                double g = Double.parseDouble(grad1[i]);
                                if(g < minV) {
                                    minInd = i;
                                    minV = g;
                                }
                            }

                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

        for(int ii = 17; ii <= 45; ii++) {

        }

    }
}

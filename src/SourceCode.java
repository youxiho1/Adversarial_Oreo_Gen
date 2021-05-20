import java.util.ArrayList;
import java.util.List;

/**
 * @author riddleli
 */
public class SourceCode {
    private String sourcePath;
    private String fileName;
    private int startLine;
    private int endLine;
    private List<String> code = new ArrayList<>();
    private String vector;

    //sourcePath: /home/linyu/BigCloneEval/ijadataset/bcb_reduced/9/selected/
    //fileName: 1.java

    public SourceCode(String sourcePath, String fileName, int startLine, int endLine) {
        this.sourcePath = sourcePath;
        this.fileName = fileName;
        this.startLine = startLine;
        this.endLine = endLine;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getStartLine() {
        return startLine;
    }

    public void setStartLine(int startLine) {
        this.startLine = startLine;
    }

    public int getEndLine() {
        return endLine;
    }

    public void setEndLine(int endLine) {
        this.endLine = endLine;
    }

    public List<String> getCode() {
        return code;
    }

    public void setCode(List<String> code) {
        this.code = code;
    }

    public String getVector() {
        return vector;
    }

    public void setVector(String vector) {
        this.vector = vector;
    }

    public void findCode() {
        String filePath = sourcePath + fileName;
        List<String> code = FileUtils.getS2ELines(filePath, startLine, endLine);
        this.setCode(code);
    }
}

import java.util.ArrayList;
import java.util.List;

public class ReviseUtils {
    public static SourceCode addIntWithOutValue(SourceCode code) {
        List<String> list = code.getCode();
        List<String> list2 = new ArrayList<>();
        list2.add(list.get(0));
        list2.add("\t\tint x;");
        for(int i = 1; i < list.size(); i++) {
            list2.add(list.get(i));
        }
        code.setCode(list2);
        return code;
    }
}

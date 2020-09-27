package trashLab;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class test2{
    public static void main(String[] args) {
        String target = "trashLab";
        Path pFromBasic = Paths.get("/Users/pinkuan/IdeaProjects/java-exercise/src/main/java");
        Path pTo = Paths.get("/Users/pinkuan/IdeaProjects/java-exercise/src/main/java/Test");

        try {
            Path mv = Files.move(pFromBasic.resolve(target), pTo.resolve(target),StandardCopyOption.REPLACE_EXISTING);
            //Files.delete(mv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class RandomFileGenerator {

    public static void generate(String file, int amount) {
        try {
            tryGenerate(file, amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tryGenerate(String file, int amount) throws Exception {

        FileWriter fw = new FileWriter(new File(file));

            int amountt = amount;

            for (int i = 0; i < amountt; i++) {
                int randomNum = (int) (Math.random() * 101);
                fw.write(randomNum + "\n");
            }
        fw.close();

    }
}
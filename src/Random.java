import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Random {

    public static void generate(String file) {
        try {
            tryGenerate(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tryGenerate(String file) throws Exception {

        try (FileWriter fw = new FileWriter(new File(file));
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Add meg a kívánt mennyiséget: ");
            int amount = sc.nextInt();

            for (int i = 0; i < amount; i++) {
                int randomNum = (int) (Math.random() * 101);
                fw.write(randomNum + "\n");
            }
        }
    }
}
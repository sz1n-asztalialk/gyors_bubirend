import java.io.*;
import java.util.ArrayList;

public class Bubblesort {

    static long comparisons = 0;
    static long swaps = 0;

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {

        int n = list.size();

        for (int i = n - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                comparisons++;

                if (list.get(j) > list.get(j + 1)) {

                    swaps++;

                    int tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }

        return list;
    }

    public static void run(String fileName) {

        comparisons = 0;
        swaps = 0;

        try {

            ArrayList<Integer> list = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line.trim()));
            }

            br.close();

            long start = System.currentTimeMillis();

            ArrayList<Integer> sorted = bubbleSort(list);

            long end = System.currentTimeMillis();

            String outputFile = "rendezett_bubble_" + fileName;

            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

            for (int x : sorted) {
                bw.write(String.valueOf(x));
                bw.newLine();
            }

            bw.close();

            System.out.println("Rendezés kész!");
            System.out.println("Kimeneti fájl: " + outputFile);
            System.out.println("Futási idő: " + (end - start) + " ms");
            System.out.println("Összehasonlítások: " + comparisons);
            System.out.println("Cserék: " + swaps);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

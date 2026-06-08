import java.io.*;
import java.util.ArrayList;

public class Quicksort {

    static long comparisons = 0;
    static long moves = 0;

    static ArrayList<Integer> quicksort(ArrayList<Integer> list) {

        if (list.size() <= 1) {
            return list;
        }

        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        int pivot = list.get(list.size() - 1);

        for (Integer x : list) {

            comparisons++;
            if (x < pivot) {
                less.add(x);
                moves++;
            }

            comparisons++;
            if (x == pivot) {
                equal.add(x);
                moves++;
            }

            comparisons++;
            if (x > pivot) {
                greater.add(x);
                moves++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        result.addAll(quicksort(less));
        result.addAll(equal);
        result.addAll(quicksort(greater));

        return result;
    }

    public static void run(String fileName) {

        comparisons = 0;
        moves = 0;

        try {

            ArrayList<Integer> list = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line.trim()));
            }

            br.close();

            long start = System.currentTimeMillis();

            ArrayList<Integer> sorted = quicksort(list);

            long end = System.currentTimeMillis();

            String outputFile = "rendezett_quick_" + fileName;

            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

            for (Integer x : sorted) {
                bw.write(x.toString());
                bw.newLine();
            }

            bw.close();

            System.out.println("Rendezés kész!");
            System.out.println("Kimeneti fájl: " + outputFile);
            System.out.println("Futási idő: " + (end - start) + " ms");
            System.out.println("Összehasonlítások: " + comparisons);
            System.out.println("Mozgatások: " + moves);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        RandomFileGenerator.generate("20_000_szam.txt", 20000);
        RandomFileGenerator.generate("40_000_szam.txt",40000);
        RandomFileGenerator.generate("80_000_szam.txt", 80000);
        RandomFileGenerator.generate("160_000_szam.txt", 160000);
        RandomFileGenerator.generate("500_000_szam.txt", 500000);

        Scanner sc = new Scanner(System.in);

        System.out.print("Add meg a fájl nevét: ");
        String fileName = sc.nextLine();

        // Quicksort.run(fileName);

        Bubblesort.run(fileName);

        sc.close();
    }
}


import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Add meg a fájl nevét: ");
        String fileName = sc.nextLine();

        // Quicksort.run(fileName);

        Bubblesort.run(fileName);

        sc.close();
    }
}


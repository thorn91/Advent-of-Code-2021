import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final ArrayList<String> input = new ArrayList<>();

    public Main() {
        this.getInput();
    }

    private void getInput() {
        File f = new File("03-BinaryDiagnostic/src/main/resources/03input.txt");

        try {
            Scanner scn = new Scanner(f);
            while (scn.hasNext()) {
                String line = scn.nextLine();
                input.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void partOne() {
       int[] counts = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
       StringBuilder finalGamma = new StringBuilder();
       StringBuilder finalEpsilon = new StringBuilder();

       for (String line : input) {
           char[] chars = line.toCharArray();

           for (int i = 0; i < chars.length; i++) {
               switch (chars[i]) {
                   case '0' -> counts[i]--;
                   case '1' -> counts[i]++;
               }
           }
       }

       for (int i : counts) {
           if (i > 0) {
               finalGamma.append("1");
               finalEpsilon.append("0");
           } else {
               finalGamma.append("0");
               finalEpsilon.append("1");
           }
       }

       int gamma = Integer.parseInt(finalGamma.toString(), 2);
       int epsilon = Integer.parseInt(finalEpsilon.toString(), 2) * gamma;

       System.out.println("Part 1: " + epsilon);
    }

    private void partTwo() {

    }

    public static void main(String... args) {
        Main m = new Main();
        m.partOne();
    }
}

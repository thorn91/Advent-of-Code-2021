import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> input = new ArrayList<String>();

    public Main() {
        this.getInput();
    }

    private void getInput() {
        File f = new File("04-GiantSquid/src/main/resources/04input.txt");

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


    public static void main (String... args) {
        Main m = new Main();

        for (String line : input) {
            System.out.println(line);
        }
    }
}

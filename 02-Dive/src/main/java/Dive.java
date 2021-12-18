import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class Dive {
    private final ArrayList<String> input = new ArrayList<>();

    public Dive() {
        getInput();
    }

    private void getInput() {
        File f = new File("02-Dive/src/resources/02input.txt");

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

    public void partOne() {
        int horizontal = 0;
        int depth = 0;

        for (String line : input) {
            String[] values = line.split(" ");
            String indicator = values[0];
            int value = Integer.parseInt(values[1]);

            switch (indicator) {
                case "forward" -> horizontal += value;
                case "up" -> depth -= value;
                case "down" -> depth += value;
            }
        }

        int total = horizontal * depth;

        System.out.format("Part 1: %s\n", total);
    }

    public void partTwo() {
        int horizontal = 0;
        int aim = 0;
        int depth = 0;

        for (String line : input) {
            String[] values = line.split(" ");
            String indicator = values[0];
            int value = Integer.parseInt(values[1]);

            switch (indicator) {
                case "down" -> aim += value;
                case "up" -> aim -= value;
                case "forward" -> {
                    depth += aim * value;
                    horizontal += value;
                }
            }
        }

        int total = horizontal * depth;

        System.out.format("Part 2: %s\n", total);
    }

}


package com.lukasz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<String> getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input: ");
        String line;
        List<String> lines = new ArrayList<>();

        while(!(line = scanner.nextLine()).isEmpty()) {
            lines.add(line);
        }

        return lines;
    }

    public static void main(String[] args) {
        List<String> lines = getInput();
        Solution solution = new Solution(lines);

        System.out.println("Letters the network packet will find: " + solution.getLetters());
        System.out.println("Steps it need to go: " + solution.getSteps());

    }
}

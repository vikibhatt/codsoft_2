package WordCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 'text' to enter a text or 'file' to provide a file: ");
        String inputType = sc.nextLine();

        if (inputType.equalsIgnoreCase("text")) {
            System.out.print("Enter the text: ");
            String text = sc.nextLine();
            int wordCount = countWords(text);
            System.out.println("Total number of words: " + wordCount);
        } else if (inputType.equalsIgnoreCase("file")) {
            System.out.print("Enter the file path: ");
            String filePath = sc.nextLine();
            try {
                File file = new File(filePath);
                Scanner fileScanner = new Scanner(file);
                StringBuilder sb = new StringBuilder();
                while (fileScanner.hasNextLine()) {
                    sb.append(fileScanner.nextLine()).append("\n");
                }
                fileScanner.close();
                String fileText = sb.toString();
                int wordCount = countWords(fileText);
                System.out.println("Total number of words: " + wordCount);
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please check the file path and try again.");
            }
        }
    }

    private static int countWords(String text) {
        String[] words = text.split("\\s+|\\p{Punct}");
        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}

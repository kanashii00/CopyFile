import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class CopyFile {

    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "output.txt";

        try {
            copyTextFile(sourceFile, destinationFile);
            System.out.println("File copied successfully");
        } catch (IOException e) {
            System.out.println("File copied unsuccessfully");
            e.printStackTrace();
        }
    }

    private static void copyTextFile(String source, String destination) throws IOException {
        File inputFile = new File(source);

        if (!inputFile.exists()) {
            throw new FileNotFoundException("Source file not found: " + source);
        }

        File outputFile = new File(destination);

        try (Scanner scanner = new Scanner(inputFile);
             FileWriter writer = new FileWriter(outputFile)) {

            while (scanner.hasNextLine()) {
                writer.write(scanner.nextLine() + System.lineSeparator());
            }
        }
    }
}
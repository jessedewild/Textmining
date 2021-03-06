import exceptions.TextFileUtitiesException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Textmining {
    private final String INPUT_FILES_FOLDER = "input_files";
    private final String OUTPUT_LOCATION = "output_from_input_files";

    private ArrayList<Publication> publications = new ArrayList<>(); // ArrayList of publications

    public void main() {
        try {
            // Add every Publication to an ArrayList
            for (File file : TextFileUtilities.getFilesFromFolder(INPUT_FILES_FOLDER)) {
                publications.add(TextFileUtilities.parsePublicationInformation(file));
            }

            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Do you want to write the publications to the file? ");
                String menuOption = sc.nextLine();
                if (menuOption.equalsIgnoreCase("yes")) {
                    // Write the ArrayList of publications to a .txt file that has been given in the argInput
                    TextFileUtilities.writePublicationsToFile(publications, OUTPUT_LOCATION);
                    System.exit(0);
                } else {
                    File file = new File(OUTPUT_LOCATION);
                    file.delete();
                    System.exit(0);
                }
            }
        } catch (TextFileUtitiesException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Textmining().main();
    }
}

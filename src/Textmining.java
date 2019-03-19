import exceptions.TextFileUtitiesException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Textmining {
    private final String INPUT_FILES_FOLDER = "input_files";
    private final String SAVE_LOCATION = "output_from_input_files";

    private ArrayList<Publication> publications = new ArrayList<>(); // ArrayList of publications

    public void main() {
        try {
            // Add every Publication to an ArrayList
            for (File file : TextFileUtilities.getFilesInFolder(INPUT_FILES_FOLDER)) {
                publications.add(TextFileUtilities.parsePublicationInformation(file));
            }

            // Write the ArrayList of publications to a .txt file that has been given in the argInput
            TextFileUtilities.writePublicationsToFile(publications, SAVE_LOCATION);
        } catch (TextFileUtitiesException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Textmining().main();
    }
}

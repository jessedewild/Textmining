import exceptions.TextFileUtitiesException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Textmining {
    private ArrayList<Publicatie> publicaties = new ArrayList<>(); // ArrayList of Publicaties

    public void main() {
        try {
            // Add every Publicatie to an ArrayList
            for (File file : TextFileUtities.getFilesInFolder("input_files")) {
                publicaties.add(TextFileUtities.parsePublicatieInformatie(file));
            }

            // Write the ArrayList of 'publicaties' to a .txt file that has been given
            TextFileUtities.schrijfPublicatiesNaarFile(publicaties, "output_from_files");
        } catch (TextFileUtitiesException tfue) {
            new TextFileUtitiesException("The given folder location is not a directory!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Textmining().main();
    }
}

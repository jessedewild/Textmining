import exceptions.TextFileUtitiesException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileUtities {

    /**
     * If the folder is a directory/folder, add the files to the ArrayList.
     * Else throw an exception for an invalid folder location.
     *
     * @return the ArrayList of files from the folder.
     */
    public static ArrayList<File> getFilesInFolder(String folderLocation) throws TextFileUtitiesException {
        ArrayList<File> fileLocations = new ArrayList<>();
        File folder = new File(folderLocation);

        if (folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                fileLocations.add(file);
            }
        } else {
            new TextFileUtitiesException();
        }

        return fileLocations;
    }

    /**
     * Make a Publicatie from the file given.
     *
     * @param file : Make a Publicatie from the given file.
     * @return : The Publicatie that has been created via the file.
     */
    public static Publicatie parsePublicatieInformatie(File file) {
        Publicatie publicatie = new Publicatie();
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.startsWith("PMID-")) {
                    publicatie.setPMID(line.split("- ")[1]);
                } else if (line.startsWith("TI  -")) {
                    publicatie.setTitel(line.split("- ")[1]);
                } else if (line.startsWith("DP  -")) {
                    publicatie.setDatum(line.split("- ")[1]);
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("This is an invalid file!");
        }

        return publicatie;
    }

    /**
     * Write the .txt file from the ArrayList of publicaties
     *
     * @param publicaties : The ArrayList given in the main() run.
     * @param saveLocation : The given location and name for the .txt file
     * @throws IOException : See Textmining.java (line 18)
     */
    public static void schrijfPublicatiesNaarFile(ArrayList<Publicatie> publicaties, String saveLocation) throws IOException {
        FileWriter writer = new FileWriter(saveLocation);
        for (Publicatie publicatie : publicaties) {
            writer.write(publicatie.toString());
        }
        writer.close();
    }
}

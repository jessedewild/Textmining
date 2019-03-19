import exceptions.TextFileUtitiesException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileUtilities {

    /**
     * If the folder is a directory/folder, add the files to the ArrayList.
     * Else throw an exception for an invalid folder location.
     *
     * @return the ArrayList of files from the folder
     */
    public static ArrayList<File> getFilesFromFolder(String folderLocation) throws TextFileUtitiesException {
        ArrayList<File> files = new ArrayList<>();
        File folder = new File(folderLocation);

        // Loop through the folder, and add every file to the ArrayList of files
        if (folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                files.add(file);
            }
        } else {
            throw new TextFileUtitiesException("The given folder location is not a directory!");
        }

        return files;
    }

    /**
     * Make a Publication from the file given.
     *
     * @param file : Make a Publication from the given file
     * @return : The Publication that has been created via the file
     */
    public static Publication parsePublicationInformation(File file) {
        Publication publication = new Publication();
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.startsWith("PMID-")) {
                    publication.setPMID(line.split("- ")[1]);
                } else if (line.startsWith("TI  -")) {
                    publication.setTitle(line.split("- ")[1]);
                } else if (line.startsWith("DP  -")) {
                    publication.setDatum(line.split("- ")[1]);
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("This is an invalid file!");
        }

        return publication;
    }

    /**
     * Write the .txt file from the ArrayList of publications.
     *
     * @param publications : The ArrayList given in the main() run
     * @param outputLocation : The given location and name for the .txt file
     */
    public static void writePublicationsToFile(ArrayList<Publication> publications, String outputLocation) throws IOException {
        FileWriter writer = new FileWriter(outputLocation);
        for (Publication publication : publications) {
            writer.write(publication.toString());
        }
        writer.close();
    }
}

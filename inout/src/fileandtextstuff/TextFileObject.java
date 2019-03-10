package fileandtextstuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This Object contans text files, their propperties (path, number of textlines,
 * number of chars?)
 *
 * @author Alex
 */
public class TextFileObject {

    public String filepath = "";
    public File f;
    public String filedirectory = "";
    public String filename = "";
    public String filetype = "";
    public String[] textlines;
    public int linecounter = 0;

    /**
     *
     * @param path
     * @param name
     * @param type
     * @throws FileNotFoundException
     */
    public TextFileObject(String path) throws FileNotFoundException, IOException {
        filepath = path;
        f = new File(filepath);
        String[] filepath_parts = PathMethods.filePathRegExToExtractPartsOfFilePaths(this.filepath);
        filedirectory = filepath_parts[0];
        filename = filepath_parts[1];
        filetype = filepath_parts[2];

        textlines = TextOperations.actualReadFileMethod(path);
        this.linecounter = this.textlines.length;
    }

    /**
     * Exactly like CTRL+S
     *
     * @throws IOException
     */
    public void save() throws IOException {
        TextOperations.saveStringArrayToFile(this.filepath, this.textlines);
    }

    /**
     * Name says everything...
     *
     * @param path_to_save_to
     * @throws IOException
     */
    public void saveAs(String path_to_save_to) throws IOException {
        File saving = new File(path_to_save_to);
        //create the needed Folders
        new File(PathMethods.filePathRegExToExtractPartsOfFilePaths(path_to_save_to)[0]).mkdirs();

        //create the file if not existent, throw Message otherwise
        if (saving.createNewFile() == true) {
            TextOperations.saveStringArrayToFile(path_to_save_to, this.textlines);
        } else {
            System.out.println("A file with this name already exists!");
        }
    }

    public void saveAsCopyInSameDirectory() throws IOException {
        String path = filedirectory + filename + " - Copy" + filetype;
        TextOperations.saveStringArrayToFile(path, this.textlines);
    }

    public void move(String path_to_move_to) throws IOException {
        boolean moved = false;
        File moving = new File(path_to_move_to);
        //Create the needed Folders. If the file already exists, the folders also exst, 
        //if a folder doesn't exist, the file can also not exist, so it has to be created.
        new File(PathMethods.filePathRegExToExtractPartsOfFilePaths(path_to_move_to)[0]).mkdirs();

        //Create the file if not existent, throw Message otherwise
        if (moving.createNewFile() == true) {
            TextOperations.saveStringArrayToFile(path_to_move_to, this.textlines);
            moved = true;
        } else {
            System.out.println("A file with this name already exists!");
        }

        //Deletes old file if it was moved
        if (moved == true) {
            moving.delete();
        } else {
            System.out.println("FILE NOT MOVED!!");
        }
    }

}

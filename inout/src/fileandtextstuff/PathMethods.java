package fileandtextstuff;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The probem is, here are Methods, but not all of them. Some are uesed in other
 * classes. That's ineficient!
 *
 * @author Alex
 */
public class PathMethods {

    public static String[] filePathRegExToExtractPartsOfFilePaths(String filepath) {
        String[] filepath_arr = new String[3];
        String filepath1 = filepath;

        String type_pattern = "\\.[A-Za-z0-9§$%&()ß´`+_,;#'-]*$";
        String name_pattern = "[\\.A-Za-z0-9§$%&()ß´`+_,;#'-]*$";

        Pattern type_pat = Pattern.compile(type_pattern);
        Matcher type_mat = type_pat.matcher(filepath1);
        type_mat.find();
        //define next String
        String filepath2 = filepath1.substring(0, type_mat.start());

        //mat1.start() + 1 wenn der punkt nicht benötigt wird
        //this.filetype = filepath1.substring(type_mat.start(), filepath1.length());
        filepath_arr[2] = filepath1.substring(type_mat.start(), filepath1.length());

        Pattern name_pat = Pattern.compile(name_pattern);
        Matcher name_mat = name_pat.matcher(filepath2);
        name_mat.find();

        //this.filename = filepath2.substring(name_mat.start(), filepath2.length());
        filepath_arr[1] = filepath2.substring(name_mat.start(), filepath2.length());
        //this.filedirectory = filepath2.substring(0, name_mat.start());
        filepath_arr[0] = filepath2.substring(0, name_mat.start());

        return filepath_arr;
    }

}

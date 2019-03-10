package inout;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * As soon as this object is created with the parameter of a String[], it will
 * instantly check validity of the provided file paths. It will check for
 * possible candidates of valid file paths, checkeveryone on validity, count the
 * number how many paths are valid, and create n Array with all valid paths.
 * Additionaly it wil create an Array with the numbers of the positions of the
 * valid paths in the Array with all valid path candidates.
 *
 * @author Alex
 */
public class FilePathObject {

    public String[] input_path_arr = null; //taxtlines to be searched for paths
    public String[] possible_file_paths = null; //all found paths
    public String[] valid_file_paths_str = null; //all valid paths in an arraay (can be accessed, are existing files on the system)
    public boolean[] valid_file_paths_bool = null; //which path is valid and which not
    public int[] valid_file_paths_nums = null; //number(position) of a valid path in $possible_file_paths
    public int valid_file_paths_count = 0; //number how many paths are valid

    /**
     * this Object Class contains File Paths and validation methods for a file
     *
     * @param path_array
     * @throws java.io.IOException
     */
    public FilePathObject(String[] path_array) throws IOException {
        input_path_arr = path_array;
        pathsProcessingProcedure();
    }

    /**
     * this Object Class contains a File Path and validation methods for file
     * input_path_arr of different File types
     *
     * @param path
     * @throws java.io.IOException
     */
    public FilePathObject(String path) throws IOException {
        input_path_arr = new String[]{path};
        pathsProcessingProcedure();
    }

    //checks for existingpaths and caecks validity of paths
    private void pathsProcessingProcedure() throws IOException {
        this.possible_file_paths = filePathSearch(this.input_path_arr);
        boolean[] bool = multiplePathTestingBooleanOutput(this.possible_file_paths);

        //count how many vaid paths exist
        for (int i = 0; i < bool.length; i++) {
            if (bool[i] == true) {
                this.valid_file_paths_count++;
            }
        }

        //define array with the length of how many valid paths exist
        this.valid_file_paths_nums = new int[this.valid_file_paths_count];
        this.valid_file_paths_str = new String[this.valid_file_paths_count];

        int j = 0;
        for (int i = 0; i < bool.length; i++) {
            if (bool[i] == true) {
                this.valid_file_paths_nums[j] = i;
                valid_file_paths_str[j] = possible_file_paths[i];
                j++;
            }
        }

    }

    /**
     * takes more String array fields, combines them to a single String,
     * searches for viable input_path_arr and returns those input_path_arr
     *
     * @param args one or more lines of text which has to be searched for
     * input_path_arr
     * @return String Array with the found input_path_arr
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String[] filePathSearch(String[] args) throws FileNotFoundException, IOException {
//this metod combines the String array to a single String and starts the single String version of this method

//connects every String of the Array to one single String and deletes every backslash n
        String textline = connectStringArrayToString(args);
        String[] paths_arr = filePathSearch(textline);

//only for testing purposes
//        for (int i = 0; i < paths_arr.length; i++) {
//         System.out.println(paths_arr[i]);
//         }
//        multiplePathTestingTextualOutput(paths_arr);
        return paths_arr;
    }

    /**
     * takes a string, searches for viable input_path_arr and returns those
     * input_path_arr
     *
     * @param args one line of text which has to be searched for input_path_arr
     * @return String Array with the found input_path_arr
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String[] filePathSearch(String args) throws FileNotFoundException, IOException {

//connects every String of the Array to one single String and deletes every backslash n
        String textline = deleteBackslashN(args);

        textline = appendSpaceBeforePossibleValidPathWithoutDoubleQuote(textline);

//this is used only to have an overviev over the RegEx variations
        /*String[] pattern_array = {
         //pattern that allows spaces but has to start with double quotes
         "(\"[A-Za-z]:\\\\[\\w\\.\\$\\-\\{\\}\\[\\]\\(\\)\\s\\\\]*\")",
         //standard pattern (no spaces -> no doublequotes)            
         "([A-Za-z]:\\\\[\\w\\.\\$\\-\\{\\}\\[\\]\\(\\)\\\\]*)"};
         */
        String[] pattern_array = {
            //pattern that allows spaces but has to start with double quotes
            "(\"[A-Za-z]:\\\\[\\w\\.\\$\\-\\{\\}\\[\\]\\(\\)\\s\\\\]*\")",
            //standard pattern (no spaces -> no doublequotes)            
            "([A-Za-z]:\\\\[\\w\\.\\$\\-\\{\\}\\[\\]\\(\\)\\\\]*)"};

        //this method is to combine the RegEx variations
        String pattern = combinePatternArrayIntoString(pattern_array);
        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(textline);

        String paths = findMatchingAndMakeStringDividedByBackslashN(mat, textline);

        String[] paths_arr = splitPathsIntoPathsArray(paths);

        paths_arr = deleteDoubleQuotes(paths_arr);

//only for testing purposes
//        for (int i = 0; i < paths_arr.length; i++) {
//         System.out.println(paths_arr[i]);
//         }
//        multiplePathTestingTextualOutput(paths_arr);
        return paths_arr;
    }

//<editor-fold defaultstate="collapsed" desc="filePathSearchSubMethods">
    private static String connectStringArrayToString(String[] str_arr) {
        String path = "";
        for (int i = 0; i < str_arr.length; i++) {
            path = path.concat(str_arr[i]);
        }
        return path;
    }

    private static String deleteBackslashN(String str_arr) {
//deletes all BackslashN, so the string doesn't have NextLines
        if (str_arr.contains("\n") == true) {
            str_arr = str_arr.replaceAll("\n", "");
        }
        return str_arr;
    }

    private static String appendSpaceBeforePossibleValidPathWithoutDoubleQuote(String input) {
        String textline = input;

//regex that searches for "C:" and puts a " " in front of "C:" ("asdadC:sa" -> "asdad C:sa")
        String strpat = "([^\"]\\w:)";
        // String strpat = "(\\w:)";
        Pattern patpat = Pattern.compile(strpat);
        Matcher matmat = patpat.matcher(textline);
        //counter to know where to start next
        int start = 0;

        //works while the Matcher finds something (starting at specifed position and proceeds through the textline)
        //Matcher has to be redefined after every iteration to take the new information
        while (matmat.find(start) == true) {
            //increase counter, so the matcher won't start on the same position
            start = (matmat.start() + 2);
            //defines the group
            String group = matmat.group().substring(1);

            //divide and recombine the String with the new " "
            String[] arr = new String[]{
                ((String) textline.subSequence(0, matmat.start() + 1)),
                ((String) textline.subSequence(matmat.end(), textline.length()))};
            //make textline whole again
            textline = arr[0].concat(" " + group).concat(arr[1]);

            //define new Matcher with the new textline
            matmat = patpat.matcher(textline);
        }

        return textline;
    }

    private static String combinePatternArrayIntoString(String[] pattern_array) {
//combines Pattern Array with OR to use all Patterns
        String pattern = "";
        for (int i = 0; i < (pattern_array.length - 1); i++) {
            pattern = pattern.concat(pattern_array[i]) + "|";
        }
        pattern = pattern.concat(pattern_array[pattern_array.length - 1]);
        return pattern;
    }

    private static String findMatchingAndMakeStringDividedByBackslashN(Matcher mat, String textline) {
        String paths = "";
        while (mat.find()) {
            paths += "\n" + textline.substring(mat.start(), mat.end());
            mat.group();
        }
        return paths;
    }

    private static String[] splitPathsIntoPathsArray(String paths) {
        //System.out.println("Paths: " + paths + ";");
        String ret[];
        if (paths != "") {
            ret = paths.substring(1).split("\n");
        } else {
            ret = new String[]{"!!!NULL!!!"};
        }

        return ret;
    }

    private static String[] deleteDoubleQuotes(String[] paths_arr) {
        for (int i = 0; i < paths_arr.length; i++) {
            if (paths_arr[i].startsWith("\"") == true) {
                paths_arr[i] = paths_arr[i].substring(1, paths_arr[i].length() - 1);
            }
        }
        return paths_arr;
    }
//</editor-fold>

    /**
     * This Method takes multiple Strings and searches for valid input_path_arr.
     * Outputs which path is a valid one through System.out.println-Method
     *
     * @param paths_arr String Array with possible input_path_arr
     */
    public static void multiplePathTestingTextualOutput(String[] paths_arr) {
        for (int i = 0; i < paths_arr.length; i++) {
            System.out.print("-> Path " + i + ": " + paths_arr[i]);
            try {
                BufferedReader r = new BufferedReader(new FileReader(paths_arr[i]));
                System.out.println("--> OK!");
                r.close();
            } catch (FileNotFoundException e) {
                System.out.println("--> File not found!");
            } catch (IOException e) {
                System.out.println("--> I/O Exception!");
            }
        }
    }

    /**
     * This Method takes multiple Strings and searches for valid input_path_arr.
     * Returns a boolean Array.
     *
     * @param paths_arr String Array with possible input_path_arr
     * @return boolean Array with thevalidations of the possible input_path_arr
     */
    public static boolean[] multiplePathTestingBooleanOutput(String[] paths_arr) {
//tests if the possible input_path_arr in the string array are valid
        boolean[] valid_or_not = new boolean[paths_arr.length];
        for (int i = 0; i < paths_arr.length; i++) {
            //System.out.println("-> Path " + i + ": " + paths_arr[i] + " ");
            try {
                BufferedReader r = new BufferedReader(new FileReader(paths_arr[i]));
                //System.out.println("--> OK!");
                valid_or_not[i] = true;
                r.close();
            } catch (FileNotFoundException e) {
                //System.out.println("--> File Nnot found!");
                valid_or_not[i] = false;
            } catch (IOException e) {
                //System.out.println("--> I/O Exception!");
                valid_or_not[i] = false;
            }
        }
        return valid_or_not;
    }

}

package inout;

//use it for 3-KeyboardRobotKeys automatic read and output method
import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextOperations {

    /**
     * Reads out a single file (path to the file MUST be valid) and returns it
     * as a String[]. In order to check if the path is valid, you have to check
     * for valid file-paths before
     *
     * @param file Valid path
     * @return String[]
     * @throws IOException
     */
    public static String[] actualReadFileMethod(String file) throws IOException {

        int line_counter = 0;

        BufferedReader r = new BufferedReader(new FileReader(file));

        //Count the number of lines in the textfile
        while (r.readLine() != null) {
            line_counter++;
        }

        //Create the necessary array
        String[] arr = new String[line_counter];
        r.close();
        //Reopen file
        r = new BufferedReader(new FileReader(file));
        //r.reset();

        //Read out all lines into an array
        for (int i = 0; i < line_counter; i++) {
            arr[i] = r.readLine();
        }

        r.close();

        return arr;
    }

    /**
     * opens the file, inputs it into a String[] and outputs it as keypresses
     *
     * @param path String containing the path to the file
     * @throws IOException
     * @throws AWTException
     */
    public static void outputFromTextFileAsKeyInput(String path) throws IOException, AWTException {
        //reads the file in a String[] if there is a path provided (the extraction before can also be empty)
        String[] arr = actualReadFileMethod(path);
        //outpts all Strings as Keypresses
        outputStringArrayByKeypresses(arr);
    }

    public static void outputStringByKeypress(String str) throws AWTException {
        Robot aedan = new Robot();
//don't know why, but the actua waiting timeis double
        int aedan_dealy = 8;
        for (int i = 0; i < str.length(); i++) {
            try {
                switch (str.charAt(i)) {
//<editor-fold defaultstate="collapsed" desc="Numbers">
                    case '0':
                        aedan.keyPress(48);
                        aedan.keyRelease(48);
                        aedan.delay(aedan_dealy);
                        break;
                    case '1':
                        aedan.keyPress(49);
                        aedan.keyRelease(49);
                        aedan.delay(aedan_dealy);
                        break;
                    case '2':
                        aedan.keyPress(50);
                        aedan.keyRelease(50);
                        aedan.delay(aedan_dealy);
                        break;
                    case '3':
                        aedan.keyPress(51);
                        aedan.keyRelease(51);
                        aedan.delay(aedan_dealy);
                        break;
                    case '4':
                        aedan.keyPress(52);
                        aedan.keyRelease(52);
                        aedan.delay(aedan_dealy);
                        break;
                    case '5':
                        aedan.keyPress(53);
                        aedan.keyRelease(53);
                        aedan.delay(aedan_dealy);
                        break;
                    case '6':
                        aedan.keyPress(54);
                        aedan.keyRelease(54);
                        aedan.delay(aedan_dealy);
                        break;
                    case '7':
                        aedan.keyPress(55);
                        aedan.keyRelease(55);
                        aedan.delay(aedan_dealy);
                        break;
                    case '8':
                        aedan.keyPress(56);
                        aedan.keyRelease(56);
                        aedan.delay(aedan_dealy);
                        break;
                    case '9':
                        aedan.keyPress(57);
                        aedan.keyRelease(57);
                        aedan.delay(aedan_dealy);
                        break;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Upper Case Letters">
                    case 'A':
                        aedan.keyPress(16);
                        aedan.keyPress(65);
                        aedan.keyRelease(65);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'B':
                        aedan.keyPress(16);
                        aedan.keyPress(66);
                        aedan.keyRelease(66);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'C':
                        aedan.keyPress(16);
                        aedan.keyPress(67);
                        aedan.keyRelease(67);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'D':
                        aedan.keyPress(16);
                        aedan.keyPress(68);
                        aedan.keyRelease(68);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'E':
                        aedan.keyPress(16);
                        aedan.keyPress(69);
                        aedan.keyRelease(69);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'F':
                        aedan.keyPress(16);
                        aedan.keyPress(70);
                        aedan.keyRelease(70);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'G':
                        aedan.keyPress(16);
                        aedan.keyPress(71);
                        aedan.keyRelease(71);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'H':
                        aedan.keyPress(16);
                        aedan.keyPress(72);
                        aedan.keyRelease(72);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'I':
                        aedan.keyPress(16);
                        aedan.keyPress(73);
                        aedan.keyRelease(73);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'J':
                        aedan.keyPress(16);
                        aedan.keyPress(74);
                        aedan.keyRelease(74);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'K':
                        aedan.keyPress(16);
                        aedan.keyPress(75);
                        aedan.keyRelease(75);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'L':
                        aedan.keyPress(16);
                        aedan.keyPress(76);
                        aedan.keyRelease(76);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'M':
                        aedan.keyPress(16);
                        aedan.keyPress(77);
                        aedan.keyRelease(77);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'N':
                        aedan.keyPress(16);
                        aedan.keyPress(78);
                        aedan.keyRelease(78);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'O':
                        aedan.keyPress(16);
                        aedan.keyPress(79);
                        aedan.keyRelease(79);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'P':
                        aedan.keyPress(16);
                        aedan.keyPress(80);
                        aedan.keyRelease(80);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'Q':
                        aedan.keyPress(16);
                        aedan.keyPress(81);
                        aedan.keyRelease(81);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'R':
                        aedan.keyPress(16);
                        aedan.keyPress(82);
                        aedan.keyRelease(82);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'S':
                        aedan.keyPress(16);
                        aedan.keyPress(83);
                        aedan.keyRelease(83);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'T':
                        aedan.keyPress(16);
                        aedan.keyPress(84);
                        aedan.keyRelease(84);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'U':
                        aedan.keyPress(16);
                        aedan.keyPress(85);
                        aedan.keyRelease(85);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'V':
                        aedan.keyPress(16);
                        aedan.keyPress(86);
                        aedan.keyRelease(86);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'W':
                        aedan.keyPress(16);
                        aedan.keyPress(87);
                        aedan.keyRelease(87);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'X':
                        aedan.keyPress(16);
                        aedan.keyPress(88);
                        aedan.keyRelease(88);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'Y':
                        aedan.keyPress(16);
                        aedan.keyPress(89);
                        aedan.keyRelease(89);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'Z':
                        aedan.keyPress(16);
                        aedan.keyPress(90);
                        aedan.keyRelease(90);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Lower Case Letters">
                    case 'a':
                        aedan.keyPress(65);
                        aedan.keyRelease(65);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'b':
                        aedan.keyPress(66);
                        aedan.keyRelease(66);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'c':
                        aedan.keyPress(67);
                        aedan.keyRelease(67);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'd':
                        aedan.keyPress(68);
                        aedan.keyRelease(68);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'e':
                        aedan.keyPress(69);
                        aedan.keyRelease(69);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'f':
                        aedan.keyPress(70);
                        aedan.keyRelease(70);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'g':
                        aedan.keyPress(71);
                        aedan.keyRelease(71);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'h':
                        aedan.keyPress(72);
                        aedan.keyRelease(72);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'i':
                        aedan.keyPress(73);
                        aedan.keyRelease(73);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'j':
                        aedan.keyPress(74);
                        aedan.keyRelease(74);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'k':
                        aedan.keyPress(75);
                        aedan.keyRelease(75);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'l':
                        aedan.keyPress(76);
                        aedan.keyRelease(76);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'm':
                        aedan.keyPress(77);
                        aedan.keyRelease(77);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'n':
                        aedan.keyPress(78);
                        aedan.keyRelease(78);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'o':
                        aedan.keyPress(79);
                        aedan.keyRelease(79);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'p':
                        aedan.keyPress(80);
                        aedan.keyRelease(80);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'q':
                        aedan.keyPress(81);
                        aedan.keyRelease(81);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'r':
                        aedan.keyPress(82);
                        aedan.keyRelease(82);
                        aedan.delay(aedan_dealy);
                        break;
                    case 's':
                        aedan.keyPress(83);
                        aedan.keyRelease(83);
                        aedan.delay(aedan_dealy);
                        break;
                    case 't':
                        aedan.keyPress(84);
                        aedan.keyRelease(84);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'u':
                        aedan.keyPress(85);
                        aedan.keyRelease(85);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'v':
                        aedan.keyPress(86);
                        aedan.keyRelease(86);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'w':
                        aedan.keyPress(87);
                        aedan.keyRelease(87);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'x':
                        aedan.keyPress(88);
                        aedan.keyRelease(88);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'y':
                        aedan.keyPress(89);
                        aedan.keyRelease(89);
                        aedan.delay(aedan_dealy);
                        break;
                    case 'z':
                        aedan.keyPress(90);
                        aedan.keyRelease(90);
                        aedan.delay(aedan_dealy);
                        break;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Special Characters">
                    case ' ':
                        aedan.keyPress(32);
                        aedan.keyRelease(32);
                        aedan.delay(aedan_dealy);
                        break;
                    case '?':
                        aedan.keyPress(16);
                        aedan.keyPress(61);
                        aedan.keyRelease(61);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case '!':
                        aedan.keyPress(16);
                        aedan.keyPress(49);
                        aedan.keyRelease(49);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case '"':
                        aedan.keyPress(16);
                        aedan.keyPress(50);
                        aedan.keyRelease(50);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case '§':
                        aedan.keyPress(16);
                        aedan.keyPress(51);
                        aedan.keyRelease(51);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case '$':
                        aedan.keyPress(16);
                        aedan.keyPress(52);
                        aedan.keyRelease(52);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case '%':
                        aedan.keyPress(16);
                        aedan.keyPress(53);
                        aedan.keyRelease(53);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case '&':
                        aedan.keyPress(16);
                        aedan.keyPress(54);
                        aedan.keyRelease(54);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case '(':
                        aedan.keyPress(16);
                        aedan.keyPress(56);
                        aedan.keyRelease(56);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case ')':
                        aedan.keyPress(16);
                        aedan.keyPress(57);
                        aedan.keyRelease(57);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case '[':
                        aedan.keyPress(17);
                        aedan.keyPress(18);
                        aedan.keyPress(56);
                        aedan.keyRelease(56);
                        aedan.keyRelease(17);
                        aedan.keyRelease(18);
                        aedan.delay(aedan_dealy);
                        break;
                    case ']':
                        aedan.keyPress(17);
                        aedan.keyPress(18);
                        aedan.keyPress(57);
                        aedan.keyRelease(57);
                        aedan.keyRelease(17);
                        aedan.keyRelease(18);
                        aedan.delay(aedan_dealy);
                        break;
                    case '{':
                        aedan.keyPress(17);
                        aedan.keyPress(18);
                        aedan.keyPress(55);
                        aedan.keyRelease(55);
                        aedan.keyRelease(17);
                        aedan.keyRelease(18);
                        aedan.delay(aedan_dealy);
                        break;
                    case '}':
                        aedan.keyPress(17);
                        aedan.keyPress(18);
                        aedan.keyPress(48);
                        aedan.keyRelease(48);
                        aedan.keyRelease(17);
                        aedan.keyRelease(18);
                        aedan.delay(aedan_dealy);
                        break;
                    case '+':
                        aedan.keyPress(521);
                        aedan.keyRelease(521);
                        aedan.delay(aedan_dealy);
                        break;
                    case '-':
                        aedan.keyPress(45);
                        aedan.keyRelease(45);
                        aedan.delay(aedan_dealy);
                        break;
                    case '*':
                        aedan.keyPress(106);
                        aedan.keyRelease(106);
                        aedan.delay(aedan_dealy);
                        break;
                    case '/':
                        aedan.keyPress(111);
                        aedan.keyRelease(111);
                        aedan.delay(aedan_dealy);
                        break;
                    case '=':
                        aedan.keyPress(16);
                        aedan.keyPress(48);
                        aedan.keyRelease(48);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case '\\':
                        aedan.keyPress(17);
                        aedan.keyPress(18);
                        aedan.keyPress(92);
                        aedan.keyRelease(92);
                        aedan.keyRelease(17);
                        aedan.keyRelease(18);
                        aedan.delay(aedan_dealy);
                        break;
                    case '.':
                        aedan.keyPress(46);
                        aedan.keyRelease(46);
                        aedan.delay(aedan_dealy);
                        break;
                    case ',':
                        aedan.keyPress(110);
                        aedan.keyRelease(110);
                        aedan.delay(aedan_dealy);
                        break;
                    case ':':
                        aedan.keyPress(16);
                        aedan.keyPress(46);
                        aedan.keyRelease(46);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case ';':
                        aedan.keyPress(16);
                        aedan.keyPress(110);
                        aedan.keyRelease(110);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case '#':
                        aedan.keyPress(520);
                        aedan.keyRelease(520);
                        aedan.delay(aedan_dealy);
                        break;
                    case '\'':
                        aedan.keyPress(17);
                        aedan.keyPress(520);
                        aedan.keyRelease(520);
                        aedan.keyRelease(17);
                        aedan.delay(aedan_dealy);
                        break;
                    case '|':
                        aedan.keyPress(17);
                        aedan.keyPress(18);
                        aedan.keyPress(153);
                        aedan.keyRelease(153);
                        aedan.keyRelease(17);
                        aedan.keyRelease(18);
                        aedan.delay(aedan_dealy);
                        break;
                    case '<':
                        aedan.keyPress(153);
                        aedan.keyRelease(153);
                        aedan.delay(aedan_dealy);
                        break;
                    case '>':
                        aedan.keyPress(16);
                        aedan.keyPress(153);
                        aedan.keyRelease(153);
                        aedan.keyRelease(16);
                        aedan.delay(aedan_dealy);
                        break;
                    case '\n':
                        aedan.keyPress(10);
                        aedan.keyRelease(10);
                        aedan.delay(aedan_dealy);
                        break;

//</editor-fold>
//when changing the defaultkey, you also have to change
//the placeholder part of the message in the exception catch below
                    default:
                        aedan.keyPress(17);
                        aedan.keyPress(18);
                        aedan.keyPress(521);
                        aedan.keyRelease(521);
                        aedan.keyRelease(17);
                        aedan.keyRelease(18);
                        break;
                }
            } catch (IllegalArgumentException e) {
                //release CTRL, SHIFT, ALT
                aedan.keyRelease(16);
                aedan.keyRelease(17);
                aedan.keyRelease(18);

                //press ENTER to be able to see the already inputed keys
                aedan.keyPress(10);
                aedan.keyRelease(10);

                inout.TextOperations.outputStringByKeypress("-> Seems like the key for the next character doesn't exist on your keyboard!");
                System.out.println("Char: " + str.charAt(i));
                inout.TextOperations.outputStringByKeypress("-> Please map the missing keys to have a valid output.");
            }
        }
        aedan.keyPress(10);
        aedan.keyRelease(10);
        aedan.delay(aedan_dealy);
    }

    public static void outputStringArrayByKeypresses(String[] arr) throws AWTException {

        for (int i = 0; i < arr.length; i++) {
            outputStringByKeypress(arr[i]);
        }

    }

    /**
     * Saves the String[] into a File to a specifed Path.
     *
     * @param filepath Filefath to be saved to.
     * @param textlines String[] that should be saved.
     * @throws IOException
     */
    public static void saveStringArrayToFile(String filepath, String[] textlines) throws IOException {
        BufferedWriter w = new BufferedWriter(new FileWriter(filepath));

        for (int i = 0; i < textlines.length; i++) {
            w.write(textlines[i] + "\n", 0, textlines[i].length());
            if (i < textlines.length - 1) {
                w.newLine();
            }
        }

        w.close();
    }

}

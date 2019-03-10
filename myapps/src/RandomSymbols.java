/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapps;

import java.util.Random;

/**
 * 100000 Rows a 80 random Symbols = 16 secs;
 *
 * 100000 Rows a 80 random Nums = 11 secs;
 *
 * @author Alex
 */
public class RandomSymbols {

    //Global Settings
    //static int type = 8;
    static int min_word_length = 3; //Min Number of Letters in a Word
    static int max_word_length = 12; //Max Number of Letters in a Word

    //Settings for Text, Sentence & Word Generator
    static int min_sentence_length = 4; //Min Number of Words in a Sentence
    static int max_sentence_length = 15; //Max Number of Words in a Sentence
    static int min_text_length = 3; //Min number of Sentences in a Text
    static int max_text_length = 20; //Max number of Sentences in a Text
    static boolean use_max_line_length = true; //Activates or deactivates next Variable and the corresponding Function
    static int max_line_length = 81; //Maxmimal Length of a line (always +1!)f; Words should not pass this Length Mark
    static boolean separate_every_line = true; //Makes a Linebreak after every Line

    //Settings for "Words only" Methods
    static boolean last_space = true; //Initiave setting
    static boolean new_sentence = false; //Initiave setting
    static int max_row_length = 80;
    static int max_rows = 100;

    //Random number Generator for all the Methods
    static Random r = new Random();

    static String test = "aaaa bbbb cccc dddd eeee ffff gggg hhhh iiii jjjjj kkkk llll mmmm nnnn oooo pppp qqqq rrrr ssss tttt uuuu vvvv wwww xxxxx yyyy zzzz";

    public static void main(int type) {

        switch (type) {
            case 0:
                allSymbols();
                break;
            case 1:
                randomNums();
                break;
            case 2:
                randomLettersBig();
                break;
            case 3:
                randomLettersSmall();
                break;
            case 4:
                randomLetters();
                break;
            case 5:
                randomWords();
                break;
            case 6:
                randomWord();
                break;
            case 7:
                System.out.println(randomSentence());
                break;
            case 8:
                System.out.println(makeDashedLine());
                System.out.println(randomText());
                break;
            default:
                randomSymbols();
                break;
        }

    }

    private static void allSymbols() {
        for (int i = 0; i < 256; i++) {
            System.out.println(i + ": " + (char) i);
        }
    }

    private static void randomSymbols() {
        for (int i = 0; i < max_rows; i++) {
            int n = new Random().nextInt(max_row_length) + (max_row_length / 10);
            for (int j = 0; j < n; j++) {
                int x = new Random().nextInt(189) + 32;
                if (x > 126) {
                    x += 34;
                }

                System.out.print((char) x);
            }

            System.out.println();
        }
    }

    private static void randomNums() {
        for (int i = 0; i < max_rows; i++) {
            int n = new Random().nextInt(max_row_length) + (max_row_length / 10);
            for (int j = 0; j < n; j++) {
                int x = new Random().nextInt(10) + 48;

                System.out.print((char) x);
            }

            System.out.println();
        }
    }

    private static void randomLettersBig() {
        for (int i = 0; i < max_rows; i++) {
            int n = new Random().nextInt(max_row_length) + (max_row_length / 10);
            for (int j = 0; j < n; j++) {
                int x = new Random().nextInt(26) + 65;

                System.out.print((char) x);
            }

            System.out.println();
        }
    }

    private static void randomLettersSmall() {
        for (int i = 0; i < max_rows; i++) {
            int n = new Random().nextInt(max_row_length) + (max_row_length / 10);
            for (int j = 0; j < n; j++) {
                int x = new Random().nextInt(26) + 97;

                System.out.print((char) x);
            }

            System.out.println();
        }
    }

    private static void randomLetters() {
        for (int i = 0; i < max_rows; i++) {
            int n = new Random().nextInt(max_row_length) + (max_row_length / 10);
            for (int j = 0; j < n; j++) {
                int x = new Random().nextInt(52) + 65;
                if (x > 90) {
                    x += 6;
                }

                System.out.print((char) x);
            }

            System.out.println();
        }
    }

    private static void randomWords() {
        last_space = false;
        int x;
        Random r = new Random();

        for (int i = 0; i < max_rows; i++) {
            int n = new Random().nextInt(max_row_length) + (max_row_length / 10);

            for (int j = 0; j < n; j++) {
                //First Letter of Row Procedure
                if (j == 0) {
                    //Skips the Space and pick Big Letter
                    x = r.nextInt(26) + 65;
                    //Reset when new line
                    last_space = false;
                } else {
                    //Pick a small Letter
                    x = r.nextInt(27) + 96;

                    //When it should be a space
                    if (x < 97) {
                        x -= 64;
                    }

                    if (last_space) {
                        if (r.nextBoolean()) {
                            x -= 32;
                        }
                        last_space = false;
                    }

                    if (x == 32) {
                        last_space = true;
                    }
                }

                System.out.print((char) x);
            }

            System.out.println();
        }
    }

    private static String replaceCharAt(String s, int pos) {
        String part1 = "", part2 = "";

        //Divide the Text into two Parts - before and after the given Position
        //Takes the chars starting with the starting Position and ending with the Position one before the ending Position
        part1 = s.substring(0, pos);
        part2 = s.substring(pos + 1, s.length());

        //Add a Linebreak
        s = part1 + "\n" + part2;

        return s;
    }

    private static int uncertainCapitalLetter(int x, Random r) {
        //Randomize if the next Letter should be a Capital Letter when the last Symbol was a Space
        if (r.nextInt(4) == 0) {
            if (x > 96 && x < 123) {
                x -= 32;
            } else if (x > 64 && x < 91) {
                //Nothing should change
            } else {
                x = 32;
            }
        }
        return x;
    }

    private static int forShureCapitalLetter(int x) {
        if (x > 96 && x < 123) {
            x -= 32;
        } else if (x > 64 && x < 91) {
            //Nothing should change
        } else {
            x = 32;
        }

        return x;
    }

    private static String randomText() {
        int n = r.nextInt(max_text_length - min_text_length) + min_text_length;
        //Initialisation
        String text = "";

        for (int i = 0; i < n; i++) {
            text += randomSentence();
        }

        text = text.trim();

        //Next 3 Lines to be deleted
        /* text = test;
        System.out.println("Text:");
        System.out.println(text);
         */
        if (use_max_line_length && !separate_every_line) {
            text = makeMaxLines(text);
        }

        return text;
    }

    private static String randomSentence() {
        last_space = false;
        new_sentence = true;
        String sentence = "";

        //Sentence Length
        int n = r.nextInt(max_sentence_length - min_word_length) + min_word_length;

        //First Word
        sentence += randomWord();
        new_sentence = false;
        //Rest of the sentence
        for (int i = 0; i < n; i++) {
            last_space = true;
            sentence = sentence + " " + randomWord();
        }

        //Punctuation
        if (separate_every_line) {
            sentence += ".\n";
            if (use_max_line_length) {
                sentence = makeMaxLines(sentence);
            }
        } else {
            sentence += ". ";
            if (use_max_line_length) {
                sentence = makeMaxLines(sentence);
            }
        }

        return sentence;
    }

    private static String randomWord() {
        int x;
        String word = "";

        int n = new Random().nextInt(max_word_length - min_word_length) + min_word_length;

        for (int j = 0; j < n; j++) {
            //Pick a small Letter
            //2/3 Random Letters; 1/3 Vocals
            if (r.nextInt(3) <= 1) {
                x = r.nextInt(26) + 97;
            } else {
                int vocal = r.nextInt(5);
                if (vocal == 0) {
                    x = 97;
                } else if (vocal == 1) {
                    x = 101;
                } else if (vocal == 2) {
                    x = 105;
                } else if (vocal == 3) {
                    x = 111;
                } else {
                    x = 117;
                }
            }

            if (last_space) {
                x = uncertainCapitalLetter(x, r);
                last_space = false;
            }

            if (new_sentence) {
                x = forShureCapitalLetter(x);
                new_sentence = false;
            }

            word += (char) x;
        }

        return word;
    }

    private static String makeMaxLines(String text) {
        String maxline;
        int nextlinemarker = 0;
        int maxlinelength = 0;

        try {
            do {   //System.out.println(text);
                //Set the Starting and Ending Positions
                if (nextlinemarker + max_line_length <= text.length() - 1) {
                    maxlinelength = nextlinemarker + max_line_length;
                } else {
                    //maxlinelength = text.length() - 1;
                    break;
                }
                //Split for a String as long as the maximum Line Length
                maxline = text.substring(0, maxlinelength);
                //System.out.println("Maxline Length: " + maxline.length());
                //System.out.println("Maxline: " + "\n" + maxline);
                //Mark the Position of the last Space in this Line
                nextlinemarker = maxline.lastIndexOf(32);
                //System.out.println("Nextlinemarker: " + nextlinemarker);
                //System.out.println();
                //Re-save the Text
                text = replaceCharAt(text, nextlinemarker);
                nextlinemarker++;

                //System.out.println("AtTheEndOfTheLoop:\n" + text);
            } while (maxlinelength != text.length() - 1);
        } catch (RuntimeException e) {
            System.out.println("ERROR: " + e);
        }

        return text;
    }

    private static String makeDashedLine() {
        String dl = "";

        for (int i = 0; i < max_line_length - 1; i++) {
            dl += '-';
        }

        return dl;
    }

}

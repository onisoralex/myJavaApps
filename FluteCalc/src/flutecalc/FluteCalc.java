/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flutecalc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import static maths.Calculations.sqrt;
import static geometrics.AreaVolumeCalculations.*;
/*
import static fileandtextstuff.TextOperations.actualReadFileMethod;
import static others.Basics.regexTheString;
import physics.Wave;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
*/

/**
 *
 * @author Alex
 */
public class FluteCalc {

    static boolean gui_deactivated = true;
    static Flute f; //This can be transformed in an Array to make multiple Flutes at once by some kind of Tab Function.
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        gui.FXML.main(args);

        if (gui_deactivated) {
            System.out.println("-> If a Value should be ommited enter \"-1\"! \n");
            System.out.println("-> Tappered Bore is not supported yet! Only one Bore Size will be asked for!\n");

            System.out.print("Flute Name: ");
            f = new Flute(sc.nextLine());



            setBaseTone(f);
            setWallThickness(f);
            setBoreDiameter(f);
            setEmbouchureHole(f);

            int asd = 1;
            String str;

            while (asd == 1) {
                System.out.println("\n\n-> Enter the specified numbers to pick an Option.\n");
                System.out.println("0: Show all Stats");
                System.out.println("1: Change Flute Name");
                System.out.println("2: Change Base Tone");
                System.out.println("3: Change Wall thickness");
                System.out.println("4: Change Bore Diameter");
                System.out.println("5: Set Embouchure Hole");
                System.out.println("6: Set Change Tonehole Position");
                System.out.println("7: Set Tonehole Diameter");
                /*Will be supported later
                 System.out.println("8: Set Custom Tonehole Chimney");
                 Will be supported later
                 System.out.println("9: Set Tonhole Undercut");
                 */
                System.out.println("quit: Close\n");
                System.out.print("> ");

                str = sc.nextLine();

                switch (str) {
                    case "0":
                        showAllStats(f);
                        break;
                    case "1":
                        setFluteName(f);
                        break;
                    case "2":
                        setBaseTone(f);
                        break;
                    case "3":
                        setWallThickness(f);
                        break;
                    case "4":
                        setBoreDiameter(f);
                        break;
                    case "5":
                        setEmbouchureHole(f);
                        break;
                    case "6":
                        setToneHolePositions(f);
                        break;
                    case "7":
                        setToneHoleDiameter(f);
                        break;
                    case "8":
                        setToneHoleChimney(f);
                        break;
                    case "9":
                        setToneHoleUndercut(f);
                        break;
                    case "quit":
                        asd = 0;
                        break;
                }
            }

            sc.close();

        } else {
            System.out.println("-> Output over GUI not existent!");
        }
    }

    public static void showAllStats(Flute f) {

        System.out.println("-> Flute Name: " + f.flute_name);
        System.out.println("-> Base Tone: " + f.flute_base_tone);
        System.out.println("-> Wall Thickness: " + f.wall_thickness);
        System.out.println("-> Bore Diameter: " + f.bore_diameter_head);
        System.out.println();
        System.out.println("-> Embouchure Hole Type: " + f.emb_hole_type);
        System.out.println("-> Embouchure Hole Length: " + f.emb_hole_l);
        System.out.println("-> Embouchure Hole Width: " + f.emb_hole_w);
        if (f.emb_hole_type == 0) {
            System.out.println("-> Embouchure Hole Radius: " + f.emb_hole_r);
        }
        System.out.println("-> Embouchure Hole Area: " + f.emb_hole_a);
        System.out.println();
        for (int i = 0; i < f.tone_hole_position.length; i++) {
            System.out.println("-> Tone Hole " + i + " Position: " + f.tone_hole_position[i]);
        }
        System.out.println();
        for (int i = 0; i < f.tone_hole_diameter.length; i++) {
            System.out.println("-> Tone Hole " + i + " Diameter: " + f.tone_hole_diameter[i]);
        }
        System.out.println();
        for (int i = 0; i < f.tone_hole_chimney.length; i++) {
            System.out.println("-> Tone Hole " + i + " Chimney: " + f.tone_hole_chimney[i]);
        }
        System.out.println();
        for (int i = 0; i < f.tone_hole_undercut.length; i++) {
            System.out.println("-> Tone Hole " + i + " Undercut: " + f.tone_hole_undercut[i]);
        }

    }

    private static void setFluteName(Flute f) {
        System.out.print("Flute Name (actual: " + f.flute_name + "): ");
        f.flute_name = sc.nextLine();
    }

    private static void setBaseTone(Flute f) {
        System.out.print("Base Tone (actual: " + f.flute_base_tone + "): ");
        f.flute_base_tone = sc.nextLine();
    }

    /* private static BigDecimal getFluteFrequency(Flute f) {
        //Read from the frequency table and save the entry;
        String[] freq;
        String[] split;
        boolean freq_found = false;
        BigDecimal frequency = negone;

        try {
            //When theFilecan not be found, it will log the Exception and output a message.
            freq = actualReadFileMethod(".\\NotesFrequencies");

            //When the given Base note is found, get it's frequency
            for (String freq1 : freq) {
                if (regexTheString(f.flute_base_tone, freq1) == true) {
                    split = freq1.split(" ");
                    frequency = new BigDecimal(split[1]);
                    freq_found = true;
                    break;
                }
            }

            if (freq_found) {
                System.out.print("Flute Frquency = " + f.flute_base_frequency);
            } else {
                f.flute_base_tone = "D4";
                frequency = new BigDecimal("293,665");
                System.out.println("-> Since you didn't enter a valid Base Note, I've set it to \"D4\"!");
            }

        } catch (IOException ex) {
            System.out.println();
            Logger.getLogger(FluteCalc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return frequency;
    } */

    /* private static BigDecimal getFluteLength(Flute f) {
        // LAMBDA / 2
        BigDecimal length = Wave.lambdaHalf(getFluteFrequency(f), const_sonic);
        System.out.print("Flute Length = " + length);

        return length;
    } */

    private static void setWallThickness(Flute f) {
        System.out.print("Wall Thickness (actual: " + f.wall_thickness + "): ");
        f.wall_thickness = new BigDecimal(getValidNumberInput());

        if (f.emb_hole_chimney != f.wall_thickness) {
            f.emb_hole_chimney = f.wall_thickness;
            for (int i = 0; i < f.tone_hole_chimney.length; i++) {
                f.tone_hole_chimney[i] = f.wall_thickness;
            }
            System.out.println("The Chimney Heights were changed to be the same as the Wall Thickness!");
        }
    }

    private static void setBoreDiameter(Flute f) {
        System.out.print("Bore Diameter (actual: " + f.bore_diameter_head + "): ");
        f.bore_diameter_head = new BigDecimal(getValidNumberInput());

        //Commented code should replace above code when tapepered Bore is spported
        /*
         f.bore_diameter_middle = f.bore_diameter_head;
         f.bore_diameter_foot = f.bore_diameter_head;
         System.out.print("Bore Diameter at Head: ");
         f.bore_diameter_head = new BigDecimal(sc.nextLine());
         System.out.print("Bore Diameter in the Middle: ");
         f.bore_diameter_middle = new BigDecimal(sc.nextLine());
         System.out.print("Bore Diameter an Foot: ");
         f.bore_diameter_foot = new BigDecimal(sc.nextLine());
         */
    }

    /* private static BigDecimal getLengthToBoreRatio(Flute f) {
        return getFluteLength(f).divide(f.bore_diameter_head, const_calc_prec, RoundingMode.HALF_UP);
    } */

    private static void setEmbouchureHole(Flute f) {
        int valid_info_counter = 0;

        System.out.println();

        System.out.print("Embouchure Hole Type (0 = Ellyptical; 1 = Rounded Rectangular) (actual: " + f.emb_hole_type + "): ");
        f.emb_hole_type = new BigDecimal(getValidNumberInput()).intValue();

        System.out.print("Embouchure Hole Length (actual: " + f.emb_hole_l + "): ");
        f.emb_hole_l = new BigDecimal(getValidNumberInput());
        if (f.emb_hole_l.signum() == 1) {
            valid_info_counter++;
        }

        System.out.print("Embouchure Hole Width (actual: " + f.emb_hole_w + "): ");
        f.emb_hole_w = new BigDecimal(getValidNumberInput());
        if (f.emb_hole_w.signum() == 1) {
            valid_info_counter++;
        }

        //Radius is only needed when the type is a Rounded Rectangular
        if (f.emb_hole_type == 1) {
            System.out.print("Embouchure Hole Radius (actual: " + f.emb_hole_r + "): ");
            f.emb_hole_r = new BigDecimal(getValidNumberInput());

            //Embouchure Hole Radius shall not be bigger than (l/2) || (w/2)
            if (f.emb_hole_r.compareTo(f.emb_hole_l.divide(two, const_calc_prec, RoundingMode.HALF_UP)) == 1
                    || f.emb_hole_r.compareTo(f.emb_hole_w.divide(two, const_calc_prec, RoundingMode.HALF_UP)) == 1) {
                System.out.println("-> Because then entered Radius is bigger than the Embouchure Hole Length or Width, the Radius is set to halfof the smaller Value (rounded down)!");
                if (f.emb_hole_l.compareTo(f.emb_hole_w) <= 0) {
                    f.emb_hole_r = f.emb_hole_l.divide(two, const_calc_prec, RoundingMode.HALF_DOWN);
                }
            }

            if (f.emb_hole_r.signum() == 1) {
                valid_info_counter++;
            }
        }

        //Area acquisition
        //If it is Ellipse
        if (f.emb_hole_type == 0) {
            if (valid_info_counter == 2) {
                //If both dimensions are givencalculate the Area
                f.emb_hole_a = ellipseArea(f.emb_hole_l, f.emb_hole_w);
                System.out.println("-> Embouchure Hole Area = " + f.emb_hole_a);
            } else if (valid_info_counter == 1) {
                System.out.print("Embouchure Hole Area (actual: " + f.emb_hole_a + "): ");
                f.emb_hole_a = new BigDecimal(getValidNumberInput());
                if (f.emb_hole_a.signum() == 1) {
                    valid_info_counter++;
                }

                if (valid_info_counter == 2) {
                    //If a diension exists and also does the Area, calculate the other dimension
                    if (f.emb_hole_l.signum() != 1) {
                        f.emb_hole_w = f.emb_hole_a.divide(f.emb_hole_l, const_calc_prec, RoundingMode.HALF_UP);
                    } else if (f.emb_hole_w.signum() != 1) {
                        f.emb_hole_l = f.emb_hole_a.divide(f.emb_hole_w, const_calc_prec, RoundingMode.HALF_UP);
                    }

                } else if (valid_info_counter == 1) {
                    System.out.println("-> How should I get the dimensions of the embouchure hole correct, if you provide only the Area?!?");
                    System.out.println("-> I will just set it to a ratio of 2:1 Length to Width! Deal with that!");

                    //Calculate the Length and Width by the Area to a ratio of 2:1
                    f.emb_hole_w = maths.Calculations.sqrt(f.emb_hole_a.divide(two, const_calc_prec, RoundingMode.HALF_UP), const_calc_prec);
                    f.emb_hole_l = f.emb_hole_w.multiply(two);

                } else if (valid_info_counter == 0) {
                    System.out.println("-> Well, I can't calculate anything, if you din't proviede any information...");
                    System.out.println("-> Length & Width will be set to 1 and Area calculated respectively.");

                    f.emb_hole_l = one;
                    f.emb_hole_w = one;
                    f.emb_hole_a = ellipseArea(f.emb_hole_l, f.emb_hole_w);

                }

            } else {
                System.out.println("-> Well, I can't calculate anything, if you din't proviede any information...");
                System.out.println("-> Length & Width will be set to 1 and Area calculated respectively.");

                f.emb_hole_l = one;
                f.emb_hole_w = one;
                f.emb_hole_a = ellipseArea(f.emb_hole_l, f.emb_hole_w);
            }

            //If it is Rounded Rectangle
        } else if (f.emb_hole_type == 1) {
            if (valid_info_counter == 3) {
                //If everything is given, calculate the Area
                f.emb_hole_a = roundedRectangleArea(f.emb_hole_l, f.emb_hole_w, f.emb_hole_r);
            } else if (valid_info_counter == 2) {
                System.out.print("Embouchure Hole Area (actual: " + f.emb_hole_a + "): ");
                f.emb_hole_a = new BigDecimal(getValidNumberInput());
                if (f.emb_hole_a.signum() == 1) {
                    valid_info_counter++;
                }

                //After Area is (hoopefully) entered, calculate remaining variables
                if (valid_info_counter == 3) {
                    //If a diension exists and also does the Area, calculate the other dimension
                    if (f.emb_hole_l.signum() != 1) {
                        //   x = (2r)^2 - r^2 * pi = r^2 * (4 - pi)
                        BigDecimal x = (f.emb_hole_r.pow(2)).multiply(four.subtract(const_pi));
                        //   l = (a + x) / w
                        f.emb_hole_l = (f.emb_hole_a.add(x)).divide(f.emb_hole_w, const_calc_prec, RoundingMode.HALF_UP);

                    } else if (f.emb_hole_w.signum() != 1) {
                        //   x = (2r)^2 - r^2 * pi = r^2 * (4 - pi)
                        BigDecimal x = (f.emb_hole_r.pow(2)).multiply(four.subtract(const_pi));
                        //   w = (a + x) / l
                        f.emb_hole_w = (f.emb_hole_a.add(x)).divide(f.emb_hole_l, const_calc_prec, RoundingMode.HALF_UP);

                    } else if (f.emb_hole_r.signum() != 1) {
                        //   x = (l * w) - a
                        BigDecimal x = (f.emb_hole_l.multiply(f.emb_hole_w)).subtract(f.emb_hole_a);
                        //  r = sqrt( x / (4 - pi))
                        f.emb_hole_r = sqrt(x.divide(four.subtract(const_pi), const_calc_prec, RoundingMode.HALF_UP));

                    }

                    //This solution was omitted due to lack of useability. If not enough Information is set, just enter it again!
                    /*} else if (valid_info_counter == 2) {
                     System.out.println("-> How should I get the dimensions of the embouchure hole correct, if you don't provide enough Information?!?");
                     System.out.println("-> I will just set it to a ratio of 2:1 Length to Width with a Radius of 1/2! Deal with that!");

                     //ToDo: Calculate the Length and Width by the Area to a ratio of 2:1
                     f.emb_hole_w = calc.Calculations.sqrt(f.emb_hole_a.divide(two, const_calc_prec, RoundingMode.HALF_UP), const_calc_prec);
                     f.emb_hole_l = f.emb_hole_w.multiply(two);
                     */
                } else if (valid_info_counter >= 0 && valid_info_counter <= 2) {
                    //This was omitted from the same reason of the above code. Functionality of the above was integrated into this if-Function.
                    /*System.out.println("-> Well, I can't calculate anything, if you din't proviede any information (or just one Variable)...");
                     System.out.println("-> Length & Width will be set to 1, Radius to 1/2 and Area calculated respectively.");
                     */
                    System.out.println("-> Well, I can't calculate anything, if you din't proviede enough information ...");
                    System.out.println("-> Length & Width will be set to 1, Radius to 1/2 and Area calculated respectively.");

                    f.emb_hole_l = one;
                    f.emb_hole_w = one;
                    f.emb_hole_r = one.divide(two);
                    f.emb_hole_a = roundedRectangleArea(f.emb_hole_l, f.emb_hole_w, f.emb_hole_r);

                }
            } else {
                System.out.println("-> Well, I can't calculate anything, if you din't proviede enough information ...");
                System.out.println("-> Length & Width will be set to 1, Radius to 1/2 and Area calculated respectively.");

                f.emb_hole_l = one;
                f.emb_hole_w = one;
                f.emb_hole_r = one.divide(two);
                f.emb_hole_a = roundedRectangleArea(f.emb_hole_l, f.emb_hole_w, f.emb_hole_r);

            }

        } else {
            System.out.println("-> You have chosen an invalid Embouchure Hole Type!");
            System.out.println("-> No Calculations have been made!");
        }

        System.out.print("Embouchure Hole Chimney (actual: " + f.emb_hole_chimney + "): ");
        f.emb_hole_r = new BigDecimal(getValidNumberInput());
        System.out.print("Embouchure Hole Undercut in degree(actual: " + f.emb_hole_undercut + "): ");
        f.emb_hole_r = new BigDecimal(getValidNumberInput());

    }

    private static void setToneHolePositions(Flute f) {
        for (int i = 0; i < f.tone_hole_position.length; i++) {
            System.out.println("-> Tone Hole " + i + " Position (actual: " + f.tone_hole_position[i] + "): " + f.tone_hole_position[i]);
        }
    }

    private static void setToneHoleDiameter(Flute f) {
        for (int i = 0; i < f.tone_hole_diameter.length; i++) {
            System.out.println("-> Tone Hole " + i + " Diameter (actual: " + f.tone_hole_diameter[i] + "): " + f.tone_hole_diameter[i]);
        }
    }

//Will be supported later
    private static void setToneHoleChimney(Flute f) {
        for (int i = 0; i < f.tone_hole_chimney.length; i++) {
            System.out.println("-> Tone Hole " + i + " Chimney (actual: " + f.tone_hole_chimney[i] + "): " + f.tone_hole_chimney[i]);
        }
    }

//Will be supported later
    private static void setToneHoleUndercut(Flute f) {
        for (int i = 0; i < f.tone_hole_undercut.length; i++) {
            System.out.println("-> Tone Hole " + i + " Undercut (actual: " + f.tone_hole_undercut[i] + "): " + f.tone_hole_undercut[i]);
        }
    }

    private static String getValidNumberInput() {
        String out;

        out = sc.nextLine();
        if (out == "" || out == "0" || out == null) {
            out = "-1";
        }

        return out;
    }

}

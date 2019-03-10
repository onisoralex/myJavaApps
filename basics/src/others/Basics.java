package others;

import static java.lang.Thread.sleep;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Basics {

    public static void systemOutArray(String[] str_arr) {
        System.out.println("-----String Array START-----");
        if (str_arr == null) {
            System.out.println("Array doesn't contain anything");
        } else {
            for (String str_arr1 : str_arr) {
                System.out.println("-> " + str_arr1 + " <-");
            }
        }
        System.out.println("-----String Array END-----");
    }

    public static void systemOutArray(BigDecimal[] dec_arr) {
        System.out.println("-----BigDecimal Array START-----");
        if (dec_arr == null) {
            System.out.println("Array doesn't contain anything");
        } else {
            for (BigDecimal dec_arr1 : dec_arr) {
                System.out.println("-> " + dec_arr1 + " <-");
            }
        }
        System.out.println("-----BigDecimal Array END-----");
    }

    /**
     * A String will be lengthened to a desired length by adding spaces in front
     * of it.
     *
     * @param str String to be lengthened
     * @param len Desired length
     * @return String
     */
    public static String addSpacesFront(String str, int len) {
        String res = str;
        for (int i = str.length(); i < len; i++) {
            res = " " + res;
        }
        return res;
    }

    /**
     * A String will be lengthened to a desired length by adding spaces at it's
     * tail.
     *
     * @param str String to be lengthened
     * @param len Desired length
     * @return String
     */
    public static String addSpacesBack(String str, int len) {
        String res = str;
        for (int i = str.length(); i < len; i++) {
            res = res + " ";
        }
        return res;
    }

    public static void startingCountdown(int cd) {
        try {
            sleep(1000);
            System.out.println("Start in...");
            for (int i = cd; i > 0; i--) {
                System.out.println(i + "...");
                sleep(1000);
            }
            System.out.println("START!!!");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Thread Error: " + ex);
        }
    }

    public static void stopingCountdown(int cd) {
        try {
            sleep(1000);
            System.out.println("Stop in...");
            for (int i = cd; i > 0; i--) {
                System.out.println(i + "...");
                sleep(1000);
            }
            System.out.println("STOP!!!");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Thread Error: " + ex);
        }
    }

    public static String toString(BigDecimal bd) {
        return bd.toString();
    }

    public static boolean regexTheString(String pattern, String text) {
        boolean result;

        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(text);

        mat.find();

        if (mat.group() != null) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

//<editor-fold defaultstate="collapsed" desc="Binary Operations">
    /**
     * Turns a number into a whole number and then into its binary form. If
     * theNumber is aDecimal Number it will be truncated.
     *
     * @param n - BigDecimal number to be binarized
     * @return String
     */
    public static String bigDecToBin(BigDecimal n) {
        String ret = bigIntToBin(n.toBigInteger());

        return ret;
    }

    /**
     * Turns a whole number into its binary form.
     *
     * @param n - BigInteger number to be binarized
     * @return String
     */
    public static String bigIntToBin(BigInteger n) {
        String ret = "";
        BigInteger two = ConstantsDefinitions.two.toBigInteger();

        while (n.compareTo(two) >= 0) {
            ret = n.remainder(two).toString() + ret;
            n = n.divide(two);
        }
        ret = n.remainder(two).toString() + ret;

        return ret;
    }

    /**
     * Turns a number into a whole number and then into its binary form.
     *
     * @param bin - Binary Number to be decimalized
     * @return String
     */
    public static BigDecimal binToBigDec(String bin) {
        BigDecimal ret = null;
        boolean binary = Basics.checkIfBinary(bin);

        if (binary) {
            ret = new BigDecimal(Basics.binToBigInt(bin).toString());
        } else {
            ret = null;
        }

        return ret;
    }

    /**
     * Turns a whole number into its binary form.
     *
     * @param bin - Binary Number to be integerized
     * @return String
     */
    public static BigInteger binToBigInt(String bin) {
        BigInteger ret = new BigInteger("0");
        BigInteger one = ConstantsDefinitions.one.toBigInteger();
        BigInteger two = ConstantsDefinitions.two.toBigInteger();
        boolean binary = Basics.checkIfBinary(bin);

        if (binary == true) {
            for (int i = 0; i < bin.length(); i++) {
                ret = ret.multiply(two);
                if (bin.charAt(i) == '1') {
                    ret = ret.add(one);
                }
            }
        } else {
            ret = null;
        }

        return ret;
    }

    /**
     * Checks if a String contains only "0" and "1". Returns "true" if yes and
     * "false" if no or the string is empty.
     *
     * @param bin - String containing a Binary number
     * @return boolean
     */
    public static boolean checkIfBinary(String bin) {
        boolean binary = true;
        int it = 0;

        try {
            do {
                if (bin.charAt(it) == '0' || bin.charAt(it) == '1') {
                    //do nothing
                } else {
                    binary = false;
                }
                it++;
            } while (binary == true && it < bin.length());
        } catch (IndexOutOfBoundsException e) {
            binary = false;
        }

        return binary;
    }

    /**
     * "Find First Set"-Function
     *
     * @param bin
     * @return
     */
    public static int ffs(String bin) {
        return (ctz(bin) + 1) % (bin.length() + 1);
    }

    /**
     * "Find First Zero"-Function
     *
     * @param bin
     * @return
     */
    public static int ffz(String bin) {
        return (cto(bin) + 1) % (bin.length() + 1);
    }

    /**
     * "Find Last Set"-Function
     *
     * @param bin
     * @return
     */
    public static int fls(String bin) {
        return bin.length() - clz(bin);
    }

    /**
     * "Find Last Zero"-Function
     *
     * @param bin
     * @return
     */
    public static int flz(String bin) {
        return bin.length() - clo(bin);
    }

    /**
     * "Count Trailing Ones"-Function
     *
     * @param bin
     * @return
     */
    public static int cto(String bin) {
        int ret = 0;
        int it = 0;

        if (checkIfBinary(bin)) {
            try {
                char[] ch = bin.toCharArray();
                do {
                    if (ch[bin.length() - 1 - it] == '1') {
                        it++;
                        ret = it;
                    } else {
                        it = bin.length();
                    }
                } while (it < bin.length());
            } catch (IndexOutOfBoundsException e) {
                ret = -1;
            }
        } else {
            System.out.println("--> Number-Format is not Biary!");
            ret = -1;
        }

        return ret;
    }

    /**
     * "Count Trailing Zeros"-Function
     *
     * @param bin
     * @return
     */
    public static int ctz(String bin) {
        int ret = 0;
        int it = 0;

        if (checkIfBinary(bin)) {
            try {
                char[] ch = bin.toCharArray();
                do {
                    if (ch[bin.length() - 1 - it] == '0') {
                        it++;
                        ret = it;
                    } else {
                        it = bin.length();
                    }
                } while (it < bin.length());
            } catch (IndexOutOfBoundsException e) {
                ret = -1;
            }
        } else {
            System.out.println("--> Number-Format is not Biary!");
            ret = -1;
        }

        return ret;
    }

    /**
     * "Count Leading Ones"-Function
     *
     * @param bin
     * @return
     */
    public static int clo(String bin) {
        int ret = 0;
        int it = 0;

        if (checkIfBinary(bin)) {
            try {
                char[] ch = bin.toCharArray();
                do {
                    if (ch[it] == '1') {
                        it++;
                        ret = it;
                    } else {
                        it = bin.length();
                    }
                } while (it < bin.length());
            } catch (IndexOutOfBoundsException e) {
                ret = -1;
            }
        } else {
            System.out.println("--> Number-Format is not Biary!");
            ret = -1;
        }

        return ret;
    }

    /**
     * "Count Leading Zeros"-Function
     *
     * @param bin
     * @return
     */
    public static int clz(String bin) {
        int ret = 0;
        int it = 0;

        if (checkIfBinary(bin)) {
            try {
                char[] ch = bin.toCharArray();
                do {
                    if (ch[it] == '0') {
                        it++;
                        ret = it;
                    } else {
                        it = bin.length();
                    }
                } while (it < bin.length());
            } catch (IndexOutOfBoundsException e) {
                ret = -1;
            }
        } else {
            System.out.println("--> Number-Format is not Biary!");
            ret = -1;
        }

        return ret;
    }

    public static void binaryOperationTesting() {
        String s1 = "11111";
        String s2 = "00000";
        String s3 = "11011";
        String s4 = "00100";

        System.out.println(ffs(s1) + " (should be 1)");
        System.out.println(ffs(s2) + " (should be 0)");
        System.out.println(ffs(s3) + " (should be 1)");
        System.out.println(ffs(s4) + " (should be 3)");
        System.out.println("---");
        System.out.println(ffz(s1) + " (should be 0)");
        System.out.println(ffz(s2) + " (should be 1)");
        System.out.println(ffz(s3) + " (should be 3)");
        System.out.println(ffz(s4) + " (should be 1)");
        System.out.println("---");
        System.out.println(fls(s1) + " (should be 5)");
        System.out.println(fls(s2) + " (should be 0)");
        System.out.println(fls(s3) + " (should be 5)");
        System.out.println(fls(s4) + " (should be 3)");
        System.out.println("---");
        System.out.println(flz(s1) + " (should be 0)");
        System.out.println(flz(s2) + " (should be 5)");
        System.out.println(flz(s3) + " (should be 3)");
        System.out.println(flz(s4) + " (should be 5)");
        System.out.println("---");
        System.out.println(cto(s1) + " (should be 5)");
        System.out.println(cto(s2) + " (should be 0)");
        System.out.println(cto(s3) + " (should be 2)");
        System.out.println(cto(s4) + " (should be 0)");
        System.out.println("---");
        System.out.println(ctz(s1) + " (should be 0)");
        System.out.println(ctz(s2) + " (should be 5)");
        System.out.println(ctz(s3) + " (should be 0)");
        System.out.println(ctz(s4) + " (should be 2)");
        System.out.println("---");
        System.out.println(clo(s1) + " (should be 5)");
        System.out.println(clo(s2) + " (should be 0)");
        System.out.println(clo(s3) + " (should be 2)");
        System.out.println(clo(s4) + " (should be 0)");
        System.out.println("---");
        System.out.println(clz(s1) + " (should be 0)");
        System.out.println(clz(s2) + " (should be 5)");
        System.out.println(clz(s3) + " (should be 0)");
        System.out.println(clz(s4) + " (should be 2)");
        System.out.println("---");
    }
//</editor-fold>

}

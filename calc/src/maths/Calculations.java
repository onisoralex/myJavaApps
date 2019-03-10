package maths;

import java.math.BigDecimal;
import java.math.RoundingMode;

//import com.wolfram.jlink.*;
import others.Basics;
import others.ConstantsDefinitions;

/**
 *
 * @author Alex
 */
public class Calculations extends ConstantsDefinitions {

    static int log_it = 0; //logarithmus iterator
    public static boolean math_logging = false;
    public static boolean phi6_logging = false;

//<editor-fold defaultstate="collapsed" desc="Others">
    /**
     * Calculates the Kathere of a triangle by Pythagoras.
     *
     * @param hyp Hypothenuse
     * @param kat Kathete
     * @param precision Precision of calculation
     * @return BigDecimal
     */
    public static BigDecimal pythagorasGetKathete(BigDecimal hyp, BigDecimal kat, int precision) {
        return sqrt(hyp.pow(2).subtract(kat.pow(2)), precision);
    }

    /**
     * Calculates the Kathere of a triangle by Pythagoras.
     *
     * @param hyp Hypothenuse
     * @param kat Kathete
     * @return BigDecimal
     */
    public static BigDecimal pythagorasGetKathete(BigDecimal hyp, BigDecimal kat) {
        return pythagorasGetKathete(hyp, kat, const_calc_prec);
    }

    /**
     * Calculates the hypothenuse of a triangle by Pythagoras.
     *
     * @param kat1 First Kathete
     * @param kat2 Second Kathete
     * @param precision Precision of calculation
     * @return BigDecimal
     */
    public static BigDecimal pythagorasGetHypotenuse(BigDecimal kat1, BigDecimal kat2, int precision) {
        return sqrt((kat1.pow(2)).add(kat2.pow(2)), precision);
    }

    /**
     * Calculates the hypothenuse of a triangle by Pythagoras.
     *
     * @param kat1 First Kathete
     * @param kat2 Second Kathete
     * @return BigDecimal
     */
    public static BigDecimal pythagorasGetHypotenuse(BigDecimal kat1, BigDecimal kat2) {
        int precision = const_calc_prec;
        return pythagorasGetHypotenuse(kat1, kat2, precision);
    }

    /**
     * Converts a degree angle to a radiant.
     *
     * @param degree Degree angle which should be converted to radiant.
     * @param precision Precision of calculation.
     * @return BigDecimal
     */
    public static BigDecimal degreeToRadiant(BigDecimal degree, int precision) {
        return degree.multiply(const_pi).divide(one80, precision, RoundingMode.HALF_UP);
    }

    /**
     * Converts a degree angle to a radiant.
     *
     * @param degree Degree angle which should be converted to radiant.
     * @return BigDecimal
     */
    public static BigDecimal degreeToRadiant(BigDecimal degree) {
        int precision = const_calc_prec;
        return degreeToRadiant(degree, precision);
    }

    /**
     * Converts a radiant to a degree angle.
     *
     * @param radiant Radiant which should be converted to degree angle.
     * @param precision Precision of calculation.
     * @return BigDecimal
     */
    public static BigDecimal radiantToDegree(BigDecimal radiant, int precision) {
        return radiant.multiply(one80).divide(const_pi, precision, RoundingMode.HALF_UP);
    }

    /**
     * Converts a radiant to a degree angle.
     *
     * @param radiant Radiant which should be converted to degree angle.
     * @return BigDecimal
     */
    public static BigDecimal radiantToDegree(BigDecimal radiant) {
        int precision = const_calc_prec;
        return radiantToDegree(radiant, precision);
    }

    /**
     * Calculates the Sine of a degree. Calculates to the given precision.
     * Careful with way too high precisions, as it can take allot of time to
     * calculate.
     *
     * @param degree The degree where to ger the Sine from
     * @param precision ...
     * @return BigDecimal
     */
    public static BigDecimal sin(BigDecimal degree, int precision) {
//Calculates Sine by Degree
        int scale = precision + 3;
        BigDecimal quotient, dividend, divisor;
        BigDecimal result = new BigDecimal(0);
        BigDecimal result_old;
        int u;
        int i = 0;

        //Sine Function always operates on Radiant, so the angle has to be converted from Degree to Radiant
        degree = degreeToRadiant(degree, precision);

        do {
            //for (int i = 0; i <= iterations; i++) {
            result_old = result;
            u = (2 * i) + 1;
            dividend = degree.pow(u);
            divisor = factorial(u);
            quotient = dividend.divide(divisor, scale, RoundingMode.HALF_EVEN);
            result = result.add(negone.pow(i).multiply(quotient));
            //System.out.println("-> " + result);
            i++;
            //}
        } while (result.compareTo(result_old) != 0);

        if (math_logging == true) {
            System.out.println("-> Sine Iterations: " + i);
        }

        return result.setScale(precision, RoundingMode.HALF_UP).stripTrailingZeros();
    }

    /**
     * Calculates the Sine of a degree. Calculates to the given precision.
     * Careful with way too high precisions, as it can take allot of time to
     * calculate.
     *
     * @param degree The degree where to ger the Sine from
     * @return BigDecimal
     */
    public static BigDecimal sin(BigDecimal degree) {
        return sin(degree, const_calc_prec);
    }

    /**
     * Calculates the ArcSine of an input. Calculates to the given precision.
     * Careful with way too high precisions, as it can take allot of time to
     * calculate.
     *
     * @param param The input where to ger the ArcSine from
     * @param precision ...
     * @return BigDecimal
     */
    public static BigDecimal arcSin(BigDecimal param, int precision) {
//Calculates ArcSine by Sine
        int scale = precision + 3;
        // int u;
        BigDecimal result;
        BigDecimal result_old = null;

        //First check if the number is a valid Sine 
        if (param.compareTo(negone) >= 0 && param.compareTo(one) <= 0) {

            BigDecimal x = param;
            result = x;
            BigDecimal combined_part1 = one;
            BigDecimal part2 = zero;
            BigDecimal part1 = zero;
            BigDecimal big_j = zero;
            int j = 0;
            int i = 1;

            //arcin(x) = x + (1 / 2) * (z ^ 3 / 3) + (1 / 2 * 3 * 4) * z ^ 5 / 5
            do {
                result_old = result;
                j = (i * 2) + 1;
                big_j = new BigDecimal(j);
                //part1 = (j - 2) / (j - 1);
                part1 = (big_j.subtract(two)).divide(big_j.subtract(one), scale, RoundingMode.HALF_EVEN);
                part2 = (x.pow(j)).divide(big_j, scale, RoundingMode.HALF_EVEN);
                //res = res + (part1 * part2);
                combined_part1 = combined_part1.multiply(part1);
                result = result.add(combined_part1.multiply(part2));
                //System.out.println("Result " + i + ": " + radiantToDegree(result, precision));
                i++;
            } while (result.compareTo(result_old) != 0);

        } else {
            result = null;
            System.out.println("ERROR!");
        }

        //The calculation is radiant based, so the result is radiant and has to be converted into degree.
        result = radiantToDegree(result, precision);

        return result.setScale(precision, RoundingMode.HALF_UP).stripTrailingZeros();
    }

    /**
     * Calculates the ArcSine of an input. Calculates to the given precision.
     * Careful with way too high precisions, as it can take allot of time to
     * calculate.
     *
     * @param param The input where to ger the ArcSine from
     * @return BigDecimal
     */
    public static BigDecimal arcSin(BigDecimal param) {
        return arcSin(param, const_calc_prec);
    }

    /**
     * Calculates the Factorial of a given number.
     *
     * @param number_to_factorize - the number tobe factorialized
     * @return BigDecimal
     */
    public static BigDecimal factorial(long number_to_factorize) {
        BigDecimal factorial = new BigDecimal(1);
        for (long i = 1; i <= number_to_factorize; i++) {
            factorial = factorial.multiply(new BigDecimal(i));
        }

        return factorial;
    }

    /**
     * Calcualates theeuler number to a given Precision
     *
     * @param precision - the precision of the resulting number
     * @return BigDecimal
     */
    public static BigDecimal getEuler(int precision) {
        BigDecimal new_euler = zero;

        if (precision <= const_e.scale()) {
            new_euler = const_e;
        } else {
            int scale = precision + 3;
            BigDecimal old_euler;
            BigDecimal addition;
            int it = 0;

            do {
                old_euler = new_euler;
                addition = one.setScale(scale).divide(factorial(it), RoundingMode.HALF_EVEN);
                new_euler = new_euler.add(addition);
                it++;
            } while (old_euler.compareTo(new_euler) != 0);
        }

        return new_euler.setScale(precision, RoundingMode.HALF_UP);
    }

    /**
     * Calcualates theeuler number to a given Precision
     *
     * @param precision - the precision of the resulting number
     * @return BigDecimal
     */
    public static BigDecimal getEuler() {
        int scale = const_calc_prec;

        return getEuler(scale).setScale(scale, RoundingMode.HALF_UP);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Logarithms">
    public static BigDecimal logNat1(BigDecimal x, int precision) {
        //Only for >0 to <1 (small numbers converge slowly or never)
        BigDecimal erg = new BigDecimal(0);
        BigDecimal p1;
        int p = 10000;

        x = x.add(negone);

        for (int k = 1; k < p; k++) {
            //(-1^(k+1))*(x^k/k)
            p1 = negone.pow(k + 1).multiply(x.pow(k).divide(new BigDecimal(k), precision, RoundingMode.HALF_EVEN));
            //System.out.println(k + " p1: " + p1);
            erg = erg.add(p1);
        }

        return erg;
    }

    public static BigDecimal logNat(BigDecimal x, int precision) {
        return logBin(x).divide(logBin(const_e), precision, RoundingMode.HALF_UP).stripTrailingZeros();
    }

    public static BigDecimal logNat(BigDecimal x) {
        return logNat(x, const_calc_prec);
    }

    public static BigDecimal logDec(BigDecimal x, int precision) {
        return logBin(x).divide(logBin(new BigDecimal(10)), precision, RoundingMode.HALF_UP).stripTrailingZeros();
    }

    public static BigDecimal logDec(BigDecimal x) {
        return logDec(x, const_calc_prec);
    }

    public static BigDecimal logBin(BigDecimal x, int precision) {
        /*
         log divided in multiple parts:
         log(1002) = log(1000) + log(1002/1000)
         log_2(17) = log_2(16) + log_2(17/16)
         */

        BigDecimal erg = zero;
        // int it = 0;

//Caculation of first part by binary counting (Nubers before decimal Point)
        String bin = Basics.bigDecToBin(x);
        int n = new BigDecimal(Basics.fls(bin) - 1).intValue();

        erg = new BigDecimal(n).add(logBinRecursivePart(x, precision));
        /*Since the recursiveMethod adds one at every step, this is necessary, 
         since the last step does not need the one added, but the integer part.*/
        erg = erg.subtract(one);
        //System.out.println("it: " + it);

        //Reset the iterator for future use
        log_it = 0;

        return erg.setScale(precision, RoundingMode.HALF_UP).stripTrailingZeros();
    }

    public static BigDecimal logBinRecursivePart(BigDecimal x, int precision) {
        //Caculation of first part by binary counting (Nubers before decimal Point)
        String bin = Basics.bigDecToBin(x);
        int n = new BigDecimal(Basics.fls(bin) - 1).intValue();

        //Iterational procedure for the second part (Nubers after decimal Point)
        BigDecimal y = (one.divide(two.pow(n), precision, RoundingMode.HALF_EVEN).stripTrailingZeros()).multiply(x);
        //System.out.println("y " + log_it + ": " + y);
        BigDecimal z = y; //Z-variable is temporary, so I keep y and have the starting value for the calculation
        int m = 0;
        BigDecimal res = one;
        BigDecimal ret = zero;
        if (y.compareTo(one) == 0) {
            ret = new BigDecimal(n);
        } else {
            while (log_it < 100) {
                log_it++;
                while (z.compareTo(two) < 0) {
                    z = z.pow(2);
                    m++;
                }
//Result value s still incorrect, since I have to get the z-part, not the y-part (Source: Wikipedia)
                res = logBinRecursivePart(z.divide(two, precision, RoundingMode.HALF_EVEN).stripTrailingZeros(), precision);

                ret = (one.divide(two.pow(m), precision, RoundingMode.HALF_EVEN)).multiply(res).add(one).stripTrailingZeros();
            }
        }
        return ret;
    }

    public static BigDecimal logBin(BigDecimal x) {
        return logBin(x, const_calc_prec);
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Powers">
    /**
     * Makes a decimal power of a decimal number. Has a fixed precision, to
     * avoid long time lags.
     *
     * @param x - number to be powered
     * @param n - to the power of n
     * @param precision Precision of calculation
     * @return BigDecimal
     */
    public static BigDecimal power(BigDecimal x, BigDecimal n, int precision) {
        int scale = precision + 3;
        boolean neg_n = false;
        BigDecimal p1, p2, p3, rt;
        BigDecimal ret;

        if (n.scale() > scale) {
            n = n.setScale(scale, RoundingMode.HALF_UP);
            System.out.println("Number has been rescaled to a scale of " + scale + " for reasons of Calculation speed!");
        }

        if (n.signum() < 0) {
            neg_n = true;
            n = n.negate();
        }

        //System.out.println(x.scale());
        //System.out.println(n.scale());
        /*
         x^3.4 = x^3 * x^0.4 => x^3 * x^(4/10) => x^3 * (root(10, x^4, 10))
         -----------------------------------------p1--------- p2---p3
         */
        if (n.remainder(one).signum() == 0) {
            //if n is a whole number
            ret = x.pow(n.intValue());
        } else {
            //When n is a decimal numer
            p1 = x.pow(n.intValue());
            //System.out.println("p1: " + p1);
            p2 = one.movePointRight(n.scale());
            //System.out.println("p2: " + p2);
            p3 = x.pow(n.remainder(one).movePointRight(n.scale()).intValue());
            //System.out.println("p3: " + p3);
            rt = root(p2.intValue(), p3, scale);
            //System.out.println("rt: " + rt);
            ret = p1.multiply(rt).setScale(precision, RoundingMode.HALF_UP).stripTrailingZeros();
        }

        //Clcualtion for when n is negative (1/(x^n))
        if (neg_n == true && ret != null) {
            ret = one.divide(ret, precision, RoundingMode.HALF_UP).stripTrailingZeros();
        }

        return ret;
    }

    /**
     * Makes a decimal power of a decimal number. Has a fixed precision, to
     * avoid long time lags.
     *
     * @param x - nuber to be powered
     * @param n - to the power of n
     * @return BigDecimal
     */
    public static BigDecimal power(BigDecimal x, BigDecimal n) {
        int precision = const_calc_prec;
        return power(x, n, precision);
    }

    /**
     * Makes a fractional power of a decimal number. Has a choosable precision.
     * Don't make it too big to avoid long time lags.
     *
     * @param x - nuber to be powered
     * @param fraction - to the power of n
     * @param precision - of the result
     * @return
     */
    public static BigDecimal power(BigDecimal x, String fraction, int precision) {
        boolean neg_sig = false;
        BigDecimal p1;
        BigDecimal ret;

        //Only the first two arguments will be used anyway.
        String[] exp = fraction.split("/");
        BigDecimal zaehler = new BigDecimal(exp[0]);
        BigDecimal nenner = new BigDecimal(exp[1]);

        //Invert if both are negative or tell the method to 1/x the result if one of them is negative.
        if (zaehler.signum() < 0 && nenner.signum() < 0) {
            zaehler = zaehler.negate();
            nenner = nenner.negate();
        } else {
            if (zaehler.signum() < 0) {
                zaehler = zaehler.negate();
                neg_sig = true;
            }
            if (nenner.signum() < 0) {
                nenner = nenner.negate();
                neg_sig = true;
            }
        }

        if (zaehler.remainder(one).compareTo(zero) != 0 || nenner.remainder(one).compareTo(zero) != 0) {
            System.out.println("Not whole nubers will be rounded down!");
        }

        /*
         x^(3/4) = 4root(x^3) = root(4,x^3,100) => ret = root(nenner, x.pow(zaehler) ,100);
         */
        if ((nenner.remainder(new BigDecimal(2)) == one && x.signum() < 0) || nenner.signum() == 0) {
            //When Zaehler is odd and the number negative, it is an Error. Also when Nenner is zero.
            System.out.println("ERROR! Numbers not valid! Take something else...");
            ret = null;
        } else {
            if (nenner.compareTo(one) == 0) {
                //if n is a whole number
                ret = x.pow(zaehler.intValue());
            } else {
                //When nenner is not one.
                p1 = x.pow(zaehler.intValue());
                ret = root(nenner.intValue(), p1, precision);
            }
        }

        //Clcualtion for when n is negative (1/(x^n))
        if (neg_sig == true && ret != null) {
            ret = one.divide(ret, precision, RoundingMode.HALF_UP).stripTrailingZeros();
        }

        return ret;
    }

    /**
     * Makes a fractional power of a decimal number. Has a choosable precision.
     * Don't make it too big to avoid long time lags.
     *
     * @param x - nuber to be powered
     * @param fraction - to the power of n
     * @return
     */
    public static BigDecimal power(BigDecimal x, String fraction) {
        int precision = const_calc_prec;
        return power(x, fraction, precision);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Roots">
    /**
     * Calculates the square-root of a given area/number.
     *
     * @param area - the area/number to be rooted
     * @param precision - precision of the result
     * @return BigDecimal
     */
    public static BigDecimal sqrt(BigDecimal area, int precision) {
//Heron-Algorithm with precision range (epsilon)
//<editor-fold defaultstate="collapsed" desc="sqrt & Methods">
        int scale = precision + 3;
        // BigDecimal epsilon = one.movePointLeft(scale);
        BigDecimal a = one.setScale(scale);
        //Used to set the precision in the variable for the division
        area = area.setScale(scale, RoundingMode.HALF_EVEN);
        BigDecimal b = area;
        BigDecimal sum;
        BigDecimal zero_w_scale = zero.setScale(scale);
        BigDecimal ret;
        //int it = 0;

        if (area.compareTo(zero_w_scale) > 0) {
            //when the area is bigger than 0
            //for (int i = 0; i < it; i++) {
            do {
                //it++;
                sum = a.add(b);
                a = sum.divide(two, RoundingMode.HALF_EVEN);
                //System.out.println("A: " + a);
                b = area.divide(a, RoundingMode.HALF_EVEN);
                //System.out.println("B: " + b);
                //System.out.println("b-a: " + b.subtract(a));
            } while (a.setScale(precision, RoundingMode.HALF_UP).compareTo(b.setScale(precision, RoundingMode.HALF_UP)) > 0);
            //System.out.println("Iterations: " + it);

            if (a.compareTo(b) > 0) {
                ret = a;
                //System.out.println("a: " + ret);
            } else {
                ret = b;
                //System.out.println("b: " + ret);
            }
        } else if (area.stripTrailingZeros().compareTo(zero_w_scale) < 0) {
            //when the area is smaller than 0
            System.out.println("The given Area is below 0!");
            ret = null;
        } else {
            //when the area is 0
            ret = new BigDecimal(0);
        }
        //System.out.println("res: " + a);

        return ret.setScale(precision, RoundingMode.HALF_UP).stripTrailingZeros();
//</editor-fold>
    }

    /**
     * Calculates the square-root of a given area/number. Has a fixed Precision
     * of 10.
     *
     * @param area - the area/number to be rooted
     * @return BigDecimal
     */
    public static BigDecimal sqrt(BigDecimal area) {
//Heron-Algorithm with fix precision
//<editor-fold defaultstate="collapsed" desc="sqrt & Methods">
        return Calculations.sqrt(area, const_calc_prec);
//</editor-fold>
    }

    /**
     * Calculates the cubic-root of a given volume/number.
     *
     * @param volume - the volume/number to be rooted
     * @param precision - precision of the result
     * @return BigDecimal
     */
    public static BigDecimal qbrt(BigDecimal volume, int precision) {
//Heron-Algorithm (Variant)
        //<editor-fold defaultstate="collapsed" desc="qbrt & Methods">
        int scale = precision + 3;
        // BigDecimal epsilon = one.movePointLeft(scale);
        BigDecimal a = one;
        BigDecimal b = one;
        BigDecimal sum;
        BigDecimal ret;
        boolean neg = false;
        // int it = 0;

        //Always make the numbers positive, so te calculations are symetric
        if (volume.compareTo(zero) < 0) {
            neg = true;
            volume = volume.negate();
        }

        //Declare c here, because it has to take the positive Volume and 
        //it is not allowed to create a "0" sum in case of "volume = -2"
        BigDecimal c = volume;

        if (volume.compareTo(zero) != 0) {
            //when the area is bigger or smaller than 0
            do {
                //it++;
                sum = a.add(b).add(c);
                a = b = sum.divide(three, scale, RoundingMode.HALF_EVEN);
                c = volume.divide(a, scale, RoundingMode.HALF_EVEN).divide(b, scale, RoundingMode.HALF_EVEN);
                //System.out.println("a: " + a);
                //System.out.println("c: " + c);
                //} while (a.subtract(c).compareTo(epsilon) > 0);
            } while (a.setScale(precision, RoundingMode.HALF_UP).compareTo(c.setScale(precision, RoundingMode.HALF_UP)) != 0);
            //System.out.println("Iterations: " + it);

            if (a.compareTo(b) > 0) {
                if (a.compareTo(c) > 0) {
                    ret = a;
                    //System.out.println("a: " + ret.toString());
                } else {
                    ret = c;
                    //System.out.println("c: " + ret.toString());
                }
            } else {
                if (b.compareTo(c) > 0) {
                    ret = b;
                    //System.out.println("b: " + ret.toString());
                } else {
                    ret = c;
                    //System.out.println("c: " + ret.toString());
                }
            }
        } else {
            //when the area is 0
            ret = new BigDecimal(0);
            System.out.println("test");
        }

        //makethe reult negative again if the volume was negative
        if (neg == true) {
            ret = ret.negate();
        }

        return ret.setScale(precision, RoundingMode.HALF_UP).stripTrailingZeros();
//</editor-fold>
    }

    /**
     * Calculates the cubic-root of a given volume/number. Has a fixed
     * Precision.
     *
     * @param volume - the volume/number to be rooted
     * @return BigDecimal
     */
    public static BigDecimal qbrt(BigDecimal volume) {
//Heron-Algorithm (Variant) with fix prexision
//<editor-fold defaultstate="collapsed" desc="sqrt & Methods">
        return Calculations.qbrt(volume, const_calc_prec);
//</editor-fold>
    }

    /**
     * Calculates the n^th-root of a given number.
     *
     * @param n - n^th root
     * @param x - the gven number
     * @param precision - precision of the result
     * @return BigDecimal
     */
    public static BigDecimal root(int n, BigDecimal x, int precision) {
//Newton-Algorithm 
//<editor-fold defaultstate="collapsed" desc="Algorithm & Explication">
        /*        
         Algorithm:
         ((n - 1) * (y ^ n) + x) / (n * y ^ (n - 1))
         y = Startwert der Iteration (zu beginn mit 1 starten ?)
         n = ist die n-te Wurzel
         x = Zahl aus der man Wurzel zieht 
         */
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="root & Methods">
        int scale = precision + 3;
        BigDecimal y = one;
        BigDecimal ret;
        BigDecimal old;
        boolean neg_x = false;
        boolean neg_n = false;
        // int it = 0;

        //Always make the numbers positive, so te calculations are symetric
        if (x.compareTo(zero) < 0) {
            neg_x = true;
            x = x.negate();
        }

        if (x.compareTo(zero) != 0) {

            if (n < 0) {
                neg_n = true;
                n = n * -1;
            }

            //Controls if n is even in case x is smaller than 0
            if (neg_x == true && n % 2 == 0) {
                ret = null;
                System.out.println("The Result is not a real Number!");
            } else {
                if (n > 0) {
                    //This is the iterational calculation
                    do {
                        //it++;
                        old = y;
                        /*
                         zaehler = new BigDecimal(n - 1).multiply(y.pow(n)).add(x);
                         nenner = new BigDecimal(n).multiply(y.pow(n - 1));
                         y = zaehler.divide(nenner, scale, RoundingMode.HALF_EVEN);
                         */
                        y = (new BigDecimal(n - 1).multiply(y.pow(n)).add(x)).divide((new BigDecimal(n).multiply(y.pow(n - 1))), scale, RoundingMode.HALF_EVEN);
                        //System.out.println("old_y = " + old);
                        //System.out.println("new_y = " + y);
                    } while (old.setScale(precision, RoundingMode.HALF_UP).compareTo(y.setScale(precision, RoundingMode.HALF_UP)) != 0);
                    //System.out.println("Iterations: " + it);

                    ret = y.setScale(precision, RoundingMode.HALF_UP).stripTrailingZeros();
                } else {
                    ret = null;
                    System.out.println("The root number cannot be 0!");
                }
            }
        } else {
            //when the area is 0
            ret = zero;
        }

        //Make the result negative again if the volume was negative
        if (neg_x == true && ret != null) {
            ret = ret.negate();
        }

        //Clcualtion for when n is negative (1/(x^n))
        if (neg_n == true && ret != null) {
            ret = one.divide(ret, precision, RoundingMode.HALF_UP);
        }

        return ret;
//</editor-fold>
    }

    /**
     * Calculates the n^th-root of a given number. Has a fixed Precision of 10.
     *
     * @param n - n^th root
     * @param x - the gven number
     * @return BigDecimal
     */
    public static BigDecimal root(int n, BigDecimal x) {
//Newton-Algorithm 
//<editor-fold defaultstate="collapsed" desc="Algorithm & Explication">
        /*        
         Algorithm:
         ((n - 1) * (y ^ n) + x) / (n * y ^ (n - 1))
         y = Startwert der Iteration (zu beginn mit 1 starten ?)
         n = ist die n-te Wurzel
         x = Zahl aus der man Wurzel zieht 
         */
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="root & Methods">
        int precision = const_calc_prec;

        BigDecimal ret = root(n, x, precision);

        return ret;
//</editor-fold>
    }
//</editor-fold>

}

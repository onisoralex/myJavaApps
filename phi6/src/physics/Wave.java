/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import static others.ConstantsDefinitions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Alex
 */
public class Wave {

    public static BigDecimal lambdaHalf(BigDecimal frequency, BigDecimal speed) {
        return (speed.divide(frequency, const_calc_prec, RoundingMode.HALF_UP)).divide(two, const_calc_prec, RoundingMode.HALF_UP);
    }

}

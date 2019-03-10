/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flutecalc;

import java.math.BigDecimal;
import calc.src.definition.*;

/**
 * This is the calculating class of the Flute Calculator
 *
 * @author Alex
 */
public class Flute extends ConstantsDefinitions {

//<editor-fold defaultstate="collapsed" desc="Var. Definitions">
    public String flute_name = "-1"; //Name of the Flute or of the File
    public String flute_base_tone = "-1"; //Name
    public BigDecimal flute_base_frequency = negone; //Hz
    public BigDecimal flute_length = negone; //mm
    public BigDecimal wall_thickness = negone; //mm, at foot of flute
    public BigDecimal bore_diameter_head = negone; //mm
    public BigDecimal bore_diameter_middle = negone; //mm, if it starts to taper somewhere, else leave "0" (or "-1"?)
    public BigDecimal bore_diameter_foot = negone; //mm
    public BigDecimal bore_to_length_ratio = negone; //= (length / bore)
    public BigDecimal emb_hole_w = negone; //mm, width, also for elyptical
    public BigDecimal emb_hole_l = negone; //mm, height, also for elyptical
    public BigDecimal emb_hole_r = negone; //mm, radius of the rounding to calculate the area correctly
    public BigDecimal emb_hole_a = negone; //mm, area of Emb. Hole
    public BigDecimal emb_hole_chimney = negone; //mm, height
    public BigDecimal emb_hole_undercut = negone; //degree, front and back undercut
    private BigDecimal emb_hole_correction = negone; //mm, ???
    private BigDecimal emb_hole_position = negone; //mm, center of hole from cork
    public int emb_hole_type = -1; //elyptical = 0, rounded rectangular = 1
    private BigDecimal[] negone_aray = new BigDecimal[]{negone, negone, negone, negone, negone, negone};
    public BigDecimal[] tone_hole_position = negone_aray; //mm, position of every tonehole from foot
    public BigDecimal[] tone_hole_diameter = negone_aray; //mm, diameter of every tonehole
    public BigDecimal[] tone_hole_chimney = negone_aray; //mm, chimney height of every tonehole
    public BigDecimal[] tone_hole_undercut = negone_aray; //degree, undercut of toneholes if needed
    private BigDecimal[] tone_hole_correction = negone_aray; //mm, ???
//</editor-fold>

    public Flute(String name) {
        this.flute_name = name;
    }

}

package demos;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
// import java.awt.Graphics;
 
public class BlankArea extends JLabel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Dimension minSize = new Dimension(100, 50);
 
    public BlankArea(Color color) {
        setBackground(color);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
 
    public Dimension getMinimumSize() {
        return minSize;
    }
 
    public Dimension getPreferredSize() {
        return minSize;
    }
}

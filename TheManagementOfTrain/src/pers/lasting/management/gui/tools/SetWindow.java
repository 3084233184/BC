package pers.lasting.management.gui.tools;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

public class SetWindow {
	public static void setWindowCenter(Window w) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		double screenWidth = d.getWidth();
		double screenHeight = d.getHeight();
		int WindowWidth = w.getWidth();
		int WindowHeight = w.getHeight();
		int width = (int) (screenWidth-WindowWidth)/2;
		int height =(int) (screenHeight-WindowHeight)/2;
		w.setLocation(width, height);
	}
}

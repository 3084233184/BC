package pers.lasting.management.gui.tools;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import pers.lasting.management.gui.function.CheckString;

public class UserIDLegalListener implements KeyListener{
	
		JTextField text;
		
		public UserIDLegalListener(JTextField text) {
			// TODO Auto-generated constructor stub
			this.text = text;
		}
	
		@Override
		public void keyTyped(KeyEvent e) {
			CheckString.textTrim(text);
			text.setText(CheckString.filterChinese(text.getText()));
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			CheckString.textTrim(text);
			text.setText(CheckString.filterChinese(text.getText()));
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			CheckString.textTrim(text);
			text.setText(CheckString.filterChinese(text.getText()));
		}
}

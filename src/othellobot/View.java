package othellobot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View {
	private JFrame frame;
	
	public View(String title) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		GridLayout layout = new GridLayout(8,8,0,0);
		frame.getContentPane().setLayout(layout);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		int xcounter = 0;
		int ycounter = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				JButton button = new JButton();
				button.setBounds(xcounter, ycounter, 100, 100);
				button.setBackground(Color.green);
				button.setOpaque(false);
				frame.getContentPane().add(button);
				xcounter += 100;
			}
			xcounter = 0;
			ycounter+= 100;
		}
		
	}
}

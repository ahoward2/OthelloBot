package othellobot;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class View {
	private JFrame frame;
	
	public View(String title) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setResizable(false);
		GridLayout grid = new GridLayout(8,8);
		JPanel panel = new JPanel();
		frame.setLocationRelativeTo(null);
		panel.setLayout(grid);
		panel.setBackground(Color.green);
		
		int xcounter = 0;
		int ycounter = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				JButton button = new JButton();
				button.setBounds(xcounter, ycounter, 50, 50);
				button.setBackground(Color.green);
				panel.add(button);
				xcounter += 50;
			}
			xcounter = 0;
			ycounter+= 50;
		}
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		
	}
}

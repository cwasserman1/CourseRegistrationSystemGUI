import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class SYSGUI {
	JLabel titleText;
	JFrame j;
	JPanel panel;
	public SYSGUI() {
		initializeLayout();
	}
	public void initializeLayout()
	{
		j = new JFrame();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setBounds(0, 0, 1920, 1080);
		panel.setBackground(Color.cyan);
		titleText = new JLabel();
		titleText.setText("Course Registration System");
		//titleText.setBounds(50, 2000, 20, 0);
		panel.add(titleText);
		panel.setVisible(true);
		j.add(panel);
		j.setSize(1920,1080);
		j.setLayout(null);
		j.setVisible(true);
	}	
}


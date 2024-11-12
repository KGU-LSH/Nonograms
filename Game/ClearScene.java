package Game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClearScene extends JFrame implements ActionListener {
	Container pane = getContentPane();
	JButton mainButton, quitButton;
	
	public ClearScene() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Nonograms");
		pane.setLayout(null);
		setPreferredSize(new Dimension(800, 600));
		pane.setBackground(Color.YELLOW);
		
		JLabel success = new JLabel("SUCCESS!");
		success.setSize(250, 150);
		success.setFont(new Font("고딕",Font.PLAIN,30));
		success.setLocation(300,100);
		success.setVisible(true);
		add(success);
		
		mainButton = new JButton("Again");
		mainButton.setSize(100, 50);
		mainButton.setLocation(150, 400);
		mainButton.addActionListener(this);
		mainButton.setVisible(true);
		pane.add(mainButton);
		
		quitButton = new JButton("Quit");
		quitButton.setSize(100, 50);
		quitButton.setLocation(525, 400);
		quitButton.addActionListener(this);
		quitButton.setVisible(true);
		pane.add(quitButton);
		
		setResizable(false);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClearScene clearscene = new ClearScene();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == mainButton) {
			MainScene mainscene = new MainScene();
			mainscene.setVisible(true);
			dispose();
		}
		if (e.getSource() == quitButton) {
			System.exit(0);
		}
	}
}

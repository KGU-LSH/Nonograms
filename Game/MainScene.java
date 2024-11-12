package Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class MainScene extends JFrame implements ActionListener {
	Container pane = getContentPane();
	JButton easyButton, normalButton, hardButton;

	public MainScene() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Nonograms");
		pane.setLayout(null);
		setPreferredSize(new Dimension(800, 600));
		pane.setBackground(Color.GREEN);

		JLabel theme = new JLabel("NONOGRAMS");
		theme.setSize(200, 150);
		theme.setFont(new Font("고딕", Font.PLAIN, 30));
		theme.setLocation(300, 100);
		theme.setVisible(true);
		pane.add(theme);

		easyButton = new JButton("Easy");
		easyButton.setSize(100, 50);
		easyButton.setLocation(150, 400);
		easyButton.addActionListener(this);
		easyButton.setVisible(true);
		pane.add(easyButton);

		normalButton = new JButton("Normal");
		normalButton.setSize(100, 50);
		normalButton.setLocation(350, 400);
		normalButton.addActionListener(this);
		normalButton.setVisible(true);
		pane.add(normalButton);

		hardButton = new JButton("Hard");
		hardButton.setSize(100, 50);
		hardButton.setLocation(550, 400);
		hardButton.addActionListener(this);
		hardButton.setVisible(true);
		pane.add(hardButton);

		setResizable(false);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		MainScene mainscene = new MainScene();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == easyButton) {
			EasyScene easyscene = new EasyScene();
			easyscene.setVisible(true);
			dispose();
		}
		if (e.getSource() == normalButton) {
			NormalScene normalscene = new NormalScene();
			normalscene.setVisible(true);
			dispose();
		}
		if (e.getSource() == hardButton) {
			HardScene hardscene = new HardScene();
			hardscene.setVisible(true);
			dispose();
		}
	}
}
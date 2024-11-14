package Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class MainScene extends JFrame implements ActionListener {
	Container pane = getContentPane();
	JButton startButton, profileButton, signinButton, signupButton;

	public MainScene() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Nonograms");
		pane.setLayout(null);
		setPreferredSize(new Dimension(900, 700));
		pane.setBackground(new Color(202, 238, 251));

		JLabel theme = new JLabel("NONOGRAMS");
		theme.setSize(200, 50);
		theme.setFont(new Font("고딕", Font.PLAIN, 30));
		theme.setLocation(350, 150);
		theme.setVisible(true);
		pane.add(theme);

		signinButton = new JButton("Sign In");
		signinButton.setSize(100, 50);
		signinButton.setLocation(150, 500);
		signinButton.setBackground(new Color(255, 255, 255));
		signinButton.addActionListener(this);
		signinButton.setVisible(true);
		pane.add(signinButton);

		signupButton = new JButton("Sign Up");
		signupButton.setSize(100, 50);
		signupButton.setLocation(400, 500);
		signupButton.setBackground(new Color(255, 255, 255));
		signupButton.addActionListener(this);
		signupButton.setVisible(true);
		pane.add(signupButton);

		profileButton = new JButton("Profile");
		profileButton.setSize(100, 50);
		profileButton.setLocation(650, 500);
		profileButton.setBackground(new Color(255, 255, 255));
		profileButton.addActionListener(this);
		profileButton.setVisible(true);
		pane.add(profileButton);

		startButton = new JButton("Start");
		startButton.setSize(100, 50);
		startButton.setLocation(400, 300);
		startButton.setBackground(new Color(255, 255, 255));
		startButton.addActionListener(this);
		startButton.setVisible(true);
		pane.add(startButton);

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
		if (e.getSource() == signinButton) {
			SigninScene signinscene = new SigninScene();
			signinscene.setVisible(true);
			dispose();
		}
		if (e.getSource() == signupButton) {
			SignupScene signupscene = new SignupScene();
			signupscene.setVisible(true);
			dispose();
		}
		if (e.getSource() == profileButton) {
			ProfileScene profilescene = new ProfileScene();
			profilescene.setVisible(true);
			dispose();
		}
		if (e.getSource() == startButton) {
			LevelScene levelscene = new LevelScene();
			levelscene.setVisible(true);
			dispose();
		}
	}
}
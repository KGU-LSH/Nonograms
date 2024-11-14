package Game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ProfileScene extends JFrame implements ActionListener {
	Container pane = getContentPane();
	JButton submitButton, undoButton;
	JLabel search, resultLabel;
	JTextField nicknameField;
	
	public ProfileScene() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Nonograms");
		pane.setLayout(null);
		setPreferredSize(new Dimension(800, 600));
		pane.setBackground(new Color(202, 238, 251));
		
		undoButton = new JButton("Undo");
		undoButton.setSize(100, 50);
		undoButton.setLocation(0, 0);
		undoButton.setBackground(new Color(255, 255, 255));
		undoButton.addActionListener(this);
		undoButton.setVisible(true);
		pane.add(undoButton);
		
		search = new JLabel("Search : ");
		search.setSize(150, 50);
		search.setFont(new Font("고딕", Font.PLAIN, 30));
		search.setLocation(0, 200);
		search.setVisible(true);
		pane.add(search);
		
		nicknameField = new JTextField(15);
		nicknameField.setSize(150, 50);
		nicknameField.setLocation(150, 200);
		nicknameField.setVisible(true);
		pane.add(nicknameField);
		
		resultLabel = new JLabel(); 
		resultLabel.setSize(400, 50); 
		resultLabel.setFont(new Font("고딕", Font.PLAIN, 20)); 
		resultLabel.setLocation(0, 300); 
		pane.add(resultLabel);
		
		submitButton = new JButton("Submit");
		submitButton.setSize(100, 50);
		submitButton.setLocation(350, 200);
		submitButton.addActionListener(this);
		submitButton.setVisible(true);
		submitButton.addActionListener(new ActionListener() { 
			@Override 
			public void actionPerformed(ActionEvent e) { 
				String nickname = nicknameField.getText(); 
				String password = searchPasswordByNickname(nickname); 
				if (password != null) { 
					resultLabel.setText("닉네임: " + nickname + ", 비밀번호: " + password); 
				} 
				else { 
					JOptionPane.showMessageDialog(pane, "해당 닉네임을 찾을 수 없습니다.");
				}
			} 
		});
		pane.add(submitButton);
		
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProfileScene profilescene = new ProfileScene();
	}

	private static String searchPasswordByNickname(String nickname) { 
		try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) { 
			String line; 
			while ((line = reader.readLine()) != null) { 
				if (line.startsWith("닉네임 : " + nickname)) { 
					String passwordLine = reader.readLine(); 
					if (passwordLine != null && passwordLine.startsWith("비밀번호 : ")) { 
						return passwordLine.substring(passwordLine.indexOf("비밀번호 : ") + 6); 
					} 
				} 
			} 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
		return null; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == submitButton) {
			JLabel admin = new JLabel("Nickname : admin");
			admin.setSize(120, 50);
			admin.setFont(new Font("고딕", Font.PLAIN, 30));
			admin.setLocation(0, 200);
			admin.setVisible(true);
			pane.add(admin);
		}
		
		if (e.getSource() == undoButton) {
			MainScene mainscene = new MainScene();
			mainscene.setVisible(true);
			dispose();
		}
	}

}

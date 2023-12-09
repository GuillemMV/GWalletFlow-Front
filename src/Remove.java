
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Remove {
	
	public Remove() {

		Font normal = new Font("Source Code Pro", Font.PLAIN, 15);
		Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.DARK_GRAY);

		JFrame frame = new JFrame();
		
		ImageIcon icono = new ImageIcon("icons/favicon.png");
		Image imagen = icono.getImage();
		frame.setIconImage(imagen);
		
		String imagePath = "icons/remove.png";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel label = new JLabel(imageIcon);
		
		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel("Remove");
		titlePanel.setBackground(Color.BLACK);
		titlePanel.setBorder(border);
		title.setForeground(Color.RED);
		title.setFont(normal);
		titlePanel.add(label);
		titlePanel.add(title);
		

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0,1));
		
		mainPanel.add(titlePanel);
		
		frame.setBackground(Color.black);
		frame.add(mainPanel);
		frame.setTitle("GWalletFlow");
		frame.setSize(350, 200);
		frame.setResizable(false);
		frame.setVisible(true);

	}
}


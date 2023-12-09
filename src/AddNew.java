
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class AddNew {
	
	public AddNew(){

		Font normal = new Font("Source Code Pro", Font.PLAIN, 15);
		Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.DARK_GRAY);

		JFrame frame = new JFrame();
		
		ImageIcon icono = new ImageIcon("icons/favicon.png");
		Image imagen = icono.getImage();
		frame.setIconImage(imagen);
		
		String imagePath = "icons/addnew.png";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel label = new JLabel(imageIcon);
		
		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel("Add New");
		titlePanel.setBackground(Color.BLACK);
		titlePanel.setBorder(border);
		title.setForeground(Color.RED);
		title.setFont(normal);
		titlePanel.add(label);
		titlePanel.add(title);
		

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0,1));
		
		JTextField amount = new JTextField("Amount");
		amount.setBackground(Color.black);
		amount.setForeground(Color.white);
		amount.setFont(normal);
		
		JTextField date = new JTextField("Date");
		date.setBackground(Color.black);
		date.setForeground(Color.white);
		date.setFont(normal);
		
		String[] options = ApiClient.getCategories().toArray(new String[ApiClient.getCategories().size()]);
		
		JComboBox<String> category = new JComboBox<String>(options);
		category.setBackground(Color.black);
		category.setForeground(Color.white);
		category.setFont(normal);
		category.setBorder(border);
		
		
		JTextField description = new JTextField("Description");
		description.setBackground(Color.black);
		description.setForeground(Color.white);
		description.setFont(normal);
		
		JButton doneBtn = new JButton("Done");
		doneBtn.setFont(normal);
		doneBtn.setBackground(Color.black);
		doneBtn.setForeground(Color.white);
		
		doneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	BigDecimal amountVal = new BigDecimal(amount.getText());
            	Date expenseDate = null;
				try {
					expenseDate = new SimpleDateFormat("yyyy-MM-dd").parse(date.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
            	int categoryIndex = category.getSelectedIndex();
            	String desc = description.getText();
            	
            	ApiClient.insertNewExpense(amountVal, expenseDate, categoryIndex, desc);
            }
        });
		
		mainPanel.add(titlePanel);
		mainPanel.add(amount);
		mainPanel.add(date);
		mainPanel.add(category);
		mainPanel.add(description);
		mainPanel.add(doneBtn);
		
		frame.setBackground(Color.black);
		frame.add(mainPanel);
		frame.setTitle("GWalletFlow");
		frame.setSize(350, 200);
		frame.setResizable(false);
		frame.setVisible(true);

	}
}


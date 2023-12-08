import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Gui {
	public Gui() {

		Font monospace = new Font("Source Code Pro", Font.BOLD, 35);
		Font normal = new Font("Source Code Pro", Font.PLAIN, 15);
		Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.DARK_GRAY);

		JFrame frame = new JFrame();
		
		ImageIcon icono = new ImageIcon("favicon.png");
		Image imagen = icono.getImage();
		frame.setIconImage(imagen);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		JPanel totalExpensePanel = new JPanel();
		JLabel totalExpense = new JLabel(ApiClient.getTotal()+"€");
		totalExpense.setForeground(Color.RED);
		totalExpense.setFont(monospace);
		totalExpensePanel.setBorder(border);
		totalExpensePanel.setBackground(Color.black);
		totalExpensePanel.add(totalExpense);
		totalExpensePanel.add(new JLabel(LocalDate.now().getMonth().toString()));

		JPanel btnPanel = new JPanel();

		JButton myExpensesBtn = new JButton("My expenses");
		myExpensesBtn.setForeground(Color.white);
		myExpensesBtn.setBackground(Color.black);
		myExpensesBtn.setFont(normal);
		myExpensesBtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            }
	        });

		JButton addExpense = new JButton("Add new");
		addExpense.setForeground(Color.white);
		addExpense.setBackground(Color.black);
		addExpense.setFont(normal);
		addExpense.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	AddNew addNew = new AddNew();
            }
        });

		JButton removeExpense = new JButton("Remove");
		removeExpense.setForeground(Color.white);
		removeExpense.setBackground(Color.black);
		removeExpense.setFont(normal);
		removeExpense.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Remove remove = new Remove();
            }
        });

		btnPanel.add(myExpensesBtn);
		btnPanel.add(addExpense);
		btnPanel.add(removeExpense);
		btnPanel.setLayout(new GridLayout(0, 1));
		btnPanel.setBorder(border);
		btnPanel.setAlignmentY(SwingConstants.CENTER);
		btnPanel.setBackground(Color.black);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(0, 1));
		
        ImageIcon exportTxtIcon = new ImageIcon("export_txt.png");
        Image imageTxt = exportTxtIcon.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imageTxt);
        JButton exportTxtbtn = new JButton(iconoEscalado);
        exportTxtbtn.setBackground(Color.black);
        exportTxtbtn.setToolTipText("Export monthly expenses to .txt file");
        
        ImageIcon exportHtmlIcon = new ImageIcon("export_html.png");
        Image imageHtml = exportHtmlIcon.getImage();
        ImageIcon imageHtmlScaled = new ImageIcon(imageHtml);
        JButton exportHtmlbtn = new JButton(imageHtmlScaled);
        exportHtmlbtn.setBackground(Color.black);
        exportHtmlbtn.setToolTipText("Export monthly expenses to .html file");

        leftPanel.add(exportTxtbtn);
        leftPanel.add(exportHtmlbtn);
		

		JPanel attributionPanel = new JPanel();
		attributionPanel.setBackground(Color.black);
		attributionPanel.add(new JLabel("© 2023 GuillemMV"));

		mainPanel.add(totalExpensePanel, BorderLayout.NORTH);
		mainPanel.add(attributionPanel, BorderLayout.SOUTH);
		mainPanel.add(btnPanel, BorderLayout.CENTER);
		mainPanel.add(leftPanel, BorderLayout.WEST);
		frame.add(mainPanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("GWalletFlow");
		frame.setSize(350, 200);
		frame.setResizable(false);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		Gui gui = new Gui();
	}
}

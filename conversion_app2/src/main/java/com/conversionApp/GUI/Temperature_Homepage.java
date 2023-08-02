package com.conversionApp.GUI;

import com.conversionApp.Utils.*;
import com.conversionApp.GUI.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Temperature_Homepage extends JFrame {

	private JPanel contentPane;
	private JTextField temperatureInput;
	private JTextField resultTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperature_Homepage frame = new Temperature_Homepage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Temperature_Homepage() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 650);
        ImageIcon appLogo = new ImageIcon(this.getClass().getResource("/images/temperatureLogo.png"));
		Image appIcon = appLogo.getImage();
        setIconImage(appIcon);
        
	    JPanel contentPane = new JPanel();
	    contentPane.setPreferredSize(new Dimension(850, 650));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(30, 49, 99));
		header.setBounds(0, 0, 850, 93);
		contentPane.add(header);
		
		JLabel title = new JLabel("Temperature Converter");
		title.setForeground(new Color(221, 230, 237));
		title.setFont(new Font("Century Gothic", Font.BOLD, 40));
		
		ImageIcon headerImg = new ImageIcon(this.getClass().getResource("/images/temperatureLogo.png"));
		
		JLabel headerLogo1 = new JLabel("");
		headerLogo1.setIcon(headerImg);
		
		JLabel headerLogo2 = new JLabel("");
		headerLogo2.setIcon(headerImg);
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(127)
					.addComponent(headerLogo1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(title, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(headerLogo2)
					.addGap(127))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_header.createSequentialGroup()
							.addComponent(headerLogo2)
							.addContainerGap())
						.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_header.createSequentialGroup()
								.addComponent(headerLogo1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap())
							.addGroup(gl_header.createSequentialGroup()
								.addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(15)))))
		);
		header.setLayout(gl_header);
		
		JPanel menu = new JPanel();
		menu.setBackground(new Color(221, 230, 237));
		menu.setBounds(0, 91, 850, 559);
		contentPane.add(menu);
		menu.setLayout(null);
		
		temperatureInput = new JTextField();
		temperatureInput.setBorder(new LineBorder(new Color(86, 45, 125), 2, true));
		temperatureInput.setBounds(198, 124, 179, 52);
		temperatureInput.setFont(new Font("Century Gothic", Font.BOLD, 16));
		menu.add(temperatureInput);
		temperatureInput.setColumns(10);
		((AbstractDocument) temperatureInput.getDocument()).setDocumentFilter(new DocumentFilter() {
		    @Override
		    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
		        StringBuilder builder = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
		        builder.insert(offset, string);

		        if (isValidDecimal(builder.toString())) {
		            super.insertString(fb, offset, string, attr);
		        }
		    }

		    @Override
		    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        StringBuilder builder = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
		        builder.replace(offset, offset + length, text);

		        if (isValidDecimal(builder.toString())) {
		            super.replace(fb, offset, length, text, attrs);
		        }
		    }

		    private boolean isValidDecimal(String text) {
		        // Allow only numbers and up to two decimals after the dot
		        return text.matches("^(\\d*\\.?\\d{0,2})$");
		    }
		});
		
		ArrayList<String> temperatureValues = new ArrayList<>(Arrays.asList("Celsius (°C)", "Fahrenheit (°F)","Kelvin (K)" ));
		

		JComboBox<String> temperatureList1 = new JComboBox<>(temperatureValues.toArray(new String[0]));
		temperatureList1.setForeground(new Color(30, 49, 99));
		temperatureList1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		temperatureList1.setBounds(198, 176, 179, 52);
		menu.add(temperatureList1);
		
		JComboBox<String> temperatureList2 = new JComboBox<>(temperatureValues.toArray(new String[0]));
		temperatureList2.setForeground(new Color(30, 49, 99));
		temperatureList2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		temperatureList2.setBounds(473, 176, 179, 52);
		temperatureList2.setSelectedIndex(1);
		menu.add(temperatureList2);
        
		
		resultTextField = new JTextField();
		resultTextField.setBorder(new LineBorder(new Color(86, 45, 125), 2, true));
		resultTextField.setFont(new Font("Century Gothic", Font.BOLD, 16));
		resultTextField.setEditable(false);
		resultTextField.setFocusable(false);
		resultTextField.setBounds(473, 124, 179, 52);
		menu.add(resultTextField);
		resultTextField.setColumns(10);
		

		
		ButtonGradient convertBtn = new ButtonGradient(this);
		convertBtn.setText("Convert");
		convertBtn.setFont(new Font("Century Gothic", Font.BOLD, 20));
		convertBtn.setBounds(336, 281, 175, 55);
		menu.add(convertBtn);
		
		
		ImageIcon homeLogo = new ImageIcon(this.getClass().getResource("/images/homeLogo.png"));
		JButton homeBtn = new JButton("");
		homeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homeBtn.setFocusPainted(false);
		homeBtn.setIcon(homeLogo);
		homeBtn.setContentAreaFilled(false);
		homeBtn.setBorderPainted(false);
		homeBtn.setBorder(null);
		homeBtn.setBounds(752, 451, 64, 64);
		menu.add(homeBtn);
	
    
		
		JTextArea errorTextField = new JTextArea();
		errorTextField.setBorder(null);
		errorTextField.setBackground(new Color(221, 230, 237));
		errorTextField.setForeground(new Color(30, 49, 99));
		errorTextField.setFont(new Font("Century Gothic", Font.BOLD, 22));
		errorTextField.setEditable(false);
		errorTextField.setBounds(130, 381, 589, 72);


		

		menu.add(errorTextField);
		
		convertBtn.setButtonGradientClickListener(new ButtonGradientClickListener() {
            @Override
            public void onClick() {
            	errorTextField.setText("");
            	resultTextField.setText("");
				String tempFrom = temperatureList1.getSelectedItem().toString(); 
				String tempTo = temperatureList2.getSelectedItem().toString(); 
				String tempValue = temperatureInput.getText();
				
				if(tempFrom.equals(tempTo)) {
					errorTextField.setForeground(Color.RED);
					errorTextField.setText("Please select different temperature units for conversion.");
					
				}else if(tempValue.trim().isEmpty() || Double.parseDouble(tempValue)==0) {
					errorTextField.setForeground(Color.RED);
					errorTextField.setText("   Please enter a temperature value to be converted.     ");
				} else {
					TemperatureFunction temperatureConversion = new TemperatureFunction(tempFrom, tempTo, Double.parseDouble(tempValue));
					DecimalFormat decimalFormat = new DecimalFormat("#.##");
					double tempConverted = temperatureConversion.getTemperatureConvertedValue();
					String resultDisplay = decimalFormat.format(tempConverted);
					resultTextField.setForeground(new Color(7, 7, 56));
					resultTextField.setText(resultDisplay);
				
				}
            	
            }
        });
		

		
	
		 homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        dispose();
		        Homepage mainMenu = new Homepage(); 
		        mainMenu.setVisible(true);
			}
		});
		
		pack();
		setLocationRelativeTo(null);
		
	}
}

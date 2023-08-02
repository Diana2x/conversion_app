package com.conversionApp.GUI;

import com.conversionApp.Utils.*;
import com.conversionApp.GUI.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JTextArea;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;


public class CurrencyConverter_Homepage extends JFrame {

	private JPanel contentPane;
	private JTextField amountInput;
	private JTextArea resultTextField;
	private Hashtable<Object, ImageIcon> currencyIcons = new Hashtable<>();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter_Homepage frame = new CurrencyConverter_Homepage();
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

	public CurrencyConverter_Homepage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		ImageIcon appLogo = new ImageIcon(this.getClass().getResource("/images/currencyLogo.png"));
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

		JLabel title = new JLabel("Currency Converter");
		title.setForeground(new Color(221, 230, 237));
		title.setFont(new Font("Century Gothic", Font.BOLD, 40));

		ImageIcon headerImg = new ImageIcon(this.getClass().getResource("/images/currencyLogo.png"));
		JLabel headerLogo1 = new JLabel("");
		headerLogo1.setIcon(headerImg);

		JLabel headerLogo2 = new JLabel("");
		headerLogo2.setIcon(headerImg);

		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup().addGap(160).addComponent(headerLogo1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(title, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(headerLogo2).addGap(160)));
		gl_header.setVerticalGroup(gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup().addGap(20)
						.addGroup(gl_header.createParallelGroup(Alignment.LEADING).addComponent(headerLogo1)
								.addComponent(headerLogo2)
								.addComponent(title, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		header.setLayout(gl_header);

		JPanel menu = new JPanel();
		menu.setBackground(new Color(221, 230, 237));
		menu.setBounds(0, 91, 850, 559);
		contentPane.add(menu);
		menu.setLayout(null);

		JLabel fromLbl = new JLabel("From");
		fromLbl.setForeground(new Color(30, 49, 99));
		fromLbl.setFont(new Font("Century Gothic", Font.BOLD, 24));
		fromLbl.setBounds(337, 93, 63, 45);
		menu.add(fromLbl);

		JLabel toLbl = new JLabel("To");
		toLbl.setForeground(new Color(30, 49, 99));
		toLbl.setFont(new Font("Century Gothic", Font.BOLD, 24));
		toLbl.setBounds(581, 93, 36, 45);
		menu.add(toLbl);

		JLabel amountLbl = new JLabel("Amount");
		amountLbl.setFont(new Font("Century Gothic", Font.BOLD, 24));
		amountLbl.setForeground(new Color(30, 49, 99));
		amountLbl.setBounds(96, 100, 107, 31);
		menu.add(amountLbl);

		amountInput = new JTextField();
		amountInput.setForeground(new Color(30, 49, 99));
		amountInput.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		amountInput.setBounds(96, 142, 175, 38);
		((AbstractDocument) amountInput.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
					throws BadLocationException {
				StringBuilder builder = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
				builder.insert(offset, string);

				if (isValidDecimal(builder.toString())) {
					super.insertString(fb, offset, string, attr);
				}
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
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
		menu.add(amountInput);
		amountInput.setColumns(10);

		ArrayList<String> currencyCodes = new ArrayList<>(Arrays.asList("ARS", "CAD", "COP", "DOP", "EUR", "GBP", "HKD",
				"JPY", "MXN", "KRW", "PEN", "RUB", "USD"));
		currencyIcons.put("ARS", new ImageIcon(this.getClass().getResource("/images/ARS.png")));
		currencyIcons.put("CAD", new ImageIcon(this.getClass().getResource("/images/CAD.png")));
		currencyIcons.put("COP", new ImageIcon(this.getClass().getResource("/images/COP.png")));
		currencyIcons.put("DOP", new ImageIcon(this.getClass().getResource("/images/DOP.png")));
		currencyIcons.put("EUR", new ImageIcon(this.getClass().getResource("/images/EUR.png")));
		currencyIcons.put("GBP", new ImageIcon(this.getClass().getResource("/images/GBP.png")));
		currencyIcons.put("HKD", new ImageIcon(this.getClass().getResource("/images/HKD.png")));
		currencyIcons.put("JPY", new ImageIcon(this.getClass().getResource("/images/JPY.png")));
		currencyIcons.put("MXN", new ImageIcon(this.getClass().getResource("/images/MXN.png")));
		currencyIcons.put("KRW", new ImageIcon(this.getClass().getResource("/images/KRW.png")));
		currencyIcons.put("PEN", new ImageIcon(this.getClass().getResource("/images/PEN.png")));
		currencyIcons.put("RUB", new ImageIcon(this.getClass().getResource("/images/RUB.png")));
		currencyIcons.put("USD", new ImageIcon(this.getClass().getResource("/images/USD.png")));
		


		JComboBox<String> fromList = new JComboBox<>(currencyCodes.toArray(new String[0]));
		fromList.setRenderer(new CurrencyComboBoxRenderer(currencyIcons));
		fromList.setCursor(new Cursor(Cursor.HAND_CURSOR));
		fromList.setForeground(new Color(30, 49, 99));
		fromList.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		fromList.setBounds(337, 141, 175, 38);

		

		JComboBox<String> toList = new JComboBox<>(currencyCodes.toArray(new String[0]));
		toList.setRenderer(new CurrencyComboBoxRenderer(currencyIcons));
		toList.setForeground(new Color(30, 49, 99));
		toList.setSelectedIndex(4);
		toList.setCursor(new Cursor(Cursor.HAND_CURSOR));
		toList.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		toList.setBounds(579, 141, 175, 38);

		menu.add(fromList);
		menu.add(toList);
		

		ButtonGradient convertBtn = new ButtonGradient(this);
		convertBtn.setText("Convert");
		convertBtn.setFont(new Font("Century Gothic", Font.BOLD, 20));
		convertBtn.setBounds(337, 227, 175, 55);
		menu.add(convertBtn);

		resultTextField = new JTextArea();
		resultTextField.setBorder(null);
		resultTextField.setFocusable(false);
		resultTextField.setForeground(new Color(30, 49, 99));
		resultTextField.setBackground(new Color(221, 230, 237));
		resultTextField.setFont(new Font("Century Gothic", Font.BOLD, 22));
		resultTextField.setEditable(false);
		resultTextField.setBounds(96, 327, 658, 133);
		menu.add(resultTextField);
		resultTextField.setColumns(10);

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

		convertBtn.setButtonGradientClickListener(new ButtonGradientClickListener() {
			@Override
			public void onClick() {
				resultTextField.setText("");
				String currencyFrom = fromList.getSelectedItem().toString();
				String currencyTo = toList.getSelectedItem().toString();
				String amount = amountInput.getText();
				if (amount.trim().isEmpty() || Double.parseDouble(amount) == 0) {
					resultTextField.setForeground(Color.RED);
					resultTextField.append("Please enter amount to be converted");
				} else {
					DecimalFormat decimalFormat = new DecimalFormat("#.##");
					resultTextField.setForeground(new Color(7, 7, 56));
					CurrencyRatesAPI dataSet = new CurrencyRatesAPI(currencyFrom, currencyTo);
					double amountValue = Double.parseDouble(amount);
					double exchangeRate = dataSet.getConversionRate();
					double conversion = amountValue * exchangeRate;
					String dateOfUpdate = dataSet.getDateFromAPI();
					String conversionValueDisplay = decimalFormat.format(conversion);

					resultTextField.append(Double.toString(amountValue) + " " + currencyFrom + " = "
							+ conversionValueDisplay + " " + currencyTo + "\nExchange Rate: " + exchangeRate
							+ "\nLast Update: " + dateOfUpdate);
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

package com.conversionApp.GUI;

import com.conversionApp.Utils.*;
import com.conversionApp.GUI.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class Homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() {

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 650);
        ImageIcon appLogo = new ImageIcon(this.getClass().getResource("/images/appLogo.png"));
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
		
		JLabel title = new JLabel("Conversion App");
		title.setForeground(new Color(221, 230, 237));
		title.setFont(new Font("Century Gothic", Font.BOLD, 40));
		
		ImageIcon headerImg = new ImageIcon(this.getClass().getResource("/images/toolLogo.png"));
		JLabel headerLogo1 = new JLabel("");
		headerLogo1.setIcon(headerImg);
		
		JLabel headerLogo2 = new JLabel("");
		headerLogo2.setIcon(headerImg);
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(198)
					.addComponent(headerLogo1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(title)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(headerLogo2)
					.addGap(199))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(headerLogo2)
						.addComponent(headerLogo1)
						.addComponent(title, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		header.setLayout(gl_header);
		

		
		JPanel menu = new JPanel();
		menu.setBackground(new Color(221, 230, 237));
		menu.setBounds(0, 91, 850, 559);
		contentPane.add(menu);
		
		ButtonGradient currencyBtn = new ButtonGradient(this);
		currencyBtn.setBounds(283, 148, 284, 66);
		currencyBtn.setFont(new Font("Century Gothic", Font.BOLD, 20));
		currencyBtn.setText("Currency Converter");
		currencyBtn.setBorder(null);
		ButtonGradient temperatureBtn = new ButtonGradient(this);
		temperatureBtn.setBounds(283, 309, 284, 66);
		temperatureBtn.setFont(new Font("Century Gothic", Font.BOLD, 20));
		temperatureBtn.setText("Temperature Converter");
		temperatureBtn.setBorder(null);
		
		ImageIcon currencyImg = new ImageIcon(this.getClass().getResource("/images/currencyLogo.png"));
		JLabel currencyLogo = new JLabel("");
		currencyLogo.setBounds(193, 148, 64, 64);
		currencyLogo.setIcon(currencyImg);
		
		ImageIcon temperatureImg = new ImageIcon(this.getClass().getResource("/images/temperatureLogo.png"));
		JLabel temperatureLogo = new JLabel("");
		temperatureLogo.setBounds(193, 309, 64, 64);
		temperatureLogo.setIcon(temperatureImg);
		
		currencyBtn.setButtonGradientClickListener(new ButtonGradientClickListener() {
            @Override
            public void onClick() {
            	CurrencyConverter_Homepage currencyPage = new CurrencyConverter_Homepage();
            	currencyPage.setVisible(true);
            	dispose();
            	
            }
        });
		
		temperatureBtn.setButtonGradientClickListener(new ButtonGradientClickListener() {
            @Override
            public void onClick() {
            	Temperature_Homepage temperaturePage = new Temperature_Homepage();
            	temperaturePage.setVisible(true);
            	dispose();
            	
            }
        });
		menu.setLayout(null);
		menu.add(temperatureLogo);
		menu.add(currencyLogo);
		menu.add(temperatureBtn);
		menu.add(currencyBtn);
	
		pack();
		setLocationRelativeTo(null);
	}
	

}

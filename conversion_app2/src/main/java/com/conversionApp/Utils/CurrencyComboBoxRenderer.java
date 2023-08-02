package com.conversionApp.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class CurrencyComboBoxRenderer implements ListCellRenderer<String> {
    private Hashtable<Object, ImageIcon> mElementos;
    private ImageIcon mImg = new ImageIcon(this.getClass().getResource("/images/default.png"));

    public CurrencyComboBoxRenderer(Hashtable<Object, ImageIcon> mElementos) {
        this.mElementos = mElementos;
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        JLabel label = new JLabel();

    
        ImageIcon flagIcon = mElementos.get(value);
        if (flagIcon == null) {
            flagIcon = mImg;
        }

        // Set the flag image and text for the ComboBox item
        label.setIcon(resizeImageIcon(flagIcon, 30, 30));
        label.setText(value.toString());
        label.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));


        // Set the background and foreground colors for selection and non-selection states
        if (isSelected) {
            label.setBackground(list.getSelectionBackground());
            label.setForeground(list.getSelectionForeground());
    
        } else {
            label.setBackground(list.getBackground());
            label.setForeground(list.getForeground());
        }

       
        label.setOpaque(true);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        return label;
    }

    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}


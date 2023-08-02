package com.conversionApp.Utils;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.plaf.basic.BasicButtonUI;

public class NoFocusButtonUI extends BasicButtonUI {
    // Override the paintFocus method to do nothing
    @Override
    protected void paintFocus(Graphics g, AbstractButton b,
                              Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        // Do nothing - this will prevent the focus border from being painted
    }
}

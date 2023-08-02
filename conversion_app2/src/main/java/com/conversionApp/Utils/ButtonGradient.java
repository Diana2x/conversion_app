package com.conversionApp.Utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.GradientPaint;
import java.awt.geom.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*; 

public class ButtonGradient extends JButton{
	
	private Color color1 = Color.decode("#562D7D");
	private Color color2 = Color.decode("#1E3163");
	private final Timer timer; 
	private final Timer timerPressed;
	private float alpha = 0.3f;
	private boolean mouseOver;
	private boolean pressed;
	private Point pressedLocation;
	private float pressedSize;
	private float sizeSpeed = 20f;
	private float alphaPressed = 0.5f;
	private JFrame parentFrame;
	
	
	public ButtonGradient(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		setContentAreaFilled(false);
		setForeground(Color.WHITE);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setBorder(new EmptyBorder(10,20,10,20));
		setBorder(new EmptyBorder(0,0,0,0));
		setUI(new NoFocusButtonUI());
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				mouseOver= true; 
				timer.start();
			}
			@Override
			public void mouseExited(MouseEvent me) {
				mouseOver= false; 
				timer.start();
			}
			@Override
			public void mousePressed(MouseEvent me) {
				pressedSize = 0; 
				alphaPressed = 0.5f;
				pressed = true;
				pressedLocation = me.getPoint();
				timerPressed.setDelay(0);
				timerPressed.start();
			}
		});
		
        ActionListener timerAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (mouseOver) {
                	if(alpha<0.6f) {
						alpha += 0.05f;
						repaint();
					}else {
						alpha = 0.6f;
						timer.stop();
						repaint();
					}
                } else {
                	if(alpha>0.3f) {
						alpha-=0.05f;
						repaint();
					} else {
						alpha = 0.3f;
						timer.stop();
						repaint();
						
					}
                }
                // Don't forget to call 'repaint()' when necessary
                repaint();
            }
        };
        timer = new Timer(20, timerAction);
        
        ActionListener timerPressedAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	pressedSize += sizeSpeed;
				if(alphaPressed <= 0) {
					pressed = false;
					timerPressed.stop();
				}else {
					repaint();
				}
            }
        };
        timerPressed = new Timer(0, timerPressedAction);
	}
	
	@Override 
	protected void paintComponent(Graphics graphics) {
		int width = getWidth();
		int height = getHeight();
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = img.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Create the Gradient Color 
		GradientPaint gra = new GradientPaint(0,0, color1, width, 0, color2);
		g2.setPaint(gra);
		g2.fillRoundRect(0, 0, width, height, height, height);
		// Add Style 
		createStyle(g2);
		if(pressed) {
			paintPressed(g2);
		}
		g2.dispose();
		graphics.drawImage(img, 0, 0, null);
		super.paintComponent(graphics);
	}
	
	private void createStyle(Graphics2D g2) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			int width= getWidth();
			int height = getHeight();
			GradientPaint gra = new GradientPaint(0,0, Color.white, 0, height, new Color(255,255,255, 50));
			g2.setPaint(gra);
			Path2D.Float f = new Path2D.Float(); 
			f.moveTo(0,0);
			int controll = height+height/2;
			f.curveTo(0, 0, width/2, controll, width, 0);
			g2.fill(f);
	}
	
	private void paintPressed(Graphics2D g2) {
		if(pressedLocation.x-(pressedSize/2)<0 && pressedLocation.x+(pressedSize/2)> getWidth()) {
			timerPressed.setDelay(1);
			alphaPressed-=0.05f; 
			if(alphaPressed<0) {
				alphaPressed = 0;
			}
		}
		g2.setColor(Color.white);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alphaPressed));
		float x =pressedLocation.x-(pressedSize/2);
		float y = pressedLocation.y-(pressedSize/2);
		g2.fillOval((int)x, (int)y, (int)pressedSize, (int)pressedSize);
		
	}
	
	private ButtonGradientClickListener clickListener;
	public void setButtonGradientClickListener(ButtonGradientClickListener listener) {
        this.clickListener = listener;
    }
	@Override
    protected void processMouseEvent(MouseEvent e) {
        if (getModel().isEnabled()) {
            if (e.getID() == MouseEvent.MOUSE_PRESSED) {
                // Handle the mouse press event and notify the click listener
                if (clickListener != null) {
                    clickListener.onClick();
                }
            }
        }
        super.processMouseEvent(e);
    }
	

}


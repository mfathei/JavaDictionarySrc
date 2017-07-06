package org.sqlite.data;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class setting extends JDialog {
    private BorderLayout borderLayout1 = new BorderLayout();
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JLabel jLabel1 = new JLabel();
    private JSlider volume = new JSlider();
    private JSlider speed = new JSlider();
    private JLabel jLabel2 = new JLabel();
    private JSeparator jSeparator1 = new JSeparator();
    private JSeparator jSeparator2 = new JSeparator();
    private JSeparator jSeparator3 = new JSeparator();
    private JSeparator jSeparator4 = new JSeparator();
    private JSeparator jSeparator5 = new JSeparator();

    public setting() {
        this(null, "", false);
    }

    public setting(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(403, 244));
        this.getContentPane().setLayout(borderLayout1);
        this.setModal(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("Settings");
        jPanel1.setLayout(null);
        jPanel2.setBounds(new Rectangle(-3, 0, 405, 215));
        jPanel2.setLayout(null);
        jPanel2.setBackground(Color.white);
        jLabel1.setText("Volume");
        jLabel1.setFont(new Font("Tahoma", 1, 12));
        jLabel1.setBounds(new Rectangle(25, 35, 65, 30));
        volume.setBounds(new Rectangle(95, 35, 250, 50));
        volume.setValueIsAdjusting(true);
        volume.setForeground(Color.red);
        volume.setBackground(Color.white);
        jPanel2.add(jSeparator5, null);
        jPanel2.add(jSeparator4, null);
        jPanel2.add(jSeparator3, null);
        jPanel2.add(jSeparator2, null);
        jPanel2.add(jSeparator1, null);
        jPanel2.add(jLabel2, null);
        jPanel2.add(speed, null);
        jPanel2.add(volume, null);
        jPanel2.add(jLabel1, null);
        jPanel1.add(jPanel2, null);
        this.getContentPane().add(jPanel1, BorderLayout.CENTER);
        volume.setModel(new DefaultBoundedRangeModel(10, 0, 0, 10));
        speed.setBounds(new Rectangle(95, 130, 250, 50));
        speed.setForeground(Color.red);
        speed.setBackground(Color.white);
        jLabel2.setText("Speed");
        jLabel2.setBounds(new Rectangle(25, 130, 65, 30));
        jLabel2.setFont(new Font("Tahoma", 1, 12));
        jSeparator1.setBounds(new Rectangle(10, 200, 385, 5));
        jSeparator1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jSeparator1.setBackground(Color.yellow);
        jSeparator2.setBounds(new Rectangle(10, 10, 385, 5));
        jSeparator2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jSeparator2.setBackground(Color.yellow);
        jSeparator3.setBounds(new Rectangle(10, 105, 385, 5));
        jSeparator3.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jSeparator3.setBackground(Color.yellow);
        jSeparator4.setBounds(new Rectangle(10, 10, 5, 195));
        jSeparator4.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jSeparator4.setBackground(Color.yellow);
        jSeparator5.setBounds(new Rectangle(390, 10, 5, 195));
        jSeparator5.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jSeparator5.setBackground(Color.yellow);
        setSliders();//*******
        setImage();
        speed.setModel(new DefaultBoundedRangeModel(1, 0, 0, 10)); //---
    }

    private void jButton1_actionPerformed(ActionEvent e) {
        this.dispose();
    }
    
    private void setSliders(){
        
        volume.setMajorTickSpacing(2);
        volume.setMinorTickSpacing(1);
        volume.setPaintTicks(true);
        volume.setPaintLabels(true);
        
        speed.setMajorTickSpacing(2);
        speed.setMinorTickSpacing(1);
        speed.setPaintTicks(true);
        speed.setPaintLabels(true);
    }
    
    private void setImage(){
        URL url=setting.class.getResource("images/SplashScreen (11).png");
        if(url!=null){
            this.setIconImage(new ImageIcon(url).getImage());
        }
    }
    
    public float getSpeed(){
        return (float)this.speed.getValue();
    }
    
    public void setSpeed(float value){
        this.speed.setValue((int)value);
    }
    
    public float getVolume(){
        return (float)this.volume.getValue()/10;
    }
    
    public void setVolume(float value){
        this.volume.setValue((int)value*10);
    }
    
}

package org.sqlite.data;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import java.awt.Rectangle;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class aboutd extends JDialog {
    private JPanel jPanel1 = new JPanel();
    private BorderLayout borderLayout1 = new BorderLayout();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();

    public aboutd() {
        this(null, "", false);
    }

    public aboutd(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(417, 267));
        this.getContentPane().setLayout(borderLayout1);
        this.setModal(true);
        this.setResizable(false);
        jPanel1.setLayout(null);
        jPanel1.setBackground(Color.white);
        jLabel1.setText("ﬁ«„ »«‰ «Ã Â–« «·»—‰«„Ã");
        jLabel1.setBounds(new Rectangle(34, 5, 345, 40));
        jLabel1.setFont(new Font("Courier New", 1, 13));
        jLabel1.setForeground(Color.red);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("„Â‰œ”/ „Õ„œ › ÕÏ »«‘«");
        jLabel2.setBounds(new Rectangle(41, 40, 330, 45));
        jLabel2.setFont(new Font("Courier New", 1, 20));
        jLabel2.setForeground(Color.red);
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Java & C# Programmer");
        jLabel3.setBounds(new Rectangle(16, 80, 380, 50));
        jLabel3.setFont(new Font("Arial", 1, 14));
        jLabel3.setForeground(new Color(0, 33, 115));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("Oracle & Web Developer");
        jLabel4.setBounds(new Rectangle(14, 125, 385, 60));
        jLabel4.setFont(new Font("Arial", 1, 14));
        jLabel4.setForeground(new Color(0, 33, 115));
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Tel: 012/9503393");
        jLabel5.setBounds(new Rectangle(24, 180, 365, 40));
        jLabel5.setFont(new Font("Arial", 1, 14));
        jLabel5.setForeground(new Color(0, 33, 115));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel1.add(jLabel5, null);
        jPanel1.add(jLabel4, null);
        jPanel1.add(jLabel3, null);
        jPanel1.add(jLabel2, null);
        jPanel1.add(jLabel1, null);
        this.getContentPane().add(jPanel1, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("About The Owner");
        setImage();//--
    }
    
    private void setImage(){
        URL url=aboutd.class.getResource("images/AFLLEFT.GIF");
        if(url!=null){
            this.setIconImage(new ImageIcon(url).getImage());
        }
    }
}

package org.sqlite.data;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class insert extends JDialog {
    private JPanel jPanel1 = new JPanel();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JTextField enw = new JTextField();
    private JTextField arw = new JTextField();
    private JSeparator jSeparator1 = new JSeparator();
    private JButton cancel = new JButton();
    private JButton save = new JButton();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    sqlit sql=new sqlit();
    
    public insert() {
        this(null, "", false);
    }

    public insert(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(428, 248));
        this.getContentPane().setLayout( null );
        this.setModal(true);
        this.setResizable(false);
        jPanel1.setBounds(new Rectangle(-1, 0, 425, 85));
        jPanel1.setBackground(Color.white);
        jPanel1.setLayout(null);
        jPanel1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel1.setText("Ì„ﬂ‰ﬂ «÷«›… ﬂ·„«  ÃœÌœ… ··ﬁ«„Ê”");
        jLabel1.setBounds(new Rectangle(68, 10, 295, 35));
        jLabel1.setForeground(Color.red);
        jLabel1.setFont(new Font("Tahoma", 1, 13));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("«„·« «·»Ì«‰«  «· «·Ì… Ê«÷€ÿ «÷«›…");
        jLabel2.setBounds(new Rectangle(75, 50, 280, 25));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setForeground(new Color(0, 33, 115));
        jLabel2.setFont(new Font("Tahoma", 1, 11));
        enw.setBounds(new Rectangle(15, 90, 310, 30));
        enw.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        enw.setFont(new Font("Tahoma", 1, 11));
        enw.setHorizontalAlignment(JTextField.LEFT);
        arw.setBounds(new Rectangle(15, 130, 310, 30));
        arw.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        arw.setFont(new Font("Tahoma", 1, 11));
        arw.setHorizontalAlignment(JTextField.RIGHT);
        jSeparator1.setBounds(new Rectangle(0, 170, 430, 5));
        cancel.setText("—Ã‹‹‹‹‹‹‹‹‹‹Ê⁄");
        cancel.setBounds(new Rectangle(75, 180, 110, 30));
        cancel.setFont(new Font("Tahoma", 1, 11));
        cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancel_actionPerformed(e);
                }
            });
        save.setText("«÷«›‹‹‹‹‹‹‹…");
        save.setBounds(new Rectangle(210, 180, 110, 30));
        save.setFont(new Font("Tahoma", 1, 11));
        save.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    save_actionPerformed(e);
                }
            });
        jLabel3.setText("«·ﬂ·„… «·«‰Ã·Ì“Ì…");
        jLabel3.setBounds(new Rectangle(330, 90, 95, 30));
        jLabel3.setFont(new Font("Tahoma", 1, 11));
        jLabel4.setText("«·ﬂ·„… «·⁄—»Ì‹‹‹‹‹‹…");
        jLabel4.setBounds(new Rectangle(330, 130, 95, 30));
        jLabel4.setFont(new Font("Tahoma", 1, 11));
        jPanel1.add(jLabel2, null);
        jPanel1.add(jLabel1, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(save, null);
        this.getContentPane().add(cancel, null);
        this.getContentPane().add(jSeparator1, null);
        this.getContentPane().add(arw, null);
        this.getContentPane().add(enw, null);
        this.getContentPane().add(jPanel1, null);
        setImage();//---
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("Add New Words");
    }
    
    private void setImage(){
        
        URL url=Dict.class.getResource("images/AFSAVE.GIF"); 
        
        if(url != null){
            this.setIconImage(new ImageIcon(url).getImage());
        }
    }

    private void cancel_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void save_actionPerformed(ActionEvent e) {
        
        if(this.enw.getText().trim().length()<=0){
            JOptionPane.showMessageDialog(this,"ÌÃ» «œŒ«· «·ﬂ·„… «·«‰Ã·Ì“Ì…","Œÿ‹‹‹‹‹‹‹‹‹‹√",JOptionPane.ERROR_MESSAGE);
            this.enw.requestFocus();
            return;
        }
        
        if(this.arw.getText().trim().length()<=0){
            JOptionPane.showMessageDialog(this,"ÌÃ» «œŒ«· «·ﬂ·„… «·⁄—»Ì… ","Œÿ‹‹‹‹‹‹‹‹‹‹√",JOptionPane.ERROR_MESSAGE);
            this.arw.requestFocus();
            return;
        }
        
        if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this,"Â·  —Ìœ «÷«›… Â–Â «·ﬂ·„«  »«·›⁄· ø"," √ﬂÌœ «·⁄„·Ì…",JOptionPane.YES_NO_OPTION)){
            if(sql.addData(this.enw.getText().trim(),this.arw.getText().trim())){
                JOptionPane.showMessageDialog(this," „  «·⁄„·Ì… »‰Ã«Õ ","—”‹‹‹‹‹‹‹‹‹«·…",JOptionPane.INFORMATION_MESSAGE); 
            }else{
                JOptionPane.showMessageDialog(this,"·„  ‰ÃÕ «·⁄„·Ì… Ì—ÃÏ «⁄«œ… «·„Õ«Ê·… ","Œÿ‹‹‹‹‹‹‹‹‹‹√",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

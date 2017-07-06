package org.sqlite.data;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import com.sun.speech.freetts.VoiceManager ;
import com.sun.speech.freetts.Voice ;

import java.awt.ComponentOrientation;
import java.awt.Toolkit;

import java.awt.datatransfer.Clipboard;

import java.awt.datatransfer.DataFlavor;

import java.awt.datatransfer.UnsupportedFlavorException;

import java.io.IOException;

import java.util.HashMap;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.TransferHandler;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class Dict extends JFrame {
    private BorderLayout borderLayout1 = new BorderLayout();
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JComboBox word = new JComboBox();
    private JButton mean = new JButton();
    private JButton exit = new JButton();
    private JButton speak = new JButton();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JTable artab = new JTable();
    private JTable entab = new JTable();

    String stext="";
    VoiceManager vmanager=VoiceManager.getInstance();
    Voice voice=vmanager.getVoice("kevin16");
    private JMenuBar jMenuBar1 = new JMenuBar();
    private JMenu jMenu1 = new JMenu();
    private JMenuItem ext = new JMenuItem();
    private JMenu jMenu2 = new JMenu();
    private JMenuItem opti = new JMenuItem();
    private JMenu jMenu3 = new JMenu();
    private JMenuItem about = new JMenuItem();
    setting sett=new setting();
    sqlit sql=new sqlit();
    HashMap likes=new HashMap();
    Object selected=null;
    int i=0;
    private JMenuItem aDD = new JMenuItem();

    public Dict() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try{
            voice.allocate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"ÕœÀ Œÿ√ ›Ï «” œ⁄«¡ √’Ê«  «·ﬁ«„Ê” ”Ì „ «€·«ﬁ «·»—‰«„Ã","Œÿ‹‹‹‹‹‹‹‹‹‹‹‹‹‹‹‹‹‹‹‹√",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        setMenus();//****
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(borderLayout1);
        this.setSize(new Dimension(600, 323));
        jPanel1.setPreferredSize(new Dimension(10, 45));
        jPanel1.setSize(new Dimension(495, 50));
        jPanel1.setLayout(null);
        jPanel2.setPreferredSize(new Dimension(300, 10));
        jPanel2.setLayout(null);
        word.setBounds(new Rectangle(5, 10, 290, 30));
        word.setSize(new Dimension(288, 30));
        word.setEditable(true);
        word.setFont(new Font("Tahoma", 1, 13));
        word.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        word.setForeground(new Color(198, 0, 0));
        word.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    word_actionPerformed(e);
                }
            });
        mean.setText("Mean „⁄‰Ï");
        mean.setBounds(new Rectangle(300, 10, 100, 30));
        mean.setFont(new Font("Tahoma", 1, 11));
        mean.setFocusPainted(false);
        mean.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mean_actionPerformed(e);
                }
            });
        exit.setText("Exit Œ—ÊÃ");
        exit.setBounds(new Rectangle(495, 10, 95, 30));
        exit.setFont(new Font("Tahoma", 1, 11));
        exit.setFocusPainted(false);
        exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    exit_actionPerformed(e);
                }
            });
        speak.setText("Talk  ‰ÿﬁ ");
        speak.setBounds(new Rectangle(400, 10, 95, 30));
        speak.setFont(new Font("Tahoma", 1, 11));
        speak.setFocusPainted(false);
        speak.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    speak_actionPerformed(e);
                }
            });
        jScrollPane1.setBounds(new Rectangle(5, 0, 290, 220));
        jScrollPane1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jScrollPane1.setSize(new Dimension(288, 220));
        jScrollPane2.setBounds(new Rectangle(300, 0, 290, 220));
        jScrollPane2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        artab.setFillsViewportHeight(true);
        artab.setShowHorizontalLines(false);
        artab.setShowVerticalLines(false);
        entab.setFillsViewportHeight(true);
        entab.setShowHorizontalLines(false);
        entab.setShowVerticalLines(false);
        entab.setSize(new Dimension(284, 216));
        jMenu1.setText("File");
        ext.setText("Exit");
        ext.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ext_actionPerformed(e);
                }
            });
        jMenu2.setText("Edit");
        opti.setText("Options");
        opti.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    opti_actionPerformed(e);
                }
            });
        jMenu3.setText("Help");
        about.setText("About");
        about.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    about_actionPerformed(e);
                }
            });
        aDD.setText("Add Words");
        aDD.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aDD_actionPerformed(e);
                }
            });
        jPanel1.add(speak, null);
        jPanel1.add(exit, null);
        jPanel1.add(mean, null);
        jPanel1.add(word, null);
        this.getContentPane().add(jPanel1, BorderLayout.NORTH);
        jScrollPane2.getViewport().add(artab, null);
        jPanel2.add(jScrollPane2, null);
        jScrollPane1.getViewport().add(entab, null);
        jPanel2.add(jScrollPane1, null);
        this.getContentPane().add(jPanel2, BorderLayout.CENTER);
        jMenu1.add(ext);
        jMenuBar1.add(jMenu1);
        jMenu2.add(aDD);
        jMenu2.addSeparator();
        jMenu2.add(opti);
        jMenuBar1.add(jMenu2);
        jMenu3.add(about);
        jMenuBar1.add(jMenu3);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Java Dictionary");
        this.setJMenuBar(jMenuBar1);
        this.addComponentListener(new ComponentAdapter() {
                public void componentShown(ComponentEvent e) {
                    this_componentShown(e);
                }
            });
        this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    this_windowClosing(e);
                }
            });
        this.setLocationRelativeTo(null);
        setImage();// *****
        alterTables();//---
    }
    
    private void setImage(){
        
        URL url=Dict.class.getResource("images/kmix.png"); 
        
        if(url != null){
            this.setIconImage(new ImageIcon(url).getImage());
        }
    }

    private void exit_actionPerformed(ActionEvent e) {
        this_windowClosing(null);
    }

    private void mean_actionPerformed(ActionEvent e) {
        if(word.getSelectedItem()!=null && ((String)word.getSelectedItem()).trim().length()>0){
            
            sql.getData(((String)word.getSelectedItem()).trim());
            
            entab.setModel(new tmodel(sql.getenMap()));
            artab.setModel(new amodel(sql.getarMap()));
            TableColumn column = artab.getColumn("A");
            DefaultTableCellRenderer cellrenderer = new DefaultTableCellRenderer();
            cellrenderer.setHorizontalAlignment(JLabel.RIGHT);
            column.setCellRenderer(cellrenderer);
            
            if(this.isEnglish((String)word.getSelectedItem())){
                if(entab.getRowCount() <=0){
                    likes.clear();
                    selected=word.getSelectedItem();               
                    likes=sql.getenlikes((String)word.getSelectedItem());// *********
                    word.removeAllItems();
                    word.addItem(selected);
                    for(i=0;i<likes.size();i++){
                        word.addItem(likes.get(i));
                    }
                    word.setPopupVisible(true);
                }
            }else{
                if(entab.getRowCount() <=0){
                    likes.clear();
                    selected=word.getSelectedItem();               
                    likes=sql.getarlikes((String)word.getSelectedItem());// *********
                    word.removeAllItems();
                    word.addItem(selected);
                    for(i=0;i<likes.size();i++){
                        word.addItem(likes.get(i));
                    }
                    word.setPopupVisible(true);
                }
            }
                       

            
        }
    }

    private boolean isEnglish(String word){
        char first=word.trim().charAt(0);
        String start=first+"";
        if(start.equalsIgnoreCase("a")||start.equalsIgnoreCase("b")||start.equalsIgnoreCase("c")||start.equalsIgnoreCase("d")
            ||start.equalsIgnoreCase("e")||start.equalsIgnoreCase("f")||start.equalsIgnoreCase("g")||start.equalsIgnoreCase("h")
            ||start.equalsIgnoreCase("i")||start.equalsIgnoreCase("j")||start.equalsIgnoreCase("k")||start.equalsIgnoreCase("l")
            ||start.equalsIgnoreCase("m")||start.equalsIgnoreCase("n")||start.equalsIgnoreCase("o")||start.equalsIgnoreCase("b")
            ||start.equalsIgnoreCase("q")||start.equalsIgnoreCase("r")||start.equalsIgnoreCase("s")||start.equalsIgnoreCase("t")
            ||start.equalsIgnoreCase("u")||start.equalsIgnoreCase("v")||start.equalsIgnoreCase("w")||start.equalsIgnoreCase("x")
            ||start.equalsIgnoreCase("y")||start.equalsIgnoreCase("z")){
               return true;
           }
        
        return false;
    }

    private void word_actionPerformed(ActionEvent e) {
        if(!word.isPopupVisible()){
            mean.doClick(1);
        }
    }

    private void ext_actionPerformed(ActionEvent e) {
        this_windowClosing(null);
    }
    
    private void setMenus(){
        ext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,ActionEvent.ALT_MASK));
        opti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
        aDD.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
    }

    private void speak_actionPerformed(ActionEvent e) {
        
        if(word.getSelectedItem() != null){
            stext=(String)word.getSelectedItem();
        }
               
        if(stext != null && stext.trim().length()>0){ 
            
            //voice.setPitch(1000.0f);// 10.0f to 1000.0f
            voice.setDurationStretch(sett.getSpeed());// 0.0f 20.0f speed
            //voice.setPitchRange(0.5f);// 10.0f to 1000.0f
            //voice.setRate(10.0f);// 10.0f to 1000.0f
            //voice.setPitchShift(0.5f);// 0.5f to 10.0f
            voice.setVolume(sett.getVolume());// 0.0f to 1.0f
            voice.speak(stext);
            //System.out.println("hiiiiiiiii");
        }
        
        
    }

    private void opti_actionPerformed(ActionEvent e) {
        
        sett.setLocationRelativeTo(this);
        sett.setVisible(true);
    }

    private void about_actionPerformed(ActionEvent e) {
        aboutd ab=new aboutd();
        ab.setLocationRelativeTo(this);
        ab.setVisible(true);
    }

    private void alterTables() {
        artab.setRowHeight(23);
        artab.setFont(new Font("Arial",Font.BOLD,15));
        artab.setForeground(new Color(0,33,115));
        artab.setSelectionForeground(new Color(255,0,0));
        artab.setTableHeader(null);
        
        entab.setRowHeight(23);
        entab.setFont(new Font("Arial",Font.BOLD,15));
        entab.setForeground(new Color(0,33,115));
        entab.setSelectionForeground(new Color(255,0,0));
        entab.setTableHeader(null);
    }

    private void this_componentShown(ComponentEvent e) {
        if(sql.Connect()){
            
            if(!sql.findData()){
                JOptionPane.showMessageDialog(this,"ÕœÀ Œÿ√ ›Ï «·« ’«· »ﬁ«⁄œ… «·»Ì«‰«  ”Ì „ «€·«ﬁ «·»—‰«„Ã","Œÿ‹‹‹‹‹‹‹‹‹‹‹‹‹√",JOptionPane.ERROR_MESSAGE);
                sql.Disconnect();
                System.exit(0);
            }
            
        }
    }

    private void this_windowClosing(WindowEvent e) {
        sql.Disconnect();
        this.dispose();
        System.exit(0);
    }

    private void aDD_actionPerformed(ActionEvent e) {
        insert ins=new insert();
        ins.setLocationRelativeTo(this);
        ins.setVisible(true);
    }
}

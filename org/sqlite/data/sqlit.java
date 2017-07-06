package org.sqlite.data;

import java.sql.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;


public class sqlit {
    
    HashMap arvc=new HashMap();
    HashMap envc=new HashMap();
    HashMap likes=new HashMap();
    static Connection conn=null;
    
    public sqlit(){
        
        System.setProperty("file.encoding","windows-1256");
        
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean Connect(){

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:ClassPath/Dic_data.class");
            return true;
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return false;
    }
    
    public void getData(String aword){
        
        try {
            
            arvc.clear();
            envc.clear();
            
            Statement ss=conn.createStatement();
            ResultSet rs=ss.executeQuery("select Distinct(en),ar from word where en='"+ aword.toUpperCase() +"' or ar='"+ aword.toUpperCase() +"' ");
            
            int i=0;
            while(rs.next()){
                //System.out.println(rs.getString(1));
                //JOptionPane.showMessageDialog(null,rs.getString(1));               
                envc.put(i,rs.getObject(1));
                arvc.put(i,rs.getObject(2));
                i++;
            }
            
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        
    }
    
    public HashMap getarMap(){
        return this.arvc;
    }
    
    public HashMap getenMap(){
        return this.envc;
    }
    
    public HashMap getenlikes(String word){
        
        try {
            
            likes.clear();

            Statement ss=conn.createStatement();
            ResultSet rs=ss.executeQuery("select Distinct(en) from word where en like '%"+ word.toUpperCase() +"%' limit 20 ");
            
            int i=0;
            while(rs.next()){              
                likes.put(i,rs.getObject(1));
                i++;
            }
            
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        
        return likes;
    }
    
    public HashMap getarlikes(String word){
        
        try {
            
            likes.clear();

            Statement ss=conn.createStatement();
            ResultSet rs=ss.executeQuery("select Distinct(ar) from word where  ar like'%"+ word.toUpperCase() +"%' limit 20 ");
            
            int i=0;
            while(rs.next()){              
                likes.put(i,rs.getObject(1));
                i++;
            }
            
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        
        return likes;
    }
    
    public boolean addData(String enword,String arword){
        
        try {
            
            PreparedStatement prs=conn.prepareStatement("insert into word(en,ar) values(?,?); ");
            
            prs.setString(1,enword.toUpperCase());
            prs.setString(2,arword.toUpperCase());
            int success=prs.executeUpdate();

            if(success > 0) return true;
            
        } catch (Exception e) {
            System.out.print(e.getMessage());
            //e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean findData(){
        
        try {
            
            Statement prs=conn.createStatement();
            ResultSet rs=prs.executeQuery("select count(*) from word");
            
            int success=rs.getInt(1);
            if(success >= 1) return true;
            
        } catch (Exception e) {
            System.out.print(e.getMessage());
            //e.printStackTrace();
        }
        
        return false;
    }
    
    public void Disconnect(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        }
    }
    
}

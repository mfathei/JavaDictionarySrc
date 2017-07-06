package org.sqlite.data;

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

public class amodel extends AbstractTableModel {
    
    HashMap arabic=new HashMap();
    
    public amodel(HashMap amap) {
        super();
        this.arabic=amap;
    }

    public int getRowCount() {
        return arabic.size();
    }

    public int getColumnCount() {
        return 1;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return arabic.get(rowIndex);
    }
}

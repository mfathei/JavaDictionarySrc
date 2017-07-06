package org.sqlite.data;

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

public class tmodel extends AbstractTableModel {
    
    HashMap english=new HashMap();
    
    public tmodel(HashMap emap) {
        super();
        this.english=emap;
    }

    public int getRowCount() {
        return english.size();
    }

    public int getColumnCount() {
        return 1;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return english.get(rowIndex);
    }
}

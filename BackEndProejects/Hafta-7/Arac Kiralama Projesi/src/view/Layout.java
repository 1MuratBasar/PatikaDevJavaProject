package view;

import core.Helper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Layout extends JFrame {

    public void guiInitialize (int width, int height) {
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("RENT A CAR");
        this.setSize(width, height);
        this.setLocation(Helper.getLocationPoint("x", this.getSize()), Helper.getLocationPoint("y", this.getSize()));
        this.setVisible(true);
}

public void createTable (DefaultTableModel model, JTable table, Object[] columns, ArrayList<Object[]> rows) {
      model.setColumnIdentifiers(columns);
      table.setModel(model);
      table.getTableHeader().setReorderingAllowed(false);
      table.getColumnModel().getColumn(0).setMaxWidth(75); //kolon boyutları
      table.setEnabled(false);

      DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
      clearModel.setRowCount(0);

      if (rows == null) {
        rows = new ArrayList<>();
      }

      for (Object[] row : rows) {
        model.addRow(row);
      }
}

public int getTableSelectedRow (JTable table, int index){ // geriye integer bir id döndürecek
//bu içerde jtable alacak ve seçili row u verecek
return Integer.parseInt(table.getValueAt(table.getSelectedRow(), index).toString()); //hangi row seçiliyse onun 0. indexindeki değeri veriyor ve bunu string donduruyor
//bu metot ile bu tablodak isecili indexteki veriyi getirsin diyorum

}

//**************************************************************************************************************
//MODELLERİN OLUTURULMASI - KISIM 2 - ALT

public void tableRowSelect(JTable table){ //burayı akıllı hale getiriyorum conku tum marka, model, kiralama tabloalrında ortak bir özellik
    table.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            int selected_row = table.rowAtPoint(e.getPoint()); // burasınn anlamı. tabloda mouse hangi alana denk geliyorsa bana getir
            table.setRowSelectionInterval(selected_row, selected_row);
        }
    }); //MOUSE LISTENER İLE TABLODAKİ SATIRI SEÇTİRMEYİ SAĞLADIK.
}
//MODELLERİN OLUTURULMASI - KISIM 2 - ÜST
//**************************************************************************************************************

}
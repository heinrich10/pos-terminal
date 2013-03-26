/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.service;

import IMS.controller.InventoryController;
import IMS.domain.Inventory;
import OMS.domain.TransactionData;
import core.domain.SessionFactory;
import db.mapper.TransactionMapper;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Heinrich
 */
public class ExcelService {
    
    private String fileName;
    private Workbook wb;
    private int rowCounter = 0;
    private int colLength;
    
    public ExcelService(String fileName){
        this.fileName = fileName;
        wb = new HSSFWorkbook(); 
    }
    
    public Sheet createSheet(String name){
        Sheet sheet = wb.createSheet(name);
        return sheet;
    }
    
    public void setColumnName(String[] columnName, Sheet sheet){
        Row row = sheet.createRow(rowCounter++);
        colLength = columnName.length;
        for(int i = 0; i < columnName.length; i++){
            Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
            cell.setCellValue(columnName[i]);
        }
        
    }
    
    public void setTransactionData(ArrayList<TransactionData> arrList, Sheet sheet){
        
        
        for(int i = 0; i < arrList.size(); i++){
            Row row = sheet.createRow(rowCounter++);
            Cell cell = row.createCell(0, Cell.CELL_TYPE_STRING);
            cell.setCellValue(arrList.get(i).getTimeStamp());
            CellStyle cs = cell.getCellStyle();
            
            Cell cell1 = row.createCell(1, Cell.CELL_TYPE_NUMERIC);
            cell1.setCellValue(arrList.get(i).getCodeTransaction());
            Cell cell2 = row.createCell(2, Cell.CELL_TYPE_STRING);
            if(arrList.get(i).getIndDineIn()){
                cell2.setCellValue("Yes");
            } else {
                cell2.setCellValue("No");
            }
           
            Cell cell3 = row.createCell(3, Cell.CELL_TYPE_STRING);
            cell3.setCellValue(arrList.get(i).getMenuItemName());
            Cell cell4 = row.createCell(4, Cell.CELL_TYPE_NUMERIC);
            cell4.setCellValue(arrList.get(i).getMenuItemPrice());
            Cell cell5 = row.createCell(5, Cell.CELL_TYPE_NUMERIC);
            cell5.setCellValue(arrList.get(i).getTotalAmount());
        }
     }
    
    public void createExcel() {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(fileName);
            wb.write(out);
        } catch (IOException ex) {
            Logger.getLogger(ExcelService.class.getName()).log(Level.SEVERE, null, ex);
        
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(ExcelService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        
    }
    
    public static void main(String[] args){
        ExcelService test = new ExcelService("D:\\report.xls");
        String[] col = {"Time", "Transaction Number", "Dine in", "Item Ordered", "Price", "Total Amount"};
        Sheet sheet = test.createSheet("test");
        test.setColumnName(col, sheet);
        ArrayList<TransactionData> arrList = null;
        try (SqlSession session = SessionFactory.getSqlSession().openSession()) {

            TransactionMapper mapper = session.getMapper(TransactionMapper.class);
            arrList = mapper.loadTransactionReport("2013-03-25");
        }
        test.setTransactionData(arrList, sheet);
        test.createExcel();
    }
}

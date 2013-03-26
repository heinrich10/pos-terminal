/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mapper;

import OMS.domain.MenuItem;
import OMS.domain.Transaction;
import OMS.domain.TransactionData;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Heinrich
 */
public interface TransactionMapper {
    
    void saveTransaction(Transaction transaction);
    
    void saveOrderList(long tranId, List<MenuItem> arrMenuItem);
    
    ArrayList<TransactionData> loadTransactionReport(String date);
    
}

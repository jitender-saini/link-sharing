package com.springTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Service
public class TransactionService {
    private JdbcTemplate jdbcTemplate;


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void recordTransaction(String receiver, String sender, long amount) {
        String query = "insert into account_transaction (receiver, sender,balance_transferred) values(?,?,?)";
        jdbcTemplate.update(query, new Object[]{receiver, sender, amount});
        System.out.println("record transaction done");
    }


    @Transactional(readOnly = true)
    public Transaction getTransaction(int transactionID) {
        return jdbcTemplate.queryForObject("select * from account_transaction where transactionID = ?", new Object[]{transactionID}, (rs, rowNum) -> {
            Transaction transaction = new Transaction();
            transaction.setTransactionId(rs.getInt("transactionID"));
            transaction.setSender(rs.getString("sender"));
            transaction.setReceiver(rs.getString("receiver"));
            transaction.setAmount(rs.getLong("balance_transferred"));
            transaction.setDateTime(rs.getTimestamp("transaction_time"));
            return transaction;
        });
    }
}

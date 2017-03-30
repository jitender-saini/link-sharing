package com.springTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

@Service
public class AccountServices {
    private JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager transactionManager;
    @Autowired
    TransactionService transactionService;

    @Autowired
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Transactional
    public void transferAmountDeclarativeTransaction(String receiver, String sender, long amount) {
        String sql = "Update userAccount set balance = balance + ? where username = ?";
        jdbcTemplate.update(sql, new Object[]{amount, receiver});
        String querySender = "update userAccount set balance = balance - ? where username = ?";
        jdbcTemplate.update(querySender, new Object[]{amount, sender});

        transactionService.recordTransaction(receiver,sender,amount);

        System.out.println("Amount Rs. "+amount+" transferred from "+sender+" successfully to "+receiver);
    }


    public void transferAmountProgrammaticTransaction(String receiver, String sender, long amount){
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
        try {
            String sql = "Update userAccount set balance = balance + ? where username = ?";
            jdbcTemplate.update(sql, new Object[]{amount, receiver});
            String querySender = "update userAccount set balance = balance - ? where username = ?";
            jdbcTemplate.update(querySender, new Object[]{amount, sender});
            transactionManager.commit(transactionStatus);
            System.out.println("Amount Rs. "+amount+" transferred from "+sender+" successfully to "+receiver);
        }catch (Exception e){
            transactionManager.rollback(transactionStatus);
            System.out.println("transaction failed");
        }
    }

    public void addUser(String name, int balance) {
        String addSql = "insert into userAccount(username,balance) values(?,?)";
        jdbcTemplate.update(addSql, new Object[]{name, balance});
        System.out.println("User account " + name+ " added successfully with balance: "+balance);
    }

    public void deleteUser(String name) {
        String delSql = "delete from userAccount where username = ?";
        jdbcTemplate.update(delSql, name);
        System.out.println("User "+name+"'s account removed.");
    }

    public void updateBalance(String name, int amount) {
        String update = "update userAccount set balance = balance + ? where username = ?";
        jdbcTemplate.update(update, new Object[]{amount, name});
        System.out.println("Balance updated");
    }

    @Transactional(readOnly = true)
    public UserAccount getUser(String name) {
        return jdbcTemplate.queryForObject("select * from userAccount WHERE username = ?",
                new Object[]{name}, (rs, rowNum) -> {           //new RowMapper<UserAccount>()
                    UserAccount userAccount = new UserAccount();
                    userAccount.setUsername(rs.getString("username"));
                    userAccount.setBalance(rs.getInt("balance"));
                    return userAccount;
                });
    }
}
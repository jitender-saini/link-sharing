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
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class AccountServices {

    private JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager transactionManager;
    @Autowired
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Transactional
    public void transferAmount(String receiver,String sender,long amount){

        String sql = "Update userAccount set balance = balance + ? where username = ?";
        jdbcTemplate.update(sql, new Object[]{amount, receiver});
       // int i = 1/0;
        String querySender = "update userAccount set balance = balance - ? where username = ?";
        jdbcTemplate.update(querySender, new Object[]{amount, sender});
        //int i = 1/0;
        System.out.println("success");
//        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
//        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
//        try {
//            String sql = "Update userAccount set balance = balance + ? where username = ?";
//            jdbcTemplate.update(sql, new Object[]{amount, receiver});
//            //int i =1/0;
//            String querySender = "update userAccount set balance = balance - ? where username = ?";
//            jdbcTemplate.update(querySender, new Object[]{amount, sender});
//            transactionManager.commit(transactionStatus);
//            System.out.println("transaction Success");
//        }catch (Exception e){
//            transactionManager.rollback(transactionStatus);
//            System.out.println("transaction failed");
//        }
    }

    public void getAccountStateOfUser(String username){

        jdbcTemplate.queryForObject("select * from userAccount where username = ?",
                new Object[]{username}. new RowMapper<UserAccount>() {
            @Override
                    public UserAccount mapRow(ResultSet resultSet, int i) throws SQLException{

            }

                })
    }

}

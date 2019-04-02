package com.ddc.common.demo.common.util.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class DataSourceTransactionManagerUtil {

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;


    public TransactionStatus newTransaction() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // 事物隔离级别，开启新事务，这样会比较安全些。
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        // 获得事务状态
        TransactionStatus status = dataSourceTransactionManager.getTransaction(def);
        return status;
    }

    /**
     * 提交事务
     *
     * @param status
     * @return 返回 是否回滚
     */
    public void commit(TransactionStatus status) {
        if (status != null)dataSourceTransactionManager.commit(status);
    }

    /**
     * 回滚事务
     *
     * @param
     * @param status
     */
    public void rollback(TransactionStatus status) {
        if (status != null)dataSourceTransactionManager.rollback(status);
    }
}

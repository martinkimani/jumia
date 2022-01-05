package com.jumia.test.config;

/**
 *
 * @author martin
 */
import java.sql.Types;
 
import org.hibernate.dialect.Dialect;
 
public class SQLDialect extends Dialect {
    public SQLDialect() {
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.VARCHAR, "varchar");
 
    }
 
    public boolean supportsIdentityColumns() {
        return true;
    }
 
    public boolean hasDataTypeInIdentityColumn() {
        return false; // As specify in NHibernate dialect
    }
 
    public String getIdentityColumnString() {
        // return "integer primary key autoincrement";
        return "integer";
    }
 
}

package org.durcframework.autocode.generator;


public interface SQLService {

    TableSelector getTableSelector(DataBaseConfig dataBaseConfig);

    ColumnSelector getColumnSelector(DataBaseConfig dataBaseConfig);

}

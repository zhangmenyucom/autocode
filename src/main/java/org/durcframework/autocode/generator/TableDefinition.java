package org.durcframework.autocode.generator;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * 数据库表定义,从这里可以获取表名,字段信息
 * @author Administrator
 */
@Data
public class TableDefinition {
    /** 表名**/
    private String tableName;
    /**字段定义**/
    private List<ColumnDefinition> columnDefinitions;

    public TableDefinition(String tableName) {
        this(tableName, Collections.<ColumnDefinition>emptyList());
    }

    public TableDefinition(String tableName, List<ColumnDefinition> columnDefinitions) {
        this.tableName = tableName;
        this.columnDefinitions = columnDefinitions;
    }

    public ColumnDefinition getPkColumn() {
        for (ColumnDefinition column : columnDefinitions) {
            if (column.getIsPk()) {
                return column;
            }
        }
        return null;
    }
}

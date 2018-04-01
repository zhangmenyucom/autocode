package org.durcframework.autocode.generator;

import lombok.Data;
import org.durcframework.autocode.util.FieldUtil;

import java.util.List;

/**
 * SQL上下文,这里可以取到表,字段信息<br>
 * 最终会把SQL上下文信息放到velocity中
 * @author Administrator
 */
@Data
public class SQLContext {
    /** 表结构定义**/
    private TableDefinition tableDefinition;
    /**包名**/
    private String packageName;

    public SQLContext(TableDefinition tableDefinition) {
        this.tableDefinition = tableDefinition;
        // 默认为全字母小写的类名
        this.packageName = getJavaBeanName().toLowerCase();
    }

    public String getJavaBeanName() {
        String tableName = getJavaBeanNameLF();
        return FieldUtil.upperFirstLetter(tableName);
    }

    /**
     * 返回Java类名且首字母小写
     *
     * @return
     */
    public String getJavaBeanNameLF() {
        String tableName = tableDefinition.getTableName();
        tableName = FieldUtil.underlineFilter(tableName);
        tableName = FieldUtil.dotFilter(tableName);
        return FieldUtil.lowerFirstLetter(tableName);
    }

    public String getPkName() {
        if (this.tableDefinition.getPkColumn() != null) {
            return this.tableDefinition.getPkColumn().getColumnName();
        }
        return "";
    }

    public String getJavaPkName() {
        if (this.tableDefinition.getPkColumn() != null) {
            return this.tableDefinition.getPkColumn().getJavaFieldName();
        }
        return "";
    }

    public String getJavaPkType() {
        if (this.tableDefinition.getPkColumn() != null) {
            return this.tableDefinition.getPkColumn().getJavaType();
        }
        return "";
    }

    public String getMybatisPkType() {
        if (this.tableDefinition.getPkColumn() != null) {
            return this.tableDefinition.getPkColumn().getMybatisJdbcType();
        }
        return "";
    }

}

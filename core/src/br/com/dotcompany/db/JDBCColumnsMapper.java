package br.com.dotcompany.db;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class JDBCColumnsMapper {

  private static final Map<Integer, ColumnType> MAP = new HashMap<Integer, ColumnType>();
  
  public static ColumnType get(int jdbcTypeId) {
    ColumnType type = MAP.get(jdbcTypeId);
    return type == null ? ColumnType.UNKNOW : type;
  }

  static {
    MAP.put(Types.BIT, ColumnType.BOOLEAN);
    MAP.put(Types.TINYINT, ColumnType.NUMERIC);
    MAP.put(Types.SMALLINT, ColumnType.NUMERIC);
    MAP.put(Types.INTEGER, ColumnType.NUMERIC);
    MAP.put(Types.BIGINT, ColumnType.NUMERIC);
    MAP.put(Types.FLOAT, ColumnType.NUMERIC);
    MAP.put(Types.REAL, ColumnType.NUMERIC);
    MAP.put(Types.DOUBLE, ColumnType.NUMERIC);
    MAP.put(Types.NUMERIC, ColumnType.NUMERIC);
    MAP.put(Types.DECIMAL, ColumnType.NUMERIC);
    MAP.put(Types.CHAR, ColumnType.STRING);
    MAP.put(Types.VARCHAR, ColumnType.STRING);
    MAP.put(Types.LONGVARCHAR, ColumnType.STRING);
    MAP.put(Types.DATE, ColumnType.DATE);
    MAP.put(Types.TIME, ColumnType.UNKNOW); //WE HAVE TO GO BACK HERE!
    MAP.put(Types.TIMESTAMP, ColumnType.DATE); //WE HAVE TO GO BACK HERE!
    MAP.put(Types.BINARY, ColumnType.UNKNOW); 
    MAP.put(Types.VARBINARY, ColumnType.UNKNOW);
    MAP.put(Types.LONGVARBINARY, ColumnType.UNKNOW); 
    MAP.put(Types.NULL, ColumnType.UNKNOW); //WE HAVE TO GO BACK HERE!
    MAP.put(Types.OTHER, ColumnType.UNKNOW); //WE HAVE TO GO BACK HERE!
    MAP.put(Types.JAVA_OBJECT, ColumnType.UNKNOW); //WE HAVE TO GO BACK HERE!
    MAP.put(Types.DISTINCT, ColumnType.UNKNOW); //WE HAVE TO GO BACK HERE!
    MAP.put(Types.STRUCT, ColumnType.UNKNOW); //WE HAVE TO GO BACK HERE!
    MAP.put(Types.ARRAY, ColumnType.UNKNOW); //WE HAVE TO GO BACK HERE!
    MAP.put(Types.BLOB, ColumnType.UNKNOW); 
    MAP.put(Types.BLOB, ColumnType.UNKNOW); 
    MAP.put(Types.REF, ColumnType.UNKNOW); //WE HAVE TO GO BACK HERE!
    MAP.put(Types.DATALINK, ColumnType.UNKNOW); //WE HAVE TO GO BACK HERE!
    MAP.put(Types.BOOLEAN, ColumnType.BOOLEAN);
    MAP.put(Types.ROWID, ColumnType.NUMERIC); 
    MAP.put(Types.NCHAR, ColumnType.STRING); 
    MAP.put(Types.NVARCHAR, ColumnType.STRING);
    MAP.put(Types.LONGNVARCHAR, ColumnType.STRING);
    MAP.put(Types.NCLOB, ColumnType.STRING);
    MAP.put(Types.SQLXML, ColumnType.UNKNOW); //WE HAVE TO GO BACK HERE!
  }
}
package com.potaliadmin.util.query;

import com.potaliadmin.constants.query.EnumJoinType;
import com.potaliadmin.constants.query.EnumQueryOperation;

/**
 * Created by Shakti Singh on 12/8/14.
 */
public class QueryBuilder {

  private StringBuilder sb = new StringBuilder();
  private String table;
  private String alias;
  private static final String FROM_CLAUSE = "from";
  private static final String WHERE_CLAUSE = "where";
  private static final String JOIN = "join";
  private static final String FETCH = "fetch";
  private static final String QUOTE = "'";
  private static final String AND = "and";
  private static final String AS = "as";


  public QueryBuilder(String tableName, String alias) {
    this.table = tableName;
    this.alias = alias;
  }

  public QueryBuilder buildFromClause() {
    String fromClause = FROM_CLAUSE + " " + table + " " + AS+ " " +alias + " ";
    sb.append(fromClause);
    return this;
  }

  public QueryBuilder buildJoinClause(String field,String alias, EnumJoinType joinType,boolean forceFetch) {
    String joinClause = " "+JOIN;
    if (joinType != null) {
      joinClause = " "+joinType.getToken() + " " + JOIN;
    }
    if (forceFetch) {
      joinClause = joinClause + " " + FETCH + " ";
    }
    joinClause = joinClause + field + " ";
    sb.append(joinClause);
    return this;
  }

  /*
  * TODO: write it in a more robust manner
  * it can handle complex where clause, use SPEL later
  * */
  public QueryBuilder buildWhereClause(String field, Object value, EnumQueryOperation operation) {
    String whereClause = " ";
    if (!sb.toString().contains(WHERE_CLAUSE)) {
      whereClause = whereClause + WHERE_CLAUSE+ " ";
    } else {
      whereClause = whereClause + AND + " ";
    }
    whereClause = whereClause + alias + "." + field + " ";
    sb.append(whereClause);
    switch (operation) {
      case EQUAL:
        sb.append(EnumQueryOperation.EQUAL.getToken());
        break;
      case IS_NOT_NULL:
        sb.append(EnumQueryOperation.IS_NOT_NULL.getToken());
        sb.append(" ");
        break;
      default:
        sb.append(EnumQueryOperation.EQUAL.getToken());
    }
    appendValue(value);
    return this;
  }

  private void appendValue(Object value) {
    if (value == null) {
      sb.append("null");
    } else if (value instanceof String) {
      sb.append(QUOTE);
      sb.append(value);
      sb.append(QUOTE);
    } else if (value instanceof Long) {
      sb.append(value);
    } else if (value instanceof Boolean) {
      if ((Boolean)value) {
        sb.append(1);
      } else {
        sb.append(0);
      }
    }
  }

  public String getQueryString() {
    return sb.toString();
  }
}

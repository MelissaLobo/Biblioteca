package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;


public class Main {
  public static void main(String[] args) throws Exception {
    Connection conn = getConnection();
    Statement st = conn
        .createStatement();

    st.executeUpdate("create table survey (id int,myDate DATE,myDateTime TIMESTAMP);");
    String INSERT_RECORD = "insert into survey(id, myDate,myDateTime) values(?, ?,?)";
    
    PreparedStatement pstmt = conn.prepareStatement(INSERT_RECORD);
    pstmt.setString(1, "1");
    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
    java.sql.Timestamp dataehora = new Timestamp(new java.util.Date().getTime());
    pstmt.setDate(2, sqlDate);
    pstmt.setTimestamp(3, dataehora);
    
    pstmt.executeUpdate();
    
    ResultSet rs = st.executeQuery("SELECT * FROM survey");

    rs.next();
    java.util.Date x = rs.getDate("MYDATE");
    System.out.println(x);
    
    Timestamp y = rs.getTimestamp("myDateTime");
    System.out.println(y);
    // outputResultSet(rs);

    rs.close();
    st.close();
    conn.close();
  }

  private static Connection getConnection() throws Exception {
    Class.forName("org.hsqldb.jdbcDriver");
    String url = "jdbc:hsqldb:mem:data/tutorial";

    return DriverManager.getConnection(url, "sa", "");
  }
}
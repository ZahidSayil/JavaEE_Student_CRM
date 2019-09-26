package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EMPUtil {
	private static DataSource dataSource;
	public EMPUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public static void main(String[] args) {
		
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet rs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			myStmt=myConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from emp where salary>2000";
			 rs = myStmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString(0)+ ":" + rs.getString(1));
			}		
		}
		catch(Exception e ){e.printStackTrace();}
	}
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
















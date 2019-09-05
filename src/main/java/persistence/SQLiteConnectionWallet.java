/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Carlos Miranda Rocha
 */
public class SQLiteConnectionWallet {
    private static Connection con;
    private static boolean hasData = false;
    public SQLiteConnectionWallet(){
    
    }
    private void getConnection() throws ClassNotFoundException, SQLException {
		  // sqlite driver
		  Class.forName("org.sqlite.JDBC");
		  // database path, if it's new database, it will be created in the project folder
		  con = DriverManager.getConnection("jdbc:sqlite:SQLiteWallet.db");
		  initialise();
    }
    private void initialise() throws SQLException {
		 if( !hasData ) {
			 hasData = true;
			 // check for database table
			 Statement state = con.createStatement();
			 ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='wallet'");
			 if( !res.next()) {
				 System.out.println("CONSTRUYENDO BASE DE DATOS.");
				 // need to build the table
				  Statement state2 = con.createStatement();
				  state2.executeUpdate("create table wallet(saldo DOUBLE);");
				  // inserting some sample data
				  PreparedStatement prep = con.prepareStatement("insert into wallet values(0);");
				  prep.execute();
			 }
			 
		 }
    }
    public String getBalance() throws SQLException, ClassNotFoundException {
		 if(con == null) {
                    getConnection();
		 }
		 Statement state = con.createStatement();
		 ResultSet res = state.executeQuery("select * from wallet");
                 return res.getString("saldo");
    }
    public String cashOut(double monto) throws SQLException, ClassNotFoundException{
                 if(con == null) {
                    getConnection();
		 }
		 Statement state = con.createStatement();
		 state.executeQuery("UPDATE wallet SET saldo = saldo -" + monto);
                 return getBalance();
    }
}

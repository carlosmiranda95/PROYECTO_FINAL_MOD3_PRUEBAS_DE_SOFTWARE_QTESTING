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
    public boolean getConnection() throws ClassNotFoundException, SQLException {
		 try{
                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:SQLiteWallet.db");
                    initialise();
                    return true;
                  }catch(ClassNotFoundException | SQLException e){
                      return false;
                  }
    }
    public boolean initialise() throws SQLException {
		 if( !hasData ) {
			 hasData = true;
			 Statement state = con.createStatement();
			 ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='wallet'");
			 if(!res.next()) {
				 System.out.println("CONSTRUYENDO BASE DE DATOS.");
				  Statement state2 = con.createStatement();
				  state2.executeUpdate("create table wallet(saldo DOUBLE);");
				  PreparedStatement prep = con.prepareStatement("insert into wallet values(0);");
				  prep.execute();
                                  return true;
			 }else{
                             return false;
                         }
		 }
    }
  
    public String getBalance() throws SQLException, ClassNotFoundException {
                 if(con == null) {
			 getConnection();
		 }
		 Statement state = con.createStatement();
		 ResultSet res = state.executeQuery("select * from wallet");
                 String stres = res.getString("saldo");
                 //con.close();
                 return stres;
    }
    public String cashOut(double monto) throws SQLException, ClassNotFoundException{
                 if(con == null) {
			 getConnection();
		 }
		 
                 String sql = "UPDATE wallet SET saldo = saldo - " + monto;
                 PreparedStatement state = con.prepareStatement(sql);
		 state.execute();
                 //con.close();
                 return getBalance();
    }
    public String cashIn(double monto) throws SQLException, ClassNotFoundException{
                 if(con == null) {
			 getConnection();
		 }
                 String sql = "UPDATE wallet SET saldo = saldo + " + monto;
		 PreparedStatement state = con.prepareStatement(sql);
		 state.execute();
                 //con.close();
                 return getBalance();
    }
}

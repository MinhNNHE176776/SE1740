/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author AD
 */
public class AccountDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Account> getListAccount() {
	try {
		String query = "SELECT * FROM Account";
		conn = new DBContext().getConnection();
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		List<Account> list = new ArrayList<>();
		while(rs.next()) {
                    Account a = new Account(rs.getString(1), rs.getString(2));
                    list.add(a);
            }
            return list;

        } catch (Exception e){
    }
    return null; 
    } 
}


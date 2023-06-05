/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import java.util.List;
import model.Account;
/**
 *
 * @author AD
 */
public class Main {
    public static void main(String[] args) {
        AccountDAO accountDAO  = new AccountDAO();
        List<Account> list = accountDAO.getListAccount();
        for (Account a :list) {
            System.out.println("name: " + a.getUsername() + "password: " + a.getPassword());
        }    
    }
    
}

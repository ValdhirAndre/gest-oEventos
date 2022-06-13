/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacadastramentoeavaliacaodeeventos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Fortunato José
 */
public class ConexaBD {
    
    public static Connection ligar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/gestao_de_eventos", "root", "");
        } 
        catch(ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
        return null;
    }
    
}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public Connection connectDB(){
        Connection conn = null;
        Properties props = new Properties();
        try {
            // 1. Lê o arquivo de texto que está invisível para o GitHub
            FileInputStream file = new FileInputStream("db.properties.txt");
            props.load(file);
            
            // 2. Guarda a senha lida na variável
            String senhaOculta = props.getProperty("password");
            
            // 3. Conecta no banco usando a variável em vez da senha digitada
            conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11?user=root&password=" + senhaOculta + "&useSSL=false");
            
        } catch (SQLException | IOException erro) {
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO: " + erro.getMessage());
        }
        return conn;
    }
    
}

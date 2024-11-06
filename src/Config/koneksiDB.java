package Config;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class koneksiDB {

    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) { // Memastikan koneksi hanya dibuat sekali
            try {
                // Menentukan driver DB
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // URL, user, dan password untuk koneksi database
                String url = "jdbc:mysql://localhost:3308/pv_biodata";
                String user = "root";
                String password = "";

                // Membuat koneksi ke database
                conn = DriverManager.getConnection(url, user, password);
                
                // Pesan jika koneksi berhasil
                JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage());
            }
        }
        return conn;
    }
}

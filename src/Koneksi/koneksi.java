package Koneksi;

import java.sql.*;

public class koneksi {
    private Connection koneksi;

    public Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Berhasil load driver");
        }catch(ClassNotFoundException ex){
            System.out.println("Gagal load driver "+ex);
        }

        String url = "jdbc:mysql://localhost:3306/karyatirtamandiri?useSSL=false&serverTimezone=Asia/Jakarta";

        try{
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("Berhasil koneksi database");
        }catch (SQLException ex){
            System.out.println("Gagal koneksi database "+ex);
        }
        return koneksi;
    }

    public static void main(String[] args){
        koneksi k = new koneksi();
        k.connect();
    }
}
package Classes;

import java.sql.*;
import java.util.ArrayList;

public class Prieteni {
    private static int contorIdPrietenie = 1;
    private int idPrietenie;
    private String numeUtilizator1;
    private String numeUtilizator2;

    public Prieteni(String numeUtilizator1, String numeUtilizator2) {
        this.idPrietenie = contorIdPrietenie ++;
        this.numeUtilizator1 = numeUtilizator1;
        this.numeUtilizator2 = numeUtilizator2;
    }

    public Prieteni() {
        this.idPrietenie = -1;
        this.numeUtilizator1 = "-1";
        this.numeUtilizator2 = "-1";
    }

    public int getIdPrietenie() {
        return idPrietenie;
    }

    public void setIdPrietenie(int idPrietenie) {
        this.idPrietenie = idPrietenie;
    }

    public String getNumeUtilizator1() {
        return numeUtilizator1;
    }

    public void setNumeUtilizator1(String numeUtilizator1) {
        this.numeUtilizator1 = numeUtilizator1;
    }

    public String getNumeUtilizator2() {
        return numeUtilizator2;
    }

    public void setNumeUtilizator2(String numeUtilizator2) {
        this.numeUtilizator2 = numeUtilizator2;
    }

    public void insertTable(){
        try{
            String sql = "INSERT INTO prieteni VALUES (" +
                    this.idPrietenie + ",'" + this.numeUtilizator1 + "','" + this.numeUtilizator2 + "')";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proiect_carti","root","");
            Statement statement=con.createStatement();
            statement.execute(sql);
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static ArrayList<Prieteni> selectUrmarii(String user){
        ArrayList<Prieteni> prieteni = new ArrayList<Prieteni>();
        try{
            String sql = "SELECT * FROM prieteni WHERE utilizator_1 =" + "'" + user + "'";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proiect_carti","root","");
            Statement statement=con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Prieteni selected = new Prieteni();
                selected.setIdPrietenie(rs.getInt("ID_PRIETENIE"));
                selected.setNumeUtilizator1(rs.getString("UTILIZATOR_1"));
                selected.setNumeUtilizator2(rs.getString("UTILIZATOR_2"));
                prieteni.add(selected);
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return prieteni;
    }

    public static ArrayList<Prieteni> selectUrmaritori(String user){
        ArrayList<Prieteni> prieteni = new ArrayList<Prieteni>();
        try{
            String sql = "SELECT * FROM prieteni WHERE utilizator_2 =" + "'" + user + "'";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proiect_carti","root","");
            Statement statement=con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Prieteni selected = new Prieteni();
                selected.setIdPrietenie(rs.getInt("ID_PRIETENIE"));
                selected.setNumeUtilizator1(rs.getString("UTILIZATOR_1"));
                selected.setNumeUtilizator2(rs.getString("UTILIZATOR_2"));
                prieteni.add(selected);
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return prieteni;
    }

    public static void deleteEntry(int idPrietenie){
        try{
            String sql = "DELETE FROM prieteni WHERE ID_PRIETENIE = " + idPrietenie;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proiect_carti","root","");
            Statement statement=con.createStatement();
            statement.executeUpdate(sql);
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "Prieteni{" +
                "idPrietenie=" + idPrietenie +
                ", numeUtilizator1='" + numeUtilizator1 + '\'' +
                ", numeUtilizator2='" + numeUtilizator2 + '\'' +
                '}';
    }
}

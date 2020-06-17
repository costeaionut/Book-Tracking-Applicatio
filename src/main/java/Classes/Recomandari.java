package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Recomandari {
    private static int contorIdRecomandare = 1;
    private int idRecomandare;
    private int idCarte;
    private String numeUtilizatorCareRecomanda;
    private String numeUtilizatorCarePrimesteRecomandare;

    public Recomandari(int idCarte, String numeUtilizatorCareRecomanda, String numeUtilizatorCarePrimesteRecomandare) {
        this.idRecomandare = contorIdRecomandare++;
        this.idCarte = idCarte;
        this.numeUtilizatorCareRecomanda = numeUtilizatorCareRecomanda;
        this.numeUtilizatorCarePrimesteRecomandare = numeUtilizatorCarePrimesteRecomandare;
    }

    public Recomandari() {
        this.idRecomandare = -1;
        this.idCarte = -1;
        this.numeUtilizatorCareRecomanda = "-1";
        this.numeUtilizatorCarePrimesteRecomandare = "-1";
    }

    public int getIdRecomandare() {
        return idRecomandare;
    }

    public void setIdRecomandare(int idRecenzie) {
        this.idRecomandare = idRecenzie;
    }

    public int getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(int idCarte) {
        this.idCarte = idCarte;
    }

    public String getNumeUtilizatorCareRecomanda() {
        return numeUtilizatorCareRecomanda;
    }

    public void setNumeUtilizatorCareRecomanda(String numeUtilizatorCareRecomanda) {
        this.numeUtilizatorCareRecomanda = numeUtilizatorCareRecomanda;
    }

    public String getNumeUtilizatorCarePrimesteRecomandare() {
        return numeUtilizatorCarePrimesteRecomandare;
    }

    public void setNumeUtilizatorCarePrimesteRecomandare(String numeUtilizatorCarePrimesteRecomandare) {
        this.numeUtilizatorCarePrimesteRecomandare = numeUtilizatorCarePrimesteRecomandare;
    }

    public void insertTable(){
        try{
            String sql = "INSERT INTO recomandari VALUES (" +
                    this.idRecomandare + "," + this.idCarte + ",'" + this.numeUtilizatorCareRecomanda + "','" +
                    this.numeUtilizatorCarePrimesteRecomandare + "')";
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

    public static Recomandari selectEntry(int idRecomandareDeSelectat){
        Recomandari selected = new Recomandari();
        try{
            String sql = "SELECT * FROM recomandari WHERE ID_RECOMANDARE =" + idRecomandareDeSelectat;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proiect_carti","root","");
            Statement statement=con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                selected.setIdRecomandare(rs.getInt("ID_RECOMANDARE"));
                selected.setIdCarte(rs.getInt("ID_CARTE"));
                selected.setNumeUtilizatorCareRecomanda(rs.getString("UTILIZATOR_1"));
                selected.setNumeUtilizatorCarePrimesteRecomandare(rs.getString("UTILIZATOR_2"));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return selected;
    }

    public static void deleteEntry(int idRecomandareDeSters){
        try{
            String sql = "DELETE FROM recomandari WHERE ID_RECOMANDARE = " + idRecomandareDeSters;
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
        return "Recomandare{" +
                "idRecenzie=" + idRecomandare +
                ", idCarte=" + idCarte +
                ", numeUtilizatorCareRecomanda='" + numeUtilizatorCareRecomanda + '\'' +
                ", numeUtilizatorCarePrimesteRecomandare='" + numeUtilizatorCarePrimesteRecomandare + '\'' +
                '}';
    }
}

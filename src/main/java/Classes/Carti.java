package Classes;

import java.sql.*;
import java.util.ArrayList;

public class Carti {
    private static int contorIdCarti = 1;
    private int idCarte;
    private String titlu;
    private String autor;
    private int nrPagini;
    private float nota;


    public Carti() {
        this.idCarte = -1;
        this.titlu = "-1";
        this.autor = "-1";
        this.nrPagini = -1;
        this.nota = -1;
    }

    @Override
    public String toString() {
        return "Carti{" +
                "idCarte=" + idCarte +
                ", titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", nrPagini=" + nrPagini +
                ", nota=" + nota +
                '}';
    }

    public Carti(String titlu, String autor, int nrPagini, float nota) {
        this.idCarte = contorIdCarti++;
        this.titlu = titlu;
        this.autor = autor;
        this.nrPagini = nrPagini;
        this.nota = nota;
    }

    public int getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(int idCarte) {
        this.idCarte = idCarte;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNrPagini() {
        return nrPagini;
    }

    public void setNrPagini(int nrPagini) {
        this.nrPagini = nrPagini;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public void insertTable(){
        try{
            String sql = "INSERT INTO carti (id_carte, titlu, autor, nr_pagini, nota) VALUES (" +
                    this.idCarte + ",'" + this.titlu + "','" + this.autor + "'," +
                    this.nrPagini + "," + this.nota + ")";
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

    public static Carti selectEntryByID(int idCarteDeSelectat){
        Carti selected = new Carti();
        try{
            String sql = "SELECT * FROM carti WHERE ID_CARTE =" + idCarteDeSelectat;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proiect_carti","root","");
            Statement statement=con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                selected.setIdCarte(rs.getInt("ID_CARTE"));
                selected.setTitlu(rs.getString("TITLU"));
                selected.setAutor(rs.getString("AUTOR"));
                selected.setNrPagini(rs.getInt("NR_PAGINI"));
                selected.setNota(rs.getFloat("NOTA"));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return selected;
    }

    public static Carti selectEntryByTitle(String titlu){
        Carti selected = new Carti();
        try{
            String sql = "SELECT * FROM carti WHERE titlu =" + "'" +titlu + "'";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proiect_carti","root","");
            Statement statement=con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                selected.setIdCarte(rs.getInt("ID_CARTE"));
                selected.setTitlu(rs.getString("TITLU"));
                selected.setAutor(rs.getString("AUTOR"));
                selected.setNrPagini(rs.getInt("NR_PAGINI"));
                selected.setNota(rs.getFloat("NOTA"));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return selected;
    }

    public static ArrayList<Carti> selectAllEntries(){
        ArrayList<Carti> carti = new ArrayList<Carti>();
        try{
            String sql = "SELECT * FROM carti";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proiect_carti","root","");
            Statement statement=con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Carti selected = new Carti();
                selected.setIdCarte(rs.getInt("ID_CARTE"));
                selected.setTitlu(rs.getString("TITLU"));
                selected.setAutor(rs.getString("AUTOR"));
                selected.setNrPagini(rs.getInt("NR_PAGINI"));
                selected.setNota(rs.getFloat("NOTA"));
                carti.add(selected);
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return carti;
    }

    public static void deleteEntry(int idCarteDeSters){
        try{
            String sql = "DELETE FROM carti WHERE ID_CARTE = " + idCarteDeSters;
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

}

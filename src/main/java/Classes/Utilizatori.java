package Classes;

import java.sql.*;

public class Utilizatori {
    private String numeUtilizator;
    private String nume;
    private String prenume;
    private String parola;
    private int rol; //Admin - 1 ---> User normal 0
    private String email;

    public Utilizatori() {
        this.numeUtilizator = "-1";
        this.nume = "-1";
        this.prenume = "-1";
        this.parola = "-1";
        this.rol = 0;
        this.email = "-1";
    }

    public Utilizatori(String numeUtilizator, String nume, String prenume, String parola, String email) {
        this.numeUtilizator = numeUtilizator;
        this.nume = nume;
        this.prenume = prenume;
        this.parola = parola;
        this.rol = 0;
        this.email = email;
    }

    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    public void setNumeUtilizator(String numeUtilizator) {
        this.numeUtilizator = numeUtilizator;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int isRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void insertTable(){
        try{
            String sql = "INSERT INTO utilizatori VALUES ('" +
                    this.numeUtilizator + "','" + this.parola + "','" + this.nume + "','" +
                    this.prenume + "','" + this.email + "'," + this.rol + ")";
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

    public static Utilizatori selectEntry(String utilizatorDeSelectat){
        Utilizatori selected = new Utilizatori();
        try{
            String sql = "SELECT * FROM utilizatori WHERE nume_utilizator = " + "'" + utilizatorDeSelectat + "'";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proiect_carti","root","");
            Statement statement=con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                selected.setNumeUtilizator(rs.getString("NUME_UTILIZATOR"));
                selected.setParola(rs.getString("PAROLA"));
                selected.setNume(rs.getString("NUME"));
                selected.setPrenume(rs.getString("PRENUME"));
                selected.setEmail(rs.getString("EMAIL"));
                selected.setRol(rs.getInt("ROL"));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return selected;
    }

    public static void deleteEntry(String utilizatorDeSters){
        try{
            String sql = "DELETE FROM utilizatori WHERE nume_utilizator = " + "'" + utilizatorDeSters + "'";
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

    ///Clasa conectare la baza de date sa fie o singura conexiune (ex:Singletone)


    @Override
    public String toString() {
        return "Utilizatori{" +
                "numeUtilizator='" + numeUtilizator + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", parola='" + parola + '\'' +
                ", rol=" + rol +
                ", email='" + email + '\'' +
                '}';
    }
}

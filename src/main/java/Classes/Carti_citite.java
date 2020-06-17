package Classes;

import java.sql.*;
import java.util.ArrayList;

public class Carti_citite {//Uneste
    private int idCarteCitita;
    private String numeUtilizator;
    private int progres;
    private String recenzie;
    private float nota;
    private String dataInceput; ///Formatu pentru data e 'YYYY-MM-DD'
    private String dataSfarsit; ///Formatu pentru data e 'YYYY-MM-DD'

    public Carti_citite() {
        this.idCarteCitita = -1;
        this.numeUtilizator = "-1";
        this.progres = -1;
        this.recenzie = "-1";
        this.nota = -1;
        this.dataInceput = "-1";
        this.dataSfarsit = "-1";
    }

    public Carti_citite(int idCarteCitita, String numeUtilizator, int progres, String recenzie, float nota, String dataInceput, String dataSfarsit) {
        this.idCarteCitita = idCarteCitita;
        this.numeUtilizator = numeUtilizator;
        this.progres = progres;
        this.recenzie = recenzie;
        this.nota = nota;
        this.dataInceput = dataInceput;
        this.dataSfarsit = dataSfarsit;
    }

    public int getIdCarteCitita() {
        return idCarteCitita;
    }

    public void setIdCarteCitita(int idCarteCitita) {
        this.idCarteCitita = idCarteCitita;
    }

    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    public void setNumeUtilizator(String numeUtilizator) {
        this.numeUtilizator = numeUtilizator;
    }

    public int getProgres() {
        return progres;
    }

    public void setProgres(int progres) {
        this.progres = progres;
    }

    public String getRecenzie() {
        return recenzie;
    }

    public void setRecenzie(String recenzie) {
        this.recenzie = recenzie;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getDataInceput() {
        return dataInceput;
    }

    public void setDataInceput(String dataInceput) {
        this.dataInceput = dataInceput;
    }

    public String getDataSfarsit() {
        return dataSfarsit;
    }

    public void setDataSfarsit(String dataSfarsit) {
        this.dataSfarsit = dataSfarsit;
    }

    public void insertTable(){
        try{
            String sql = "INSERT INTO carti_citite VALUES (" + this.idCarteCitita + ",'"
                    + this.numeUtilizator + "'," + this.progres + ",'" + this.dataInceput + "','" + this.dataSfarsit + "','"
                    + this.recenzie + "',"+ this.nota +")";
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

    public static ArrayList<Carti_citite> selectEntry(String UtilizatorDeSelectat){
        ArrayList<Carti_citite> _carti_citite = new ArrayList<Carti_citite>();
        try{
            String sql = "SELECT * FROM carti_citite WHERE nume_utilizator = " + "'" + UtilizatorDeSelectat + "'";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proiect_carti","root","");
            Statement statement=con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Carti_citite selected = new Carti_citite();
                selected.setIdCarteCitita(rs.getInt("ID_CARTE"));
                selected.setNumeUtilizator(rs.getString("NUME_UTILIZATOR"));
                selected.setProgres(rs.getInt("PROGRES"));
                selected.setDataInceput(rs.getString("DATA_INCEPUT"));
                selected.setDataSfarsit(rs.getString("DATA_SFARSIT"));
                selected.setRecenzie(rs.getString("Recenzie"));
                selected.setNota(rs.getFloat("Nota"));
                _carti_citite.add(selected);
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return _carti_citite;
    }

    public static Carti_citite selectEntry(int idCarteCitita, String UtilizatorDeSelectat){
        Carti_citite selected = new Carti_citite();
        try{
            String sql = "SELECT * FROM carti_citite WHERE nume_utilizator = " + "'" + UtilizatorDeSelectat + "'"
                    + "and id_carte = " + idCarteCitita;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proiect_carti","root","");
            Statement statement=con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                selected.setIdCarteCitita(rs.getInt("ID_CARTE"));
                selected.setNumeUtilizator(rs.getString("NUME_UTILIZATOR"));
                selected.setProgres(rs.getInt("PROGRES"));
                selected.setDataInceput(rs.getString("DATA_INCEPUT"));
                selected.setDataSfarsit(rs.getString("DATA_SFARSIT"));
                selected.setRecenzie(rs.getString("Recenzie"));
                selected.setNota(rs.getFloat("Nota"));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return selected;
    }

    public static void deleteEntry(int idCititeDeSters, String numeUtilizator){
        try{
            String sql = "DELETE FROM CARTI_CITITE WHERE ID_CARTE= " + idCititeDeSters + " AND NUME_UTILIZATOR = '" + numeUtilizator + "'";
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
        return "Carti_citite{" +
                "idCarteCitita=" + idCarteCitita +
                ", numeUtilizator='" + numeUtilizator + '\'' +
                ", progres=" + progres +
                ", recenzie='" + recenzie + '\'' +
                ", nota=" + nota +
                ", dataInceput='" + dataInceput + '\'' +
                ", dataSfarsit='" + dataSfarsit + '\'' +
                '}';
    }
}


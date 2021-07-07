package com.example.tpbd;

public class Etudiant {
    int id ;
    String name;
    String adresse ;

    public Etudiant (int idE , String nameE , String adresseE ){
        this.id = idE ;
        this.name = nameE ;
        this.adresse = adresseE;
    }

    public Etudiant (String nameE , String adresseE ){

        this.name = nameE ;
        this.adresse = adresseE;
    }

    public Etudiant() {}


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}

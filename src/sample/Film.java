package sample;

import javafx.scene.control.TextField;

public class Film {

    //Na początek, jako obiekty: film (nazwa, opis, czas trwania w minutach, limit wiekowy, dla chętnych - obrazek z ilustracją),
    // sala (number, liczba miejsc, typ sali). Trzeba zrobić jakąś formatkę pozwalającą na dodawanie filmów oraz sal.
    // Docelowo także edycja / usuwanie.

    public String nazwa;
    public String opis;
    public String czas;
    public String limit;
    //public cośtam obrazek;

    public String getNazwa() {

        return nazwa;
    }

    public void setNazwa(String nazwa) {

        this.nazwa = nazwa;
    }

    public String getOpis() {

        return opis;
    }

    public void setOpis(String opis) {

        this.opis = opis;
    }

    public String getCzas() {

        return czas;
    }

    public void setCzas(String czas) {

        this.czas = czas;
    }

    public String getLimit() {

        return limit;
    }

    public void setLimit(String limit) {

        this.limit = limit;
    }

    //public costam getObrazek() {
    //    return obrazek;
    //}
}

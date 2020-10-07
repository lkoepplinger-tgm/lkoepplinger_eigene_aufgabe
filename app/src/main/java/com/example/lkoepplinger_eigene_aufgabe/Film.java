package com.example.lkoepplinger_eigene_aufgabe;

public class Film {
    private String filmName;
    private String iconName;
    private int anfang;
    private String mainAntagonist;

    public Film(String filmName, String iconName, int anfang, String mainAntagonist) {
        this.filmName = filmName;
        this.iconName = iconName;
        this.anfang = anfang;
        this.mainAntagonist = mainAntagonist;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public void setAnfang(int anfang) {
        this.anfang = anfang;
    }

    public void setMainAntagonist(String mainAntagonist) {
        this.mainAntagonist = mainAntagonist;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getIconName() {
        return iconName;
    }

    public int getAnfang() {
        return anfang;
    }

    public String getMainAntagonist() {
        return this.mainAntagonist;
    }

    @Override
    public String toString()  {
        return this.filmName + " (Erster Film erschien in: " + this.anfang + ", Main Antagonist: " + this.mainAntagonist + ")";
    }
}

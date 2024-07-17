package com.ligabetplay.city.domain.entity;

public class City {
    private String id;
    private String nombre;
    private int idRegion;


    public City(){

    }

    public City(String id, String nombre, int idRegion){
        this.id= id;
        this.nombre = nombre;
        this.idRegion = idRegion;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getIdRegion() {
        return idRegion;
    }


    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    

}

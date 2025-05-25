package com.techlab.productos;

public class Perfume extends Producto {
    private String genero;

    public Perfume(String nombre, String marca, double precio, int stock, String genero) {
        super(nombre, marca, precio, stock);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return super.toString() + " - Género: " + genero;
    }
}
package com.techlab.productos;

public class Cosmetico extends Producto {
    private String tipoDePiel;

    public Cosmetico(String nombre, String marca, double precio, int stock, String tipoDePiel) {
        super(nombre, marca, precio, stock);
        this.tipoDePiel = tipoDePiel;
    }

    public String getTipoDePiel() {
        return tipoDePiel;
    }

    public void setTipoDePiel(String tipoDePiel) {
        this.tipoDePiel = tipoDePiel;
    }

    @Override
    public String toString() {
        return super.toString() + " - Tipo de piel: " + tipoDePiel;
    }
}
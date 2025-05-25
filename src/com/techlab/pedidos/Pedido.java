package com.techlab.pedidos;

import java.util.List;

public class Pedido {
    private int id;
    private List<LineaPedido> lineas;

    public Pedido(int id, List<LineaPedido> lineas) {
        this.id = id;
        this.lineas = lineas;
    }

    public int getId() {
        return id;
    }

    public List<LineaPedido> getLineas() {
        return lineas;
    }

    public double calcularTotal() {
        double total = 0;
        for (LineaPedido lp : lineas) {
            total += lp.calcularSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido ID: ").append(id).append("\n");
        for (LineaPedido lp : lineas) {
            sb.append("  ").append(lp).append("\n");
        }
        sb.append("Total: $").append(calcularTotal());
        return sb.toString();
    }
}
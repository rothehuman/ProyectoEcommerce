package com.techlab.productos;

import com.techlab.utils.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductoService {
    private final List<Producto> productos = new ArrayList<>();
    private static int contadorId = 1;
    private final Scanner scanner = new Scanner(System.in);

    public void agregarProducto() {
        System.out.println("Seleccione el tipo de producto:");
        System.out.println("1) Cosmético");
        System.out.println("2) Perfume");

        int tipo = InputUtils.leerEntero("Ingrese una opción: ", 1, 2);

        String nombre = InputUtils.leerTexto("Nombre del producto: ");
        String marca = InputUtils.leerTexto("Marca: ");
        double precio = InputUtils.leerDouble("Precio: ", 0.01);
        int stock = InputUtils.leerEntero("Stock: ", 0, Integer.MAX_VALUE);

        Producto producto;

        if (tipo == 1) {
            System.out.println("Tipo de piel:");
            System.out.println("1) Seca");
            System.out.println("2) Grasa");
            System.out.println("3) Mixta");
            int tipoPiel = InputUtils.leerEntero("Seleccione opción: ", 1, 3);
            String tipoPielStr = switch (tipoPiel) {
                case 1 -> "Seca";
                case 2 -> "Grasa";
                case 3 -> "Mixta";
                default -> "Desconocido";
            };
            producto = new Cosmetico(nombre, marca, precio, stock, tipoPielStr);
        } else {
            System.out.println("Género:");
            System.out.println("1) Masculino");
            System.out.println("2) Femenino");
            System.out.println("3) Unisex");
            int genero = InputUtils.leerEntero("Seleccione opción: ", 1, 3);
            String generoStr = switch (genero) {
                case 1 -> "Masculino";
                case 2 -> "Femenino";
                case 3 -> "Unisex";
                default -> "Desconocido";
            };
            producto = new Perfume(nombre, marca, precio, stock, generoStr);
        }

        productos.add(producto);
        System.out.println("Producto agregado con éxito.");
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("=== Lista de Productos ===");
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    public void buscarYActualizarProducto() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para buscar.");
            return;
        }

        System.out.println("Buscar producto por:");
        System.out.println("1) ID");
        System.out.println("2) Nombre");
        int opcion = InputUtils.leerEntero("Seleccione opción: ", 1, 2);

        Producto encontrado = null;

        if (opcion == 1) {
            int id = InputUtils.leerEntero("Ingrese ID del producto: ", 1, Integer.MAX_VALUE);
            for (Producto p : productos) {
                if (p.getId() == id) {
                    encontrado = p;
                    break;
                }
            }
        } else {
            String nombre = InputUtils.leerTexto("Ingrese nombre del producto: ").toLowerCase();
            for (Producto p : productos) {
                if (p.getNombre().toLowerCase().contains(nombre)) {
                    encontrado = p;
                    break;
                }
            }
        }

        if (encontrado == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("Producto encontrado:");
        System.out.println(encontrado);

        System.out.println("¿Desea actualizar?");
        System.out.println("1) Precio");
        System.out.println("2) Stock");
        System.out.println("3) Ambos");
        System.out.println("4) Cancelar");
        int act = InputUtils.leerEntero("Seleccione opción: ", 1, 4);

        if (act == 1 || act == 3) {
            double nuevoPrecio = InputUtils.leerDouble("Nuevo precio: ", 0.01);
            encontrado.setPrecio(nuevoPrecio);
        }

        if (act == 2 || act == 3) {
            int nuevoStock = InputUtils.leerEntero("Nuevo stock: ", 0, Integer.MAX_VALUE);
            encontrado.setStock(nuevoStock);
        }

        if (act != 4) {
            System.out.println("Producto actualizado.");
        }
    }

    public void eliminarProducto() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para eliminar.");
            return;
        }

        int id = InputUtils.leerEntero("Ingrese ID del producto a eliminar: ", 1, Integer.MAX_VALUE);
        Producto aEliminar = null;

        for (Producto p : productos) {
            if (p.getId() == id) {
                aEliminar = p;
                break;
            }
        }

        if (aEliminar == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("Producto encontrado:");
        System.out.println(aEliminar);

        System.out.print("¿Está seguro que desea eliminar este producto? (s/n): ");
        String confirmacion = scanner.nextLine().trim().toLowerCase();

        if (confirmacion.equals("s")) {
            productos.remove(aEliminar);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
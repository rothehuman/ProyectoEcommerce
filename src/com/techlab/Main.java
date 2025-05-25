package com.techlab;

import com.techlab.pedidos.PedidoService;
import com.techlab.productos.ProductoService;
import com.techlab.utils.InputUtils;

public class Main {
    public static void main(String[] args) {
        ProductoService productoService = new ProductoService();
        PedidoService pedidoService = new PedidoService(productoService);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n========== SISTEMA DE GESTIÓN - OPAL BEAUTY ==========");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar/Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear un pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("7) Salir");

            int opcion = InputUtils.leerEntero("Seleccione una opción: ", 1, 7);

            switch (opcion) {
                case 1 -> productoService.agregarProducto();
                case 2 -> productoService.listarProductos();
                case 3 -> productoService.buscarYActualizarProducto();
                case 4 -> productoService.eliminarProducto();
                case 5 -> pedidoService.crearPedido();
                case 6 -> pedidoService.listarPedidos();
                case 7 -> {
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema Opal Beauty!");
                }
            }
        }
    }
}
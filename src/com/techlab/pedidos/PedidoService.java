package com.techlab.pedidos;

import com.techlab.productos.Producto;
import com.techlab.productos.ProductoService;
import com.techlab.utils.InputUtils;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private final List<Pedido> pedidos = new ArrayList<>();
    private static int contadorPedido = 1;
    private final ProductoService productoService;

    public PedidoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void crearPedido() {
        List<Producto> productosDisponibles = productoService.getProductos();
        if (productosDisponibles.isEmpty()) {
            System.out.println("No hay productos disponibles para crear un pedido.");
            return;
        }

        List<LineaPedido> lineas = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            productoService.listarProductos();
            int id = InputUtils.leerEntero("Ingrese ID del producto que desea agregar: ", 1, Integer.MAX_VALUE);

            Producto seleccionado = null;
            for (Producto p : productosDisponibles) {
                if (p.getId() == id) {
                    seleccionado = p;
                    break;
                }
            }

            if (seleccionado == null) {
                System.out.println("ID inválido.");
                continue;
            }

            int cantidad = InputUtils.leerEntero("Ingrese cantidad: ", 1, seleccionado.getStock());

            lineas.add(new LineaPedido(seleccionado, cantidad));
            seleccionado.setStock(seleccionado.getStock() - cantidad);

            System.out.print("¿Desea agregar otro producto? (s/n): ");
            String respuesta = InputUtils.leerTexto("");
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        Pedido pedido = new Pedido(contadorPedido++, lineas);
        pedidos.add(pedido);
        System.out.println("Pedido creado con éxito:");
        System.out.println(pedido);
    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }

        System.out.println("=== Lista de Pedidos ===");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }
}
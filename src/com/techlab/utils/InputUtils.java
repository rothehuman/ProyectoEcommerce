package com.techlab.utils;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("El texto no puede estar vacío. Intente nuevamente.");
        }
    }

    public static int leerEntero(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            try {
                int numero = Integer.parseInt(input);
                if (numero >= min && numero <= max) {
                    return numero;
                } else {
                    System.out.println("Ingrese un número entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
            }
        }
    }

    public static double leerDouble(String mensaje, double min) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            try {
                double numero = Double.parseDouble(input);
                if (numero >= min) {
                    return numero;
                } else {
                    System.out.println("El número debe ser mayor o igual a " + min + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número decimal.");
            }
        }
    }
}
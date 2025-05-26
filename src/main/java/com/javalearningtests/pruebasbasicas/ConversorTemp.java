package com.javalearningtests.pruebasbasicas;//Escribe un programa que permita al usuario seleccionar una opción de un menú para convertir temperaturas:
//
//Convertir de Celsius a Fahrenheit.
//Convertir de Fahrenheit a Celsius.
//Convertir de Celsius a Kelvin.
//Convertir de Kelvin a Celsius.
//Requerimientos:
//Solicita la opción al usuario utilizando un switch.
//Solicita la temperatura inicial dependiendo de la opción seleccionada.
//Realiza la conversión correcta y muestra el resultado.
//Si el usuario selecciona una opción no válida, muestra un mensaje de error.


import java.util.Scanner;

public class ConversorTemp {
    public static void main(String[] args) {

        //Constantes a utilizar para evitar usar numeros dentro de codigo y reemplazarlos por uso de variables
        float constanteNueveEntreCinco = 1.8f;
        float constanteCincoEntreNueve = 0.5556f;
        int constanteCelsiusFahrenheit2 = 32;
        float constanteKelvin = 273.15f;

        System.out.println("\n---------Bienvenido a tu conversor de Temperatura--------");
        //Mostrar el menu
        System.out.println("\nElige que tipo de conversion deseas:");
        System.out.println("\n1.Convertir de Celsius a Fahrenheit.");
        System.out.println("2.Convertir de Fahrenheit a Celsius.");
        System.out.println("3.Convertir de Celsius a Kelvin.");
        System.out.println("4.Convertir de Kelvin a Celsius.");
        System.out.println("5.Salir");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {

                int opcion = scanner.nextInt();

                if (opcion == 5) { //Opcion para salir del bucle en general
                    System.out.println("\nGracias por utilizar nuestro convertidor. Feliz Dia!");
                    break;
                }

                System.out.println("Ingresa la Temperatua a Calcular");

                double temperaturaInicial = scanner.nextDouble();

                double resultado = 0;

                switch (opcion) { //Parte central del programa donde se efectuan los calculos
                    case 1:
                        System.out.println("\nHas seleccionado convertir Celsius a Fahrenheit");
                        resultado = (temperaturaInicial * constanteNueveEntreCinco) + constanteCelsiusFahrenheit2;
                        break;
                    case 2:
                        System.out.println("\nHas seleccionado convertir Fahrenheit a Celsius.");
                        resultado = (temperaturaInicial - constanteCelsiusFahrenheit2) * constanteCincoEntreNueve;
                        break;
                    case 3:
                        System.out.println("\nHas seleccionado convertir Celsius a Kelvin.");
                        resultado = temperaturaInicial + constanteKelvin;
                        break;
                    case 4:
                        System.out.println("\nHas seleccionado convertir Kelvin a Celsius.");
                        resultado = temperaturaInicial - constanteKelvin;
                        break;
                    default:
                        System.out.println("Por favor ingresa una opcion dentro del menu.");
                        System.exit(0);
                }
                System.out.println("\nEl resultado es: " + resultado);
            } catch (Exception e) {
                System.out.println("Error! Ingresa valores validos");
                System.exit(0);
            }

        }

        scanner.close();
    }

}
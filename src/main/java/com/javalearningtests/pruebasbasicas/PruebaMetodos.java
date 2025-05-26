package com.javalearningtests.pruebasbasicas;//Diseña un programa que realice las siguientes operaciones con números enteros:
//
//1.Determinar si un número es par o impar.
//2.Calcular el factorial de un número.
//3.Determinar si un número es primo.
//4.Mostrar un menú interactivo para que el usuario elija la operación deseada y
// repita el proceso hasta que decida salir.

//Requisitos del menu
//1.Cada funcionalidad debe implementarse como una función independiente:
//esPar(int numero): Retorna true si el número es par, o false si es impar.
//calcularFactorial(int numero): Calcula y retorna el factorial del número.
//esPrimo(int numero): Retorna true si el número es primo, o false si no lo es.
//2.El programa debe contener un menú interactivo que permita al usuario seleccionar la operación que desea realizar.
//3.Si el usuario selecciona un número inválido, muestra un mensaje de error y vuelve al menú.
//4.La opción para salir del programa debe estar incluida en el menú.

import java.util.Scanner;

public class PruebaMetodos {
    public static void main(String[] args) {

        System.out.println("\n-------Bienvenido a tu validador numerico------");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor selecciona tu accion del menu:");
        System.out.println("\n1.Verificar si un número es par o impar:");
        System.out.println("2.Calcular el factorial de un número.");
        System.out.println("3.Verificar si un número es primo.");
        System.out.println("4.Salir.");

        while (true) { //Loop que permite que la persona continue haciendo consultas hasta que seleccione salir
            try { // manejo de excepciones por si la persona ingresa datos incorrectos
                int opcion = scanner.nextInt();

                System.out.println("Has seleccionado la opcion: " + opcion);

                if (opcion == 4) { //Opcion para salir del bucle en general
                    System.out.println("\nGracias por utilizar nuestro validador numerico. Feliz Dia!");
                    break;
                }

                System.out.println("\nIngresa el numero a validar: ");

                int numeroValidar = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        esPar(numeroValidar);
                        break;
                    case 2:
                        if (numeroValidar < 0) {
                            System.out.println("El factorial no se puede calcular");
                        } else calcularFactorial(numeroValidar);

                        break;

                    case 3:
                        esPrimo(numeroValidar);
                        break;

                    default:
                        System.out.println("Por favor ingresa una opcion dentro del menu.");
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Error! Ingresa valores validos");
                System.exit(0);
            }
        }

        scanner.close();
    }

    public static void esPar(int numeroValidar) { // metodo para calcular si un numero es par
        if (numeroValidar % 2 == 0) {
            System.out.println("El número " + numeroValidar + " es par.");
        } else {
            System.out.println("El número " + numeroValidar + " es impar.");
        }
    }

    public static void calcularFactorial(int numeroValidar) { // metodo para calcular el factorial
        int inicio = 1;
        for (int i = 1; i <= numeroValidar; i++) {
            inicio = inicio * i;
        }
        System.out.println("El numero factorial es: " + inicio);
    }

    public static void esPrimo(int numeroValidar) { // metodo para calcular si un numero es o no primo
        int inicializador = 1;
        int contador = 0;
        while (inicializador <= numeroValidar) {
            if (numeroValidar % inicializador == 0) {
                contador++;
            }
            inicializador++;
        }
        if (contador == 2) {
            System.out.println("El número " + numeroValidar + " es primo.");
        } else {
            System.out.println("El número " + numeroValidar + " no es primo.");
        }

    }

}
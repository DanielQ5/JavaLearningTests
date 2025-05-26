package com.javalearningtests.pruebasbasicas;//Crea un programa que actúe como una calculadora básica. El programa debe:
//
//Solicitar al usuario dos números.
//Mostrar un menú de operaciones disponibles:
//1: Suma
//2: Resta
//3: Multiplicación
//4: División
//Pedir al usuario que seleccione una operación ingresando el número correspondiente.
//Realizar la operación seleccionada y mostrar el resultado.
//Manejar los siguientes casos especiales:
//Si el usuario intenta dividir por cero, mostrar un mensaje de error.
//Si el usuario ingresa una opción no válida, mostrar un mensaje y no realizar ninguna operación.


import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        System.out.println("-------Bienvenido al Programa de com.javalearningtests.pruebasbasicas.Calculadora---------");


        System.out.println("\n Ingresa tu primer numero: ");


        try {
            Scanner scanner = new Scanner(System.in);
            double numero1 = scanner.nextDouble(); //Primer registro de numero

            System.out.println("\nCual operacion deseas llevar a cabo? (Digita el numero de la opcion)");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt(); //Input de la seleccion del usuario


            System.out.println("\nIngresa tu segundo numero: ");
            double numero2 = scanner.nextDouble();

            double resultado = 0; //Permite guardar la variable que estaremos manejando

            switch (opcion) {
                case 1:
                    resultado = numero1 + numero2;
                    break;
                case 2:
                    resultado = numero1 - numero2;
                    break;
                case 3:
                    resultado = numero1 * numero2;
                    break;
                case 4:
                    if (numero2 != 0) {
                        resultado = numero1 / numero2;
                    } else {
                        throw new ArithmeticException("No se puede dividir por cero.");
                    }
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Por favor ingresa una opcion dentro del menu.");
                    System.exit(0);

            }


            System.out.println("\nEl resultado es: " + resultado);


        } catch (Exception e) {
            System.out.println("Error! Ingresa valores validos");

        }
    }

}

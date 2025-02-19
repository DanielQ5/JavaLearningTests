package PruebasBasicas;//Enunciado:
//Crea un programa que reciba un número entero ingresado por el usuario y
// realice las siguientes acciones:
//
//Si el número es par, imprime todos los números pares desde 0 hasta ese número.
//Si el número es impar, imprime todos los números impares desde 0 hasta ese número.
//Si el número es menor o igual a 0, muestra un mensaje indicando que el número no es válido.

import java.util.Scanner;

public class CondYLoops {

    public static void main(String[] args) {

        System.out.println("Por favor ingresa un numero:");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("El numero ingresado no es valido");
        } else if (number % 2 == 0) {
            for (int i = 0; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } else {
            for (int j = 0; j <= number; j++) {
                if (j % 2 != 0) {
                    System.out.println(j);
                }
            }
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin20_1;

/**
 *
 * @author ecollazodominguez
 */
public class Boletin20_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Liga xor = new Liga();
     xor.creaArray();
     xor.amosar();
        System.out.println("*****");
     xor.calcularGoles();
     xor.amosarTodo();
        System.out.println("*****");
//     xor.ordenarMenorMayor();
     xor.amosarTodo();
        System.out.println("****");
        xor.mejorXornada();
        System.out.println("*****");
        xor.maisGoles();
        System.out.println("*****");
        xor.consultaGoles("Celta", "X2");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin20_2;

/**
 *
 * @author ecollazodominguez
 */
public class Tartaglia {
    private int[] numeros = new int[0];
    
    public void Triángulo(){
        for (int i = 1; i <= 10; i++) {
            int[] numeros2 = new int[i];
            for (int j=0;j<i;j++) {
                if (j==0 || j==(i-1)) {
                    numeros2[j]=1;
                } else {
                    numeros2[j]=numeros[j]+numeros[j-1];
                }
                System.out.print(numeros2[j] +" ");
            }
            numeros=numeros2;
            System.out.println();
        }
    }
}

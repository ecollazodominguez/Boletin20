/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin20_1;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author ecollazodominguez
 */
public class Liga {

    private String[] equipos = {"Celta", "Depor", "Barça"};
    private String[] xornadas = {"X1", "X2", "X3"};
    private int[][] goles = {{3, 4, 2},
    {1, 2, 1},
    {3, 0, 1}};
    private int[] golesT = new int[goles.length];

    public void menu() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Escriba o número da operación que desee facer"
                    + "\n 1: Mostrar tabla de puntuacions"
                    + "\n 2: Lista dos equipos ordenados por menor nº goles na liga"
                    + "\n 3: Mostrar equipo que marca máis goles en cada Xornada"
                    + "\n 4: Mostrar o equipo e xornada que se rexistrara máis goles"
                    + "\n 5: Consultar nº goles introducindo equipo e xornada"));

            switch (opcion) {
                case 1:
                    this.amosarTodo();
                    break;
                case 2:
                    this.ordenarMenorMayor();
                    this.amosarTodo();
                    break;
                case 3:
                    this.mejorXornada();
                    break;
                case 4:
                    this.maisGoles();
                    break;
                case 5:
                    this.consultaGoles(JOptionPane.showInputDialog("Introducir nome do equipo, celta, barça o depor"), JOptionPane.showInputDialog("Elixe xornada, X1, X2 o X3"));
                    break;
                default:
                    break;
            }
        } while (opcion > 5);
    }

    public void creaArray() {
        Random rand = new Random();
        for (int i = 0; i < goles.length; i++) {
            for (int j = 0; j < goles[i].length; j++) {
                goles[i][j] = rand.nextInt(6);//generamos numeros al azar entre el 1 y 10
            }
        }
    }

    public void amosar() {
        for (int i = 0; i < goles.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < goles[i].length; j++) {
                System.out.print(goles[i][j] + "    ");
            }
            System.out.print("|\n");
        }
    }
    
    public int[] calcularGoles() {
        int f;
        int c;
        int suma;
        for (f = 0; f < goles.length; f++) {
            suma = 0;
            for (c = 0; c < goles[f].length; c++) {
                suma = suma + goles[f][c];
            }
            golesT[f] = suma;

        }
        return golesT;
    }

    public void ordenarMenorMayor() {
        this.calcularGoles();
        int aux = 0;
        int[] aux2 = {0, 0, 0};
        for (int i = 0; i < golesT.length - 1; i++) {
            for (int j = i + 1; j < golesT.length; j++) {
                if (golesT[i] > golesT[j]) {
                    aux = golesT[i];
                    golesT[i] = golesT[j];
                    golesT[j] = aux;
                    String auxnome = equipos[i];
                    equipos[i] = equipos[j];
                    equipos[j] = auxnome;
                    aux2 = goles[i];
                    goles[i] = goles[j];
                    goles[j] = aux2;

                }
            }
        }

    }

    public void amosarTodo() {
        System.out.println("          " + xornadas[0] + "  " + xornadas[1] + "  " + xornadas[2] + " Total");
        for (int f = 0; f < goles.length; f++) {
            System.out.print(equipos[f] + "    |");
            for (int c = 0; c < goles[f].length; c++) {
                System.out.print(goles[f][c] + " | ");
            }
            System.out.print(golesT[f]);

            System.out.print(" |\n");
        }
    }

    public void mejorXornada() {
        int total = 0;
        String nome = "a";
        for (int j = 0; j < goles[0].length; j++) {
            total = 0;
            for (int i = 0; i < goles.length; i++) {
                if (total < goles[i][j]) {
                    total = goles[i][j];
                    nome = equipos[i];
                }

            }
            System.out.println(nome + ": " + total);
        }
    }

    public void maisGoles() {
        int total = 0;
        String nome = "a";
        String xornada = "b";
        for (int j = 0; j < goles[0].length; j++) {
            for (int i = 0; i < goles.length; i++) {
                if (total < goles[i][j]) {
                    total = goles[i][j];
                    nome = equipos[i];
                    xornada = xornadas[j];

                }

            }
        }
        System.out.println(nome + " " + xornada + ": " + total);
    }

    public void consultaGoles(String nEquipo, String nXornada) {
        int x = 0;
        for (x = 0; x < xornadas.length; x++) {
            if (xornadas[x].equalsIgnoreCase(nXornada)) {
                break;
            }
        }
        System.out.print(xornadas[x] + " ");

        for (int i = 0; i < goles.length; i++) {
            if (equipos[i].equalsIgnoreCase(nEquipo)) {
                System.out.print(equipos[i] + ": ");
            }
            for (int j = 0; j < goles[0].length; j++) {
                if (j == x - 1) {
                    if (equipos[i].equalsIgnoreCase(nEquipo)) {
                        System.out.println(goles[i][j] + " goles");
                    }
                }
            }

        }
    }
}

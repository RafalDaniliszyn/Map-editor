package pl.rafal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ZapisTablic {
    int tablicaMapy[][];
    int tablicaMapyKanwa[][];
    int tablicaMapyKolizji[][];

    int tablicaMapyPoziom1[][];
    int tablicaMapyKanwaPoziom1[][];
    int tablicaMapyKolizjiPoziom1[][];

    PrintWriter zapisTablicyMapy;
    PrintWriter zapisTablicyMapyKanwa;
    PrintWriter zapisTablicyMapyKolizji;

    PrintWriter zapisTablicyMapyPoziom1;
    PrintWriter zapisTablicyMapyKanwaPoziom1;
    PrintWriter zapisTablicyMapyKolizjiPoziom1;

    Scanner scanner;

    ZapisTablic(int tablicaMapy[][], int tablicaMapyKanwa[][], int tablicaMapyKolizji[][], int tablicaMapyPoziom1[][], int tablicaMapyKanwaPoziom1[][], int tablicaMapyKolizjiPoziom1[][]){
        this.tablicaMapy = tablicaMapy;
        this.tablicaMapyKanwa = tablicaMapyKanwa;
        this.tablicaMapyKolizji = tablicaMapyKolizji;

        this.tablicaMapyPoziom1 = tablicaMapyPoziom1;
        this.tablicaMapyKanwaPoziom1 = tablicaMapyKanwaPoziom1;
        this.tablicaMapyKolizjiPoziom1 = tablicaMapyKolizjiPoziom1;


        try {
            zapisTablicyMapy = new PrintWriter(new File("C:\\Users\\Rafal\\mapaKafelkowa\\tabliceMap\\tablicaMapy.txt"));
            zapisTablicyMapyKanwa = new PrintWriter(new File("C:\\Users\\Rafal\\mapaKafelkowa\\tabliceMap\\tablicaMapyKanwa.txt"));
            zapisTablicyMapyKolizji = new PrintWriter(new File("C:\\Users\\Rafal\\mapaKafelkowa\\tabliceMap\\tablicaKolizji.txt"));

            zapisTablicyMapyPoziom1 = new PrintWriter(new File("C:\\Users\\Rafal\\mapaKafelkowa\\tabliceMap\\tablicaMapyPoziom1.txt"));
            zapisTablicyMapyKanwaPoziom1 = new PrintWriter(new File("C:\\Users\\Rafal\\mapaKafelkowa\\tabliceMap\\tablicaMapyKanwaPoziom1.txt"));
            zapisTablicyMapyKolizjiPoziom1 = new PrintWriter(new File("C:\\Users\\Rafal\\mapaKafelkowa\\tabliceMap\\tablicaMapyKolizjiPoziom1.txt"));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void zapiszTabliceMapy(){
        for (int i = 0; i < tablicaMapy.length; i++) {
            for (int i1 = 0; i1 < tablicaMapy.length; i1++) {
                zapisTablicyMapy.print(" ");
                zapisTablicyMapyKanwa.print(" ");
                zapisTablicyMapyKolizji.print(" ");
                zapisTablicyMapy.print(tablicaMapy[i][i1]);
                zapisTablicyMapyKanwa.print(tablicaMapyKanwa[i][i1]);
                zapisTablicyMapyKolizji.print(tablicaMapyKolizji[i][i1]);

                zapisTablicyMapyPoziom1.print(" ");
                zapisTablicyMapyKanwaPoziom1.print(" ");
                zapisTablicyMapyKolizjiPoziom1.print(" ");
                zapisTablicyMapyPoziom1.print(tablicaMapyPoziom1[i][i1]);
                zapisTablicyMapyKanwaPoziom1.print(tablicaMapyKanwaPoziom1[i][i1]);
                zapisTablicyMapyKolizjiPoziom1.print(tablicaMapyKolizjiPoziom1[i][i1]);
            }
        }
    }

    int[][] wczytajMape(int[][] tab, String sciezka){
        try {
            scanner = new Scanner(new File("C:\\Users\\Rafal\\Gra\\src\\pl\\rafal\\tabliceMap\\"+sciezka));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if(scanner.hasNext()) {
                    tab[i][j] = scanner.nextInt();
                }
            }
        }
        return tab;
    }


}











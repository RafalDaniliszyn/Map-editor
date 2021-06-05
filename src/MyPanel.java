package pl.rafal;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public Dimension getPreferredSize() {
        return new Dimension(1000, 700);
    }
    ZapisTablic zapisTablic;
    Map map;
    WyborKafelka wyborKafelka;
    MapaKolizji mapaKolizji;
    MapaKolizji mapaKolizjiPoziom1;

    MyPanel(){

        mapaKolizji = new MapaKolizji();
        mapaKolizjiPoziom1 = new MapaKolizji();

        this.map = new Map(mapaKolizji, mapaKolizjiPoziom1);
        map.zaladujObrazki();
        zapisTablic = new ZapisTablic(map.tablicaMapy, map.tablicaMapyKanwa, mapaKolizji.tablicaMapyKolizji, map.tablicaMapyPoziom1, map.tablicaMapyKanwaPoziom1, mapaKolizjiPoziom1.tablicaMapyKolizji);
        zapisTablic.wczytajMape(map.tablicaMapy,"tablicaMapy.txt");
        zapisTablic.wczytajMape(map.tablicaMapyKanwa, "tablicaMapyKanwa.txt");
        zapisTablic.wczytajMape(mapaKolizji.tablicaMapyKolizji, "tablicaKolizji.txt");

        zapisTablic.wczytajMape(map.tablicaMapyPoziom1,"tablicaMapyPoziom1.txt");
        zapisTablic.wczytajMape(map.tablicaMapyKanwaPoziom1, "tablicaMapyKanwaPoziom1.txt");
        zapisTablic.wczytajMape(mapaKolizjiPoziom1.tablicaMapyKolizji, "tablicaMapyKolizjiPoziom1.txt");
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        map.wyswietlMape(g);
        wyborKafelka.wyswietlWybranyKafelek(g);
        wyborKafelka.ukladanieKafelkow();

        if (map.saveMap == 1) {
            zapisTablic.zapiszTabliceMapy();
            zapisTablic.zapisTablicyMapy.close();
            zapisTablic.zapisTablicyMapyKanwa.close();
            zapisTablic.zapisTablicyMapyKolizji.close();
        }
        repaint();
    }
}

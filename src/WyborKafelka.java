package pl.rafal;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Struct;

public class WyborKafelka implements MouseListener, MouseWheelListener {

    Map map;
    int kafelek = 0;
    int kafelekKanwa = 0;
    int liczbaKafelkowKanwa = 10;
    BufferedImage tablicaKafelkow[];
    BufferedImage tablicaKafelkowKanwa[] = new BufferedImage[this.liczbaKafelkowKanwa];
    BufferedImage kafelekKolizji;
    MapaKolizji mapaKolizji;

    boolean czyWcisniety = false;
    int eventMyszy;

    int poziomEdycji = 0;
    int x = (int) MouseInfo.getPointerInfo().getLocation().x;
    int y = (int) MouseInfo.getPointerInfo().getLocation().y;

    WyborKafelka(Map map, MapaKolizji mapaKolizji) throws IOException {
        this.mapaKolizji = mapaKolizji;
        this.map = map;
        tablicaKafelkow = new BufferedImage[map.liczbaObrazkowCalych];
        for (int i = 0; i < tablicaKafelkow.length; i++) {
            tablicaKafelkow[i] = map.tablicaKafelkowCalych[i];
        }
        for (int i = 0; i < map.tablicaKafelkowKanwa.length; i++) {
            this.tablicaKafelkowKanwa[i] = map.tablicaKafelkowKanwa[i];
        }

        this.kafelekKolizji = ImageIO.read(new File("C:\\Users\\Rafal\\mapaKafelkowa\\obrazki\\kafelekKolizja.png"));

    }

    void lokalizowanieMyszy() {
        x = (int) MouseInfo.getPointerInfo().getLocation().x + ((map.x * -1) * 60);
        y = (int) MouseInfo.getPointerInfo().getLocation().y + ((map.y * -1) * 60);
    }

    void wyswietlWybranyKafelek(Graphics g) {
        if (map.wyborTypuMapy == 0) {
            g.drawImage(this.tablicaKafelkow[this.kafelek], 0, 0, null);
        }
        if(map.wyborTypuMapy == 1){
            g.drawImage(this.kafelekKolizji, 0, 0, null);
        }
        if(map.wyborTypuMapy == 2){
            g.drawImage(this.tablicaKafelkowKanwa[this.kafelekKanwa], 0, 0, null);
        }

    }

    void ukladanieKafelkow(){
        if (this.czyWcisniety == true){
            if (map.wyborPoziomuMapy == 0) {
                if (map.wyborTypuMapy == 0) {
                    map.tablicaMapy[this.y / 60][this.x / 60] = this.kafelek;
                }
                if (map.wyborTypuMapy == 1) {
                    this.mapaKolizji.tablicaMapyKolizji[this.y / 60][this.x / 60] = 1;

                    if (this.mapaKolizji.tablicaMapyKolizji[this.y / 60][this.x / 60] == 1 && this.eventMyszy == 3) {
                        this.mapaKolizji.tablicaMapyKolizji[this.y / 60][this.x / 60] = 0;
                    }
                }
                if (map.wyborTypuMapy == 2) {
                    map.tablicaMapyKanwa[this.y / 60][this.x / 60] = this.kafelekKanwa;
                }
            }

            if (map.wyborPoziomuMapy == 1) {
                if (map.wyborTypuMapy == 0) {
                    map.tablicaMapyPoziom1[this.y / 60][this.x / 60] = this.kafelek;
                }
                if (map.wyborTypuMapy == 1) {
                    map.mapaKolizjiPoziom1.tablicaMapyKolizji[this.y / 60][this.x / 60] = 1;

                    if (map.mapaKolizjiPoziom1.tablicaMapyKolizji[this.y / 60][this.x / 60] == 1 && this.eventMyszy == 3) {
                        map.mapaKolizjiPoziom1.tablicaMapyKolizji[this.y / 60][this.x / 60] = 0;
                    }
                }
                if (map.wyborTypuMapy == 2) {
                    map.tablicaMapyKanwaPoziom1[this.y / 60][this.x / 60] = this.kafelekKanwa;
                }
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.czyWcisniety = true;
        this.eventMyszy = e.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.czyWcisniety = false;
        this.eventMyszy = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(map.wyborTypuMapy == 0) {
            if (e.getWheelRotation() > 0 && kafelek < tablicaKafelkow.length - 1) {
                this.kafelek += 1;
            }
            if (e.getWheelRotation() < 0 && kafelek > 0) {
                this.kafelek -= 1;
            }
        }

        if (map.wyborTypuMapy == 2){
            if (e.getWheelRotation() > 0 && this.kafelekKanwa < tablicaKafelkowKanwa.length - 1) {
                this.kafelekKanwa += 1;
            }
            if (e.getWheelRotation() < 0 && this.kafelekKanwa > 0) {
                this.kafelekKanwa -= 1;
            }
        }
    }
}

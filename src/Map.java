package pl.rafal;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Map implements KeyListener {
    int liczbaObrazkowCalych = 18;
    int LiczbaObrazkowKanwa = 10;
    BufferedImage kafelekKanwa;
    BufferedImage tablicaKafelkowCalych[] = new BufferedImage[liczbaObrazkowCalych];
    BufferedImage tablicaKafelkowKanwa[] = new BufferedImage[LiczbaObrazkowKanwa];
    BufferedImage kafelekKolizji;

    MapaKolizji mapaKolizji;
    MapaKolizji mapaKolizjiPoziom1;

    int saveMap = 0;

    int tablicaMapy[][] = new int[2500][2500];
    int tablicaMapyKanwa[][] = new int[2500][2500];

    int tablicaMapyPoziom1[][] = new int[2500][2500];
    int tablicaMapyKanwaPoziom1[][] = new int[2500][2500];


    int x;
    int y;
    int wielkoscKafelka = 60;
    int wyborTypuMapy = 0; // ta zmienna mowi ktorą mapę wyswietlac najpierw np: mapę kolizji pozniej mapę calych kafelkow
    int wyborPoziomuMapy = 1; //zmienna mowi ktory poziom wyswietlac. Gorny lub dolny. 0 oznacza poziom 0;   1 oznacza poziom pierwszy  a -1 poziom -1.

    int kafelekCalyid = 0;
    String kafelekCaly = String.valueOf(kafelekCalyid);

    int kafelekKanwaId = 0;
    String kafelekKanwaStringId = String.valueOf(kafelekKanwaId);


    Map(MapaKolizji mapaKolizji, MapaKolizji mapaKolizjiPoziom1) {
        this.mapaKolizji = mapaKolizji;
        this.mapaKolizjiPoziom1 = mapaKolizjiPoziom1;
        this.x = 0;
        this.y = 0;
    }

    void zaladujObrazki() {
        try {

            for (int i = 0; i < tablicaKafelkowCalych.length; i++) {
                tablicaKafelkowCalych[i] = ImageIO.read(new File("C:\\Users\\Rafal\\mapaKafelkowa\\obrazki\\" + kafelekCaly + ".png"));
                kafelekCalyid += 1;
                kafelekCaly = String.valueOf(kafelekCalyid);

            }
            for (int i = 0; i < tablicaKafelkowKanwa.length; i++) {
                tablicaKafelkowKanwa[i] = ImageIO.read(new File("C:\\Users\\Rafal\\mapaKafelkowa\\obrazki\\" + kafelekKanwaStringId + "kanwa.png"));
                kafelekKanwaId +=1;
                kafelekKanwaStringId = String.valueOf(kafelekKanwaId);

            }
            this.kafelekKolizji = ImageIO.read(new File("C:\\Users\\Rafal\\mapaKafelkowa\\obrazki\\kafelekKolizja.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void wyswietlMape(Graphics g) {
        if (this.wyborPoziomuMapy == 0) {
            for (int i = this.y*-1; i < (this.y*-1)+26; i++) {
                for (int j = this.x*-1; j < (this.x*-1)+26; j++) {

                    g.drawImage(this.tablicaKafelkowCalych[tablicaMapy[i][j]], (this.x + j) * this.wielkoscKafelka, (this.y + i) * this.wielkoscKafelka, null);

                }
            }
            for (int i = this.y*-1; i < (this.y*-1)+26; i++) {
                for (int j = this.x*-1; j < (this.x*-1)+26; j++) {

                    g.drawImage(this.tablicaKafelkowKanwa[tablicaMapyKanwa[i][j]], (this.x + j) * this.wielkoscKafelka, (this.y + i) * this.wielkoscKafelka, null);
                }
            }

            if (wyborTypuMapy == 1) {
                for (int i = this.y*-1; i < (this.y*-1)+26; i++) {
                    for (int j = this.x*-1; j < (this.x*-1)+26; j++) {
                        if (mapaKolizji.tablicaMapyKolizji[i][j] == 1) {
                            g.drawImage(this.kafelekKolizji, (this.x + j) * this.wielkoscKafelka, (this.y + i) * this.wielkoscKafelka, null);
                        }
                    }
                }
            }
        }

        /////////////////////////////////////////////////////////////
        if (this.wyborPoziomuMapy == 1){

            for (int i = this.y*-1; i < (this.y*-1)+26; i++) {
                for (int j = this.x*-1; j < (this.x*-1)+26; j++) {

                    g.drawImage(this.tablicaKafelkowCalych[tablicaMapy[i][j]], (this.x + j) * this.wielkoscKafelka, (this.y + i) * this.wielkoscKafelka, null);

                }
            }
            for (int i = this.y*-1; i < (this.y*-1)+26; i++) {
                for (int j = this.x*-1; j < (this.x*-1)+26; j++) {
                    g.drawImage(this.tablicaKafelkowKanwa[tablicaMapyKanwa[i][j]], (this.x + j) * this.wielkoscKafelka, (this.y + i) * this.wielkoscKafelka, null);
                }
            }




            for (int i = this.y*-1; i < (this.y*-1)+26; i++) {
                for (int j = this.x*-1; j < (this.x*-1)+26; j++) {

                    g.drawImage(this.tablicaKafelkowCalych[tablicaMapyPoziom1[i][j]], (this.x + j) * this.wielkoscKafelka, (this.y + i) * this.wielkoscKafelka, null);

                }
            }
            for (int i = this.y*-1; i < (this.y*-1)+26; i++) {
                for (int j = this.x*-1; j < (this.x*-1)+26; j++) {
                    g.drawImage(this.tablicaKafelkowKanwa[tablicaMapyKanwaPoziom1[i][j]], (this.x + j) * this.wielkoscKafelka, (this.y + i) * this.wielkoscKafelka, null);
                }
            }

            if (wyborTypuMapy == 1) {
                for (int i = this.y*-1; i < (this.y*-1)+26; i++) {
                    for (int j = this.x*-1; j < (this.x*-1)+26; j++) {
                        if (mapaKolizjiPoziom1.tablicaMapyKolizji[i][j] == 1) {
                            g.drawImage(this.kafelekKolizji, (this.x + j) * this.wielkoscKafelka, (this.y + i) * this.wielkoscKafelka, null);
                        }
                    }
                }
            }

        }
        //////////////////////////////////////////////////////////////////

        if (this.wyborPoziomuMapy == -1){

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'd' ) {
            x -= 1;
        }
        if (e.getKeyChar() == 'a'&& x < 0) {
            x += 1;
        }
        if (e.getKeyChar() == 'w' && y < 0) {
            y += 1;
        }
        if (e.getKeyChar() == 's' ) {
            y -= 1;
        }
        if (e.getKeyChar() == '2'){
            this.wyborTypuMapy = 2;
        }
        if (e.getKeyChar() == '1'){
            this.wyborTypuMapy = 1;
        }
        if (e.getKeyChar() == '0'){
            this.wyborTypuMapy = 0;
        }
        if (e.getKeyChar() == 'p'){
            this.saveMap = 1;
        }
        if (e.getKeyChar() == 'q'){
            this.wyborPoziomuMapy = 1;
        }
        if (e.getKeyChar() == 'e'){
            this.wyborPoziomuMapy = 0;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}

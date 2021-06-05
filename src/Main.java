package pl.rafal;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        MyPanel panel = new MyPanel();
        WyborKafelka wyborKafelka = new WyborKafelka(panel.map,panel.mapaKolizji);

        panel.wyborKafelka = wyborKafelka;

        frame.addMouseWheelListener(wyborKafelka);
        frame.addMouseListener(wyborKafelka);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(panel.map);
        frame.setVisible(true);
        frame.pack();
        while (true){
            wyborKafelka.lokalizowanieMyszy();
        }

    }
}

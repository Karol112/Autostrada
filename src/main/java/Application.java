import autostrada.*;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Application {
    public static void main(String[] args) {
        Queue<Pojazd> kolejkaPojazdow = new ArrayBlockingQueue<Pojazd>(100);
        Pojazd motocykl = new Motocykl(200,"VSJDAMD3984","Ducati","Enduro", Silnik.SPALINOWY);
        Pojazd motocykl1 = new Motocykl(200,"DAFCSACXDFS","Ducati","Enduro", Silnik.SPALINOWY);
        Pojazd motocykl2 = new Motocykl(200,"ASFHBGFGFEF","Ducati","Enduro", Silnik.SPALINOWY);

        kolejkaPojazdow.add(motocykl);
        kolejkaPojazdow.add(motocykl1);
        kolejkaPojazdow.add(motocykl2);

        Pojazd samochod = new Samochod(6900, "VOSASDSDFS", "DAF", "6000",Silnik.SPALINOWY);
        Pojazd samochod1 = new Samochod(650, "VOASDASDASD", "Fiat", "126p",Silnik.SPALINOWY);
        Pojazd samochod2 = new Samochod(2200, "VOSAADSFSDS", "Tesla", "X",Silnik.ELEKTRYCZNY);

        kolejkaPojazdow.add(samochod);
        kolejkaPojazdow.add(samochod1);
        kolejkaPojazdow.add(samochod2);

        System.out.println(kolejkaPojazdow);

        int oplata = 200;
        KalkulatorOplat kalkulatorStandardowy = new KalkulatorOplatStandardowy(oplata);
        KalkulatorOplat kalkulatorDlaElektrycznych = new KalkulatorOplatDlaElektrycznych();
        KalkulatorOplat kalkulatorDlaLekkich = new KalkulatorOplatPojazdowLekkich(oplata);
        Bramka bramka = new Bramka(oplata, kalkulatorStandardowy);

        for (Pojazd pojazd : kolejkaPojazdow) {
            if (Silnik.ELEKTRYCZNY.equals(pojazd.getSilnik())){
                bramka.setKalkulator(kalkulatorDlaElektrycznych);
            } else if (pojazd.getMasa() <= 3_500){
                bramka.setKalkulator(kalkulatorDlaLekkich);
            } else {
                bramka.setKalkulator(kalkulatorStandardowy);
            }
            bramka.obsluzPojazd(pojazd);
        }
    }
}

package autostrada;

public class KalkulatorOplatPojazdowLekkich extends KalkulatorOplatStandardowy {


    public KalkulatorOplatPojazdowLekkich(int oplata) {
        super(oplata);
    }

    @Override
    public int obliczOplate(Pojazd pojazd) {
        return (int) (super.obliczOplate(pojazd) * 0.5);
    }
}

package icecreams;

import scoops.Scoop;

import java.util.ArrayList;
import java.util.List;

public abstract class IceCream {


    protected List<Scoop> scoops;

    public IceCream(){
        scoops = new ArrayList<>();
        createIceCream();
    }

    protected abstract void createIceCream();


    @Override
    public String toString() {
        return "IceCream{" +
                "scoops=" + scoops +
                '}';
    }
}

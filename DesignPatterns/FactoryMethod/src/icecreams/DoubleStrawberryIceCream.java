package icecreams;

import scoops.StrawberryScoop;

public class DoubleStrawberryIceCream extends IceCream {
    @Override
    protected void createIceCream() {
        scoops.add(new StrawberryScoop());
        scoops.add(new StrawberryScoop());
    }
}

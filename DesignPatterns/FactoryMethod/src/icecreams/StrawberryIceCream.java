package icecreams;

import scoops.StrawberryScoop;

public class StrawberryIceCream extends IceCream {
    @Override
    protected void createIceCream() {
        scoops.add(new StrawberryScoop());
    }
}

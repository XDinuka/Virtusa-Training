package icecreams;

import scoops.ChocolateScoop;

public class ChocolateIceCream extends IceCream {
    @Override
    protected void createIceCream() {
        scoops.add(new ChocolateScoop());
    }
}

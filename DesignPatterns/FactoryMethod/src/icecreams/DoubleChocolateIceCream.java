package icecreams;

import scoops.ChocolateScoop;

public class DoubleChocolateIceCream extends IceCream {
    @Override
    protected void createIceCream() {
        scoops.add(new ChocolateScoop());
        scoops.add(new ChocolateScoop());
    }
}

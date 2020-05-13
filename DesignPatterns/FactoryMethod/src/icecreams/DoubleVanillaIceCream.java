package icecreams;

import scoops.VanillaScoop;

public class DoubleVanillaIceCream extends IceCream {
    @Override
    protected void createIceCream() {
        scoops.add(new VanillaScoop());
        scoops.add(new VanillaScoop());
    }
}

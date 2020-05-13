package icecreams;

import scoops.VanillaScoop;

public class VanillaIceCream extends IceCream {
    @Override
    protected void createIceCream() {
        scoops.add(new VanillaScoop());
    }
}

package icecreams;

import scoops.ChocolateScoop;
import scoops.VanillaScoop;

public class VanillaChocolateIceCream extends IceCream {
    @Override
    protected void createIceCream() {
        scoops.add(new VanillaScoop());
        scoops.add(new ChocolateScoop());
    }
}

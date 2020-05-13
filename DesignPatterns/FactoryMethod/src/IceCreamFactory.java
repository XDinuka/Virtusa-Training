import icecreams.*;

public class IceCreamFactory {


    public static IceCream createIceCream(IceCreamName iceCreamName){
        switch (iceCreamName){
            case CHOCOLATE:
                return new ChocolateIceCream();
            case VANILLA:
                return new VanillaIceCream();
            case STRAWBERRY:
                return new StrawberryIceCream();
            case CHOCOLATE_DOUBLE:
                return new DoubleChocolateIceCream();
            case VANILLA_DOUBLE:
                return new DoubleVanillaIceCream();
            case STRAWBERRY_DOUBLE:
                return new DoubleStrawberryIceCream();
            case VANILLA_CHOCOLATE:
                return new VanillaChocolateIceCream();
        }
        return null;
    }

}

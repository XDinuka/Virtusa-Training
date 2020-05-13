import icecreams.IceCream;

public class Application {

    public static void main(String[] args) {

        System.out.println(IceCreamFactory.createIceCream(IceCreamName.CHOCOLATE));
        System.out.println(IceCreamFactory.createIceCream(IceCreamName.CHOCOLATE_DOUBLE));
        System.out.println(IceCreamFactory.createIceCream(IceCreamName.VANILLA));
        System.out.println(IceCreamFactory.createIceCream(IceCreamName.VANILLA_DOUBLE));
        System.out.println(IceCreamFactory.createIceCream(IceCreamName.STRAWBERRY));
        System.out.println(IceCreamFactory.createIceCream(IceCreamName.STRAWBERRY_DOUBLE));
        System.out.println(IceCreamFactory.createIceCream(IceCreamName.VANILLA_CHOCOLATE));


    }
}

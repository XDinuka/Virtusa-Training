public class Application {
    public static void main(String[] args) {
        IceCream iceCream = new IceCream.Builder(Scoop.Chocolate).cone(Cone.Waffle).topping(Topping.Sprinkles).build();
        System.out.println(iceCream);
    }
}

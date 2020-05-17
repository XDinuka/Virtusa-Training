public class IceCream {

    private final Cone cone;
    private final Scoop scoop;
    private final Topping topping;

    IceCream(Builder builder) {
        this.cone = builder.cone;
        this.scoop = builder.scoop;
        this.topping = builder.topping;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "cone=" + cone +
                ", scoop=" + scoop +
                ", topping=" + topping +
                '}';
    }

    static class Builder {
        private Cone cone;
        private Scoop scoop;
        private Topping topping;

        Builder(Scoop scoop) {
            this.scoop = scoop;
        }

        public Builder cone(Cone cone) {
            this.cone = cone;
            return this;
        }

        public Builder topping(Topping topping) {
            this.topping = topping;
            return this;
        }

        public IceCream build(){
            return new IceCream(this);
        }


    }

}

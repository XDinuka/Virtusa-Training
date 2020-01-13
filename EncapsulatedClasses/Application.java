public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.new MemberClass().print();
        application.getInnerClass().print();
        application.getAnnoymousInnerClass().print();
    }

    class MemberClass implements PrintMessage {

        @Override
        public void print() {
            System.out.println("I'm a Member Class");
        }

    }

    public PrintMessage getInnerClass() {
        class InnerClass implements PrintMessage {

            @Override
            public void print() {
                System.out.println("I'm an Inner Class");
            }

        }
        return new InnerClass();
    }

    public PrintMessage getAnnoymousInnerClass() {
        return () -> System.out.println("I'm an Anonymous Inner Class");
    }
}

@FunctionalInterface
interface PrintMessage {
    public void print();
}

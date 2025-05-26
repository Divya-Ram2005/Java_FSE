public class patternmatching {

    public static void main(String[] args) {
        checkType("Hello");
        checkType(42);
        checkType(3.14);
        checkType(true);
    }

    public static void checkType(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("It's an Integer: " + i);
            case String s -> System.out.println("It's a String: " + s);
            case Double d -> System.out.println("It's a Double: " + d);
            case Boolean b -> System.out.println("It's a Boolean: " + b);
            default -> System.out.println("Unknown type: " + obj);
        }
    }
}

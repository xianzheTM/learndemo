import java.util.function.Function;

public class LambdaDemo {
    public static void main(String[] args) {
        Function<String, String> function = new Function<>() {
            @Override
            public String apply(String s) {
                return s + " demo";
            }
        };
        String result = function.apply("aa");
        System.out.println(result);
    }
}

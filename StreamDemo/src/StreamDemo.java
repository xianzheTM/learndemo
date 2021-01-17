import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        //map
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());

        //filter
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens =
            Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);

        //forEach
        List<Person> chars = Arrays.asList(
            new Person("aa", "男", 13),
            new Person("bb", "女", 16),
            new Person("cc", "男", 18));
        chars.forEach(p -> System.out.println(p.getName()));

        //reduce
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        concat = Stream.of("a", "B", "c", "D", "e", "F")
            .filter(x -> x.compareTo("Z") > 0)
            .reduce("", String::concat);
    }
}

class Person {
    private String name;
    private String gender;
    private Integer age;

    public Person(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
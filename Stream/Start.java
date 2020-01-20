import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Start {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("John",70);
        map.put("Jane",75);
        map.put("Peter",55);
        map.put("Rick",90);
        map.put("Morty",40);

        System.out.println(map);

        List<String> collect = map.keySet().stream().filter((s) -> map.get(s) > 60).sorted().collect(Collectors.toList());

        System.out.println(collect);

    }
}

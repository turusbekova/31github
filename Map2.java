package map;

import java.util.*;

public class Map2 {
    public static void main(String[] args) {

        Map<String,String> cities = new HashMap<>();
        cities.put("China", "Beijin");
        cities.put("UK", "London");
        cities.put("USA", "DC Washington");
        cities.put("UAE", "Abu-Dhabi");
        cities.put("Kyrgyzstan", "Bishkek");
        cities.put("France", "Paris");

        //  Map.Entry - показываем что будем использовать ключи и значения
        //                     set-заменяет перебирает потом сохраняет в itr
        Iterator<Map.Entry<String,String>> itr = cities.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry<String,String> entry = itr.next();
            System.out.println("keys: " + entry.getKey() + " " + "\t\t\tvalue: " + entry.getValue());
        }
        System.out.println(cities); // {USA=DC Washington, China=Beijin, UK=London, UAE=Abu-Dhabi, France=Paris, Kyrgyzstan=Bishkek}

        // entryset - выводит ключи и значения
        // Entry - интерфейс
        System.out.println(cities.entrySet());  // [USA=DC Washington, China=Beijin, UK=London, UAE=Abu-Dhabi, France=Paris, Kyrgyzstan=Bishkek]

        System.out.println("--------------------------------");

        List<String> month = new ArrayList<>(Arrays.asList("January", "February", "March", "April","May"));
        Iterator<String> itr2 = month.iterator();
        while (itr2.hasNext()){
            System.out.println(itr2.next()); // для итератора не важен тип он все равно перебирает
        }

        System.out.println("--------------------------------");

        Map<String,String> cities2 = new TreeMap<>(cities);
//        cities2.putAll(cities);

        System.out.print("Keys: ");
        for (String keys: cities2.keySet()){
            System.out.print(keys + " ");
        }

        System.out.println();

        System.out.print("Values: ");
        for (String values: cities2.values()){
            System.out.print(values + " ");
        }
//        System.out.println(cities2); // {} - один объект [] - каждый элемент как объект

        System.out.println("");

        LinkedHashMap<String,String> lm = new LinkedHashMap<>(cities);
        System.out.println(lm);

        System.out.println("--------------------------");

        for (Map.Entry<String,String> KeysandValues: lm.entrySet()){
            System.out.println( "Keys: " + KeysandValues.getKey() + "\t\t " + "Values: " + KeysandValues.getValue());
        }





    }
}

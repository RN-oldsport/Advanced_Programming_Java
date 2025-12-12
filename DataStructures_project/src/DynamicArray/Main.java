package DynamicArray;

public class Main {
    public static void main(String[] args) throws IllegalAccessException{

        DynamicArray<String> my_array = new DynamicArray<String>();
        for (int i = 0; i < 5; i++) {
            my_array.add("GIA" + i);
        }

        my_array.remove(2);

        my_array.insert(4, "Rastin");

        for (int i = 0; i < 5; i++) {
            System.out.println(my_array.get(i));
        }

    }
}

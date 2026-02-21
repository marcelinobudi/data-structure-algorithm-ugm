import animal.*;

public class ArrayImplementation {
    public static void main(String[] args) {
        printExperiment(1);
        int intArray[] = new int[5];
        System.out.println(intArray); // it outputs address
        printExperiment(2);
        int intArray2[];
        // intArray2[] = new int[5]; // ERROR
        // instead, use this
        int[] intArray3;
        intArray3 = new int[5];

        // Lebih direkomendasikan menggunakan int[] varname

        printExperiment(3);
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        System.out.println(cars[3]);

        printExperiment(4);
        System.out.println("Array length");
        System.out.println(cars.length);

        // we can use our CUSTOM CLASS
        printExperiment(5);
        Cat[] cats = new Cat[3];
        System.out.println(cats[0]);
        // System.out.println(cats[0].name); // ERROR: cats[0] is null

        printExperiment(6);
        Dog[] dogs = {new Dog("Blacky"), new Dog("Roggy"), new Dog("Luthfi")}; // 3 ELEMENTS
        System.out.println(dogs[2].name);

        printExperiment(7);
        // System.out.println(dogs[5]); // ArrayIndexOutOfBoundsException
        // System.out.println(cats[5]); // ArrayIndexOutOfBoundsException

    }

    static void printExperiment(int num) {
        System.out.println("Eksperimen #" + num);
    }
}

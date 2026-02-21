public class OrdArrayImplementation {
    public static void main(String[] args) {
        OrdArray arr = new OrdArray(5);
        arr.insert(56);
        arr.insert(23);
        arr.insert(33);
        arr.insert(1);
        arr.insert(2);
        System.out.println(arr);
        System.out.println(arr.find(23));
        arr.delete(23);
        System.out.println(arr);
    }
}

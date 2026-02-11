import java.util.Scanner;

/// System.in : InputStream
/// stream corresponds to keyboard input or another input source specified by the host environment or user.
public class ScannerImplementation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println(str);
        char c = input.next().charAt(0);
        System.out.println(c);
        int n = input.nextInt();
        System.out.println(n);
        float f = input.nextFloat();
        System.out.println(f);
        double d = input.nextDouble();
        System.out.println(d);

    }
}

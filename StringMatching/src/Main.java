import utils.StringX;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StringX text = new StringX("AABAACAADAABAAABAA");

        ArrayList<Integer> location = text.findPattern("AABA");
        for(int i : location) {
            System.out.println("Ditemukan kecocokan pada posisi: " + i);
        }
    }
}

package utils;
import java.lang.String;
import java.util.ArrayList;

// String Extended, hehe
public class StringX {
    private String str;

    public StringX(String str) {
        this.str = str;
    }

    // return position
    public ArrayList<Integer> findPattern(String pattern) {
        ArrayList<Integer> result = new ArrayList<>(str.length());
        if(str.length() < pattern.length()) {
            result.add(-1);
            return result;
        }
        for(int i = 0; i < str.length() - pattern.length(); i++) {
            int j = 0;

            // cek kesamaan karakter
            while(j < pattern.length()) {
                // sekali aja ada yg salah, break;
                if(str.charAt(i+j) != pattern.charAt(j)) {
                    break;
                }
                j++;
            }
            // j yg nilainya sama dengan panjang pattern menunjukkan kesamaan karena sekali saja ada yg berbeda, j akan lebih kecil dari pattern
            if(j == pattern.length()) {
                result.add(i);
            }

        }
        return result;
    }
}

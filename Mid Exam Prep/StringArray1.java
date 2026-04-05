import java.util.Arrays;

class StringArray{
    // untuk keperluan percobaan, saya gunakan public, bukan private
    public String[] arr;
    public int nElems;

    public void sort(){
        for(int i = 1; i<nElems;i++){
            String key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j].compareToIgnoreCase(key) > 0){
                arr[j+1] = arr[j];
                j--;
            }
            
            arr[j+1] = key;
        }
    }
}

public class StringArray1 {
    public static void main(String[] args) {
        StringArray str = new StringArray();
        str.arr = new String[]{
            "Kusno",
            "andi",
            "jatmiko",
            "Dani",
            "ranti"
        };
        str.nElems = 5;

        System.out.println(Arrays.toString(str.arr));
        str.sort();
        System.out.println(Arrays.toString(str.arr));

    }
}

package avl_tree;

public class Node{
    int data;
    public Node left = null, right = null;
    public int height = 1; // MENGAPA 1 dan bukan 0? height yg dimulai dari 0 sangat memperumit proses perhitungan Balance Factor!!

    public Node(int data){
        this.data = data;
    }

    // HANYA EKSPERIMEN
    // menghitung tinggi node secara rekursif
    // public int getHeight() {
    //     if(left == null && right == null){
    //         return 0;
    //     }
    //     int leftHeight = (left == null) ? 0: left.getHeight();
    //     int rightHeight = (right == null) ? 0: right.getHeight();
    //     return 1 + Math.max(leftHeight, rightHeight);
    // }
    // public int getBF(){
    //     return left.getHeight() - getHeight();
    // }
}
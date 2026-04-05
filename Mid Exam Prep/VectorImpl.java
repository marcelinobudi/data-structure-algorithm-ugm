
class Vector {
    public int x, y;
    public Vector(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Vector addition(Vector vector){
        return new Vector(this.x + vector.x, this.y + vector.y);
    }

    public Vector substraction(Vector vector){
        return new Vector(this.x - vector.x, this.y - vector.y);
    }

    public Vector scalarMultiplication(int k){
        return new Vector(k*this.x, k*this.y);
    }

    @Override
    public String toString() {
        return "(" +this.x+", " + this.y +")";
    }
}
public class VectorImpl {
    public static void main(String[] args) {
        Vector u = new Vector(1, 2);
        Vector v = new Vector(3, 3);
        Vector w = new Vector(7,2);
        System.out.println(u.addition(v));
        System.out.println(v.substraction(w));
        System.out.println(w.scalarMultiplication(5));
    }
}

import tree.Node;
import tree.Tree;

public class TreeImplementation {
    public static void main(String[] args) {
        Tree<String> family = new Tree();
        Node<String> son = new Node("Luthfi");

        Node<String> father = new Node("Gregorius Junior");
        father.children.add(son);
        Node<String> fatherSibling1 = new Node("Gregorius second");
        fatherSibling1.children.add(new Node<String>("Gregory Second Child"));
        Node<String> fatherSibling2 = new Node("Gregorius third");

        Node<String> grandFather = new Node("Gregorius Pratama");
        grandFather.children.add(father);
        grandFather.children.add(fatherSibling1);
        grandFather.children.add(fatherSibling2);
        family.root = grandFather;

        System.out.println("Pre Order");
        family.preOrder();
        System.out.println();
        System.out.println("Post Order");
        family.postOrder();
    }
}

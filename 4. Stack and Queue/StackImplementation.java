public class StackImplementation {
    public static void main(String[] args) {
        // We will create balanced symbol checking algorithm using stack
        System.out.println(isSymbolBalance("Aku (anton) suka bermain (bola)")); // true
        System.out.println(isSymbolBalance("Aku (anton[ suka bermain [bola]])")); // true
        System.out.println(isSymbolBalance("Aku (anton[] suka bermain [bola])")); // true
        System.out.println(isSymbolBalance("Aku (}anton[] suka bermain [bola])")); // false
        System.out.println(isSymbolBalance("Aku {{](anton[] suka bermain [bola])")); // true


    }
    public static boolean isSymbolBalance(String word){
        Stack<Character> stack = new Stack<Character>(word.length());
        for(int i = 0; i < word.length(); i++){
            if(
                word.charAt(i) == '{' ||
                word.charAt(i) == '(' ||
                word.charAt(i) == '[' 
            ) {
                stack.push(word.charAt(i));
            } else if(
                word.charAt(i) == '}' && stack.pop() != '{'
            ) {
                return false;
            } else if(
                word.charAt(i) == ')' && stack.pop() != '('
            ) {
                return false;
            } else if(
                word.charAt(i) == ']' && stack.pop() != '['
            ) {
                return false;
            }
        }
        
        return stack.isEmpty(); // jika masih kosong, maka benar!!
    }
}

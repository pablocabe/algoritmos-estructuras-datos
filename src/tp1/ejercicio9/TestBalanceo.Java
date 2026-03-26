package tp1.ejercicio9;

import tp1.ejercicio8.Stack;

public class TestBalanceo {

    public boolean estaBalanceado(String s) {
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Si es abre, apilamos
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);

            // Si es cierra, verificamos
            } else if (c == ')' || c == ']' || c == '}') {

                // Si la pila está vacía, no hay con qué emparejar
                if (pila.isEmpty()) return false;

                char tope = pila.pop();

                // Verificamos que el cierre coincida con el abre
                if (c == ')' && tope != '(') return false;
                if (c == ']' && tope != '[') return false;
                if (c == '}' && tope != '{') return false;
            }
        }

        // Balanceado si no quedó nada en la pila
        return pila.isEmpty();
    }

    public static void main(String[] args) {
        TestBalanceo test = new TestBalanceo();

        System.out.println(test.estaBalanceado("{( )[ ] }"));  // true
        System.out.println(test.estaBalanceado("( [ ] )"));    // true
        System.out.println(test.estaBalanceado("[ ] )"));      // false
        System.out.println(test.estaBalanceado(""));           // true (vacío)
        System.out.println(test.estaBalanceado("{(})"));       // false
    }
}
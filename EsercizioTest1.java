public class EsercizioTest1 {
        public static void main(String[] args) {
            int somma = 0;
    
            System.out.println("Stampo i numeri pari tra 1 e 50:");
    
            for (int i = 2; i <= 50; i += 2) {
                System.out.println(i);
                somma += i; 
            }
    
            System.out.println("La somma dei numeri e': " + somma);
        }
    }
    


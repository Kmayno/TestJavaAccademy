import java.util.Scanner;

public class esercizioTest1extra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci l'inizio dell'intervallo: ");
        int start = scanner.nextInt();
        System.out.print("Inserisci la fine dell'intervallo: ");
        int end = scanner.nextInt();
        int sum = 0;
        
        System.out.println("Numeri pari tra " + start + " e " + end + ":");
        
        for (int i = (start % 2 == 0 ? start : start + 1); i <= end; i += 2) { 
            System.out.print(i + " ");
            sum += i; 
            
            System.out.println("\nVuoi continuare? (1 per Sì, 0 per No): ");
            System.out.println("1) Si.");
            System.out.println("2) No.");

            int response = scanner.nextInt();
            if (response != 1) {
                break;
            }
        }
        
        System.out.println("\nSomma dei numeri pari: " + sum);
        scanner.close();
    }
}

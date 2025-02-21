import java.util.ArrayList;
import java.util.Scanner;

public class esercizioTest2 {
    // Liste per memorizzare le informazioni degli utenti
    private static ArrayList<String> names = new ArrayList<>(); // Memorizza i nomi degli utenti
    private static ArrayList<String> passwords = new ArrayList<>(); // Memorizza le password
    private static ArrayList<String> secretQuestions = new ArrayList<>(); // Memorizza le domande segrete
    private static ArrayList<String> secretAnswers = new ArrayList<>(); // Memorizza le risposte alle domande segrete
    private static Scanner scanner = new Scanner(System.in); // Scanner per input utente

    public static void main(String[] args) {
        while (true) {
            // Menu principale
            System.out.println("\n1. Registrati\n2. Login\n3. Esci");
            System.out.print("Scelta: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    registerUser(); 
                    break;
                case 2:
                    loginUser(); 
                    break;
                case 3:
                    System.out.println("Uscita...");
                    return; 
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }

    private static void registerUser() {
        System.out.print("Inserisci il tuo nome: ");
        String name = scanner.nextLine();

        // Controlla se il nome utente esiste già
        if (names.contains(name)) {
            System.out.println("Nome utente già in uso.");
            return;
        }

        System.out.print("Inserisci la password: ");
        String password = scanner.nextLine();

        System.out.print("Inserisci una domanda segreta: ");
        String secretQuestion = scanner.nextLine();

        System.out.print("Inserisci la risposta alla domanda segreta: ");
        String secretAnswer = scanner.nextLine();

        // Salva i dati utente
        names.add(name);
        passwords.add(password);
        secretQuestions.add(secretQuestion);
        secretAnswers.add(secretAnswer);

        System.out.println("Registrazione completata!");
    }

    private static void loginUser() {
        System.out.print("Nome utente: ");
        String name = scanner.nextLine();
        // Trova l'indice dell'utente
        int index = names.indexOf(name); 

        // Controlla se l'utente esiste
        if (index == -1) {
            System.out.println("Utente non trovato.");
            return;
        }

        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Controlla se la password è corretta
        if (!passwords.get(index).equals(password)) {
            System.out.println("Password errata.");
            return;
        }

        System.out.println("Login riuscito!");
        userMenu(index); // Accede al menu utente
    }

    private static void userMenu(int index) {
        while (true) {
            // Menu per modificare credenziali o effettuare il logout
            System.out.println("\n1. Modifica credenziali\n2. Logout");
            System.out.print("Scelta: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // Modifica credenziali
                modifyUser(index); 
            } else if (choice == 2) {
                System.out.println("Logout...");
                // Esce dal menu utente
                return; 
            } else {
                System.out.println("Scelta non valida.");
            }
        }
    }

    private static void modifyUser(int index) {
        // Verifica la risposta alla domanda segreta prima di consentire le modifiche
        System.out.println("Rispondi alla tua domanda segreta: " + secretQuestions.get(index));
        System.out.print("Risposta: ");
        String answer = scanner.nextLine();

        if (!secretAnswers.get(index).equalsIgnoreCase(answer)) {
            System.out.println("Risposta errata. Impossibile modificare le credenziali.");
            return;
        }

        // Permette all'utente di modificare le proprie credenziali
        System.out.print("Nuova password: ");
        String newPassword = scanner.nextLine();

        System.out.print("Nuova domanda segreta: ");
        String newSecretQuestion = scanner.nextLine();

        System.out.print("Nuova risposta alla domanda segreta: ");
        String newSecretAnswer = scanner.nextLine();

        // Aggiorna i dati dell'utente
        passwords.set(index, newPassword);
        secretQuestions.set(index, newSecretQuestion);
        secretAnswers.set(index, newSecretAnswer);

        System.out.println("Credenziali aggiornate con successo!");
    }
}

import java.util.Scanner;

public class Main {
    static Integer[] numeric = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    static String[] alphabetic = {"een", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "nul"};

    public static void main(String[] args) {

        // Hier mag je je code schrijven voor de hoofd-opdracht
        Translator translate = new Translator(numeric, alphabetic);
        boolean play = true;
        String ongeldig = "ongeldige invoer";
        String input;
        int number;
        Scanner scanner = new Scanner(System.in);
        while (play) {
            System.out.printf("Type een cijfer in van 0 t/m 9 om te vertalen\nof letter 'x' om te stoppen:\n");
            input = scanner.nextLine().trim().toLowerCase();
            if (input.length() == 1) {
                if (input.equals("x")) {
                    play = false;
                } else {
                    try {
                        number = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println(ongeldig);
                        number = -1;
                    }
                    if (number >= 0) {
                        System.out.printf("De vertaling van %d is %s.\n",
                                number, translate.translate(number));
                    }
                }
            } else {
                System.out.println(ongeldig);
            }
        }
    }
}

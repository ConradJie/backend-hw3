import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Bonus {

    public static void main(String[] args) {

        // Onderstaande code is uitgecommentarieerd. Haal de code uit de comment (delete /* en */) om aan de slag te gaan met de bonus
        // In de code staan op verschillende plekken comments tussen "/*...*/" als hint wat je moet doen

        boolean solved;
        HashSet<Integer> secretnumber = randomnumbergenerator();
        String stringnumber = setToStringConverter(secretnumber);
//        System.out.println(stringnumber);
        do {
            solved = feedback(stringnumber);
        }
        while (!solved);
    }

    public static HashSet<Integer> randomnumbergenerator() {
         /*
        Vul hier de body van de methode in.

        Stappenplan:
        - Maak een nieuwe variabele van type Random. (Tip: Zoek op internet hoe je Random kunt gebruiken)
        - Maak een nieuwe variabele van type HashSet.
        - Schrijf een while-loop om 4 random nummers aan de hashset toe te voegen
        - return de hashset
         */
        Random random = new Random();
        HashSet<Integer> randomSet = new HashSet<>();
        while (randomSet.size() < 4) {
            randomSet.add(random.nextInt(10));
        }
        return randomSet;
    }

    public static String setToStringConverter(HashSet<Integer> secretnumbers) {
        /*
        Vul hier de body van de methode in.

        Stappenplan:
        - Maak als eerst een String variabele met als waarde een lege String. (of gebruik een StringBuilder)
        - Schrijf vervolgens een for-loop om de items in de hashset een voor een aan de String variabele toe te voegen.
        - Return de (gevulde) String variabele
         */
//        String stringNumber = "";
//        for (Integer number : secretnumbers) {
//            stringNumber += number.toString();
//        }
//        return stringNumber;
        StringBuilder stringNumber = new StringBuilder();
        for (Integer number : secretnumbers) {
            stringNumber.append(number.toString());
        }
        return stringNumber.toString();
    }


    public static boolean feedback(String stringnumber) {
        boolean solved = false;
        Scanner scanner = new Scanner(System.in);
        StringBuilder feedback = new StringBuilder();
        System.out.println("+ = juiste nummer op de juiste plek, O = juiste nummer verkeerde plek, X = verkeerde nummer");
        System.out.println("Doe een gok, Let op vul 4 getallen in.");
        String guess = scanner.nextLine();

        //Aanvullen met spaties als er minder dan 4 karakters zijn ingevuld
        for (int i = guess.length(); i < 4; i++) {
            guess += " ";
        }
        if (Objects.equals(guess, stringnumber)) {
            System.out.println("gefeliciteerd je hebt het goed");
            solved = true;
        } else {
            for (int i = 0; i < 4; i++) {
                if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                    feedback.append("+");
                } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                    feedback.append("0");
                } else {
                    feedback.append("X");
                }
            }
        }
        System.out.println(feedback.toString());
        return solved;
    }
}

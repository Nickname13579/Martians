import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------");
        System.out.println("Helping the Martians");
        System.out.println("----------------------------");

        int distance_ship_city = 7;
        int ship_location = 1;
        int amount_boxes = 3;
        int correct_guesses = 0;
        int show_correct_guesses = 0;
        int amount_attempts = 0;

        int[] lost_locations_cargos = new int[amount_boxes];
        change_locations_cargos(lost_locations_cargos, amount_boxes, distance_ship_city, ship_location);

        while(show_correct_guesses < 3) {
            System.out.println("Enter Locations of cargos: ");

            int[] enter_locations_cargos = new int[amount_boxes];

            for (int i = 0; i < amount_boxes; i++) {
                enter_locations_cargos[i] = scanner.nextInt();
                if (enter_locations_cargos[i] > 7 || enter_locations_cargos[i] < 1) {
                    System.out.println("Invalid Input");
                    System.exit(1);
                }
            }

            show_correct_guesses = return_correct_guesses(amount_boxes, lost_locations_cargos, enter_locations_cargos, correct_guesses);
            System.out.println("Amount of correct guesses: " + show_correct_guesses);
            amount_attempts++;

            if(amount_attempts == 5){
                System.out.println("Too many attempts, cargos changed their locations");
                change_locations_cargos(lost_locations_cargos, amount_boxes, distance_ship_city, ship_location);
                amount_attempts = 0;
            }
        }

        System.out.println("Congratulations, you've found all the boxes!");
    }

    static void change_locations_cargos(int[] lost_locations_cargos, int amount_boxes, int distance_ship_city, int ship_location){
        Random random = new Random();
        for(int i = 0; i < amount_boxes; i++){
            lost_locations_cargos[i] = random.nextInt((distance_ship_city - ship_location + 1)) + ship_location;
        }

        for(int i = 1; i < amount_boxes; i++){
            while (lost_locations_cargos[i - 1] == lost_locations_cargos[i]){
                lost_locations_cargos[i] = random.nextInt((distance_ship_city - ship_location + 1)) + ship_location;
            }
        }

        System.out.println(lost_locations_cargos[0]);
        System.out.println(lost_locations_cargos[1]);
        System.out.println(lost_locations_cargos[2]);
    }

    static int return_correct_guesses(int amount_of_boxes, int[] lost_locations_cargos, int[] enter_locations_cargos, int correct_guesses){
        for(int i = 0; i < amount_of_boxes; i++){
            for(int j = 0; j < amount_of_boxes; j++){
                if(lost_locations_cargos[i] == enter_locations_cargos[j]){
                    correct_guesses++;
                    break;
                }
            }
        }

        return correct_guesses;
    }
}
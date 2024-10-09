import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("----------------------------");
        System.out.println("Helping the Martians");
        System.out.println("----------------------------");

        int distance_ship_city = 7;
        int ship_location = 0;
        int amount_of_boxes = 3;
        int correct_guesses = 0;
        int amount_of_attempts = 0;

        int[] lost_locations_of_cargos = new int[amount_of_boxes];
        change_locations_of_cargos(lost_locations_of_cargos, amount_of_boxes, distance_ship_city, ship_location);


        System.out.println("Enter Locations of cargos: ");

        int[] enter_locations_of_the_cargos = new int[amount_of_boxes];

        for(int i = 0; i < amount_of_boxes; i++){
            enter_locations_of_the_cargos[i] = scanner.nextInt();
        }

        int show_correct_guesses = return_correct_guesses(amount_of_boxes, lost_locations_of_cargos, enter_locations_of_the_cargos, correct_guesses);
        System.out.println(show_correct_guesses);

    }

    static void change_locations_of_cargos(int[] lost_locations_of_cargos, int amount_of_boxes, int distance_ship_city, int ship_location){
        Random random = new Random();
        for(int i = 0; i < amount_of_boxes; i++){
            lost_locations_of_cargos[i] = random.nextInt((distance_ship_city - ship_location + 1) - ship_location);
        }

        for(int i = 1; i < amount_of_boxes; i++){
            while (lost_locations_of_cargos[i - 1] == lost_locations_of_cargos[i]){
                lost_locations_of_cargos[i] = random.nextInt((distance_ship_city - ship_location + 1) - ship_location);
            }
        }

        System.out.println(lost_locations_of_cargos[0]);
        System.out.println(lost_locations_of_cargos[1]);
        System.out.println(lost_locations_of_cargos[2]);
    }

    static int return_correct_guesses(int amount_of_boxes, int[] lost_locations_of_cargos, int[] enter_locations_of_the_cargos, int correct_guesses){
        for(int i = 0; i < amount_of_boxes; i++){
            for(int j = 0; j < amount_of_boxes; j++){
                if(lost_locations_of_cargos[i] == enter_locations_of_the_cargos[j]){
                    correct_guesses++;
                }
            }
        }

        return correct_guesses;
    }
}
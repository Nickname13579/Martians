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
        int amount_of_attempts = 5;

        int location_first_cargo = random.nextInt((distance_ship_city - ship_location + 1) - ship_location);
        int location_second_cargo = random.nextInt((distance_ship_city - ship_location + 1) - ship_location);
        int location_third_cargo = random.nextInt((distance_ship_city - ship_location + 1) - ship_location);

        while(location_first_cargo == location_second_cargo){
            location_second_cargo = random.nextInt((distance_ship_city - ship_location + 1) - ship_location);
        }

        while(location_first_cargo == location_third_cargo){
            location_third_cargo = random.nextInt((distance_ship_city - ship_location + 1) - ship_location);
        }

        while(location_second_cargo == location_third_cargo){
            location_third_cargo = random.nextInt((distance_ship_city - ship_location + 1) - ship_location);
        }

        System.out.println(location_first_cargo);
        System.out.println(location_second_cargo);

        System.out.println("Enter Locations of cargos: ");

        int[] locations_of_the_cargos = new int[amount_of_boxes];

        for(int i = 0; i < amount_of_attempts; i++) {

            for(int j = 0; j < amount_of_boxes; j++){
                locations_of_the_cargos[j] = scanner.nextInt();
                if(locations_of_the_cargos[j] > distance_ship_city || locations_of_the_cargos[j] < ship_location){
                    System.out.println("Invalid Input");
                    System.exit(1);
                }
            }

            int amount_of_correct_guesses = 0;
            if (location_first_cargo == locations_of_the_cargos[0] || location_second_cargo == locations_of_the_cargos[0] || location_third_cargo == locations_of_the_cargos[0]) {
                amount_of_correct_guesses++;
            }
            if (location_first_cargo == locations_of_the_cargos[1] || location_second_cargo == locations_of_the_cargos[1] || location_third_cargo == locations_of_the_cargos[1]) {
                amount_of_correct_guesses++;
            }
            if (location_first_cargo == locations_of_the_cargos[2] || location_second_cargo == locations_of_the_cargos[2] || location_third_cargo == locations_of_the_cargos[2]) {
                amount_of_correct_guesses++;
            }

            System.out.println("Amount of correct locations: " + amount_of_correct_guesses);
        }

        System.out.println("Cargos suspected you and changed locations");
        location_first_cargo = random.nextInt((distance_ship_city - ship_location + 1) - ship_location);
        location_second_cargo = random.nextInt((distance_ship_city - ship_location + 1) - ship_location);
        location_third_cargo = random.nextInt((distance_ship_city - ship_location + 1) - ship_location);

        while(location_first_cargo == location_second_cargo){
            location_second_cargo = random.nextInt((distance_ship_city - ship_location + 1) - ship_location);
        }

        while(location_first_cargo == location_third_cargo){
            location_third_cargo = random.nextInt((distance_ship_city - ship_location + 1) - ship_location);
        }

        while(location_second_cargo == location_third_cargo){
            location_third_cargo = random.nextInt((distance_ship_city - ship_location + 1) - ship_location);
        }
    }
}
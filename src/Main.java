import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("----------------------------");
        System.out.println("Helping the Martians");
        System.out.println("----------------------------");

        int location_first_cargo = random.nextInt() % 7;
        int location_second_cargo = random.nextInt() % 7;
        int location_third_cargo = random.nextInt() % 7;

        int distance_ship_city = 7;
        int ship_location = 0;
        int amount_of_boxes = 3;

        int[] locations_of_the_cargos = new int[amount_of_boxes];

        for(int i = 0; i < amount_of_boxes; i++){
            locations_of_the_cargos[i] = scanner.nextInt();
            if(locations_of_the_cargos[i] > distance_ship_city || locations_of_the_cargos[i] < ship_location){
                System.out.println("Invalid Input");
                System.exit(1);
            }
        }


    }
}
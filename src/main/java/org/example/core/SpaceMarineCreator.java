package org.example.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.data.*;
import org.example.exception.InvalidInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceMarineCreator {
    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner1 = new Scanner(System.in);


    public SpaceMarine createSpaceMarine() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        try {
            String name;
            System.out.print("Enter Name: ");
            name = scanner.next();
            while (name == null) {
                System.out.print("Name cannot be null, Enter again: ");
                name = scanner.nextLine();
            }
            Long x;
            Double y;
            long health;
            boolean loyal;
            System.out.print("Enter x: ");
            while (scanner.nextLine() == null) {
                System.out.print("X cannot be null");
                x = scanner.nextLong();
            }
            x = scanner.nextLong();

            System.out.print("Enter y: ");
            while (scanner.nextLine() == null) {
                System.out.print("Y cannot be null");
                y = scanner.nextDouble();
            }
            y = scanner.nextDouble();

            System.out.print("Enter Health: ");
            while (scanner.nextLine() == null && scanner.nextInt() < 1) {
                System.out.print("health cannot be null");
                health = scanner.nextLong();
            }
            health = scanner.nextLong();


            Coordinates coordinates = new Coordinates(x, y);


            System.out.print("Enter loyal: ");
            while (scanner.nextLine() == null) {
                System.out.print("Loyal cannot be null");
                loyal = scanner.nextBoolean();
            }
            loyal = scanner.nextBoolean();

            Integer value = null;
            System.out.println("""
                    1. ASSAULT
                    2. INCEPTOR
                    3. LIBRARIAN
                    4. HELIX
                    5. APOTHECARY
                    """);
            System.out.print("Enter one of the numbers(Cannot be null): ");
            while (value == null) {
                value = scanner.nextInt();
            }
            AstartesCategory category = switch (value) {
                case 1 -> AstartesCategory.ASSAULT;
                case 2 -> AstartesCategory.INCEPTOR;
                case 3 -> AstartesCategory.LIBRARIAN;
                case 4 -> AstartesCategory.HELIX;
                case 5 -> AstartesCategory.APOTHECARY;
                default -> throw new InvalidInputException();

            };


            System.out.println("""
                    1. HEAVY_BOLTGUN
                    2. BOLT_RIFLE
                    3. GRAV_GUN
                    4. HEAVY_FLAMMER
                    """);
            System.out.print("Enter one of the numbers: ");
            int valueFor = scanner.nextInt();
            Weapon weapon = switch (valueFor) {
                case 1 -> Weapon.HEAVY_BOLTGUN;
                case 2 -> Weapon.BOLT_RIFLE;
                case 3 -> Weapon.GRAV_GUN;
                case 4 -> Weapon.HEAVY_FLAMER;
                default -> throw new InvalidInputException();
            };


            System.out.print("Enter Chapter name: ");
            String nameOfChapter = scanner.next();

            String parent = nameOfChapter + " parent";

            Chapter chapter = new Chapter(nameOfChapter, parent);

            return new SpaceMarine(
                    name,
                    coordinates,
                    health,
                    loyal,
                    category,
                    weapon,
                    chapter

            );
        } catch (InputMismatchException | InvalidInputException e) {
            System.out.println("Invalid input. Work with the collection will be finished");
        }


        return null;
    }
}

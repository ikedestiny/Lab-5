package org.example.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.data.*;
import org.example.exception.IllegalValueException;
import org.example.exception.InvalidInputException;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceMarineCreator {
    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner1 = new Scanner(System.in);


    public SpaceMarine createSpaceMarine() throws InvalidInputException, IllegalValueException {
        SpaceMarine spaceMarine = SpaceMarine.createPracticeObject();
        spaceMarine.setName(askForName());
        Long l = askForXCoordinate();
        Double d = askForYCoordinate();
        spaceMarine.setCoordinates(new Coordinates(l, d));
        spaceMarine.setHealth(askForHealth());
        spaceMarine.setLoyal(isLoyal());
        spaceMarine.setCategory(askForAstartesCategory());
        spaceMarine.setWeaponType(askForWeapon());
        var ch = new Chapter(askForNameOfChapter(), askForNameOfChapterParent());
        spaceMarine.setChapter(ch);
        return spaceMarine;

    }

    public String askForName() throws InvalidInputException {
        String name = "";
        System.out.print("Enter Marine name: ");
        try {
            while (name.trim().isEmpty()) {
                System.out.print("This value cannot be null: ");
                name = scanner.nextLine();
            }
            return name;
        } catch (InputMismatchException e) {
            throw new InvalidInputException();
        }

    }


    public Long askForXCoordinate() throws InvalidInputException {
        System.out.print("Enter X coordinate: ");
        try {
            Long n = scanner.nextLong();
            while ((n == null) || n < -285) {
                System.out.print("This value cannot be null a digit: ");
                n = scanner.nextLong();
            }
            return n;
        } catch (InputMismatchException e) {
            throw new InvalidInputException();
        }

    }

    public Double askForYCoordinate() throws InvalidInputException {
        System.out.print("Enter Y(Double) coordinate: ");

        try {
            Double y = scanner.nextDouble();
            while (y == null || y > 703) {
                System.out.print("This value cannot be null: ");
                y = scanner.nextDouble();
            }
            return y;
        } catch (InputMismatchException e) {
            throw new InvalidInputException();
        }
    }


    public long askForHealth() throws InvalidInputException {
        long health = 0;
        System.out.print("Enter health: ");
        try {
            while (scanner.nextLine().isEmpty() && health < 1) {
                System.out.println("Value of health has to be greater than one");
                health = scanner.nextLong();
            }
            return health;
        } catch (InputMismatchException e) {
            throw new InvalidInputException();
        }
    }

    public boolean isLoyal() throws InvalidInputException {
        try {
            System.out.println("Enter loyal (true or false): ");
            return scanner.nextBoolean();
        } catch (InputMismatchException e) {
            throw new InvalidInputException();
        }
    }


    public AstartesCategory askForAstartesCategory() throws InvalidInputException, IllegalValueException {
        try {
            Integer value = null;
            System.out.println("""
                    1. ASSAULT
                    2. INCEPTOR
                    3. LIBRARIAN
                    4. HELIX
                    5. APOTHECARY
                    """);
            System.out.print("Enter one of the numbers: ");
            while (scanner.nextLine().trim().isEmpty() && value == null) {
                System.out.print("The value cannot be null, enter again: ");
                value = scanner.nextInt();
            }
            AstartesCategory as = switch (value) {
                case 1 -> AstartesCategory.ASSAULT;
                case 2 -> AstartesCategory.INCEPTOR;
                case 3 -> AstartesCategory.LIBRARIAN;
                case 4 -> AstartesCategory.HELIX;
                case 5 -> AstartesCategory.APOTHECARY;
                default -> throw new InvalidInputException();

            };

            return as;
        } catch (NullPointerException | InputMismatchException e) {
            throw new IllegalValueException("The value you entered is not in the enum of catergory");
        }
    }

    public Weapon askForWeapon() throws InvalidInputException {
        System.out.println("""
                1. HEAVY_BOLTGUN
                2. BOLT_RIFLE
                3. GRAV_GUN
                4. HEAVY_FLAMMER
                """);
        System.out.print("Enter one of the numbers: ");
        int value = scanner.nextInt();
        Weapon as  = switch (value){
            case 1 -> Weapon.HEAVY_BOLTGUN;
            case 2 -> Weapon.BOLT_RIFLE;
            case  3 -> Weapon.GRAV_GUN;
            case 4 -> Weapon.HEAVY_FLAMER;
            default -> throw new InvalidInputException();
        };

        return  as;
    }

    public String askForNameOfChapter() throws InvalidInputException {
        try{
            System.out.print("Enter chapter name: ");
            return scanner1.nextLine();}catch (InputMismatchException e){
            throw new InvalidInputException();
        }
    }

    public String askForNameOfChapterParent() {
        System.out.print("Enter parent legion: ");
        return scanner.nextLine();
    }

    public SpaceMarine createFakeMarine() {
        return new SpaceMarine("name", new Coordinates(1L, 2.0), 34, true, AstartesCategory.HELIX, Weapon.BOLT_RIFLE, new Chapter("name", "parent"));
    }

    public void checkForNull() throws InvalidInputException {
        if (scanner.nextLine().isEmpty()) {
            throw new InvalidInputException();
        }
    }

}

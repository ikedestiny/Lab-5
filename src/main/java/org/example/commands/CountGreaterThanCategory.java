package org.example.commands;

import org.example.core.CollectionManager;
import org.example.core.Commander;
import org.example.data.AstartesCategory;
import org.example.data.SpaceMarine;
import org.example.exception.InvalidInputException;

import java.util.Scanner;

public class CountGreaterThanCategory extends Command{
    private final CollectionManager collectionManager;
    Scanner scanner = new Scanner(System.in);

    public CountGreaterThanCategory(Commander commander) {
        super("CountGreaterThanCategory",
                "display the number of elements whose category field value is greater than the specified one");
        this.collectionManager = commander.getCollectionManager();
    }

    @Override
    public boolean execute() {
        int count =0;
        try {
            AstartesCategory category =askForAstartesCategory();
            for(SpaceMarine sp : this.collectionManager.getPriorityQueue()){
                if(sp.getCategory().ordinal()>category.ordinal()){
                    count++;
                }
            }
            System.out.println(count);
        } catch (InvalidInputException e) {
            System.out.println("Wrong input type");
        }
        return true;
    }


    public AstartesCategory askForAstartesCategory() throws InvalidInputException {
        System.out.println("""
                1. ASSAULT
                2. INCEPTOR
                3. LIBRARIAN
                4. HELIX
                5. APOTHECARY
                """);
        System.out.print("Enter one of the numbers: ");

        int value = scanner.nextInt();
        AstartesCategory as  = switch (value){
            case 1 -> AstartesCategory.ASSAULT;
            case 2 -> AstartesCategory.INCEPTOR;
            case  3 -> AstartesCategory.LIBRARIAN;
            case 4 -> AstartesCategory.HELIX;
            case 5 -> AstartesCategory.APOTHECARY;
            default -> throw new InvalidInputException();

        };

        return  as;
    }
}

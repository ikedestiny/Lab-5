package org.example.commands;

import org.example.core.CollectionManager;
import org.example.core.Commander;
import org.example.data.AstartesCategory;
import org.example.data.SpaceMarine;

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
    public boolean execute(String argument) {
        int count = 0;

        for (AstartesCategory as : AstartesCategory.values()) {
            if (as.name().equalsIgnoreCase(argument.trim())) {
                AstartesCategory s = as;
                for (SpaceMarine sp : this.collectionManager.getPriorityQueue()) {
                    if (sp.getCategory().ordinal() > s.ordinal()) {
                        count++;
                    }
                }
                System.out.println(count);
                return true;
            }
        }
        System.out.println("NO SUCH CATEGORY");
        return false;
    }
}

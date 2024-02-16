package org.example.commands;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.core.Commander;

import java.util.ArrayList;

@Getter
@Setter
public class History extends Command {
    private Commander commander;
    public History(Commander commander) {
        super("history", " Print the last 15 commands (without their arguments)");
        this.commander = commander;
    }

    @Override
    public boolean execute() {
       int size = this.getCommander().getHistory().size();
       if (size>15){
           for (int i = size-15;i<=size-1;i++){
               System.out.println(this.getCommander().getHistory().get(i));
           }
       }else{
           this.getCommander().getHistory().forEach(System.out::println);
       }
        return  true;
    }
}

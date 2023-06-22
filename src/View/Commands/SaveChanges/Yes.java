package View.Commands.SaveChanges;

import View.Console;

public class Yes implements Savable{
    private Console console;

    public Yes(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        return "Да";
    }

    @Override
    public void execute() {
        console.save();
    }
}

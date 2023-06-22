package View.Commands;

import View.Console;

public class Exit implements Commandable{
    private Console console;

    public Exit(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        String desc = "Выход";
        return desc;
    }

    @Override
    public void execute() {
        console.exit();
    }
}

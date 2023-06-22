package View.Commands;

import View.Console;

public class ShowToys implements Commandable{
    private Console console;

    public ShowToys(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        String desc = "Показать список игрушек";
        return desc;
    }

    @Override
    public void execute() {
        console.showInfo();
    }
}

package View.Commands.AdminMenu;

import View.Console;

public class AdminAddToy implements Adminable{
    private Console console;

    public AdminAddToy(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        return "Добавить игрушку";
    }

    @Override
    public void execute() {
        console.addToy();
    }
}

package View.Commands.AdminMenu;

import View.Console;

public class AdminDelete implements Adminable{
    private Console console;

    public AdminDelete(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        return "Удалить игрушку";
    }

    @Override
    public void execute() {
        console.delete();
    }
}

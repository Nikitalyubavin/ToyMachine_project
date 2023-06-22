package View.Commands.AdminMenu;

import View.Console;

public class AdminShowInfo implements Adminable{
    private Console console;

    public AdminShowInfo(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        return "Расширенный список игрушек";
    }

    @Override
    public void execute() {
        console.adminShowInfo();
    }
}

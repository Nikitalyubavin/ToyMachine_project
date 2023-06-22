package View.Commands.AdminMenu;

import View.Console;

public class AdminBackToMenu implements Adminable{
    private Console console;

    public AdminBackToMenu(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        return "В основное меню";
    }

    @Override
    public void execute() {
        console.startMenu();
    }
}

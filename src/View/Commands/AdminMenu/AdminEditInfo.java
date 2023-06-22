package View.Commands.AdminMenu;

import View.Console;

public class AdminEditInfo implements Adminable{
    private Console console;

    public AdminEditInfo(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        return "Редактировать информацию";
    }

    @Override
    public void execute() {
        console.edit();
    }
}

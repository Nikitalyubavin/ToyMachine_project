package View.Commands.AdminMenu.EditMenu;

import View.Console;

public class BackToAdminMenu implements Editable{
    private Console console;

    public BackToAdminMenu(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        return "В меню администратора";
    }

    @Override
    public void execute(int index) {
        console.admin();
    }
}

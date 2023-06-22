package View.Commands.AdminMenu.EditMenu;

import View.Console;

public class ChangeDesc implements Editable{
    private Console console;

    public ChangeDesc(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        return "Изменить описание";
    }

    @Override
    public void execute(int index) {
        console.changeDesc(index);
    }
}

package View.Commands.AdminMenu.EditMenu;

import View.Console;

public class ChangeQuantity implements Editable{
    private Console console;

    public ChangeQuantity(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        return "Изменить количество";
    }

    @Override
    public void execute(int index) {
        console.changeQuantity(index);
    }
}

package View.Commands.AdminMenu.EditMenu;

import View.Console;

public class ChangeRate implements Editable{
    private Console console;

    public ChangeRate(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        return "Изменить вероятность выпадения";
    }

    @Override
    public void execute(int index) {
        console.changeRate(index);
    }
}

package View.Commands.AdminMenu.EditMenu;

import View.Console;

public class ChangeName implements Editable{
    private Console console;

    public ChangeName(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        return "Изменить навание";
    }

    @Override
    public void execute(int index) {
        console.changeName(index);

    }
}

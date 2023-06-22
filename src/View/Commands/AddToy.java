package View.Commands;
import View.Console;

public class AddToy implements Commandable{
    private Console console;

    public AddToy(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        String desc = "Добавить игрушку";
        return desc;
    }

    @Override
    public void execute() {
        console.addToy();
    }
}

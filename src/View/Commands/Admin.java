package View.Commands;
import View.Console;

public class Admin implements Commandable{
    private Console console;

    public Admin(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        String desc = "Меню администратора";
        return desc;
    }

    @Override
    public void execute() {
        console.admin();
    }
}

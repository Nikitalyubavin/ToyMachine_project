package View.Commands.SaveChanges;

import View.Console;

public class No implements Savable{
    private Console console;

    public No(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        return "Нет";
    }

    @Override
    public void execute() {
        console.quit();
    }
}

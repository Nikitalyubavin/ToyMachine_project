package View.Commands;

import View.Console;

public class Play implements Commandable{
    private Console console;

    public Play(Console console) {
        this.console = console;
    }

    @Override
    public String print() {
        String desc = "Разыграть игрушку";
        return desc;
    }

    @Override
    public void execute() {
        console.play();
    }
}

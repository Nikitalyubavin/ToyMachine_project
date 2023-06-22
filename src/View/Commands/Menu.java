package View.Commands;

import View.Console;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Commandable> commands;
    private Console console;

    public Menu(Console console) {
        this.commands = new ArrayList<>();
        commands.add(new Play(console));
        commands.add(new Admin(console));
        commands.add(new ShowToys(console));
        commands.add(new Exit(console));
    }

    public void start(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= commands.size(); i++){
            sb.append(i + ". " + commands.get(i-1).print() + "\n");
        }
        System.out.println(sb);
    }

    public void execute(int choice){
        commands.get(choice - 1).execute();
    }

    public int getSize() {
        return commands.size();
    }
}

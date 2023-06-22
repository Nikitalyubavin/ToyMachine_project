package View.Commands.SaveChanges;

import View.Commands.AdminMenu.EditMenu.Editable;
import View.Console;

import java.util.ArrayList;

public class SaveMenu {
    private ArrayList<Savable> saving;
    private Console console;

    public SaveMenu(Console console) {
        this.saving = new ArrayList<>();
        saving.add(new Yes(console));
        saving.add(new No(console));
    }
    public void start(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= saving.size(); i++){
            sb.append(i + ". " + saving.get(i-1).print() + "\n");
        }
        System.out.println(sb);
    }
    public void execute(int choice){
        saving.get(choice - 1).execute();
    }
    public int getSize() {
        return saving.size();
    }
}

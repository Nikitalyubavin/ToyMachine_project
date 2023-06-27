package View.Commands.AdminMenu.EditMenu;

import View.Commands.*;
import View.Console;

import java.util.ArrayList;

public class EditMenu {
    private ArrayList<Editable> edit;
    private Console console;

    public EditMenu(Console console) {
        this.edit = new ArrayList<>();
        edit.add(new ChangeName(console));
        edit.add(new ChangeDesc(console));
        edit.add(new ChangeQuantity(console));
        edit.add(new ChangeRate(console));
        edit.add(new BackToAdminMenu(console));
    }

    public void start(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= edit.size(); i++){
            sb.append(i + ". " + edit.get(i-1).print() + "\n");
        }
        System.out.println(sb);
    }

    public void execute(int index, int choice){
        edit.get(choice - 1).execute(index);
    }

    public int getSize() {
        return edit.size();
    }
}

package View.Commands.AdminMenu;

import View.Console;

import java.util.ArrayList;

public class AdminSubMenu {
    private ArrayList<Adminable> adm;
    private Console console;

    public AdminSubMenu(Console console) {
        this.adm = new ArrayList<>();
        adm.add(new AdminShowInfo(console));
        adm.add(new AdminEditInfo(console));
        adm.add(new AdminAddToy(console));
        adm.add(new AdminDelete(console));
        adm.add(new AdminBackToMenu(console));
    }
    public void start(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= adm.size(); i++){
            sb.append(i + ". " + adm.get(i-1).print() + "\n");
        }
        System.out.println(sb);
    }

    public void execute(int admChoice) {
        adm.get(admChoice-1).execute();
    }
    public int admMenuSize(){
        return adm.size();
    }
}

package View;

import Presenter.Presenter;
import View.Commands.Menu;
import java.util.Scanner;


public class Console {
    boolean var;
    private Scanner sc;
    private Menu menu;
    private Presenter presenter;

    public Console(Presenter presenter) {
        this.menu = new Menu(this);
        this.presenter = presenter;
        this.sc = new Scanner(System.in);
        this.var = true;
    }
    public void startMenu(){
        System.out.println("Вас приветствует игровой автомат! " +
                "Мы готовы подарить Вам незабываемую игрушку! " +
                "Все зависит от Вашей удачи! ;)\n");
        System.out.println("В нашем автомате представлены следующие игрушки:");
        presenter.showInfo();
        while (work()){
            menu.start();
            System.out.print("Ваш выбор: ");
            int choice = Integer.parseInt(sc.nextLine());
            menu.execute(choice);
        }

    }

    private boolean work() {
        return var;
    }

    public void addToy() {
        System.out.print("Введите название игрушки: ");
        String name = sc.nextLine();
        System.out.print("Введите описание игрушки: ");
        String desc = sc.nextLine();
        System.out.print("Введите частоту выпадения игрушки: ");
        Integer rate = Integer.parseInt(sc.nextLine());
        presenter.addToy(name, desc, rate);
    }

    public void play() {
        System.out.print("Вам выпала игрушка: ");
        presenter.play();
    }

    public void exit() {
        this.var = false;
    }

    public void showInfo() {
        presenter.showInfo();
    }
}

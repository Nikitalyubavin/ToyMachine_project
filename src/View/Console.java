package View;

import Presenter.Presenter;
import View.Commands.AdminMenu.AdminSubMenu;
import View.Commands.AdminMenu.EditMenu.EditMenu;
import View.Commands.Menu;
import View.Commands.SaveChanges.SaveMenu;

import java.util.Scanner;


public class Console {
    boolean var;
    private Scanner sc;
    private Menu menu;
    private Presenter presenter;
    private AdminSubMenu adm;
    private EditMenu editMenu;
    private SaveMenu saving;

    public Console(Presenter presenter) {
        this.menu = new Menu(this);
        this.adm = new AdminSubMenu(this);
        this.editMenu = new EditMenu(this);
        this.saving = new SaveMenu(this);
        this.presenter = presenter;
        this.sc = new Scanner(System.in);
        this.var = true;
    }
    public void title(){
        System.out.println("Вас приветствует игровой автомат! " +
                "Мы готовы подарить Вам незабываемую игрушку! " +
                "Все зависит от Вашей удачи! ;)\n");
        System.out.println("В нашем автомате представлены следующие игрушки:");
        presenter.showInfo();
    }
    public void startMenu(){
        while (work()){
            menu.start();
            System.out.print("Ваш выбор: ");
            String choice = sc.nextLine();
            if (check(choice)) {
                menu.execute(Integer.parseInt(choice));
            } else {
                System.out.println("Такой опции не существует! " +
                        "Посмотрите внимательнее меню и выберете ещё раз!");
            }
        }

    }
    private boolean check(String text){
        return (text.matches("[0-9]+") && Integer.parseInt(text) <= menu.getSize() && Integer.parseInt(text) > 0);
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
        String rating = sc.nextLine();
        int rate = 10;
        if (checkRate(rating)) {
            rate = Integer.parseInt(rating);
        }
        System.out.print("Введите количество данных игрушек: ");
        String quan = sc.nextLine();
        int quantity = 1;
        if (checkQuantity(quan)) {
            quantity = Integer.parseInt(quan);
        }
        presenter.addToy(name, desc, rate, quantity);
    }

    private boolean checkQuantity(String text) {
        return (text.matches("[0-9]+") && Integer.parseInt(text) > 0);
    }

    private boolean checkRate(String text) {
        return (text.matches("[0-9]+") && Integer.parseInt(text) <= 10 && Integer.parseInt(text) > 0);
    }

    public void play() {
        if (presenter.checkList()){
            System.out.print("Вам выпала игрушка: ");
            presenter.play();
        } else {
            System.out.println("Наш автомат пуст... Попробуйте в другой раз! ;)");
        }
    }

    public void exit() {
        System.out.println("Сохранить изменения?");
        saving.start();
        System.out.print("Ваш выбор: ");
        String ans = sc.nextLine();
        if (checkMenu(ans)){
            saving.execute(Integer.parseInt(ans));
        } else {
            System.out.println("Программа Вас не поняла... " +
                    "Изменения будут сохранены автоматически!");
            save();
        }
    }

    private boolean checkMenu(String text) {
        return (text.matches("[0-9]+") && Integer.parseInt(text) <= saving.getSize() && Integer.parseInt(text) > 0);
    }

    public void showInfo() {
        presenter.showInfo();
    }

    public void admin() {
        System.out.println("Вы в системном меню. Вам доступны следующие действия:");
        while (work()){
            adm.start();
            System.out.print("Ваш выбор: ");
            String admChoice = sc.nextLine();
            if (checkAdmin(admChoice)) {
                adm.execute(Integer.parseInt(admChoice));
            } else {
                System.out.println("Такой опции не существует! " +
                        "Посмотрите внимательнее меню и выберете ещё раз!");
            }
        }
    }

    private boolean checkAdmin(String text) {
        return (text.matches("[0-9]+") && Integer.parseInt(text) <= adm.admMenuSize() && Integer.parseInt(text) > 0);
    }

    public void adminShowInfo() {
        presenter.adminShowInfo();
    }

    public void edit() {
        if (presenter.checkList()){
            adminShowInfo();
            String ans = null;
            while (work()){
                System.out.print("Выберите игрушку: ");
                ans = sc.nextLine();
                if (checkToy(ans)){
                    break;
                } else {
                    System.out.println("Выбранной Вами игрушки не существует! " +
                            "Попробуйте ещё раз.");
                }
            }
            editMenu.start();
            while (work()){
                System.out.print("Выберите, что хотите поменять: ");
                String choice = sc.nextLine();
                if (checkChoice(choice)){
                    editMenu.execute(Integer.parseInt(ans), Integer.parseInt(choice));
                    break;
                } else {
                    System.out.println("Такой опции не существует! " +
                            "Посмотрите внимательнее меню и выберете ещё раз!");
                }
            }
        } else {
            System.out.println("В автомате нет игрушек...");
        }
    }

    private boolean checkChoice(String text) {
        return (text.matches("[0-9]+") && Integer.parseInt(text) <= editMenu.getSize() && Integer.parseInt(text) > 0);
    }

    public int toyListGetSize(){
        return presenter.toyListGetSize();
    }
    private boolean checkToy(String text){
        return (text.matches("[0-9]+") && Integer.parseInt(text) <= toyListGetSize() && Integer.parseInt(text) > 0);
    }

    public void changeName(int index) {
        System.out.print("Название: ");
        String name = sc.nextLine();
        presenter.changeName(index, name);
    }

    public void changeDesc(int index) {
        System.out.print("Описание: ");
        String desc = sc.nextLine();
        presenter.changeDesc(index, desc);
    }

    public void changeRate(int index) {
        System.out.println("Вероятность выпадения: ");
        String rate = sc.nextLine();
        if (!checkRate(rate)){
            System.out.println("Неверно задано значение! Оно будет выставлено по умолчанию.");
            rate = "10";
        }
        presenter.changeRate(index, Integer.parseInt(rate));
    }

    public void save() {
        presenter.save();
        quit();
    }

    public void quit(){
        var = false;
        System.out.println("До новых встреч!");
    }

    public void delete() {
        if (presenter.checkList()){
            adminShowInfo();
            String ans = null;
            while (work()){
                System.out.print("Выберите игрушку, которую хотите удалить: ");
                ans = sc.nextLine();
                if (checkToy(ans)){
                    break;
                } else {
                    System.out.println("Выбранной Вами игрушки не существует! " +
                            "Попробуйте ещё раз.");
                }
            }
            presenter.delete(Integer.parseInt(ans));
        } else {
            System.out.println("В автомате нет игрушек...");
        }
    }
}

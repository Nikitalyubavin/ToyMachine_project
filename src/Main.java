import Model.Service;
import Model.ToyMachine;
import Model.WorkWithFiles.Filer;
import Presenter.Presenter;
import View.Console;

import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) {
        ToyMachine tm = new ToyMachine();
        Service service = new Service(tm);
        service.addToy("Мишка", "Мягкая игрушка", 6, 4);
        service.addToy("Жираф", "Мягкая игрушка", 6, 2);
        service.addToy("Заяц", "Мягкая игрушка", 6, 10);
        service.addToy("Волк", "Мягкая игрушка", 6, 7);
        service.addToy("Лошадь", "Мягкая игрушка", 6, 3);
        service.addToy("Корова", "Мягкая игрушка", 6, 5);
        service.addToy("Фрукты и овощи", "Набор", 3, 2);
        service.addToy("Детская посуда", "Набор", 3, 3);
        service.addToy("Автомат", "Игрушка", 3, 3);
        service.addToy("Лего", "Конструктор", 1, 1);

        service.setWritable(new Filer());
//        service.load();
        Presenter presenter = new Presenter(service);
        Console console = new Console(presenter);
        console.title();
        console.startMenu();
    }
}
package Model;

public class Service {
    private int id = 1;
    private ToyMachine tm;

    public Service() {
        this.tm = new ToyMachine();
    }

    public void play() {
        tm.play();
    }

    public void addToy(String name, String desc, Integer rate) {
        if (desc == null){
            tm.addToy(new Toys(id++, rate, name));
        }
        else{
            tm.addToy(new Toys(id++, rate, name, desc));
        }
    }

    public void showInfo() {
        System.out.println(tm.showInfo());
    }
}

package Model;

import Model.WorkWithFiles.Writable;

public class Service {
    private int id = 1;
    private Writable writable;
    private final String filePath = "Toys.txt";
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

    public void adminShowInfo() {
        System.out.println(tm.adminShowInfo());
    }

    public int toyListGetSize() {
        return tm.toyListGetSize();
    }

    public void changeName(int index, String name) {
        tm.changeName(index, name);
    }

    public void changeDesc(int index, String name) {
        tm.changeDesc(index, name);
    }

    public void changeRate(int index, int rate) {
        tm.changeRate(index, rate);
    }
    public boolean save(){
        if (writable == null){
            return false;
        }
        return writable.save(tm, filePath);
    }
    public boolean load(){
        if (writable == null){
            return false;
        }
        tm = (ToyMachine) writable.read(filePath);
        return true;
    }
    public void setWritable(Writable writable) {
        this.writable = writable;
    }
}


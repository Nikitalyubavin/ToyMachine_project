package Presenter;

import Model.Service;

public class Presenter {
    private Service service;

    public Presenter(Service service) {
        this.service = service;
    }

    public Presenter() {
        this.service = new Service();
    }

    public void addToy(String name, String desc, Integer rate, Integer quantity) {
        service.addToy(name, desc, rate, quantity);
    }

    public void play() {
        service.play();
    }

    public void showInfo() {
        service.showInfo();
    }

    public void adminShowInfo() {
        service.adminShowInfo();
    }

    public int toyListGetSize() {
        return service.toyListGetSize();
    }

    public void changeName(int index, String name) {
        service.changeName(index, name);
    }
    public void changeDesc(int index, String name) {
        service.changeDesc(index, name);
    }

    public void changeRate(int index, int rate) {
        service.changeRate(index, rate);
    }

    public void save() {
        service.save();
    }

    public void delete(int ans) {
        service.delete(ans);
    }

    public boolean checkList() {
        return service.checkList();
    }
}

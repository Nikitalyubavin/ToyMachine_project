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

    public void addToy(String name, String desc, Integer rate) {
        service.addToy(name, desc, rate);
    }

    public void play() {
        service.play();
    }

    public void showInfo() {
        service.showInfo();
    }
}

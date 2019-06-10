package cn.nzy.DesignPattern.Observer;

/**
 * Created by nizy on 2019/3/13.
 */
public class Observer2 implements Observer {

    @Override
    public void update() {
        System.out.println("observer2 has received!");
    }
}

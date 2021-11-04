package RedSocialTest.Model;

import Network.ObserverPattern.IObservable;
import Network.ObserverPattern.IObserver;

import java.util.ArrayList;

public class Post implements IObservable {
    int id;
    String content;
    ArrayList<IObserver> observers;

    public Post(int id,String content){
        this.id = id;
        this.content = content;
    }

    @Override
    public void updateAll() {
        for (IObserver observer:observers) {
            observer.update();
        }
    }

    @Override
    public void addObserver(IObserver observer) {
        this.observers.add(observer);
    }
}

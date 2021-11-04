package Network.ObserverPattern;

public interface IObservable {
    void updateAll();
    void addObserver(IObserver observer);
}

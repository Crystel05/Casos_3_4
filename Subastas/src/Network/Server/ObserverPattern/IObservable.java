package Network.Server.ObserverPattern;

import java.io.IOException;

public interface IObservable {
    void updateAll() throws IOException;
    void addObserver(IObserver observer);
}

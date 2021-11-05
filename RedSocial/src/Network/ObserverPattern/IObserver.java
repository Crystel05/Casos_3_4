package Network.ObserverPattern;

import java.io.IOException;

public interface IObserver {

    void update(IObservable observable) throws IOException;
}//Se le pasa al observer el observable con el que se llama.

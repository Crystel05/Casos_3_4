package Network.Response;

import java.io.Serializable;

public interface IResponse extends Serializable {
    Enum getType();
}

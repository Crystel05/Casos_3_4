package Network.Request;

import java.io.Serializable;

public interface IRequest extends  Serializable{
    Enum getType();
}

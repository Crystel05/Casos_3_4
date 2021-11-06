package Network.Request;

public class BaseRequest implements IRequest{

    protected Enum type;

    public BaseRequest(){

    }

    @Override
    public Enum getType() {
        return type;
    }
}

package Network.Response;

public class BaseResponse implements IResponse{

    protected Enum type;

    @Override
    public Enum getType() {
        return type;
    }
}

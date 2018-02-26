package Interface;

import java.io.Serializable;

public interface IMessage extends Serializable {

    public void setMessage(String message);

    public String getMessage();

    public void setClient(IClient client);

    public IClient getClient();
}

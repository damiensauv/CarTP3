package Interface;

import java.io.Serializable;

public interface IMessage extends Serializable {

    public void setMessage(String message);

    public void setClient(IClient client);
}

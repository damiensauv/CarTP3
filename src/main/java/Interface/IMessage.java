package Interface;

import java.io.Serializable;
import java.util.Date;

public interface IMessage extends Serializable {

    public String getMessage();

    public void setMessage(String message);

    public Date getTime();

    public void setTime(Date date);

    public IClient getClient();

    public void setClient(IClient client);
}

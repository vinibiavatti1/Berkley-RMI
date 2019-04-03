import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author vbiavatti
 */
public interface HorarioServidor extends Remote {
    
    public Date getHorario() throws RemoteException;
    public void setHorario(Date horario) throws RemoteException;
    
}

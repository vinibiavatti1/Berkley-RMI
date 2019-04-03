import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Interface para implementação de horário do servidor
 * @author vbiavatti
 */
public interface HorarioServidor extends Remote {
    
    /**
     * Obter horário
     * @return
     * @throws RemoteException 
     */
    public Date getHorario() throws RemoteException;
    
    /**
     * Sefinir novo horário
     * @param horario
     * @throws RemoteException 
     */
    public void setHorario(Date horario) throws RemoteException;
    
}

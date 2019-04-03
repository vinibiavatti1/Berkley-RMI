

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 *
 * @author vbiavatti
 */
public class HorarioServidorImpl extends UnicastRemoteObject implements HorarioServidor {

    private Date horario;
    
    public HorarioServidorImpl(Date horario) throws RemoteException {
        this.horario = horario;
    }

    @Override
    public Date getHorario() throws RemoteException {
        return horario;
    }

    @Override
    public void setHorario(Date horario) throws RemoteException {
        this.horario = horario;
    }

    
}

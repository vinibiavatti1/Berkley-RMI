import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Implementação de horario do servidor
 * @author vbiavatti
 */
public class HorarioServidorImpl extends UnicastRemoteObject implements HorarioServidor {

    /**
     * Horário do servidor
     */
    private Date horario;
    
    /**
     * Construir Horario Servidor
     * @param horario
     * @throws RemoteException 
     */
    public HorarioServidorImpl(Date horario) throws RemoteException {
        this.horario = horario;
    }

    @Override
    public Date getHorario() throws RemoteException {
        return horario;
    }

    @Override
    public void setHorario(Date horario) throws RemoteException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Horário atualizado: " + sdf.format(horario));
        this.horario = horario;
    }

    
}

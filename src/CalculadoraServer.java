

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author vbiavatti
 */
public interface CalculadoraServer extends Remote {
    
    public double somar(double x, double y) throws RemoteException;
    
}

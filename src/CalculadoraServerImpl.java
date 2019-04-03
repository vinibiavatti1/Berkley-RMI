

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author vbiavatti
 */
public class CalculadoraServerImpl extends UnicastRemoteObject implements CalculadoraServer {

    public CalculadoraServerImpl() throws RemoteException {
    }

    @Override
    public double somar(double x, double y) throws RemoteException {
        System.out.println("X: " + x + " Y: " + y);
        return x + y;
    }
    
}

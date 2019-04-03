
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author vbiavatti
 */
public class MainCliente {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1234);
            CalculadoraServer c = (CalculadoraServer) registry.lookup("CalculadoraServerImpl");
            System.out.println("O objeto servidor " + c + " foi encontradocom sucesso.\n");
            // vamos efetuar uma soma?
            System.out.println("A soma de 2 + 5 é: " + c.somar(2, 5));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}

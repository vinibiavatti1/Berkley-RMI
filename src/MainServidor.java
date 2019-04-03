/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author vbiavatti
 */
public class MainServidor {

    public static void main(String[] args) {
        try {
            CalculadoraServer sdrmi = new CalculadoraServerImpl();
            Registry registry = LocateRegistry.createRegistry(1234);
            registry.rebind("CalculadoraServerImpl", sdrmi);
            System.out.println("Servidor Calculadora " + sdrmi + " registrado e pronto para aceitar solicitações.");
        } catch (Exception ex) {
            System.out.println("Houve um erro: " + ex.getMessage());
        }
    }

}


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author vbiavatti
 */
public class MainCliente {

    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date horarioLocal = sdf.parse("05:10:05");
            System.out.println("Horário Local: " + sdf.format(horarioLocal));
            
            // Conexão Servidor 1
            Registry registry1 = LocateRegistry.getRegistry("localhost", MainServidor.PORTA_SERVIDOR_1);
            HorarioServidor hs1 = (HorarioServidor) registry1.lookup("HorarioServidorImpl");
            System.out.println("Conexão com Servidor 1 estabelecida com sucesso.");
            Date horarioServidor1 = hs1.getHorario();
            System.out.println("Horário: " + sdf.format(horarioServidor1));
            
            // Conexão Servidor 2
            Registry registry2 = LocateRegistry.getRegistry("localhost", MainServidor.PORTA_SERVIDOR_2);
            HorarioServidor hs2 = (HorarioServidor) registry2.lookup("HorarioServidorImpl");
            System.out.println("Conexão com Servidor 2 estabelecida com sucesso.");
            Date horarioServidor2 = hs2.getHorario();
            System.out.println("Horário: " + sdf.format(horarioServidor2));
            
            // Média (Berkeley)
            long minutosHorarioLocal = horarioLocal.getTime(); 
            long minutosHorarioServidor1 = horarioServidor1.getTime(); 
            long minutosHorarioServidor2 = horarioServidor2.getTime(); 
            long media = (minutosHorarioLocal + minutosHorarioServidor1 + minutosHorarioServidor2) / 3;
            Date horarioNovo = new Date(media);
            System.out.println("Média: " + sdf.format(horarioNovo));
            
            // Atribuir Data Nova
            hs1.setHorario(horarioNovo);
            hs2.setHorario(horarioNovo);
            horarioLocal = horarioNovo;
            
            // Verificar horario em todas as instâncias
            System.out.println("Horarios Local: " + sdf.format(horarioLocal));
            System.out.println("Horarios Servidor 1: " + sdf.format(hs1.getHorario()));
            System.out.println("Horarios Servidor 2: " + sdf.format(hs2.getHorario()));
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}

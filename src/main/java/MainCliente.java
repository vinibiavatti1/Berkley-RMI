import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Cliente
 * @author vbiavatti
 */
public class MainCliente {

    /**
     * Main
     * @param args 
     */
    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date horarioLocal = sdf.parse("19:00:00");

            // Lista de conexões
            List<Conexao> conexoes = new ArrayList<>();
            conexoes.add(new Conexao("10.13.12.249", 1234));
            conexoes.add(new Conexao("201.54.201.56", 12345));
            
            // Lista de horários
            Map<Conexao, HorarioServidor> servidores = new HashMap<>();
            for(Conexao c : conexoes) {
            	Registry registry = LocateRegistry.getRegistry(c.getIp(), c.getPorta());
                HorarioServidor hs = (HorarioServidor) registry.lookup("HorarioServidorImpl");
                System.out.println(String.format("Horário Servidor %s: %s", c.getIp(), sdf.format(hs.getHorario())));
                servidores.put(c, hs);
            }
            System.out.println("Horário Local: " + sdf.format(horarioLocal));

            // Média (Berkeley)
            int divisor = servidores.size() + 1;
            long somatorio = horarioLocal.getTime();
            for (Map.Entry<Conexao,HorarioServidor> entry : servidores.entrySet()) {
            	somatorio += entry.getValue().getHorario().getTime();
            }
            long media = somatorio / divisor;
            Date horarioNovo = new Date(media);
            System.out.println("Média: " + sdf.format(horarioNovo));
            
            // Atribuir Horário Novo
            for (Map.Entry<Conexao,HorarioServidor> entry : servidores.entrySet()) {
            	entry.getValue().setHorario(horarioNovo);
            	System.out.println(String.format("Horário Servidor %s: %s", entry.getKey().getIp(), sdf.format(entry.getValue().getHorario())));
            }
            horarioLocal = horarioNovo;
            System.out.println(String.format("Horário local: %s", sdf.format(horarioLocal)));
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}

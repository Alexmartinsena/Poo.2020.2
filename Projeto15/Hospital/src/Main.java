package hospital013;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Hospital hospital = new Hospital();

		while (true){
			String line = scanner.nextLine();
			System.out.println("$" + line);
			String ui[] = line.split(" ");
			
			if(ui[0].equals("end"))
				break;
			
			else if(ui[0].equals("addPac")){
				for(int i = 1; i < ui.length;i++){
					String dados[] = ui[i].split("-");
					hospital.addPaciente(new Paciente(dados[0], dados[1]));
				}
			}
            
			else if (ui[0].equals("addMed")){
				for(int i = 1; i < ui.length;i++){
					String dados[] = ui[i].split("-");
					hospital.addMedico(new Medico(dados[0], dados[1]));
				}
			}
            
			else if(ui[0].equals("show")){
				System.out.print(hospital.showAll());
			}
            
			else if(ui[0].equals("vinc")){
				for(int i = 2; i < ui.length;i++){
					hospital.vincular(ui[1], ui[i]);
				}
			}
		}
		
		scanner.close();
	
	}
}

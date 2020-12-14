import java.util.Scanner;

public class Carro {
	int nPessoas = 0; //atributos
	int maxPessoas = 5;
	int gasosa;
    int gasosaMax;
	int km;

	void embarcar() { //metodos
		
		if(nPessoas >= maxPessoas) {
			System.out.println("Ihhhhh, num vai dar nao pow");
			return;
		}
		else {
		System.out.println("Entra ai pow");
		nPessoas++;
		}
	}
	
	void desembarcar() {
		if(this.nPessoas <= maxPessoas) {
			nPessoas--;
			System.out.println("so tem " + this.nPessoas + " no carro");
			return;
		}
		else if(nPessoas == 0){
            System.out.println("Ta vazio");
        }
		
		
	}
	
	void show() {
		System.out.println("Carro: nPessoas = " + this.nPessoas);
	}

	//Abastecer o tanque 
    void abastecer(int Litros) {
        this.gasosa += Litros;
		if(this.gasosa > this.gasosaMax){
            this.gasosa = this.gasosaMax;
		System.out.println("Pronto pra rodar...\n");
		}
    }

    //Dirigir
    void dirigir(int distancia) {
        if(this.nPessoas == 0) {
            System.out.println("Vish,o motorista sumiu!\n");
            return;
        }
        if(this.gasosa == 0) {
            System.out.println("Te falta gasosa\n");
            return;
        }

        // Calculo do consumo.
        if(this.gasosa < distancia) {
            this.km += this.gasosa;
            System.out.println("A gasosa vai acabar depois de " + this.gasosa + " km\n");
            this.gasosa = 0;
            return;
        }

        //Se der ruim. 
        this.km += distancia;
        this.gasosa -= distancia;
    }

    public String toString() {
        return "Pass: " + this.nPessoas + ", gasosa: " + this.gasosa + ", distancia: " + this.km + "\n";
    }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Carro carro = new Carro();
		
		while(true) {
			System.out.println("--------------Carrão Turbinado---------------");
            System.out.println("- Embarcar: 'in'");
            System.out.println("- Desembarcar: 'out'");
            System.out.println("- Abastecer: 'fuel'");
            System.out.println("- Dirigir: 'drive'");
            System.out.println("- Show: 'show'");
            System.out.println("- Sair: 'sair'\n");

            System.out.print(" ==> Escolha aqui sua opção: ");
			
			String line = scanner.nextLine();
			String ui[] = line.split(" ");
			
			if(ui[0].equals("end")) {
				break;
			}
			else if(ui[0].equals("show")) {
				carro.show();
			}
			else if(ui[0].equals("in")) {
				carro.embarcar();
				
			}
			else if(ui[0].equals("out")) {
				carro.desembarcar();
				
			}
			else if(ui[0].equals("drive")) {
				carro.dirigir(Integer.parseInt(ui[1]));
				
			}	
			else if(ui[0].equals("fuel")) {
				carro.abastecer(Integer.parseInt(ui[1]));
				
            }
			else {
				System.out.println("Comando invalido");
			}

		}
		scanner.close();
	}
}

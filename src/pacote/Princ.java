package pacote;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Princ {

    //public static int aux = 25000;
    //public static volatile int inaTempo;

    public static void main(String[] args) {
        //inaTempo = aux;
        Ps();
        Ps1();


        Thread T = new Thread() {
            @Override
            public void run() {
                System.out.println("Começou");
                while (true) {
                    try {
                        /*if (inaTempo < 1500) {
                            Ps();
                            Ps1();
                            Thread.sleep(600000);
                            inaTempo = aux;
                        }*/
                        Ps();
                        Ps1();
                        Thread.sleep(600000);
                        //inaTempo -= 1000;
                        //Thread.sleep(1000);
                        //System.out.println(inaTempo);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        T.start();
    }

	public static void Ps() {
		String comandoPs = "$Process = Get-Process RainbowSix; $Process.ProcessorAffinity=8";
		try {
			ProcessBuilder processBuilder = new ProcessBuilder("pwsh","-Command", comandoPs);
			processBuilder.redirectErrorStream(true);
			
			Process process = processBuilder.start();
			
			InputStream inputStream = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String linha;
			while((linha = reader.readLine())!=null) {
				System.out.println(linha);
			}
			
			int codigoSaida = process.waitFor();
			System.out.println("Código de saída: "+ codigoSaida);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Ps1() {
		String comandoPs1 = "$Process = Get-Process RainbowSix; $Process.ProcessorAffinity=15";
		try {
			ProcessBuilder processBuilder = new ProcessBuilder("pwsh","-Command", comandoPs1);
			processBuilder.redirectErrorStream(true);
			
			Process process = processBuilder.start();
			
			InputStream inputStream = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String linha;
			while((linha = reader.readLine())!=null) {
				System.out.println(linha);
			}
			
			int codigoSaida = process.waitFor();
			System.out.println("Código de saída: "+ codigoSaida);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}

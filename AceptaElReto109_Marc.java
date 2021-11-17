import java.util.*;


public class AceptaElReto109_Marc{

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);		
		String equip1, equip2,lliga;
		int set1, set2;
		int temp = 0;
		int cont = 0;
		int partidosTotales;
		int partidosRestantes;
		String ganador;
		int lliga;

		while (true) {

			HashMap <String,Integer> map = new HashMap <String,Integer>();
			partidosTotales = 0;
			partidosRestantes = 0;
			cont = 0;
			liga = kb.next();

			if(liga.equals("FIN")) {

				break;

			}

			while(true) {

				equip1 = kb.next();

				if(equip1.equals("FIN")) {

					break;

				}

				set1 = kb.nextInt();
				equip2 = kb.next();
				set2 = kb.nextInt();

				
				if(map.get(equip1) == null) {

					map.put(equip1, 0);

				}

				if(map.get(equip2) == null) {

					map.put(equip2, 0);

				}

				
				if (set1 > set2) {

					cont++; 
					temp = map.get(equip1);
					map.put(equip1, temp + 2);
					temp = map.get(equip2);
					map.put(equip2, temp + 1);

				}else {

					cont++; 
					temp = map.get(equip2);
					map.put(equip2, temp + 2);
					temp = map.get(equip1);
					map.put(equip1, temp + 1);
				}


				partidosTotales = (map.size()*(map.size()-1));
				partidosRestantes = partidosTotales - cont;

			}


			ganador = equipoGanador(map);
			System.out.println(ganador +" "+ partidosRestantes);


		}	
	}

	private static String equipoGanador(HashMap<String, Integer> map) {


		int mayor = -1;
		String ganador = null;

		Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {

			Map.Entry<String, Integer> entry = entries.next();
			
			int prueba = entry.getValue();
			
			if (entry.getValue() > mayor) {
				
				ganador = entry.getKey();
				mayor = entry.getValue();
				
			} else if (entry.getValue() == mayor) {
				
				ganador = "EMPATE";
				mayor = entry.getValue();
			}

		}
		return ganador;
	}
}
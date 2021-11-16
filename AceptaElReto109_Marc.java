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


				// Estos dos if comprueban si el equipo está ya en la tabla. De no estar, los añadimos
				
				if(map.get(equip1) == null) {

					map.put(equip1, 0);

				}

				if(map.get(equip2) == null) {

					map.put(equip2, 0);

				}

				//Si set1 es mayor que set2 significa que gana equipo 1
				
				if (set1 > set2) {

					cont++; // Contamos un encuentro 
					temp = map.get(equip1); //Obtenemos el valor de esa celda
					map.put(equip1, temp + 2); // Le sumamos a temp dos puntos por haber ganado encuentro
					temp = map.get(equip2); // Repetimos operación con otro equipo
					map.put(equip2, temp + 1); //Y le sumamos 1 a temp

				//De lo contrario gana equipo 2	
				}else {

					cont++; 
					temp = map.get(equip2);
					map.put(equip2, temp + 2);
					temp = map.get(equip1);
					map.put(equip1, temp + 1);
				}

				//Formula para calcular cuantos encuentros no se han jugado en la liguilla
				partidosTotales = (map.size()*(map.size()-1));//Obtiene los hipotéticos partidos que se deberian jugar en la liga con n equipos
				partidosRestantes = partidosTotales - cont;//Restamos al hipotético total el contador de partidos, lo que nos da los partidos que han faltado por disputar

			}


			ganador = equipoGanador(map);
			System.out.println(ganador +" "+ partidosRestantes);


		}	
	}

	private static String equipoGanador(HashMap<String, Integer> map) {


		int mayor = -1;
		String ganador = null;

		//Recorremos map para buscar el mayor valor de todos. En caso de empate devuelve empate.
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
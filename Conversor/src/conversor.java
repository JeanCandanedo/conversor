import javax.swing.JOptionPane;
import java.util.Map;
import java.util.HashMap;

public class conversor {
	public static String [][] romanos={{"","I","II","III","IV","V","VI","VII","VIII","IX"},
	         							{"","X","XX","XXX","XL","L","LX","LXX","LXX","XC"},
	         							{"","C"}};
	public static int cent = 0, dec = 0, uni = 0;
	public static void main(String[] args) {
			int num,res,s;
			String n1,n2;
			s=Integer.parseInt(JOptionPane.showInputDialog("Seleccione el tipo e Conversion que desee: \n \n 1.Convertir de Arabigo a Romano.\n 2.Convertir de Romano a Arabigo.\n \n "));
			switch(s) {
			case 1:
				num=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero Arabigo entre 1 y 100: "));
				obtener(num);
				n1=romano();
				JOptionPane.showMessageDialog(null, "El Numero en Romano es:"+n1, "RESULTADOS " , JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				n2=(JOptionPane.showInputDialog("Ingrese un Numero Romano entre 1 y 100: "));
				n2=n2.toUpperCase();
				res=arabigo(n2);
				JOptionPane.showMessageDialog(null, "El Numero en Arabigo es:"+res, "RESULTADOS " , JOptionPane.INFORMATION_MESSAGE);
				break;
			default:
					try {
						JOptionPane.showMessageDialog(null, "Opcion Invalida", "RESULTADOS " , JOptionPane.INFORMATION_MESSAGE);
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Error", "RESULTADOS " , JOptionPane.INFORMATION_MESSAGE);
						}
				break;
			}
	}
	
	
	
	public static void obtener(int n) {
	      cent = (int)n % 1000 / 100;
	      dec = (int)n % 1000 % 100 / 10;
	      uni= (int)n% 1000 % 100 % 10;
	   }
	
	public static String romano(){
	      return romanos[2][cent]+""+romanos[1][dec]+""+romanos[0][uni]+"";
	   }
	
	public static int arabigo(String n) {
        Map<Character, Integer> hash = new HashMap<Character, Integer>();
        hash.put('I', 1);
        hash.put('V', 5);
        hash.put('X', 10);
        hash.put('L', 50);
        hash.put('C', 100);
        int r = 0;
        for (int i = 0; i < n.length(); i += 1) {
            if (i == 0 || hash.get(n.charAt(i)) <= hash.get(n.charAt(i - 1)))
                r += hash.get(n.charAt(i));
            else
                r += hash.get(n.charAt(i)) - 2 * hash.get(n.charAt(i - 1));
        }
        return r;
    }
	
}

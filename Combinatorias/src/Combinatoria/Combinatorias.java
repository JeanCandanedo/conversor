package Combinatoria;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.math.*;
public class Combinatorias 
{
	public static void main (String[] args)
	{
	int i, op, fin=0;
		while(fin==0)
		{
			i=JOptionPane.showOptionDialog(null, "Escoga que combinatoria desea ejecutar", "Seleccion", 
			JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] 
			{"Permutacion","Variacion", "Combinaciones","Salir"}, null);
			switch(i)
			{
				case 0:
				{
					op=JOptionPane.showOptionDialog(null, "Escoja el Tipo de Permutacion", "Seleccion", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Con repeticion","Sin repeticion"}, null);
					switch(op)
					{
						case 0:
						{
							int n, r;
							int a,b,c,a1,b1,c1, den;
							float res;
							n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero que tomara valor en n."));
							r=factorial(n);
							a=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de A"));
							b=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de B"));
							c=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de C"));
							a1=factorial(a);
							b1=factorial(b);
							c1=factorial(c);
							den=a1*b1*c1;
							res=(float)r/den;
							JOptionPane.showMessageDialog(null, "El resultado de PR("+n+" !) / ("+a+" !)("+b+" !)("+c+" !) es: \n"+res);
							break;
						}
						case 1:
						{
							int n, r;
							n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero que tomara valor en n."));
							r=factorial(n);
							JOptionPane.showMessageDialog(null, "El resultado de P("+n+")! es: \n"+r);
							break;
						}
					}
					break;
				}
				case 1:
				{
					op=JOptionPane.showOptionDialog(null, "Escoja el Tipo de Variacion", "Seleccion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Con repeticion","Sin repeticion"}, null);
					switch(op)
					{
						case 0:
						{
							int n,r, res;
							n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero que tomara el valor en n"));
							r=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero que tomara el valor en r"));
							res=(int) Math.pow(n, r);
							JOptionPane.showMessageDialog(null, "El resultado de VR("+n+","+r+")="+n+"^"+r+" es: \n"+res);
							break;
						}
						case 1:
						{
							int n,r, res, den,num;
							n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero que tomara el valor en n"));
							r=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero que tomara el valor en r"));
							den=factorial(n-r);
							num=factorial(n);
							res=num/den;
							JOptionPane.showMessageDialog(null, "El resultado de V("+n+","+r+")="+n+"! / ("+n+"-"+r+")! es: \n"+res);
							break;
						}
					}
					break;
				}
				case 2:
				{
					op=JOptionPane.showOptionDialog(null, "Escoja el Tipo de Combinacion", "Seleccion", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Con repeticion","Sin repeticion"}, null);switch(op)
					{
						case 0:
						{
							int n,r, den,num;
							float res;
							n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero que tomara el valor en n"));
							r=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero que tomara el valor en r"));
							num=factorial(n+r-1);
							den=factorial(r)*factorial(n-1);
							res=num/den;
							JOptionPane.showMessageDialog(null, "El resultado de CR("+n+","+r+")=("+n+"+"+r+"-1)! / "+r+"!("+n+"-1)! es: \n"+res);
							break;
						}
						case 1:
						{
							int n,r, den,num;
							float res;
							n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero que tomara el valor en n"));
							r=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero que tomara el valor en r"));
							num=factorial(n);
							den=factorial(r)*factorial(n-r);
							res=num/den;
							JOptionPane.showMessageDialog(null, "El resultado de C("+n+","+r+")="+n+"! / "+r+"!("+n+"-"+r+")! es: \n"+res);
							break;
						}
					}
				}
				case 3:
				fin=1;
				break;
			}
		}
	}
	
	public static int factorial(int x)
	{
		int res=1;
		for(int c=x; c>0; c--)
		{
		res=res*c;
		}
		return res;
	}
}
package Paquetes;

import Paquetes.Arbol;
import Paquetes.Arbol.Nodo;

public class Arbol {
    class Nodo
      {
        int info;
        Nodo izq, der;
      }
      Nodo raiz;

      public Arbol() {
          raiz=null;
      }
      
      public void insertar (int info)
      {
          Nodo nuevo;
          nuevo = new Nodo ();
          nuevo.info = info;
          nuevo.izq = null;
          nuevo.der = null;
          if (raiz == null)
              raiz = nuevo;
          else
          {
              Nodo anterior = null, reco;
              reco = raiz;
              while (reco != null)
              {
                  anterior = reco;
                  if (info < reco.info)
                      reco = reco.izq;
                  else
                      reco = reco.der;
              }
              if (info < anterior.info)
                  anterior.izq = nuevo;
              else
                  anterior.der = nuevo;
          }
      }


      private void imprimirPre (Nodo reco)
      {
          if (reco != null)
          {
              System.out.print(reco.info + " ");
              imprimirPre (reco.izq);
              imprimirPre (reco.der);
          }
      }

      public void imprimirPre ()
      {
          imprimirPre (raiz);
          System.out.println();
      }

      private void imprimirEntre (Nodo reco)
      {
          if (reco != null)
          {    
              imprimirEntre (reco.izq);
              System.out.print(reco.info + " ");
              imprimirEntre (reco.der);
          }
      }

      public void imprimirEntre ()
      {
          imprimirEntre (raiz);
          System.out.println();
      }


      private void imprimirPost (Nodo reco)
      {
          if (reco != null)
          {
              imprimirPost (reco.izq);
              imprimirPost (reco.der);
              System.out.print(reco.info + " ");
          }
      }


      public void imprimirPost ()
      {
          imprimirPost (raiz);
          System.out.println();
      }

      public static void main (String [] ar)
      {
    	  Arbol abo = new Arbol ();
    	  abo.insertar (400);
          abo.insertar (100);
          abo.insertar (200);
          abo.insertar (700);
          abo.insertar (50);
          abo.insertar (75);
          System.out.println ("Impresion preorden: ");
          abo.imprimirPre ();
          System.out.println ("Impresion entreorden: ");
          abo.imprimirEntre ();
          System.out.println ("Impresion postorden: ");
          abo.imprimirPost ();        
      }  
}
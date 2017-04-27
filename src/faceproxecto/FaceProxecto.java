
package faceproxecto;

import facebook4j.FacebookException;
import javax.swing.JOptionPane;


public class FaceProxecto {

    
    public static void main(String[] args) throws FacebookException {
    
    Metodos.autorizar();

    
    
       
       
    int op=0;
   
      do{
  
            try{
        op = Integer.parseInt(JOptionPane.showInputDialog("***MENU*** \n1. Publicar mensaje  \n2.Publicar Imagen \n3.buscar \n4.Publicar comentario en una foto \n5. salir"));
        
            }catch(Exception e){
                System.out.println(e.getMessage());
                op = 0;
            }
                switch (op) {

            case 1:
                Metodos.publicarMensaje();
                break;
            case 2:
                Metodos.publicarImagen();
                break;
            case 3:
                Metodos.buscar();
            case 4:
                Metodos.publicarComentario();
            case 5:
                System.exit(0);
        
                }
    }while (op<5);
}

    }


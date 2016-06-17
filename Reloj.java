/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Marcos
 */

import java.util.Timer;
import java.util.TimerTask;
public class Reloj {

    /**
     * @param args the command line arguments
     */
    
    Timer reloj = new Timer();
   
    int cuentat=0;
    
    public void Pruebareloj()
    {
         TimerTask tarea=new TimerTask()
         {
             
             
             @Override
             public void run()
             {
                
                     System.out.println("TME="+cuentat);
              cuentat++;
                     
             }
                 
         };
         //reloj.schedule(TareaAEjecutar,tiempoquetardaeniniciar,cada cuanto tiempo ejecutara la tarea);
        reloj.schedule(tarea,10,1000);
        
    }
    
    
   
 
    
}

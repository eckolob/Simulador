import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Simulador {
 	
        Proceso procesovacio=new Proceso();
        Proceso p=new Proceso();
        Interfaz ventana =new Interfaz();
        Random aleatorio;
        
        ArrayList <Proceso> ProcesosNuevos;
        ArrayList <Proceso> Memoria;
        ArrayList <Proceso> ProcesosTerminados;
         ArrayList <Proceso> ProcesosBloqueados;
        ArrayList <Integer> relojBloqueados;
        
        boolean procesoTerminado=false;
        int cuentaterminados=0;  
        int milisegundos= 300;
        int cuentat=0,unidadtme=0,j=0,bloq=0,relojGlobal=0,relojAux=0,relojAux2=0;
        int generaids=0;   
        boolean tal=false,error=false;
        boolean rej=false;
  
  
  
   
    int num1,num2;
    int tmeactual=0;
  
    boolean termina=false;
      int id,tme,tr=0,procesosrecibidos; String resultado;
    //Contador que lleva el tiempo (determinar mi unidad de tiempo
    //ejemplo 1 tme = x segundos controlados por un delay
      
      int opcion=0;
      
      
    
      
      public Simulador()
      {
          //quiero capturar n objetos, dividir n/5, crear un array list que
          
         Memoria= new ArrayList<> (); 
         ProcesosNuevos = new ArrayList();
         ProcesosTerminados = new ArrayList();
         ProcesosBloqueados = new ArrayList();
         aleatorio = new Random();
         relojBloqueados = new ArrayList();
         
      }
      
      
      
      	public String Sumar(int n1,int n2)
	{
		int suma= n1+n2;
		resultado=""+n1+" + "+n2+" = "+suma;
		return  resultado;
	}
	
	public String Restar(int n1,int n2)
	{
		int resta= n1-n2;
		resultado=""+n1+" - "+n2+" = "+resta;
		return  resultado;
	}
	
	public String Multiplicar(int n1,int n2)
	{
		int mult= n1*n2;
		resultado=""+n1+" * "+n2+" = "+mult;
		
		return  resultado;
	}
	
	public String Dividir(int n1,int n2)
	{
		if(n2<=0)
		{
		 	JOptionPane.showMessageDialog(null, "Error: Division entre 0!", "", JOptionPane.ERROR_MESSAGE);
                        error=true;
                        resultado="Error\t";
		}
		else
		{
		 int div= n1/n2;
		 resultado=""+n1+" / "+n2+" = "+div;	
		}
	
		
		return  resultado;
	}
	
	public String Residuo(int n1,int n2)
	{
		if(n2<=0)
		{
		 	
                        JOptionPane.showMessageDialog(null, "Division entre 0!", "", JOptionPane.ERROR_MESSAGE);
                        error=true;
                         resultado="Error\t";
		}
		else
		{
		 int residuo= n1%n2;
		 resultado=""+n1+" % "+n2+" = "+residuo;	
		}
		return  resultado;
	}
	
	public String Potencia(int n1,int n2)
	{
	 int potencia=(int) Math.pow(n1, n2);;
		resultado=""+n1+" ^ "+n2+" = "+potencia;
		return  resultado;	
	}
        
        
        public void IngresaProcesos()
        {
         int cuentaprocesos2=0;
         int cuentaprocesos=0;
         int sumatme=0;
        
    	
        String op;

        procesosrecibidos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero de procesos: "));
          int tam=0;
          
         
       do{
           //Bloque para introducir datos al array list
                       
                        if(cuentaprocesos2==procesosrecibidos)
           	{
           		 termina=true;                   
                        break;
           	}
                        
                     id = cuentaprocesos2+1 ;
       
                        tme = aleatorio.nextInt(30)+ 1 ;
                        tr=tme;
                               while(tme<=0)
                                {                       
                                      tme = aleatorio.nextInt(30);
                                }
                            
                        sumatme+=tme;
                        

                        num1 = aleatorio.nextInt(100)+1;
                        num2 = aleatorio.nextInt(100) + 1;
                        int o=0;
                        do
                        {                  
                       opcion =  aleatorio.nextInt(6);
                        switch(opcion)
                        {
                            

                               case 1:resultado=Sumar(num1,num2);
                                        o=1;
                        		break;
                         	case 2:resultado=Restar(num1,num2);
                                        o=2;
                        		break;
                        	case 3:resultado=Multiplicar(num1,num2);
                                        o=3;
                        		break;
                        	case 4:resultado=Dividir(num1,num2);
                                        o=4;
                        		break;
                        	case 5:resultado=Residuo(num1,num2);
                                       o=5;
                        		break;
                        	case 6:resultado=Potencia(num1,num2);
                                        o=6;
                        		break;
                        
                        		default:
            			
                        }
                        }while(o==0);  
                             
                         ProcesosNuevos.add(new Proceso(id,tme,resultado,tr));  
                                         //nuevo,listo,ejecucion,terminado,bloqueado
                         p.AsignarEstado(true, false, false, false, false);
                         cuentaprocesos++;
                         cuentaprocesos2++;//controla el while
                
                         
                         if(cuentaprocesos>0&&cuentaprocesos<6)
                         {
                              for(int z=0;z<5;z++)
                                     {
                                        if(z<ProcesosNuevos.size()) 
                                        {
                                             Memoria.add(ProcesosNuevos.get(z));  //Agrega 5 o menos procesos nuevos a memoria (ARRAYLISTPROCESOS)
                                                                                    //Estados listo, ejecucion y bloqueado
                                        }
                                          
                                     }
                                     
                                     for(int z=0;z<5;z++)
                                     {
                                         
                                         if(z<ProcesosNuevos.size())
                                        {
                                            ProcesosNuevos.remove(ProcesosNuevos.get(z)); //Como ya estan en memoria, borralos 
                                        }
                                            
                                     }
                         }
                                    
                                    
                    	
       }while(error!=true||termina!=true);
       
       ventana.Simular();
        }
 
        
      
        
         public void MostrarProcesos()throws InterruptedException 
        {
                
                                     
            Timer relojProcesos = new Timer();        
            TimerTask mostrarproceso=new TimerTask()
                   
         {
          @Override
             public void run() 
             { 
                
                 cuentat++;       
                 //Cada que pasen 3 segundos es una unidadtme
                 if(cuentat%3==0)              
                 {    
                    
                        
                        //Mostrar procesos en cola de nuevos(pendientes)
                     //Evaluar que show aqui
                      ventana.txt_procesosPendientes.setText(Integer.toString(ProcesosNuevos.size()));
     
                        String LA="";
                        //Puedo hacer un arraylist de cadenas para que en cada posicion este la info de un proceso
                        //y agregar cada posicin al jtextarea al mismo tiempo, y asi tambien poder quitar individualmente 
                    
                         for(int a=0;a<Memoria.size();a++)
                                     {
                                     
                                       LA +=(Memoria.get(a).ObtenerId())+"      "+(Memoria.get(a).ObtenerTME())+"     "+Memoria.get(a).ObtenerTR()+"\n";
                                                                                      //nuevo,listo,ejecucion,terminado,bloqueado 
                                       Memoria.get(a).AsignarEstado(false, true, false, false, false);
                                     }
                         //Mostrar los procesos listos
                                      ventana.ta_procesosListos.setText(LA); 
                                      ventana.ta_procesosListos.setLineWrap(true); 
                                      ventana.ta_procesosListos.setWrapStyleWord(true);
                       
                     
                     
                    
                     if(j!=Memoria.size()) //Para que no trate de acceder a una posicion que no existe
                     {
                  
                         tmeactual= (Memoria.get(j).ObtenerTME());
                               //PROCESO EN EJECUCION
                         
                                                                             //nuevo,listo,ejecucion,terminado,bloqueado
                                 Memoria.get(j).AsignarEstado(false, false, true,   false,    false);
                                 ventana.txt_idproceso2.setText(Integer.toString(Memoria.get(j).ObtenerId()));  
                                 ventana.txt_operacion.setText(Memoria.get(j).ObtenerOperacion());
                                 ventana.txt_tme2.setText(Integer.toString(Memoria.get(j).ObtenerTME()));
                                 tme=Memoria.get(j).ObtenerTME();
                                 ventana.txt_tr.setText(Integer.toString( ((Memoria.get(j).ObtenerTR()))-unidadtme)); 
                                 ventana.txt_tt.setText(Integer.toString(unidadtme));
                       
                             
                                 //Mostrar reloj global
                                  ventana.txt_reloj.setText(Integer.toString(relojGlobal));
                                 
                                   unidadtme++;
                     
                         //INTERRUPCIONES
                         if(ventana.I_p==true)
                            {
                             try {
                                 Pausar();
                             } catch (InterruptedException ex) {
                                 Logger.getLogger(Simulador.class.getName()).log(Level.SEVERE, null, ex);
                             }
                            }  
                 
                          if(ventana.I_w==true)
                            {                                                                   
                              String ope = "Error          ";
                              Memoria.get(j).AsignarOperacion(ope);
                              Memoria.get(j).AsignarTR(0);    
                            }
                                   
                                     
                                 
                         if(ventana.I_e==true)
                         {
                         //Despues de esta interrupcion el tr pasa a ser la referencia 
                         //Al presionar E guarda el tiempo que le resta a el proceso  
                            Memoria.get(j).AsignarTR(tme-(unidadtme));   
                                                             //nuevo,listo,ejecucion,terminado,bloqueado
                            Memoria.get(j).AsignarEstado(false, false, false,   false,    true);
                            ProcesosBloqueados.add(Memoria.get(j));
                            relojBloqueados.add(0);
                            ProcesosBloqueados.get(ProcesosBloqueados.size()-1).AsignarTT(relojBloqueados.get(relojBloqueados.size()-1));
                            
                            
                             //borralo de la posicion actual
                               Memoria.remove(Memoria.get(j));    
                               unidadtme=0;
                            
                         }
                                      
                                 
                         
                         //PROCESOS BLOQUEADOS           
                        
                         if(!ProcesosBloqueados.isEmpty())
                         {
                             
                            for(int d=0;d<ProcesosBloqueados.size();d++)
                            {
                                relojAux = relojBloqueados.get(d);
                                relojAux++;                     
                                ProcesosBloqueados.get(d).AsignarTT(relojBloqueados.set(d,relojAux));
                            }
                             
                          String PB="";
                       
                          
                         for(int a=0;a<ProcesosBloqueados.size();a++)
                                     {                               
                                       PB +=(ProcesosBloqueados.get(a).ObtenerId())+"     "+(ProcesosBloqueados.get(a).ObtenerTT())+"\n";                     
                                     }
                          //Mostrar los procesos listos
                                      ventana.ta_procesosBloqueados.setText(PB); 
                                      ventana.ta_procesosBloqueados.setLineWrap(true); 
                                      ventana.ta_procesosBloqueados.setWrapStyleWord(true);
                                      
                                      for(int z=0;z<ProcesosBloqueados.size();z++)
                                      {
                                           if((ProcesosBloqueados.get(z).ObtenerTT())==10)
                                      {
                                          Memoria.add(ProcesosBloqueados.get(z));
                                          ProcesosBloqueados.remove(ProcesosBloqueados.get(z));
                                          relojBloqueados.remove(relojBloqueados.get(z));
                                          
                                         
                                      }
                                      }
                                      
                                     
                         }
                         
                         
                        
                        
                         
                         
                         
                                  //TRANSICION DE EJECUCION A TERMINADO
                                  //El atributo TR cambia disminuye solo visualmente, pero solo cambia su valor dentro del proceso en caso de interrupcion E
                        if( Memoria.get(j).ObtenerTR()==unidadtme||ventana.I_w==true)
                                 {              
                                        Memoria.get(j).AsignarTR(0);    
                                                                             //nuevo,listo,ejecucion,terminado,bloqueado
                                         Memoria.get(j).AsignarEstado(false, false, false,   true,    false);
                                
                                                            
                                         procesoTerminado = Memoria.get(j).ObtenerEstadoTerminado();
                                         if(procesoTerminado==true)
                                          {
                                            cuentaterminados++; 
                                          }        
                                    
                                     //Cada que termine un proceso, agregalo a la lista de terminados, borralo de memoria y muestralo desde terminados
                                    if( !Memoria.isEmpty())
                                    {                             
                                        ProcesosTerminados.add(Memoria.get(j));
                                        Memoria.remove(Memoria.get(j));
                                    }  
                                         ventana.ta_procesosTerminados.append(Integer.toString(ProcesosTerminados.get(cuentaterminados-1).ObtenerId()));
                                         ventana.ta_procesosTerminados.append("        "+ProcesosTerminados.get(cuentaterminados-1).ObtenerOperacion());
                                         ventana.ta_procesosTerminados.append("\n");
                                        
                                         
                                     //Tambien cada que termina un proceso, debe entrar un proceso nuevo a memoria, 
                                         //y quitarlo de nuevos, siempre y cuando la suma de procesos en los estados bloqueado, listo y ejecucion sean menos de 5   
                                         if(!ProcesosNuevos.isEmpty())
                                         {                             
                                          if(Memoria.size()+ProcesosBloqueados.size()<5)
                                          {
                                            Memoria.add(ProcesosNuevos.get(0));
                                            ProcesosNuevos.remove(ProcesosNuevos.get(0));
                                          }
                                          
                                         }
                                      //J se pasa al otro proceso aunque siga siendo el mismo valor, porque ya se elminino el proceso en esa poscicion                                
                                     //Empieza a contar otra vez
                                     unidadtme=0;  
                                
                                 }
                                  
                    
                     }    
                   
                    //Aqui se evalua cuando ya no hay mas procesos 
                    if(Memoria.isEmpty())
                                {
                               
                                       
                                    ventana.ta_procesosListos.setText(""); 
                                      ventana.ta_procesosListos.setLineWrap(true); 
                                      ventana.ta_procesosListos.setWrapStyleWord(true);
                                      
                         
                                 ventana.txt_idproceso2.setText("");  
                                 ventana.txt_operacion.setText("");
                                 ventana.txt_tme2.setText("");
                         
                                 ventana.txt_tr.setText(""); 
                                 ventana.txt_tt.setText("");
                                 //Cuando todos los procesos terminen, acaba de contar el reloj global
                                 relojProcesos.cancel();
                                 relojProcesos.purge();
                                }
                            
                    //cuando un proceso termina o es interrumpido a unidadtme se le asigna 0, pero aqui antes de que vuelva a empezar
                    //se incrementa, osea que segun yo no vuelve a contar de 0 sino de 1
                   
                    
                     relojGlobal++; 
                     
                     
                     
                 }  
             }            
         };
              relojProcesos.scheduleAtFixedRate(mostrarproceso,1,milisegundos); 
        }
      
         
  
    public synchronized void Pausar() throws InterruptedException
    {
        
                            
         try {     
                wait(5000);
             } catch (InterruptedException ex) 
             {
                Logger.getLogger(Simulador.class.getName()).log(Level.SEVERE, null, ex);
             }
         
    }
    
    public synchronized void Continuar()
    {
              
            notify();
      
    }
    	
    	public static void main(String args[])throws InterruptedException {
        
               Simulador objeto = new Simulador();
               objeto.IngresaProcesos();         
               objeto.MostrarProcesos();
             
                             objeto.Continuar();
                             
}

                      }
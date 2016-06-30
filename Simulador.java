import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Simulador {
 	Lote lote = new Lote();	
        Lote lotevacio=new Lote();
        Proceso procesovacio=new Proceso();
        Proceso p=new Proceso();
        Interfaz ventana =new Interfaz();
        Random aleatorio;
        
        
        
         boolean procesoTerminado=false;
      int cuentaterminados=0;  
    int milisegundos= 250;
    int cuentat=0,unidadtme=0,j=0,k=0,relojGlobal=0;
    int generaids=0;   
    boolean tal=false,error=false;
  
    //Esta array list es para extraer los lotes de donde se almacenan y mostrarlos
 
    //En estas array list se guardan los procesos y lotes
    ArrayList <Lote> Lotes;
    ArrayList <Proceso> ProcesosTemporal;
    ArrayList <Proceso> Procesos;
   
    int lotesreq=0;
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
          Lotes= new ArrayList<> (); 
         Procesos= new ArrayList<> (); 
         ProcesosTemporal = new ArrayList();
         aleatorio = new Random();
        
         
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
      int cuentalotes;
      int sumatme=0;
        
    	
        String op;

        procesosrecibidos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero de procesos: "));
         lotesreq=lote.CalcularLotes(procesosrecibidos); 
          int tam=0;
          
          cuentalotes=0;
       do{
                               
 		cuentat++;	
                              
               //Bloque para introducir datos al array list
                       
                        if(cuentaprocesos2==procesosrecibidos)
           	{
           		 termina=true;
                       //  JOptionPane.showMessageDialog(null, "Ya no puedes ingresar mas procesos!", "", JOptionPane.ERROR_MESSAGE);
                        break;
           	}
                      
 		
                     id = cuentaprocesos2+1 ;
       
                        tr= tme = aleatorio.nextInt(30) ;
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
                        
                        
                         procesovacio = new Proceso();
                       
                         Procesos.add(new Proceso(id,tme,resultado,tr));  
                                         //nuevo,listo,ejecucion,terminado,bloqueado
                         p.AsignarEstado(true, false, false, false, false);
                         cuentaprocesos++;//controla la asignacion de idlote
                         cuentaprocesos2++;//controla el while
                         
                          if(cuentaprocesos==1)//Si es el  proceso 1 de un Lote N
                           {
                               //Agrego este lote vacio para que halla algo en la posicion 0 y no me arroje exepcion al querer 
                               //poener algo en la posicion 0 con el metodo set(reemplazar)
                               Lotes.add(lotevacio);
                           }
                          
                           if((cuentaprocesos%5)==0)                      
                                 {
                                     for(int z=0;z<Procesos.size();z++)
                                     {
                                         
                                         ProcesosTemporal.add(z, Procesos.get(z));    
                                     }
                                    
                                    //EL ERROR EN EJECUCION EN TME LOTE SE DEBE A QUE EN EL SEGUNDO LOTE AL PROCESO CON ID 6 LE ASGINO UN TME 6
                                     //Y EL LOTE SE CREA CON EL TME DE ESE PROCESO, PERO EN REALIDAD SE LE AGREGA ESE PROCESO Y  LOS PROCESOS DEL LOTE ANTERIOR
                                     lote = new Lote((cuentalotes+1),Procesos,sumatme);
                                     Lotes.set(cuentalotes, lote);
                                       Procesos = new ArrayList();
                                   //sin borrar array list de procesos como le digo que aguegue solo 5 procesos a cada bloque
                                     //OK6
                                      // que de lista procesos me pase a otra lista solo los procesos correspondientes (5)
                              
                             // Procesos.remove(p);
                              // Procesos.subList(0, 5).clear();
                             
                                   cuentalotes++;
                                   cuentaprocesos=0;
                                   sumatme=0;
    
                                 }  
                           else
                           {
                         
                                lote = new Lote((cuentalotes+1),Procesos,sumatme);
                          // lote.creaLote((cuentalotes+1),Procesos);
                           
                          
                         //  Lotes.add(cuentalotes,lote);
                           Lotes.set(cuentalotes, lote);
                           }
                          
                        
                       
                       
                                  
                         	
       }while(error!=true||termina!=true);
       
       ventana.Simular();
        }
 
        
      
        
         public void MostrarProcesoActual()throws InterruptedException 
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
                    
                       if( k< Lotes.size())
                       {    
                        //Mostrar lotes pendientes
                      ventana.txt_lotesPendientes.setText(Integer.toString(Lotes.size()-k));
     
                        String LA="";
                        //Puedo hacer un arraylist de cadenas para que en cada posicion este la info de un proceso
                        //y agregar cada posicin al jtextarea al mismo tiempo, y asi tambien poder quitar individualmente 
                        //Acumular en la cadena LA los procesos del lote actual
                         for(int a=0;a<Lotes.get(k).procesosLote.size();a++)
                                     {
                                     
                                       LA +="                "+((Lotes.get(k).procesosLote.get(a).ObtenerId()))+"                "+(Lotes.get(k).procesosLote.get(a).ObtenerTME())+"         "+Lotes.get(k).procesosLote.get(a).ObtenerTR()+"\n";
                                                                                      //nuevo,listo,ejecucion,terminado,bloqueado 
                                       Lotes.get(k).procesosLote.get(a).AsignarEstado(false, true, false, false, false);
                                     }
                         //Mostrar los procesos del lote actual
                                      ventana.ta_loteActual.setText(LA); 
                                      ventana.ta_loteActual.setLineWrap(true); 
                                      ventana.ta_loteActual.setWrapStyleWord(true);
                       }
                     
                     
                    if(k< Lotes.size()) 
                    { 
                     if(j!=Lotes.get(k).procesosLote.size()) //Para que no trate de acceder a una posicion que no existe
                     {
                         //Mostrar id de lote ejecutandose
                         ventana.txt_loteEjecutandose.setText(Integer.toString(Lotes.get(k).idLote));
   
                         tmeactual= (Lotes.get(k).procesosLote.get(j).ObtenerTME());
                               //PROCESO EN EJECUCION
                         //En este punto debe entrar en accion la interrupcion E
                                                                             //nuevo,listo,ejecucion,terminado,bloqueado
                                 Lotes.get(k).procesosLote.get(j).AsignarEstado(false, false, true,   false,    false);
                                 ventana.txt_idproceso2.setText(Integer.toString(Lotes.get(k).procesosLote.get(j).ObtenerId()));  
                                 ventana.txt_operacion.setText(Lotes.get(k).procesosLote.get(j).ObtenerOperacion());
                                 ventana.txt_tme2.setText(Integer.toString(Lotes.get(k).procesosLote.get(j).ObtenerTME()));
                                 tme=Lotes.get(k).procesosLote.get(j).ObtenerTME();
                                 ventana.txt_tr.setText(Integer.toString( ((Lotes.get(k).procesosLote.get(j).ObtenerTR()))-unidadtme)); 
                                 ventana.txt_tt.setText(Integer.toString(unidadtme));
                                 //si no hay interrupcion asignar el tme como tr
                                 //   Lotes.get(k).procesosLote.get(j).AsignarTR(tme);  
                                 
                           
                              
                             
                                 //Mostrar reloj global
                                  ventana.txt_reloj.setText(Integer.toString(relojGlobal));
                                 
                                   unidadtme++;
                                 
                                   
                        
                            
                         
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
                                         Lotes.get(k).procesosLote.get(j).AsignarOperacion(ope);
                                         Lotes.get(k).procesosLote.get(j).AsignarTR(0);    
                                                                                    //nuevo,listo,ejecucion,terminado,bloqueado
                                         
                       
                                        }
                                   
                                     
                                     
                                             if(ventana.I_e==true)
                         {
                             //OJO si interrumpo varias veces el mismo proceso TR se vuelve negativo
                         //Despues de esta interrupcion el tr pasa a ser la referencia 
                             //Al presionar E guarda el tiempo que le resta a el proceso 
                             
                             Lotes.get(k).procesosLote.get(j).AsignarTR(tme-(unidadtme));          
                                //agregalo al final del lote
                             Lotes.get(k).procesosLote.add(Lotes.get(k).procesosLote.get(j));
                             //borralo de la posicion actual
                               Lotes.get(k).procesosLote.remove(Lotes.get(k).procesosLote.get(j));
                               unidadtme=0;
                            
                         }
                                      
                                      
                                      
                                  //TRANSICION DE EJECUCION A TERMINADO
                                  //El atributo TR cambia disminuye solo visualmente, pero solo cambia su valor dentro del proceso en caso de interrupcion E
                                  if( Lotes.get(k).procesosLote.get(j).ObtenerTR()==unidadtme||ventana.I_w==true)
                                 {              
                                        Lotes.get(k).procesosLote.get(j).AsignarTR(0);    
                                                                             //nuevo,listo,ejecucion,terminado,bloqueado
                                Lotes.get(k).procesosLote.get(j).AsignarEstado(false, false, false,   true,    false);
                                
                                                            
                                         procesoTerminado =Lotes.get(k).procesosLote.get(j).ObtenerEstadoTerminado();
                                         if(procesoTerminado==true)
                                          {
                                            cuentaterminados++; 
                                          }        
                                    
                                      ventana.ta_loteTerminado.append(Integer.toString(Lotes.get(k).idLote));
                                      ventana.ta_loteTerminado.append("               "+Lotes.get(k).procesosLote.get(j).ObtenerOperacion()+"\t");
                                      ventana.ta_loteTerminado.append(Integer.toString(Lotes.get(k).procesosLote.get(j).ObtenerId()));
                                      ventana.ta_loteTerminado.append("\n");
                                      //Pasate al otro proceso
                                     j++;
                                     //Empieza a contar otra vez
                                     unidadtme=0;  
                                    
                                 }
                                  
                                  
                                  
                                 //LOTES TERMINADOS
                               
                                   if(cuentaterminados==5)  //Solo hasta que los 5 procesos terminen por alguna razon, termina el lote
                                {                            
                                j=0;    
                                k++;
                                ventana.txt_lotesPendientes.setText(Integer.toString(Lotes.size()-k));
                                cuentaterminados=0;
                                
                                }           
                                
                     }    
                   }
                    
                    if(Lotes.size()==k)
                                {
                                       ventana.txt_loteEjecutandose.setText("");
                                       
                                    ventana.ta_loteActual.setText(""); 
                                      ventana.ta_loteActual.setLineWrap(true); 
                                      ventana.ta_loteActual.setWrapStyleWord(true);
                                      
                         
                                 ventana.txt_idproceso2.setText("");  
                                 ventana.txt_operacion.setText("");
                                 ventana.txt_tme2.setText("");
                         
                                 ventana.txt_tr.setText(""); 
                                 ventana.txt_tt.setText("");
                                 //Cuando todos los lotes terminen, acaba de contar el reloj global
                               //  relojProcesos.cancel();
                                // relojProcesos.purge();
                                }
                    //cuando un proceso termina o es interrumpido a unidadtme se le asigna 0, pero aqui antes de que vuelva a empezar
                    //se incrementa, osea que segun yo no vuelve a contar de 0 sino de 1
                   
                    
                     relojGlobal++; 
                     
                     
                     
                 }  
             }            
         };
              relojProcesos.scheduleAtFixedRate(mostrarproceso,1,milisegundos); 
        }
      
         
        
          
        
        //esto es disque  para actualizar la ventana
             //SwingUtilities.updateComponentTreeUI(ventana);  
       
        
   
 
    public boolean existeEnArray(int bus){
 
        boolean saber=false;
 
        for(int i=0; i<= Procesos.size(); i++){
            if(Procesos.get(i).ObtenerId()==bus){
                saber=true;
                break;
            }
        }
        return saber;
    }
 
    public int indiceDato(int bus){
        int j=0;
 
        for (int i=0 ;i < Procesos.size(); i++) {
            if(Procesos.get(i).ObtenerId()== bus){
                j=i;
                break;
            }
        }
        return j;
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
               objeto.MostrarProcesoActual();
             
                             objeto.Continuar();
                             
}

                      }
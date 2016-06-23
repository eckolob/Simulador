import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.util.Timer;
import java.util.TimerTask;
 
public class Simulador {
 	Lote lote = new Lote();	
        Lote lotevacio=new Lote();
        Proceso procesovacio=new Proceso();
        Proceso p=new Proceso();
        Interfaz ventana =new Interfaz();
        
    int milisegundos= 250;
    int cuentat=0,unidadtme=0,j=0,k=0,relojLote=0,relojGlobal=0;
       
    boolean tal=false,error=false;
  
    //Esta array list es para extraer los lotes de donde se almacenan y mostrarlos
    ArrayList <Proceso> temporal;
    //En estas array list se guardan los procesos y lotes
    ArrayList <Lote> Lotes;
    ArrayList <Proceso> ProcesosTemporal;
    ArrayList <Proceso> Procesos;
   
    int lotesreq=0;
    int num1,num2;
    int tmeactual=0;
  
    boolean termina=false;
      int id,tme,procesosrecibidos; String programador,resultado;
    //Contador que lleva el tiempo (determinar mi unidad de tiempo
    //ejemplo 1 tme = x segundos controlados por un delay
      
      String opcion="";
      
      
    
      
      public Simulador()
      {
          //quiero capturar n objetos, dividir n/5, crear un array list que
          Lotes= new ArrayList<> (); 
         Procesos= new ArrayList<> (); 
         temporal = new ArrayList();
         ProcesosTemporal = new ArrayList();
        
         
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
                      
 						
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID: "));
                        
                        for(int z=0;z<Procesos.size();z++)
                        {
                            while(id==Procesos.get(z).ObtenerId())
                                {
                                    JOptionPane.showMessageDialog(null, "Id Duplicado!", "", JOptionPane.ERROR_MESSAGE);
                                     id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID: "));
                                }
                        }
                        
                        if(error==false)
                        {
                            
                        programador = JOptionPane.showInputDialog(null, "Programador: ");
                        
                       
                        tme = Integer.parseInt(JOptionPane.showInputDialog(null, "TME: "));
                        
                               while(tme<=0)
                                {
                                     JOptionPane.showMessageDialog(null, "EL tme debe ser mayor a cero", "Error en TME", JOptionPane.ERROR_MESSAGE);
                                     tme = Integer.parseInt(JOptionPane.showInputDialog(null, "TME: "));
                                }
                            
                        sumatme+=tme;
                        

        num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero: "));
                        num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero: "));
                       opcion = JOptionPane.showInputDialog(null, "1)Suma\n2)Resta\n3)Multiplicacion\n4)Division\n5)Residuo\n6)Potencia: ");
                        switch(opcion)
                        {
                            

                               case "1":resultado=Sumar(num1,num2);
                        		break;
                         	case "2":resultado=Restar(num1,num2);
                        		break;
                        	case "3":resultado=Multiplicar(num1,num2);
                        		break;
                        	case "4":resultado=Dividir(num1,num2);
                        		break;
                        	case "5":resultado=Residuo(num1,num2);
                        		break;
                        	case "6":resultado=Potencia(num1,num2);
                        		break;
                        
                        		default:
                        			
                        }
                 
                        
                         procesovacio = new Proceso();
                       
                         Procesos.add(new Proceso(id,programador,tme,resultado));  
                        
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
                          
                        
                       
                       }
                                  
                         	
       }while(error!=true||termina!=true);
       
       ventana.Simular();
        }
 
        
      
        
         public void MostrarProcesoActual()
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
                        Lotes.get(k).ObtenerIdLote();
                        temporal=Lotes.get(k).ObtenerProcesos();
                        String LA="";
                         for(int a=0;a<temporal.size();a++)
                                     {
                                       LA +=    ((temporal.get(a).ObtenerId()))+"\t   "+(temporal.get(a).ObtenerTME())+"\n";
 
                                     }
                                      ventana.ta_loteActual.setText(LA); 
                                      ventana.ta_loteActual.setLineWrap(true); 
                                      ventana.ta_loteActual.setWrapStyleWord(true);
                       }
                     
                     unidadtme++;
                     relojLote++;
                     relojGlobal++;
                    if(k< Lotes.size()) 
                    {
                        
                    
                     if(j!=temporal.size()) //Para que no trate de acceder a una posicion que no existe
                     {
                         
                         ventana.txt_loteEjecutandose.setText(Integer.toString(Lotes.get(k).idLote));
                         
                                 
                         
                         tmeactual= (temporal.get(j).ObtenerTME());
                                 ventana.txt_programador.setText(temporal.get(j).ObtenerProgramador());
                                 ventana.txt_idproceso2.setText(Integer.toString(temporal.get(j).ObtenerId()));  
                                 ventana.txt_operacion.setText(temporal.get(j).ObtenerOperacion());
                                 ventana.txt_tme2.setText(Integer.toString(temporal.get(j).ObtenerTME()));
                                 tme=temporal.get(j).ObtenerTME();
                                 ventana.txt_tr.setText(Integer.toString(tme-(unidadtme))); 
                                 ventana.txt_tt.setText(Integer.toString(unidadtme));
                                 
                                  ventana.txt_reloj.setText(Integer.toString(relojGlobal));
                                  
                                  if(tmeactual==unidadtme)
                                 {                   
                                     j++;
                                     unidadtme=0;  
                                    
                                 } 
                                  
                                 
                                 //LOTES TERMINADOS
                                if(Lotes.get(k).tmelote==relojLote)
                                {
                                    for(int b=0;b<temporal.size();b++)
                                    {
                                      ventana.ta_loteTerminado.append(Integer.toString(Lotes.get(k).idLote));
                                      ventana.ta_loteTerminado.append("               "+temporal.get(b).ObtenerOperacion()+"\t");
                                      ventana.ta_loteTerminado.append(Integer.toString(temporal.get(b).ObtenerId()));
                                      ventana.ta_loteTerminado.append("\n");
                                 
                                    }
                                j=0;    
                                k++;
                                relojLote=0;
                                }                
                     }    
                   }
                     
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
    	
    	public static void main(String args[]){
       
                            
           
               Simulador objeto = new Simulador();
               objeto.IngresaProcesos();
            
               objeto.MostrarProcesoActual();
              
                   
       
          
              
               
                 
       
    
}

                      }
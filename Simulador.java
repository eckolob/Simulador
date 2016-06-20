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
        
   
    int cuentat=0,unidadtme=0,j=0,relojglobal=0;;
       
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
                                    
                                     lote = new Lote((cuentalotes+1),ProcesosTemporal);
                                     Lotes.set(cuentalotes, lote);
                                   //sin borrar array list de procesos como le digo que aguegue solo 5 procesos a cada bloque
                                     //OK que de lista procesos me pase a otra lista solo los procesos correspondientes (5)
                              
                             // Procesos.remove(p);
                               //Procesos.subList(0, 5).clear();
                                 
                                   cuentalotes++;
                                   cuentaprocesos=0;
    
                                 }  
                           else
                           {
                                lote = new Lote((cuentalotes+1),Procesos);
                          // lote.creaLote((cuentalotes+1),Procesos);
                           
                          
                         //  Lotes.add(cuentalotes,lote);
                           Lotes.set(cuentalotes, lote);
                           }
                          
                        
                       
                       }
                                  
                         	
       }while(error!=true||termina!=true);
       
       ventana.Simular();
        }
 
        
        public void MostrarLoteActual()
        {
             for( int m = 0 ; m  < Lotes.size(); m++)
                       {
                        Lotes.get(m).ObtenerIdLote();
                        temporal=Lotes.get(m).ObtenerProcesos();
                       }
             
               for( int i = 0 ; i  < Lotes.size(); i++)
                         {
                             for(int j=0;j<temporal.size();j++)
                             {
                                 ventana.txt_loteEjecutandose.setText(Integer.toString(Lotes.get(i).idLote));
                                 ventana.ta_loteActual.append("         "+(temporal.get(j).ObtenerId())+"\t   "+(temporal.get(j).ObtenerTME())+"\n"); 
                                 ventana.ta_loteActual.setLineWrap(true); 
                                 ventana.ta_loteActual.setWrapStyleWord(true);
                             }
                         }
            
        }
        
         public void MostrarProcesoActual()
        {
                
            Timer relojProcesos = new Timer();
             for( int m = 0 ; m  < Lotes.size(); m++)
                       {
                        Lotes.get(m).ObtenerIdLote();
                        temporal=Lotes.get(m).ObtenerProcesos();
                       }
                       
              TimerTask mostrarproceso=new TimerTask()
         {
          @Override
             public void run()
             {
               
                 cuentat++;
                 
               
                 //Cada que pasen 3 segundos es una unidadtme
                 if(cuentat%3==0)
                 {                
                     
                     unidadtme++;
                     if(j!=temporal.size()) //Para que no trate de acceder a una posicion que no existe
                     {
                         tmeactual= (temporal.get(j).ObtenerTME());
                     ventana.txt_programador.setText(temporal.get(j).ObtenerProgramador());
                                 ventana.txt_idproceso2.setText(Integer.toString(temporal.get(j).ObtenerId()));  
                                 ventana.txt_operacion.setText(temporal.get(j).ObtenerOperacion());
                                 ventana.txt_tme2.setText(Integer.toString(temporal.get(j).ObtenerTME()));
                                 tme=temporal.get(j).ObtenerTME();
                                 ventana.txt_tr.setText(Integer.toString(tme-(unidadtme))); 
                                 ventana.txt_tt.setText(Integer.toString(unidadtme));
                                  if(tmeactual==unidadtme)
                                 {
                                     j++;
                                     unidadtme=0;
                                     
                                     
                                 } 
                     }
                    
                        
                 }
                 
            
             }
                 
         };
              relojProcesos.scheduleAtFixedRate(mostrarproceso,1,500); 
              
         
                           
                                 
 
        }
         
          public void MostrarLoteTerminado()
        {
             for( int m = 0 ; m  < Lotes.size(); m++)
                       {
                        Lotes.get(m).ObtenerIdLote();
                        temporal=Lotes.get(m).ObtenerProcesos();
                       }
             for( int i = 0 ; i  < Lotes.size(); i++)
                         {
                             for(int j=0;j<temporal.size();j++)
                             {
                                ventana.ta_loteTerminado.append(Integer.toString(Lotes.get(i).idLote));
                                ventana.ta_loteTerminado.append("               "+temporal.get(j).ObtenerOperacion()+"\t");
                                ventana.ta_loteTerminado.append(Integer.toString(temporal.get(j).ObtenerId()));
                                ventana.ta_loteTerminado.append("\n");
                                    }
                         }
        }
         
        
          
          public void MostrarReloj()
          {
               ventana.txt_reloj.setText(Integer.toString(relojglobal));
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
       
                            
            Timer relojGlobal = new Timer();
               Simulador objeto = new Simulador();
               objeto.IngresaProcesos();
               objeto.MostrarLoteActual();
               objeto.MostrarProcesoActual();
                
                   
       
            
                       
              TimerTask mostrarRelojGlobal=new TimerTask()
         {
          @Override
             public void run()
             {
             
                 
                 if(objeto.cuentat%3==0)
                 {  
                     objeto.relojglobal++;
                     objeto.MostrarReloj(); 
                    
                 }
              
             }
               
               
                 
         };
              relojGlobal.schedule(mostrarRelojGlobal,1,500); 
              
               
                 
       
    
}

                      }
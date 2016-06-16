
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
 
public class Simulador {
 	Lote lote = new Lote();	
        Proceso p=new Proceso();
        Interfaz ventana =new Interfaz();
       
    boolean tal=false,error=false;
    //Esta array list es para extraer los lotes de donde se almacenan y mostrarlos
    ArrayList <Proceso> temporal;
    //En estas array list se guardan los procesos y lotes
    ArrayList <Lote> Lotes;
    ArrayList <Proceso> LoteTemporal;
    ArrayList <Proceso> Procesos;
    int reloj;
    int lotesreq=0;
    int num1,num2;
  
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
         LoteTemporal = new ArrayList();
         
         
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
 
    public void menu(){
  
    	int cuentaprocesos2=0;
       int cuentaprocesos=0;
      
        
    	
        String op;

        procesosrecibidos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero de procesos: "));
         lotesreq=lote.CalcularLotes(procesosrecibidos); 
          int tam=0;
          int cuentalotes=1;
          
       do{
                                   
 		reloj++;	
                              
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
                        
                        //Agregar objeto a la lista
                        //Aqui se borro el lote que tenia y se encima el nuevo
                        
                       
                        
                         p=new Proceso(id,programador,tme,resultado);
                         Procesos.add(p);  
                         lote=new Lote(cuentalotes,Procesos);
                         cuentaprocesos++;//controla la asignacion de idlote
                         cuentaprocesos2++;//controla el while
                          int l=1;
                         if((cuentaprocesos%5)==0)                      
                                 {
                                   
                                   Lotes.add(lote);
                                   cuentalotes++;
                                   cuentaprocesos=1;
                                   //Cuando borro el arraylistprocesos se borran los procesos de ese arraylist que ya habia guardado en otro array
                                  //intentar con metodo subList(int fromIndex, int toIndex) 
                                   //http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html#method_summary
                                   
                                 }
        
                         
                       }
                                  
                         	
       }while(error!=true||termina!=true);
       
       
    //Ver lote
                           ventana.Simular();
                           
               
                      //Mostrar lote completo
                       for( int m = 0 ; m  < Lotes.size(); m++)
                       {
                        Lotes.get(m).ObtenerIdLote();
                        Lotes.get(m).ObtenerProcesos();
                       }
                       
                         for( int i = 0 ; i  < Lotes.size(); i++)
                         {
                             for(int j=0;j<Lotes.get(i).procesosLote.size();j++)
                             {
                                 ventana.txt_programador.setText(Lotes.get(i).procesosLote.get(j).ObtenerProgramador());
                         ventana.txt_idproceso2.setText(Integer.toString(Lotes.get(i).procesosLote.get(j).ObtenerId()));  
                           ventana.txt_operacion.setText(Lotes.get(i).procesosLote.get(j).ObtenerOperacion());
                           ventana.txt_tme2.setText(Integer.toString(Lotes.get(i).procesosLote.get(j).ObtenerTME()));
                           
                           ventana.txt_loteEjecutandose.setText(Integer.toString(Lotes.get(i).idLote));
                           
                           ventana.ta_loteTerminado.append(Integer.toString(Lotes.get(i).idLote));
                           ventana.ta_loteTerminado.append("               "+Lotes.get(i).procesosLote.get(j).ObtenerOperacion()+"\t");
                           ventana.ta_loteTerminado.append(Integer.toString(Lotes.get(i).procesosLote.get(i).ObtenerId()));
                            ventana.ta_loteTerminado.append("\n");
                             }
                         
                 
                           ventana.ta_loteActual.append("         "+ventana.txt_idproceso2.getText()+"\t   "+ventana.txt_tme2.getText()+"\n"); 
                           ventana.ta_loteActual.setLineWrap(true); 
                           ventana.ta_loteActual.setWrapStyleWord(true);
                                             
                       
                           
                           
                       }
                            
                            ventana.txt_reloj.setText(Integer.toString(reloj));
                   
    
    SwingUtilities.updateComponentTreeUI(ventana);                
                    
      
       
       
       
    }
 
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
        objeto.menu();
    }   
}

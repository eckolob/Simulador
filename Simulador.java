
import java.util.ArrayList;
import javax.swing.JOptionPane;
 
public class Simulador {
 	Lote lote = new Lote();	
        Proceso p=new Proceso();
        Interfaz ventana =new Interfaz();
       
    boolean tal=false,error=false;
    //Esta array list es para extraer los lotes de donde se almacenan y mostrarlos
    ArrayList <Proceso> temporal;
    //En estas array list se guardan los procesos y lotes
    ArrayList <Lote> Lotes;
    ArrayList <Proceso> Procesos;
    int reloj;
    int lotesreq=0;
    int num1,num2;
  
    boolean termina=false;
      int id,tme,procesosrecibidos; String programador,resultado;
    //Contador que lleva el tiempo (determinar mi unidad de tiempo
    //ejemplo 1 tme = x segundos controlados por un delay
      
      
      
      
      
      public Simulador()
      {
          
          Lotes= new ArrayList<> (); 
         Procesos= new ArrayList<> (); 
         temporal = new ArrayList();
         
         
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
		 int residuo= n1/n2;
		 resultado=""+n1+" / "+n2+" = "+residuo;	
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
  
    	int cuentaprocesos=0;
        String opcion="0";
        
    	
        String op;

        procesosrecibidos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero de procesos: "));
         lotesreq=lote.CalcularLotes(procesosrecibidos); 
          
          
       do{
           op = JOptionPane.showInputDialog(null,"1.\n  Ver Interfaz\n"
                                              + "2.  Introducir datos\n"
                                              +"3.  Mostrar datos\n"
                                              +"4.  Salir");
                                              
 		reloj++;	
           switch(op){
               case "1"://Ver lote
                            ventana.Simular();
               
                      //Mostrar lote completo
                       for( int m = 0 ; m  < Lotes.size(); m++)
                       {
                        Lotes.get(m).ObtenerIdLote();
                       temporal= Lotes.get(m).ObtenerProcesos();
                       }
                       
                         for( int i = 0 ; i  < temporal.size(); i++)
                         {
                         ventana.txt_programador.setText(temporal.get(i).ObtenerProgramador());
                         ventana.txt_idproceso2.setText(Integer.toString(temporal.get(i).ObtenerId()));  
                           ventana.txt_operacion.setText(temporal.get(i).ObtenerOperacion());
                           ventana.txt_tme2.setText(Integer.toString(temporal.get(i).ObtenerTME()));
                           
                           ventana.txt_loteEjecutandose.setText(Integer.toString(Lotes.get(i).idLote));
                           
                           ventana.ta_loteTerminado.append(Integer.toString(Lotes.get(i).idLote));
                           ventana.ta_loteTerminado.append("               "+temporal.get(i).ObtenerOperacion()+"\t");
                           ventana.ta_loteTerminado.append(Integer.toString(temporal.get(i).ObtenerId()));
                            ventana.ta_loteTerminado.append("\n");
                 
                           ventana.ta_loteActual.append("         "+ventana.txt_idproceso2.getText()+"\t   "+ventana.txt_tme2.getText()+"\n"); 
                           ventana.ta_loteActual.setLineWrap(true); 
                           ventana.ta_loteActual.setWrapStyleWord(true);
                                             
                       
                           
                           
                       }
                            
                            ventana.txt_reloj.setText(Integer.toString(reloj));
                   break;
               case "2"://Bloque para introducir datos al array list
                        
                        if(cuentaprocesos==procesosrecibidos)
           	{
           		 termina=true;
                         JOptionPane.showMessageDialog(null, "Ya no puedes ingresar mas procesos!", "", JOptionPane.ERROR_MESSAGE);
                        break;
           	}
                        
 						
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID: "));
                        
                        for(int z=0;z<Procesos.size();z++)
                        {
                            if(id==Procesos.get(z).ObtenerId())
                                {
                                    JOptionPane.showMessageDialog(null, "Id Duplicado!", "", JOptionPane.ERROR_MESSAGE);
                                    error=true;
                                    break;
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
                        
                        //La variable operacion tiene algo mal y reemplaza a la operacion anterior
                         p=new Proceso(id,programador,tme,resultado);
                         cuentaprocesos++;
                         
                        Procesos.add(p);  
                   
                       
                       for( int i = 0 ; i  < Procesos.size(); i++){  
                           
                           
                           //A listaLotes en el indice i agregale el proceso en la posicion i
                           lote.procesosLote.add(i, Procesos.get(i)); 
                           {
                               //Se  me estan creando el mismo numero de procesos que de lotes y con el mismo proceso en todas las posiciciones
                               for (int a=0;a<lotesreq;a++)
                               {//Cada que a aumente guarda un lote nuevo en la lista Lotes
                                lote=new Lote(a+1,lote.procesosLote);
                                //Se agrega un objeto tipo Lote, lo cual significa que ya no necesito calcular que tenga entre 1 y 5 
                                //procesos, porque ya se creo con esa especificacion
                                Lotes.add(lote);
                               }
                               
                           }
                                    
                                    
                       }
                    
                        
                  
                            
                        }
                          
                   break;
              
               case "3"://Bloque para mostar los datos del array list
                  
                       String Muestra= "";
                       for( int i = 0 ; i  < Procesos.size(); i++){
                        Muestra += "Id: "+Procesos.get(i).ObtenerId();
                        Muestra += "\nProgramador: "+Procesos.get(i).ObtenerProgramador();
                        Muestra += "\nOperacion: "+Procesos.get(i).ObtenerOperacion();
                        Muestra += "\nTME: "+Procesos.get(i).ObtenerTME();
                        Muestra += "\n"+"\n";
                       }
                        JOptionPane.showMessageDialog(null, Muestra);
                        
                                    
                   break;                   
               case "4":
                   System.exit(0);
                   break;
               default:
                   JOptionPane.showMessageDialog(null, "Opcion invalida !");
                   break;
           }      
           	
      
                       
                               	
       }while(!op.equals("7")||termina!=true);
       
       
   
                   
      /*
              int j=0,h=4;
	    	for(int i=0;i<=lotesreq;i++)
                {
                    //Si encuentra procesos en la lista entre la posicion 0 y 4 que cree un lote con ellos
                     for(int c=j;c<=h;c++)
                        { 
                          lote.procesosLote.add(c,Procesos.get(c));
                        }   
                   lote = new  Lote(i+1,lote.procesosLote);//Agregar a objeto lote
                   Lotes.add(lote);//agregar lote al arraylist de lotes
                    //despues aumenta para que busque de 5 en 5 en las posiciones del arraylist
                    j+=4;
                    h+=j+4;
                }
       */
                
                    
                    
      
       
       
       
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

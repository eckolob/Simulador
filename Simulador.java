
import java.util.ArrayList;
import javax.swing.JOptionPane;
 
public class Simulador {
 	Lote lote = new Lote();	
        Proceso p=new Proceso();
       
    boolean tal=false;
    
    ArrayList <Lote> Lotes;
    ArrayList <Proceso> Procesos;
    int reloj;
    int lotesrequeridos=0;
    int num1,num2;
    String operacion="";
  
    boolean termina=false;
      int id,tme,procesosrecibidos; String programador;
    //Contador que lleva el tiempo (determinar mi unidad de tiempo
    //ejemplo 1 tme = x segundos controlados por un delay
      
      
      public Simulador()
      {
         Lotes= new ArrayList<> (); 
         Procesos= new ArrayList<> (); 
      }
 
    public void menu(){
  
    	int cuentaprocesos=0;
        String opcion="0";
    
    	
        String op;
          procesosrecibidos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero de procesos: "));
          lotesrequeridos=lote.CalcularLotes(procesosrecibidos);
          
          
       do{
           op = JOptionPane.showInputDialog(null,"2.  Introducir datos\n"
                                              +"3.  Modificar datos\n"
                                              +"4.  Eliminar datos\n"
                                              +"5.  Buscar datos\n"
                                              +"6.  Mostrar datos\n"
                                              +"7.  Salir");
                                              
 			
           switch(op){
               case "2"://Bloque para introducir datos al array list
                     
                        if(cuentaprocesos==procesosrecibidos)
           	{
           		 termina=true;
                         JOptionPane.showMessageDialog(null, "Ya no puedes ingresar mas procesos!", "", JOptionPane.ERROR_MESSAGE);
                        break;
           	}
                        
 						
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID: "));
                        programador = JOptionPane.showInputDialog(null, "Programador: ");
                        tme = Integer.parseInt(JOptionPane.showInputDialog(null, "TME: "));
                        num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero: "));
                        num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero: "));
                        opcion = JOptionPane.showInputDialog(null, "1)Suma\n2)Resta\n3)Multiplicacion\n4)Division\n5)Residuo\n6)Potencia: ");
                        switch(opcion)
                        {
                        	case "1":operacion=p.Sumar(num1,num2);
                        		break;
                        	case "2":operacion=p.Restar(num1,num2);
                        		break;
                        	case "3":operacion=p.Multiplicar(num1,num2);
                        		break;
                        	case "4":operacion=p.Dividir(num1,num2);
                        		break;
                        	case "5":operacion=p.Residuo(num1,num2);
                        		break;
                        	case "6":operacion=p.Potencia(num1,num2);
                        		break;
                        
                        		default:
                        			
                        }
                        
                        //Agregar objeto a la lista
                         p=new Proceso(id,programador,tme,operacion);
                        Procesos.add(p);  
                        cuentaprocesos++;
                          
                            // Procesos.add(new Proceso(id,programador,tme,operacion));
                        
                         
                    
                       	/*
                        if(Procesos.size()<=lote.capacidad)
                        {
							int x=1;	
								if(x!=lotesrequeridos)
								{
								 Lotes.add(new Lote(x,Procesos));	
								 	x++;
								}
				
                         	cuentaprocesos=0;
                        }
                       
                      */
                        	                       
                                    
                   break;
               case "3"://Bloque para modificar datos al array list
                   
                        int indice, b;
                        String c;
                        b = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el indice(id) a Modificar: "));
                        if(existeEnArray(b)){                            
                            indice = indiceDato(b);
                            c = JOptionPane.showInputDialog(null, "Programador: ");
                            Procesos.get(indice).AsignarNombre(c); 
                            	//Aqui se puede indicarle que modifique mas atributos invocando al metodo asignarATRIBUTO() creado en Proceso
                        }else{
                            JOptionPane.showMessageDialog(null, "No existe el dato a modificar !", "", JOptionPane.ERROR_MESSAGE);
                        }
                                 
                   break;
               case "4"://Bloque para eliminar dato del array
                   
                   
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id a eliminar: "));
                        for(int i=0; i<Procesos.size(); i++){
                            if(Procesos.get(i).ObtenerId()==id){
                                Procesos.remove(i);
                            }
                        }
                     
                   break;
               case "5"://Bloque para buscar datos en el array list
                  
                        String mostrarBus= "No se ha encontrado nada!";
                        
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id a buscar: "));
                        for( int i = 0 ; i  < Procesos.size(); i++){
                        	//Obtener el id del objeto almacenado en la posicion 0,1,2,...
                            if(Procesos.get(i).ObtenerId()==id){
                                mostrarBus  ="";
                                mostrarBus += "Id: "+Procesos.get(i).ObtenerId();
                                mostrarBus += "\nNombre "+Procesos.get(i).ObtenerProgramador();
                                mostrarBus += "\nOperacion "+Procesos.get(i).ObtenerOperacion();
                                mostrarBus += "\nTME: "+Procesos.get(i).ObtenerTME();
                                mostrarBus += "\n"+"\n";
                            }                        
                       }
                         JOptionPane.showMessageDialog(null, mostrarBus);
                  
 
                   break;
               case "6"://Bloque para mostar los datos del array list
                  
                       String Salida= "";
                       for( int i = 0 ; i  < Procesos.size(); i++){
                        Salida += "Id: "+Procesos.get(i).ObtenerId();
                        Salida += "\nProgramador: "+Procesos.get(i).ObtenerProgramador();
                        Salida += "\nOperacion: "+Procesos.get(i).ObtenerOperacion();
                        Salida += "\nTME: "+Procesos.get(i).ObtenerTME();
                        Salida += "\n"+"\n";
                       }
                        JOptionPane.showMessageDialog(null, Salida);
                                    
                   break;                   
               case "7":
                   System.exit(0);
                   break;
               default:
                   JOptionPane.showMessageDialog(null, "Opcion invalida !");
                   break;
           }      
           	
           	
       }while(!op.equals("7")||termina!=true);
       
     
      
       
       
       
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

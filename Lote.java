import java.util.ArrayList;
public class Lote{

 
	int capacidad=5;
	int lotesRequeridos;
      ArrayList <Proceso> procesosLote;
    
    //Datos de entrada
     

   
    
    
    //Datos de salida
    int lotesPendientes;
    int idLote;
    //id lote identificara el lote en ejecucion, el cual tendra sus 5 procesos asignados y aumentara cada que el idprocesos cuente 5 procesos
	//
    public Lote()
    {  	
    	//Si creo un objeto y no le paso parametros se ejecuta este metodo constructor
    	//Los atributos se inicializan con los valores por defecto del sistema
       
        procesosLote = new  ArrayList();
    } 
  
    public Lote(int id, ArrayList <Proceso> Procesos){
    	//Si creo un objeto y le paso estos parametros se ejecuta este metodo constuctor
    	//Los atributos se inicializan con los valores que recibe como parametro
        this.idLote= id; 
        
        this.procesosLote = Procesos;
    }
 
    public int ObtenerIdLote() {
        return idLote;
    }
 
   
    
    public void ObtenerLotesPendientes() {
        //determinar que recibira y que retornara
    }
    
    public ArrayList ObtenerProcesos()
    {
        return procesosLote;
    }
    
    
 
    public void LoteProcesandose() {
       //    determinar que recibira y que retornara    
    }   
    	
    	
    	public int CalcularLotes(int procesosrecibidos)
	{
		int residuo=0;
		//En este metodo le asignare el id al lote 
	
	    if(procesosrecibidos>0) 
	    {
                
	    	lotesRequeridos=procesosrecibidos/capacidad;
                
	    	residuo=procesosrecibidos%capacidad;
	    	if(residuo>0)
	    	{
	    		lotesRequeridos++;
	    	}
	    }
	   return lotesRequeridos; 
	} 
		
        
        
        
		
}
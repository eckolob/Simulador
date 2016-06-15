
public class Proceso{
 
    
    
    //Datos de entrada
    String programador;
	int idProceso,tme,num1,num2;
	
   // int[] idsProcesos = new int[l.procesosrecibidos];//hacer metodo obtener procesosrecibidos para invocarlo desde aqui y que me regrese 
    //el numero de procesos que recibio el objeto lote
    
    //Datos de salida
	String operacion;
	int tr,tt;
	
    public Proceso()
    {  	
        programador="";
        idProceso=0;
        tme=0;
        num1=0;
        num2=0;
        operacion="";
        tr=0;
        tt=0;
    	//Si creo un objeto y no le paso parametros se ejecuta este metodo constructor
    	//Los atributos se inicializan con los valores por defecto del sistema
    } 
  
    public Proceso(int id, String nombre,int tme,String op){
    	//Si creo un objeto y le paso estos parametros se ejecuta este metodo constuctor
    	//Los atributos se inicializan con los valores que recibe como parametro
        this.idProceso = id;
        this.programador  = nombre;  
        this.tme = tme;   
        this.operacion = op;   
    }
 
    public int ObtenerId() {
        return idProceso;
    }
 
    public String ObtenerProgramador() {
        return programador;
    }
    
    public int ObtenerTME() {
        return tme;
    }
    
    public String ObtenerOperacion()
    {
    	return operacion;
    }
    
 
    public void AsignarNombre(String d) {
        this.programador = d;        
    }    
    	
    	

   	
  
    	
}
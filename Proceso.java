
public class Proceso{
 
    
    
    //Datos de entrada

	int idProceso,tme,num1,num2;
	
   // int[] idsProcesos = new int[l.procesosrecibidos];//hacer metodo obtener procesosrecibidos para invocarlo desde aqui y que me regrese 
    //el numero de procesos que recibio el objeto lote
    
    //Datos de salida
	String operacion;
	int tr,tt;
        boolean nuevo,listo,ejecucion,terminado,bloqueado;
	
    public Proceso()
    {  	
  
        idProceso=0;
        tme=0;
        num1=0;
        num2=0;
        operacion="";
        tr=0;
        tt=0;
        nuevo=false;
        listo=false;
        ejecucion=false;
        terminado=false;
        bloqueado=false;
    	//Si creo un objeto y no le paso parametros se ejecuta este metodo constructor
    	//Los atributos se inicializan con los valores por defecto del sistema
    } 
  
    public Proceso(int id,int tme,String op,int t){
    	//Si creo un objeto y le paso estos parametros se ejecuta este metodo constuctor
    	//Los atributos se inicializan con los valores que recibe como parametro
        this.idProceso = id;
        this.tr=t;
        this.tme = tme;   
        this.operacion = op;   
        nuevo=false;
        listo=false;
        ejecucion=false;
        terminado=false;
        bloqueado=false;
    }
 
    public int ObtenerId() {
        return idProceso;
    }
 
    
    public int ObtenerTME() {
        return tme;
    }
    
    
    public void AsignarTR(int x)
    {
        this.tr=x;
    }
    
    public int ObtenerTR()
    {
     return this.tr;    
    }
    
    public void AsignarTT(int y)
    {
        this.tt=y;
    }
    
    public int ObtenerTT()
    {
    	return tt;
    }
    
    public String ObtenerOperacion()
    {
    	return operacion;
    }
    
    public void AsignarOperacion(String o)
    {
        this.operacion=o;
    }
    
    public boolean ObtenerEstadoNuevo()
    {
        return nuevo;
    }
    public boolean ObtenerEstadoListo()
    {
        return listo;
    }
    public boolean ObtenerEstadoEjecucion()
    {
        return ejecucion;
    }
    public boolean ObtenerEstadoTerminado()
    {
        return terminado;
    }
    public boolean ObtenerEstadoBloqueado()
    {
        return bloqueado;
    }
    

public void AsignarEstado(boolean n,boolean l,boolean e,boolean t,boolean b)
{
     this.nuevo=n;
     this.listo=l;
     this.ejecucion=e;
     this.terminado=t;
     this.bloqueado=b;
}


    	
}

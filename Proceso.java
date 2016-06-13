
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
        
    	//Si creo un objeto y no le paso parametros se ejecuta este metodo constructor
    	//Los atributos se inicializan con los valores por defecto del sistema
    } 
  
    public Proceso(int id, String nombre,int tme,String operacion){
    	//Si creo un objeto y le paso estos parametros se ejecuta este metodo constuctor
    	//Los atributos se inicializan con los valores que recibe como parametro
        this.idProceso = id;
        this.programador  = nombre;  
        this.tme = tme;   
        this.operacion = operacion;   
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
    	
    		public String Sumar(int n1,int n2)
	{
		int suma= n1+n2;
		operacion=""+n1+" + "+n2+" = "+suma;
		return  operacion;
	}
	
	public String Restar(int n1,int n2)
	{
		int resta= n1-n2;
		operacion=""+n1+" - "+n2+" = "+resta;
		return  operacion;
	}
	
	public String Multiplicar(int n1,int n2)
	{
		int mult= n1*n2;
		operacion=""+n1+" * "+n2+" = "+mult;
		
		return  operacion;
	}
	
	public String Dividir(int n1,int n2)
	{
		if(n2<=0)
		{
		 	operacion="Error";	
		}
		else
		{
		 int div= n1/n2;
		 operacion=""+n1+" / "+n2+" = "+div;	
		}
	
		
		return  operacion;
	}
	
	public String Residuo(int n1,int n2)
	{
		if(n2<=0)
		{
		 	operacion="Error";	
		}
		else
		{
		 int residuo= n1/n2;
		 operacion=""+n1+" / "+n2+" = "+residuo;	
		}
		return  operacion;
	}
	
	public String Potencia(int n1,int n2)
	{
	 int potencia=(int) Math.pow(n1, n2);;
		operacion=""+n1+" ^ "+n2+" = "+potencia;
		return  operacion;	
	}

   	
  
    	
}
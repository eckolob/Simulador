import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


 
public class Interfaz extends JFrame implements KeyListener{
    
    boolean I_e,I_w,I_p,I_c=false;
    
    JTextArea ta_loteActual,ta_loteTerminado;
    JScrollPane sp_loteActual,sp_loteTerminado;
 
    JLabel et_lotesPendientes,et_loteEjecutandose,et_Idproceso,et_tme;//Etiquetas Panel LoteActual
    JLabel et_procesoEjecutandose,et_idproceso2,et_operacion,et_tme2,et_tr,et_tt; //Etiquetas Panel Proceso Actual
    JLabel et_lotesTerminados,et_lote,et_operacion2,et_idproceso3;//Etiquetas Panel Lotes Terminados
    JLabel et_reloj,et_tr2;
    JLabel et_tecla;

    JTextField txt_tecla;
    JTextField txt_lotesPendientes,txt_loteEjecutandose;//txt Panel LoteActual
            //jtextarea para los idproceso e tme      
            //investigar donde puedo mostrar el contador del reloj, barrade progreso o con numeritos
    JTextField txt_idproceso2, txt_operacion, txt_tme2, txt_tr, txt_tt; //txt Panel Proceso Actual
    //txt Panel lotes terminados jtextarea para mostrar lotes terminados
    JTextField txt_reloj;
    public Interfaz()
    {
       
    }
    
   
    
    
    public void Simular()
    {
        int x=200,y=60,ancho=150,alto=20;
 
        JFrame ventana = new JFrame("Simulador de Procesamiento por Lotes");  
        ventana.setLayout(null);
        
        
        
        et_reloj = new JLabel("Reloj:");
        et_reloj.setBounds(10,240,40,20);
        ventana.add(et_reloj);
        
        
        et_tecla = new JLabel("Tecla");
        et_tecla.setBounds(x+30,240,40,20);
        ventana.add(et_tecla);
        
        txt_tecla = new JTextField();
        txt_tecla.setBounds(x+70,240,40,20);
        txt_tecla.addKeyListener(this);
        ventana.add(txt_tecla);
        
        txt_reloj = new JTextField();
        txt_reloj.setBounds(42,240,40,20);
        txt_reloj.setEditable(false);
        ventana.add(txt_reloj);
       
        
        //Componentes LOTE EN EJECUCION
        et_lotesPendientes = new JLabel("Lotes Pendientes:");
        et_lotesPendientes.setBounds(10,15, 120, 10);
        ventana.add(et_lotesPendientes);     
        
        txt_lotesPendientes  = new JTextField();
        txt_lotesPendientes.setBounds(112,10, 20, 20);
        txt_lotesPendientes.setEditable(false);
        ventana.add(txt_lotesPendientes);
        
         et_loteEjecutandose =new JLabel("Lote Ejecutandose:");
         et_loteEjecutandose.setBounds(35,30,120, 20);
         ventana.add(et_loteEjecutandose);
     
        txt_loteEjecutandose = new JTextField();
        txt_loteEjecutandose.setBounds(145, 30, 20, 20);
        txt_loteEjecutandose.setEditable(false);
        ventana.add(txt_loteEjecutandose);       
        
        et_Idproceso = new JLabel("ID Proceso");
        et_Idproceso.setBounds(40, 60, 100, 20);
        ventana.add(et_Idproceso);
        
        et_tme = new JLabel("TME");  
        et_tme.setBounds(120, 60, 50, 20);
        ventana.add(et_tme);   
        
         et_tr2 = new JLabel("TR");  
        et_tr2.setBounds(170, 60, 50, 20);
        ventana.add(et_tr2); 
        
        ta_loteActual = new JTextArea();
        sp_loteActual = new JScrollPane(ta_loteActual);
        sp_loteActual.setBounds(20,80,180,150);
        ta_loteActual.setEditable(false);
        ventana.add(sp_loteActual);
        
        
        //Componentes Proceso en ejecucion
         et_procesoEjecutandose = new JLabel("Proceso en Ejecucion");
         et_procesoEjecutandose.setBounds(x+30, 30, ancho, 20);
         ventana.add(et_procesoEjecutandose );
       
    
        et_idproceso2           = new JLabel("Id:");
        et_idproceso2.setBounds         (x, y+40, 20, 20);
        ventana.add(et_idproceso2 );
          
        et_operacion            = new JLabel("Operacion:");
        et_operacion.setBounds          (x, y+60, 70, 20);
        ventana.add(et_operacion);
        
        et_tme2                 = new JLabel("TME:");
        et_tme2.setBounds               (x, y+80, 40, 20);
         ventana.add(et_tme2);
               
        et_tr                   = new JLabel("TR:");
        et_tr.setBounds                 (x, y+100, 40, 20);
        ventana.add(et_tr );
               
        et_tt                   = new JLabel("TT:");
        et_tt.setBounds                 (x, y+120, 40, 20);
        ventana.add(et_tt);     
        
    
         
         
         txt_idproceso2     = new JTextField();
         txt_idproceso2.setBounds(x+90, y+40, 90, 20);
         txt_idproceso2.setEditable(false);
         ventana.add(txt_idproceso2);
         
         
         txt_operacion      = new JTextField();
         txt_operacion.setBounds(x+90, y+60, 90, 20); 
         txt_operacion.setEditable(false);
         ventana.add(txt_operacion);
         
         txt_tme2           = new JTextField();
         txt_tme2.setBounds(x+90, y+80, 90, 20); 
         txt_tme2.setEditable(false);
         ventana.add(txt_tme2);
        
         txt_tr             = new JTextField();
         txt_tr.setBounds(x+90, y+100, 90, 20);
         txt_tr.setEditable(false);
         ventana.add(txt_tr );
         
         txt_tt             = new JTextField();
         txt_tt.setBounds(x+90, y+120, 90, 20);
         txt_tt.setEditable(false);
         ventana.add(txt_tt);
   
       
       //Componentes Lotes Terminados
        et_lotesTerminados  = new JLabel("Lotes Terminados");
        et_lotesTerminados.setBounds(450, 30, ancho, 20);
        ventana.add(et_lotesTerminados); 
        
        et_lote             = new JLabel("Lote");
        et_lote.setBounds(430, y, 50, 20);
        ventana.add(et_lote);
        
        et_operacion2       = new JLabel("Operacion");
        et_operacion2.setBounds(480, y, 70, 20);
        ventana.add(et_operacion2);
        
        et_idproceso3       = new JLabel("ID");
        et_idproceso3.setBounds(590, y, 20, 20);     
        ventana.add(et_idproceso3);     
         
        ta_loteTerminado = new JTextArea();
        sp_loteTerminado = new JScrollPane(ta_loteTerminado);
        sp_loteTerminado.setBounds(430,80,210,150);
        ta_loteTerminado.setEditable(false);
        ventana.add(sp_loteTerminado);
    
        //Propiedades de la ventana principal
        ventana.setLocation(100, 50);
        ventana.setResizable(true);
        ventana.setVisible(true);
        ventana.setSize(700, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getSource()==txt_tecla)
        {
             if (e.VK_E==e.getKeyCode())
             {
                
                I_e=true;
             }
         }
        if (e.getSource()==txt_tecla)
        {
             if (e.VK_W==e.getKeyCode())
             { 
                I_w=true;
             }
         }
         if (e.getSource()==txt_tecla)
        {
             if (e.VK_P==e.getKeyCode())
             {
                I_p=true;
             }
         }
          if (e.getSource()==txt_tecla)
        {
             if (e.VK_C==e.getKeyCode())
             {
        
                I_c=true;
             }
         }
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {//SI se suelta la tecla
        
        I_e=false;
        I_w=false;
        I_p=false;
        I_c=false;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    


  
 
     
}
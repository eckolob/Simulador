# Simulador
Bugs:
1.Cuando mando todos los procesos a bloqueados se para el programa y deberia seguir contando el reloj global y el tiempo transcurrido que lleva cada proceso en bloqueados
2.Tambien irregularidades con los tiempos
3.-Arroja exepcion al tratar de agregar mas de 5 procesos a bloqueados (no se debe permitir)
4.-No funciona la interrupcion C, La solucion temporal es dejar que se pause cierto tiempo y se despause solo, pero el requisito es despausarlo pulsando una tecla

Soluciones
1.Se corrigio el bug 1 indicando que solo pare el reloj cuando la memoria (Estados bloqueado, listo y ejecucion) este vacia (no se habia contenplado el estado bloqueado)
2.-Analizando las practicas previas note que al modificar esta linea:
 if( Memoria.get(j).ObtenerTR()==unidadtme||ventana.I_w==true)
 por esta
  if( Memoria.get(Memoria.size()-1).ObtenerTR()==unidadtme||ventana.I_w==true)
  fue lo que origino el error que altero el reloj
  3.- Restringido
  
  

package apuesta;

/**
 * La clase Apuesta rellena los datos de una apuesta con el dinero disponible y el que se puede apostar.
 * 
 * @author ikloerzer
 * @version 1.0
 * 
 * */
public final class Apuesta {
	
	/**
	 * Variable numérica que se refiere a la cantidad
	 * de dinero disponible.
	 */
    private int dineroDisp;
    
    /**
     * Variable numérica que cuenta la cantidad de 
     * goles del equipo local. 
     */
    private static int golesLocal;
    
    /** 
     * Variable numérica que cuenta la cantidad de 
     * goles del equipo visitante.
     */
    private static int golesVisitantes;
    
    /**
     * Variable numérica que cuenta el dinero apostado
     * */
    private static int apostado;
    
    /**
     * Constructor por defecto Apuesta
     * es una función
     */
    public Apuesta  () {
    	//Constructor que asigna a los atributos valores por defecto.
    }

    /**
     * Contructor con par�metros
     *
     *@param dineroDisp dinero disponible
     *@param golesLocal goles marcados por el equipo local
     *@param golesVisitante goles marcados por el equipo visitante
     */
    public Apuesta (int dineroDisp, int golesLocal, int golesVisitante) {
        this.dineroDisp = dineroDisp;
        this.golesLocal = golesLocal;
        this.golesVisitantes = golesVisitante;
        this.apostado = 0;
    }
    
    /**
     * Función para obtener el valor del atributo dinero_disp
     * 
     * @return el dinero disponible
     */
    public int getDineroDisp() {
        return dineroDisp;
    }
    
    /**
     * Función para modificar el valor del atributo dinero_disp
     * 
     * @param dineroDisp
     */
    public void setDineroDisp(int  dineroDisp) {
        this.dineroDisp = dineroDisp;
    }

    /**
     * Función para apostar. Permite elegir la cantidad a apostar, no pudiendo 
     * ser inferior a 1 ni superior a tu saldo disponible
     * 
     * @param dinero Coge la variable dinero del main.
     * @throws No se puede apostar menos de 1 euro
     * @throws No se puede apostar más del dinero que se tiene
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Error ("No se puede apostar menos de 1�");
        }

        if (dinero > dineroDisp) {
            throw new Error ("No se puede apostar m�s de lo que tienes");
        }
        {
            dineroDisp = dinero - dineroDisp;
            apostado = dinero;
        }
    }
    
    /**
     * Función que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. 
     * @param local Goles del equipo local.
     * @param visitante Goles del equipo visitante
     * @return acertado Devuelve un booleano sobre si un equipo ha metido gol.
     * @throws No se pueden meter menos de 0 goles.
     */
    public boolean comprobarResultado(int local, int visitante) throws Exception {
        boolean acertado=false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (golesLocal == local && golesVisitantes == visitante) {
            acertado = true;
        }
        return acertado;
    }
    
    /**
     * Función para cobrar la apuesta. Comprueba que se acert� el resultado y,
     * en ese caso, a�ade el valor apostado multiplicado por 10 al saldo disponible
     * 
     * @param cantGolesLocal dinero apostado sobre los goles del equipo local
     * @param cantGolesVisitante dinero apostado sobre los goles eq visit
     * @throws No se puede cobrar una apuesta no acertada
     */
    final void cobrarApuesta(int cantGolesLocal, int cantGolesVisit) throws Exception {

        if (!comprobarResultado(cantGolesLocal, cantGolesVisit)) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        dineroDisp = dineroDisp * 10;

    }
}

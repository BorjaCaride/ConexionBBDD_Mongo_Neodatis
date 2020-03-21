
package validaciones;

/**
 *
 * @author a16raulic
 */
public class MisExcepciones extends Exception{
    
    private String error;

   

    public MisExcepciones(String message) {
        super(message);
        this.error=message;
    }

    public String getError() {
        return error;
    }


    public MisExcepciones() {
    }
}

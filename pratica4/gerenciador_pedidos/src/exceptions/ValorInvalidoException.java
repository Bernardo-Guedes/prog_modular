package exceptions;

public class ValorInvalidoException extends IllegalArgumentException {
    public ValorInvalidoException(double valor){
        super("Valor: " + valor + ". O valor não pode ser menor ou igual a 0!");
    }
    
}

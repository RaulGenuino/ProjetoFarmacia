package Excessoes;

public class ProdutoInexistenteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProdutoInexistenteException(String msg){
		super(msg);
	}

}

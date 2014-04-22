package Controles;

import Excessoes.PessoaInexistenteException;



public interface ControleFarmaciaIF {
	
	public String informarCpfDePessoaFisica(String nome) throws PessoaInexistenteException;
	
	public void removerPessoaPeloCpf(String cpf) throws PessoaInexistenteException;
	
	public String[] buscarPessoaPorNome(String nome);
	

}

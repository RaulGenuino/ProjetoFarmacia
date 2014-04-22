package Controles;

import Entidades.Cliente;
import Excessoes.PessoaInexistenteException;
import Excessoes.PessoaJaExistenteException;

public class ControleCliente implements ControleFarmaciaIF{
	
	private Cliente clientes[] = new Cliente[30];
	
	private int posicao = 0;
	
	
	public void addCliente(Cliente c)throws PessoaJaExistenteException{
		int i = 0;
		boolean verifica = false;
		for(Cliente c1: clientes){
			if(clientes[i]!=null){
				if(c1.getCpf().equalsIgnoreCase(c.getCpf())){
					verifica = true;
				}
				
			}
			i++;
		}
		if(verifica == true){
			throw new PessoaJaExistenteException("Cliente já Existente");
			
		}
		clientes[posicao] = c;
		posicao++;
		
	}

	@Override
	public String informarCpfDePessoaFisica(String nome) throws PessoaInexistenteException {
		int i = 0;
		for(Cliente c: clientes){
			if(clientes[i]!=null){
				if(c.getNome().equalsIgnoreCase(nome)){
					return c.getCpf();
				}
			}
			i++;
		}
		throw new PessoaInexistenteException("O Funcionário é inexistente");
	
	
	}
	

	@Override
	public void removerPessoaPeloCpf(String cpf)throws PessoaInexistenteException {
		int i = 0;
		boolean verifica = false;
		for(Cliente c : clientes){
			if(clientes[i]!= null){
				if(c.getCpf().equalsIgnoreCase(cpf)){
					clientes[i] = null;
					verifica = true;
				
				}
			}
			i++;
		}
		if(verifica == false){
			throw new PessoaInexistenteException("O cliente é inexistente");
		}
	}
		

	@Override
	public String[] buscarPessoaPorNome(String nome) {
		String []clientesNomes = new String [30];
		int i = 0;
		for(Cliente c: clientes){
			if(clientes[i]!=null){
				if(c.getNome().indexOf(nome) == 0){
					clientesNomes[i] = c.getNome();
				
				}
			}
			i++;
		}
		return clientesNomes;
		
	}

	public Cliente[] getClientes() {
		return clientes;
	}
	
	public Cliente[] buscarClienteAtivosParaCrediario(){
		Cliente clientesAtivos[] = new Cliente[30];
		int i = 0;
		for(Cliente c: clientes){
			if(clientes[i]!=null){
				if(c.isClienteAtivoParaCrediario()==true){
					clientesAtivos[i] = c;
				}
			}
			i++;
		}
		return clientesAtivos;
	}


}

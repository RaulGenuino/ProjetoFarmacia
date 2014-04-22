package Controles;

import Entidades.Funcionario;
import Excessoes.PessoaInexistenteException;
import Excessoes.PessoaJaExistenteException;

public class ControleFuncionario implements ControleFarmaciaIF {
	
	private Funcionario funcionarios [] = new Funcionario[30];
	private int posicao = 0;
	

	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}

	public void addFuncionario(Funcionario f) throws PessoaJaExistenteException {
		int i = 0;
		boolean verifica = false;
		for(Funcionario f1 : funcionarios){
			if(funcionarios[i]!=null){
				if(f1.getCpf().equalsIgnoreCase(f.getCpf())){
					verifica = true;
					break;
				}
			}
			i++;
		}
		if(verifica == true){
			throw new PessoaJaExistenteException("O Funcionário já existe");
		}
		funcionarios[posicao]= f;
		posicao++;
	}
	
	public Funcionario buscarFuncionarioPorCpf(String cpf) throws PessoaInexistenteException{
		int i = 0;
		for(Funcionario f: funcionarios){
			if(funcionarios[i]!=null){
				if(f.getCpf().equalsIgnoreCase(cpf)){
					return f;
				}
			}
			i++;
		}
		throw new PessoaInexistenteException("O Funcionário é inexistente");

	}
	
	public Funcionario buscarFuncionarioPorMatricula(String matricula) throws PessoaInexistenteException{
		int i = 0;
		for(Funcionario f: funcionarios){
			if(funcionarios[i]!=null){
				if(f.getMatricula().equalsIgnoreCase(matricula)){
					return f;
				}
			}
			i++;
		}
		throw new PessoaInexistenteException("O Funcionário é inexistente");
	}
	
	public void removerFuncionarioPorMatricula(String matricula) throws PessoaInexistenteException{
		int i = 0;
		boolean verifica = false;
		for(Funcionario f: funcionarios){
			if(funcionarios[i]!= null){
				if(f.getMatricula().equalsIgnoreCase(matricula)){
					funcionarios[i] = null;
					verifica = true;
				
				}
			}
			i++;
		}
		if(verifica == false){
			throw new PessoaInexistenteException("O Funcionário é inexistente");
		}
		
	}
	
	
	
	@Override
	public void removerPessoaPeloCpf(String cpf) throws PessoaInexistenteException {
		int i = 0;
		boolean verifica = false;
		for(Funcionario f: funcionarios){
			if(funcionarios[i]!= null){
				if(f.getCpf().equalsIgnoreCase(cpf)){
					funcionarios[i] = null;
					verifica = true;
				
				}
			}
			i++;
		}
		if(verifica == false){
			throw new PessoaInexistenteException("O Funcionário é inexistente");
		}
	}
	
	@Override
	public String informarCpfDePessoaFisica(String nome)throws PessoaInexistenteException {
		int i = 0;
		for(Funcionario f: funcionarios){
			if(funcionarios[i]!=null){
				if(f.getNome().equalsIgnoreCase(nome)){
					return f.getCpf();
				}
			}
			i++;
		}
		throw new PessoaInexistenteException("O Funcionário é inexistente");
	}

	@Override
	public String[] buscarPessoaPorNome(String nome) {
		String []funcionariosNomes = new String [30];
		int i = 0;
		for(Funcionario f: funcionarios){
			if(funcionarios[i]!=null){
				if(f.getNome().indexOf(nome) == 0){
					funcionariosNomes[i] = f.getNome();
				}
			}
			i++;
		}
		return funcionariosNomes;
	}
	

}
package Fachada;

import Controles.ControleCliente;
import Controles.ControleFuncionario;
import Controles.ControleProduto;
import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Produto;
import Excessoes.PessoaInexistenteException;
import Excessoes.PessoaJaExistenteException;
import Excessoes.ProdutoInexistenteException;
import Excessoes.ProdutoJaExistenteException;

public class FarmaciaFachada {
	
	ControleFuncionario cf = new ControleFuncionario();
	ControleCliente cc = new ControleCliente();
	ControleProduto cp = new ControleProduto();
	
	public Funcionario[] getFuncionarios() {
		return cf.getFuncionarios();
	}
	
	public void addFuncionario(Funcionario f) throws PessoaJaExistenteException {
		cf.addFuncionario(f);
	}
	
	public Funcionario buscarFuncionarioPorCpf(String cpf) throws PessoaInexistenteException{
		return cf.buscarFuncionarioPorCpf(cpf);
	}
	
	public Funcionario buscarFuncionarioPorMatricula(String matricula) throws PessoaInexistenteException{
		return cf.buscarFuncionarioPorMatricula(matricula);
	}
	
	public void removerFuncionarioPorMatricula(String matricula) throws PessoaInexistenteException{
		cf.removerFuncionarioPorMatricula(matricula);
	}
	
	public void removerFuncionarioCpf(String cpf) throws PessoaInexistenteException{
		cf.removerPessoaPeloCpf(cpf);
	}
	
	public String informarCpfDeFuncionario(String nome)throws PessoaInexistenteException {
		return cf.informarCpfDePessoaFisica(nome);
	}
	
	public String[] buscarFuncionarioPorNome(String nome){
		return cf.buscarPessoaPorNome(nome);
	}
	public Cliente[] getClientes() {
		return cc.getClientes();
	}
	
	public void addCliente(Cliente c)throws PessoaJaExistenteException{
		cc.addCliente(c);
	}
	public String informarCpfDeCliente(String nome) throws PessoaInexistenteException {
		return cc.informarCpfDePessoaFisica(nome);
	}
	public void removerClientePeloCpf(String cpf)throws PessoaInexistenteException {
		cc.removerPessoaPeloCpf(cpf);
	}

	public String[] buscarClientePorNome(String nome){
		return cc.buscarPessoaPorNome(nome);
	}
	public Cliente[] buscarClienteAtivosParaCrediario(){
		return cc.buscarClienteAtivosParaCrediario();
	}
	public Produto[] getProdutos() {
		return cp.getProdutos();
	}
	public void addProdutos(Produto p)throws ProdutoJaExistenteException {
		cp.addProdutos(p);
	}
	
	public Produto buscarProdutoPorCodigo(String codigo) throws ProdutoInexistenteException{
		return cp.buscarProdutoPorCodigo(codigo);
	}
	public void removerProdutoPorCodigo(String codigo)throws ProdutoInexistenteException{
		cp.removerProdutoPorCodigo(codigo);
	}
	public String[]buscarProdutoPorNome(String nome) throws ProdutoInexistenteException{
		return cp.buscarProdutoPorNome(nome);
	}
	public Produto[]verificarProdutosDisponiveisParaVenda(){
		return cp.verificarProdutosDisponiveisParaVenda();
	}

}

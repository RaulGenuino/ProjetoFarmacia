package Teste;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Produto;
import Excessoes.PessoaInexistenteException;
import Excessoes.PessoaJaExistenteException;
import Excessoes.ProdutoInexistenteException;
import Excessoes.ProdutoJaExistenteException;
import Fachada.FarmaciaFachada;

public class FarmaciaTest {

	FarmaciaFachada farmacia;

	@Before
	public void setUp() throws Exception {
		farmacia = new FarmaciaFachada();
	}

	@Test
	public void testAddFuncionario() throws PessoaJaExistenteException {
		Funcionario f1 = criarFuncionarioPadrao();
		farmacia.addFuncionario(f1);
		Funcionario f2 = criarFuncionarioMinimo();
		farmacia.addFuncionario(f2);
		Funcionario[] funcionarios = farmacia.getFuncionarios();
		assertEquals(f1, funcionarios[0]);
		assertEquals(f2, funcionarios[1]);
	}

	@Test
	public void testBuscarFuncionarioPorCpf()
			throws PessoaInexistenteException, PessoaJaExistenteException {
		Funcionario f = criarFuncionarioPadrao();
		farmacia.addFuncionario(f);
		Funcionario f2 = criarFuncionarioMinimo();
		farmacia.addFuncionario(f2);
		assertEquals(f, farmacia.buscarFuncionarioPorCpf("12345"));
		assertEquals(f2, farmacia.buscarFuncionarioPorCpf("11111"));
	}

	@Test
	public void testBuscarFuncionarioPorMatricula()
			throws PessoaInexistenteException, PessoaJaExistenteException {
		Funcionario f = criarFuncionarioPadrao();
		farmacia.addFuncionario(f);
		assertEquals(f, farmacia.buscarFuncionarioPorMatricula("0102"));
	}

	@Test
	public void testRemoverFuncionarioPorMatricula()
			throws PessoaJaExistenteException, PessoaInexistenteException {
		Funcionario f1 = criarFuncionarioPadrao();
		farmacia.addFuncionario(f1);
		Funcionario f2 = criarFuncionarioMinimo();
		farmacia.addFuncionario(f2);
		farmacia.removerFuncionarioPorMatricula("0000");
		assertEquals(farmacia.getFuncionarios()[0].getMatricula(),
				f1.getMatricula());

	}

	@Test
	public void testRemoverFuncionarioCpf() throws PessoaJaExistenteException,
			PessoaInexistenteException {
		Funcionario f1 = criarFuncionarioPadrao();
		farmacia.addFuncionario(f1);
		Funcionario f2 = criarFuncionarioMinimo();
		farmacia.addFuncionario(f2);
		farmacia.removerFuncionarioCpf("11111");
		Assert.assertEquals(farmacia.getFuncionarios()[0].getCpf(), f1.getCpf());
	}

	@Test
	public void testInformarCpfDeFuncionario()
			throws PessoaJaExistenteException, PessoaInexistenteException {
		Funcionario f = criarFuncionarioPadrao();
		farmacia.addFuncionario(f);
		assertEquals(f.getCpf(), farmacia.informarCpfDeFuncionario("Jackson"));
	}

	@Test
	public void testBuscarFuncionarioPorNome()
			throws PessoaJaExistenteException {
		Funcionario[] funcionariosCadastrados = listaDeFuncionarios();
		adicionarFuncionariosFachada(funcionariosCadastrados);

		String[] funcionarisPorNome = farmacia
				.buscarFuncionarioPorNome("Jackson");
		assertEquals(30, funcionarisPorNome.length);
		assertTrue(funcionarisPorNome[0].contains(funcionariosCadastrados[0]
				.getNome()));
		assertTrue(funcionarisPorNome[3].contains(funcionariosCadastrados[3]
				.getNome()));

	}

	@Test
	public void testAddCliente() throws PessoaJaExistenteException {
		Cliente c = criarClientePadrao();
		farmacia.addCliente(c);
		Cliente c1 = criarClienteMinimo();
		farmacia.addCliente(c1);
		Cliente[] clientes = farmacia.getClientes();
		assertEquals(c, clientes[0]);
		assertEquals(c1, clientes[1]);
	}

	@Test
	public void testInformarCpfDeCliente() throws PessoaJaExistenteException,
			PessoaInexistenteException {
		Cliente c = criarClientePadrao();
		Cliente c2 = criarClienteMinimo();
		farmacia.addCliente(c);
		farmacia.addCliente(c2);
		assertEquals(c.getCpf(), farmacia.informarCpfDeCliente("Augusto"));
		assertEquals(c2.getCpf(), farmacia.informarCpfDeCliente("Raul"));

	}

	@Test
	public void testRemoverClientePeloCpf() throws PessoaJaExistenteException,
			PessoaInexistenteException {
		Cliente c1 = criarClientePadrao();
		farmacia.addCliente(c1);
		Cliente c2 = criarClienteMinimo();
		farmacia.addCliente(c2);
		farmacia.removerClientePeloCpf("98775");
		assertEquals(farmacia.getClientes()[0].getCpf(), c1.getCpf());
		assertEquals(farmacia.getClientes()[1], null);

	}

	@Test
	public void testBuscarClientePorNome() throws PessoaJaExistenteException {
		Cliente[] clientesCadastrados = listaClientes();
		adicionarClientesFachada(clientesCadastrados);

		String[] clientesPorNome = farmacia.buscarClientePorNome("José");
		assertEquals(30, clientesPorNome.length);
		assertTrue(clientesPorNome[0]
				.contains(clientesCadastrados[0].getNome()));
		assertTrue(clientesPorNome[1]
				.contains(clientesCadastrados[1].getNome()));
		assertTrue(clientesPorNome[3]
				.contains(clientesCadastrados[3].getNome()));
	}

	@Test
	public void testBuscarClienteAtivosParaCrediario()
			throws PessoaJaExistenteException {
		Cliente[] clientesCadastrados = listaClientes();
		adicionarClientesFachada(clientesCadastrados);
		Cliente[] clientesAtivos = farmacia.buscarClienteAtivosParaCrediario();
		assertEquals(30, clientesAtivos.length);
		assertTrue(clientesAtivos[0].isClienteAtivoParaCrediario() == true);
	}

	@Test
	public void testAddProdutos() throws ProdutoJaExistenteException {
		Produto p = criarProdutoPadrao();
		farmacia.addProdutos(p);
		Produto p2 = criarProdutoMinimo();
		farmacia.addProdutos(p2);
		Produto produtos[] = farmacia.getProdutos();
		assertEquals(p, produtos[0]);
		assertEquals(p2, produtos[1]);

	}

	@Test
	public void testRemoverProdutoPorCodigo()
			throws ProdutoJaExistenteException, ProdutoInexistenteException {
		Produto p = criarProdutoPadrao();
		farmacia.addProdutos(p);
		Produto p2 = criarProdutoMinimo();
		farmacia.addProdutos(p2);
		farmacia.removerProdutoPorCodigo("22222");
		assertEquals(farmacia.getProdutos()[0].getCodigoBarras(),
				p.getCodigoBarras());
	}

	@Test
	public void testBuscarProdutoPorCodigo()
			throws ProdutoJaExistenteException, ProdutoInexistenteException {
		Produto p = criarProdutoPadrao();
		farmacia.addProdutos(p);
		Produto p2 = criarProdutoMinimo();
		farmacia.addProdutos(p2);
		assertEquals(p, farmacia.buscarProdutoPorCodigo("88888"));
		assertEquals(p2, farmacia.buscarProdutoPorCodigo("22222"));

	}

	@Test
	public void testBuscarProdutoPorNome() throws ProdutoInexistenteException,
			ProdutoJaExistenteException {
		Produto[] produtosCadastrados = listaDeProdutos();
		adicionarProdutosFachada(produtosCadastrados);

		String[] produtosPorNome = farmacia.buscarProdutoPorNome("Charope");
		assertEquals(100, produtosPorNome.length);

		assertTrue(produtosPorNome[1]
				.contains(produtosCadastrados[1].getNome()));
	}

	@Test
	public void testVerificarProdutosDisponiveisParaVenda()
			throws ProdutoJaExistenteException {
		Produto[] produtosCriados = listaDeProdutos();
		adicionarProdutosFachada(produtosCriados);
		Produto produtos[] = farmacia.verificarProdutosDisponiveisParaVenda();
		Assert.assertTrue(produtos[0].isDisponivelParaVendas() == true);
	}

	// Método usado para criar um Funcionario Padrão
	private Funcionario criarFuncionarioPadrao() {
		Funcionario f = new Funcionario();
		f.setNome("Jackson");
		f.setCargo("Gerente");
		f.setCpf("12345");
		f.setMatricula("0102");
		f.setSalario(1000);
		return f;

	}

	// Método usado para criar um Funcionario Minimo.
	private Funcionario criarFuncionarioMinimo() {
		Funcionario f = new Funcionario();
		f.setNome("Arilan");
		f.setCpf("11111");
		f.setMatricula("0000");
		return f;
	}

	// Método usado para criar um cliente Padrão
	private Cliente criarClientePadrao() {
		Cliente c = new Cliente();
		c.setNome("Augusto");
		c.setCpf("98765");
		c.setClienteAtivoParaCrediario(true);
		return c;

	}

	// Método usado para criar um cliente Minimo
	private Cliente criarClienteMinimo() {
		Cliente c = new Cliente();
		c.setNome("Raul");
		c.setCpf("98775");
		return c;
	}

	// Método usado para criar um Produto Padrão
	private Produto criarProdutoPadrao() {
		Produto p = new Produto();
		p.setCodigoBarras("88888");
		p.setNome("Charope");
		p.setPrecoDeCusto(50);
		p.setQuantProdutos(2);
		p.setTipo("genérico");
		p.setDisponivelParaVendas(true);
		return p;
	}

	// Método usado para criar um produto Minimo
	private Produto criarProdutoMinimo() {
		Produto p = new Produto();
		p.setCodigoBarras("22222");
		p.setNome("Comprimido");
		return p;
	}

	// Método usado para criar uma lista de clientes diferentes
	private Cliente[] listaClientes() {
		String[] nome = { "José Raul", "José Augusto", "Arilan", "José Anísio" };
		String[] cpf = { "001.010.100-01", "002.020.200-02", "003.030.300-03",
				"004.040.400-04" };
		boolean[] ativarCrediario = { true, false, true, false };
		Cliente[] clientes = new Cliente[4];
		int quantClientes = 4;

		for (int i = 0; i < quantClientes; i++) {
			Cliente c = new Cliente();
			c.setNome(nome[i]);
			c.setCpf(cpf[i]);
			c.setClienteAtivoParaCrediario(ativarCrediario[i]);
			clientes[i] = c;
		}
		return clientes;

	}

	// Método usado para adicionar uma lista de clientes na fachada
	private void adicionarClientesFachada(Cliente[] clientesCadastrados)
			throws PessoaJaExistenteException {
		for (Cliente c : clientesCadastrados) {
			farmacia.addCliente(c);
		}
	}

	// Método usado para criar uma lista de funcionarios diferentes
	private Funcionario[] listaDeFuncionarios() {
		String[] nomes = { "Jackson", "Augusto", "Raul", "Jackson" };
		String[] cpfs = { "12345", "05000", "00000", "22222" };
		Funcionario[] funcionarios = new Funcionario[4];
		int quantFuncionarios = 4;
		for (int i = 0; i < quantFuncionarios; i++) {
			Funcionario f = new Funcionario();
			f.setNome(nomes[i]);
			f.setCpf(cpfs[i]);
			funcionarios[i] = f;
		}
		return funcionarios;
	}

	// Método usado para adicionar uma lista de funcionarios na fachada
	private void adicionarFuncionariosFachada(Funcionario[] listaDeFuncionarios)
			throws PessoaJaExistenteException {
		for (Funcionario f : listaDeFuncionarios) {
			farmacia.addFuncionario(f);
		}
	}

	// Método usado para criar uma lista de Produtos
	private Produto[] listaDeProdutos() {
		String[] nomes = { "Charope", "Charope para gripe", "Comprido" };
		String[] tipos = { "Genérico", "Genérico", "Similar" };
		String[] codigosDeBarras = { "11111", "22222", "33333" };
		boolean[] ativos = { true, true, false };
		Produto produtos[] = new Produto[3];
		int quantProdutos = 3;
		for (int i = 0; i < quantProdutos; i++) {
			Produto p = new Produto();
			p.setNome(nomes[i]);
			p.setTipo(tipos[i]);
			p.setCodigoBarras(codigosDeBarras[i]);
			p.setDisponivelParaVendas(ativos[i]);
			produtos[i] = p;
		}
		return produtos;
	}

	// Método usado para adicionar uma lista de produtos na fachada
	private void adicionarProdutosFachada(final Produto[] listaDeProdtutos)
			throws ProdutoJaExistenteException {
		for (Produto p : listaDeProdtutos) {
			farmacia.addProdutos(p);
		}
	}

}

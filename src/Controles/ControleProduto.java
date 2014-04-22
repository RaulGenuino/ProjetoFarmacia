package Controles;

import Entidades.Produto;
import Excessoes.ProdutoInexistenteException;
import Excessoes.ProdutoJaExistenteException;

public class ControleProduto {
	
	private Produto[]produtos = new Produto[100];
	

	private int posicao = 0;

	public Produto[] getProdutos() {
		return produtos;
	}

	public void addProdutos(Produto p)throws ProdutoJaExistenteException {
		int i = 0;
		boolean verifica = false;
		for(Produto p1: produtos){
			if(produtos[i]!=null){
				if(p1.getCodigoBarras().equalsIgnoreCase(p.getCodigoBarras())){
					verifica = true;
				}
			}
			i++;
		
		}
		if(verifica==true){
			throw new ProdutoJaExistenteException("Produto já existente");
		}
		produtos[posicao] = p;
		posicao++;
	}
	
	public void removerProdutoPorCodigo(String codigo)throws ProdutoInexistenteException{
		int i = 0;
		boolean verifica = false;
		for(Produto p : produtos){
			if(produtos[i]!= null){
				if(p.getCodigoBarras().equalsIgnoreCase(codigo)){
					produtos[i] = null;
					verifica = true;
				
				}
			}
			i++;
		}
		if(verifica == false){
			throw new ProdutoInexistenteException("O produto é inexistente");
	
		}
	}
	
	public String[]buscarProdutoPorNome(String nome) throws ProdutoInexistenteException{
		String[]produtosNomes = new String[100];
		int i = 0;
		boolean verifica = false;
		for(Produto p: produtos){
			if(produtos[i]!=null){
				if(p.getNome().indexOf(nome)== 0){
					produtosNomes[i] = p.getNome();
					verifica = true;
				}
			}
			i++;
			
			}
		if(verifica == false){
			throw new  ProdutoInexistenteException("Produto Inexistente");
		}
		return produtosNomes;
	}
	
	public Produto[]verificarProdutosDisponiveisParaVenda(){
		Produto []produtosDisponiveis = new Produto[100];
		int i = 0;
		for(Produto p: produtos){
			if(produtos[i]!=null){
				if(p.isDisponivelParaVendas()==true){
					produtosDisponiveis[i] = p;
				}
			}
			i++;
		}
		return produtosDisponiveis;
	}

	public Produto buscarProdutoPorCodigo(String codigo)throws ProdutoInexistenteException {
		int i = 0;
		for(Produto p: produtos){
			if(produtos[i]!= null){
				if(p.getCodigoBarras().equalsIgnoreCase(codigo)){
					return p;
				}
			}
			i++;
		}
		throw new ProdutoInexistenteException("Produto Inexistente");
	}

	
}
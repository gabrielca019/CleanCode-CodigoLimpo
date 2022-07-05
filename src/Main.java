import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	
	static ArrayList<Produto> estoque = new ArrayList<Produto>();
	static Produto produto = new Produto();
	static int opcao = 0;

	public static void main(String[] args) {		
		do {
			exibirMenuParaSelecionarOpcao();
			realizarOpcaoMenu();
		} while(opcao != 0); //voltar para o menu
	}
	
	public static void exibirMenuParaSelecionarOpcao() {
		opcao = Integer.parseInt(
				String.valueOf(
				JOptionPane.showInputDialog(
					"Selecionar operação \n" //menu
			  	  + "1 - Cadastrar produto \n"
			  	  + "2 - Listar produtos \n"
			  	  + "3 - Editar produto \n"
			  	  + "4 - Excluir produto \n"
			  	  + "Outro  - Sair")));
	}
	
	public static void realizarOpcaoMenu() {
		if(opcao == 1) 
			CadastrarProduto();
		else if(opcao == 2)
			listarProdutos();
		else if(opcao == 3)
			editarProduto();
		else if(opcao == 4)
			excluirProduto();
	}
	
	private static void CadastrarProduto() {
		estoque.add(gerarProdutoParaCadastro());	
	}

	public static Produto gerarProdutoParaCadastro() {
		return new Produto(pegarIdProduto(), 
							pegarNomeProduto(), 
							pegarPrecoProduto(), 
							pegarQuantidadeProduto());
	}
	
	public static void listarProdutos() {
		JOptionPane.showMessageDialog(null, gerarListaTodosProdutosCadastrados());
	}
	
	public static String gerarListaTodosProdutosCadastrados() {
		String lista = "";
		for(Produto p : estoque)
			lista += p.toString() + "\n";
		return lista;
	}
	
	public static void editarProduto() {
		if(validarOpcaoCasoListaVazia())
			estoque.set((produto.getId()), gerarProdutoParaEditar());
	}
	
	public static Produto gerarProdutoParaEditar() {
		selecionarIdProduto();
		return new Produto(produto.getId(), 
							pegarNomeProduto(), 
							pegarPrecoProduto(), 
							pegarQuantidadeProduto());
	}
	
	public static boolean validarOpcaoCasoListaVazia() {
		if(!verificarListaVazia()) {
			selecionarIdProduto();
			return true;
		} else {
			return false;
		}
	}
	
	public static void excluirProduto() {
		if(validarOpcaoCasoListaVazia())
			estoque.remove(produto.getId());
	}
	
	public static boolean verificarListaVazia() {
		if(estoque.size() == 0) {
			JOptionPane.showMessageDialog(null, "A lista de produtos está vazia");
			return true;
		} else {
			return false;
		}
	}
	
	public static String pegarNomeProduto() {
		return JOptionPane.showInputDialog("Nome do produto:");
	}
	
	public static double pegarPrecoProduto() {
		return Double.parseDouble(String.valueOf(JOptionPane.showInputDialog("Valor do produto:")));
	}
	
	public static int pegarQuantidadeProduto() {
		return Integer.parseInt(String.valueOf(JOptionPane.showInputDialog("Quantidade em estoque:")));
	}
	
	public static int pegarIdProduto() {
		return estoque.size();
	}
	
	public static void selecionarIdProduto() {
		produto.setId(Integer.parseInt(String.valueOf(JOptionPane.showInputDialog("ID do produto: "))) - 1);
	}
}
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	
	static ArrayList<Produto> estoque = new ArrayList<Produto>();
	static Produto produto = new Produto();
	static int opcao = 0;

	public static void main(String[] args) {		
		do {
			selecionarOpcao();
			realizarOpcao();
		} while(opcao != 0); //voltar para o menu
	}
	
	public static void selecionarOpcao() {
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
	
	public static void realizarOpcao() {
		if(opcao == 1) 
			estoque.add(cadastrarProduto());
		else if(opcao == 2)
			JOptionPane.showMessageDialog(null, estoque);
		else if(opcao == 3)
			estoque.set((produto.getId()), editarProduto());
		else if(opcao == 4)
			estoque.remove(produto.getId());
	}
	
	public static Produto cadastrarProduto() {
		String nome = pegarNomeProduto();
		double preco = pegarPrecoProduto();
		int quantidade = pegarQuantidadeProduto();
		int id = pegarIdProduto();
		return new Produto(id, nome, preco, quantidade);
	}
	
	public static String listarProduto() {
		String lista = "";
		for(Produto p : estoque)
			lista += p.toString() + "\n";
		return lista;
	}
	
	public static Produto editarProduto() {
		selecionarIdProduto();
		String nome = pegarNomeProduto();
		double preco = pegarPrecoProduto();
		int quantidade = pegarQuantidadeProduto();
		return new Produto(produto.getId(), nome, preco, quantidade);
	}
	
	public static void excluirProduto() {
		if(!(estoque.size() == 0)) {
			selecionarIdProduto();
		} else {
			JOptionPane.showMessageDialog(null, "A lista de produtos está vazia");
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
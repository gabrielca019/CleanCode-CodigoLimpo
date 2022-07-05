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
		switch (opcao) {
		case 1: //cadastrar
			estoque.add(cadastrarProduto());
			break;
		case 2: //listar
			JOptionPane.showMessageDialog(null, listarProduto());
			break;
		case 3: //editar
			int id = Integer.parseInt(String.valueOf(JOptionPane.showInputDialog("ID do produto:"))) - 1;
			estoque.set((id), editarProduto(id));
			break;
		case 4: //excluir
			estoque.remove(excluirProduto());
			break;
		default:
			opcao = 0;
			break;
		}
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
	
	public static Produto editarProduto(int id) {
		String nome = pegarNomeProduto();
		double preco = pegarPrecoProduto();
		int quantidade = pegarQuantidadeProduto();
		return new Produto(id, nome, preco, quantidade);
	}
	
	public static int excluirProduto() {
		if(!(estoque.size() == 0)) {
			return Integer.parseInt(String.valueOf(JOptionPane.showInputDialog("ID do produto: "))) - 1;
		} else {
			JOptionPane.showMessageDialog(null, "A lista de produtos está vazia");
			return 0;
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
	
}
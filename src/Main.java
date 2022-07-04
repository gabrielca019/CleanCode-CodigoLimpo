import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	
	static ArrayList<Produto> estoque = new ArrayList<Produto>();
	static Produto produto = new Produto();
	static int opcao = 0;

	public static void main(String[] args) {		
		do {
			opcao = Integer.parseInt(String.valueOf(JOptionPane.showInputDialog("Selecionar operação \n" //menu
								  	  + "1 - Cadastrar produto \n"
								  	  + "2 - Listar produtos \n"
								  	  + "3 - Editar produto \n"
								  	  + "4 - Excluir produto \n"
								  	  + "Outro  - Sair")));
			switch (opcao) {
				case 1: //cadastrar
					String nome = pegarNomeProduto();
					double preco = pegarPrecoProduto();
					int quantidade = pegarQuantidadeProduto();
					int id = pegarIdProduto(estoque);
					estoque.add(new Produto(id, nome, preco, quantidade));
					break;
				case 2: //listar
					String lista = "";
					for(Produto p : estoque)
						lista += p.toString() + "\n";
						JOptionPane.showMessageDialog(null, lista);
					break;
				case 3: //editar
					int idEditar = Integer.parseInt(String.valueOf(JOptionPane.showInputDialog("ID do produto:")));
					String nomeEditar = pegarNomeProduto();
					double precoEditar = pegarPrecoProduto();
					int quantidadeEditar = pegarQuantidadeProduto();
					produto = new Produto(idEditar, nomeEditar, precoEditar, quantidadeEditar);
					estoque.set((idEditar-1), produto);
					break;
				case 4: //excluir
					if(!(estoque.size() == 0)) {
						int remover = Integer.parseInt(String.valueOf(JOptionPane.showInputDialog("ID do produto: "))) - 1;
						estoque.remove(remover);
					} else {
						JOptionPane.showMessageDialog(null, "A lista de produtos está vazia");
					}
					break;
				default:
					opcao = 0;
					break;
			}
		} while(opcao != 0); //voltar para o menu
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
	
	public static int pegarIdProduto(ArrayList<Produto> estoque) {
		return estoque.size();
	}

}
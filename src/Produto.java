
public class Produto {
	
	private int id;
	private String nome;
	private double preco;
	private int quantidade;

	public Produto() {};
	public Produto(int id, String nome, double preco, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String toString() {
		return "ID do Produto: " + (this.id+1) + "\n" +
			   "Nome do produto: " + this.nome + "\n" +
			   "Preco do produto: " + this.preco + "\n" +
			   "Quantidade em estoque: " + this.quantidade + "\n";
	}
}
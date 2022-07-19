package modelo;

public class Livro {

    private String id_livro,
            titulo,
            autor,
            categoria,
            editora,
            edicao,
            isbn,
            quantidade,
            status,
            corredor,
            prateleira;

    private String[] colunas = new String[]{"ID", "TITULO", "AUTOR", "CATEGORIA", "EDITORA", "EDICAO", "ISBN", "QUANTIDADE", "STATUS", "CORREDOR", "PRATELEIRA"};

    public Livro() {
    }

    public Livro(String id_livro) {
        this.id_livro = id_livro;
    }

    public String getId_Livro() {
        return id_livro;
    }

    public void setId_Livro(String id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCorredor() {
        return corredor;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] Colunas) {
        this.colunas = Colunas;
    }

}

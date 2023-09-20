package br.com.wiflix.exception;

public class FilmeNotFoundException extends RuntimeException{

    public FilmeNotFoundException(String id){
        super("Filme não encontrado pelo id: " + id);
    }

}

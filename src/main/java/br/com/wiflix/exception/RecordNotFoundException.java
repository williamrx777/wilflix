package br.com.wiflix.exception;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(Long id) {
        super("Episodio não encontrado com o id: " + id);
    }
}

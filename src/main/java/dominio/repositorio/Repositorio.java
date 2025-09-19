package dominio.repositorio;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T> {

    void salvar(T t);

    void atualizar(T t);

    void remover(T t);

    List<T> listar();

    Optional<T> pesquisarPorId(int id);
}

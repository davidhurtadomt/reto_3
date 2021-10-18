package co.usa.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.model.Categoria;
import co.usa.reto3.repository.crud.InterfaceCategoria;

@Repository
public class RepositorioCategoria {
    @Autowired
    private InterfaceCategoria crud;

    public List<Categoria> getAll() {
        return (List<Categoria>) crud.findAll();
    }

    public Optional<Categoria> getCategoria(int id) {
        return crud.findById(id);
    }

    public Categoria save(Categoria categoria) {
        return crud.save(categoria);
    }

    public void delete(Categoria categoria) {
        crud.delete(categoria);
    }

}

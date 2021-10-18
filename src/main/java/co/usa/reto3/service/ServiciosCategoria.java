package co.usa.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.model.Categoria;
import co.usa.reto3.repository.RepositorioCategoria;

@Service
public class ServiciosCategoria {
    @Autowired
    private RepositorioCategoria metodosCrud;

    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Categoria> getCategory(int idCategory) {
        return metodosCrud.getCategoria(idCategory);
    }

    public Categoria save(Categoria categoria) {
        if (categoria.getId() == null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Categoria> e = metodosCrud.getCategoria(categoria.getId());
            if (e.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }

        }
    }

    public Categoria update(Categoria categoria) {
        if (categoria.getId() != null) {
            Optional<Categoria> e = metodosCrud.getCategoria(categoria.getId());
            if (!e.isEmpty()) {
                if (categoria.getName() != null) {
                    e.get().setName(categoria.getName());
                }
                if (categoria.getDescription() != null) {
                    e.get().setDescription(categoria.getDescription());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return categoria;
            }
        } else {
            return categoria;
        }
    }

    public boolean deleteCategoria(int idCategory) {
        Boolean aBoolean = getCategory(idCategory).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}

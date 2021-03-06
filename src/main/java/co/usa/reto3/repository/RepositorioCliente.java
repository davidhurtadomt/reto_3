package co.usa.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.model.Cliente;
import co.usa.reto3.repository.crud.InterfaceCliente;

@Repository
public class RepositorioCliente {
    @Autowired
    private InterfaceCliente crud;

    public List<Cliente> getAll(){
        return (List<Cliente>) crud.findAll();
    }

    public Optional<Cliente> getCliente(int id){
        return crud.findById(id);
    }

    public Cliente save(Cliente cliente){
        return crud.save(cliente);
    }

    public void delete(Cliente cliente){
        crud.delete(cliente);
    }
    
}

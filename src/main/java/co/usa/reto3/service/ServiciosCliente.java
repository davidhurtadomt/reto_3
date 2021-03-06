package co.usa.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.model.Cliente;
import co.usa.reto3.repository.RepositorioCliente;

@Service
public class ServiciosCliente {
    @Autowired
    private RepositorioCliente metodosCrud;

    public List<Cliente> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Cliente> getClient(int idcliente) {
        return metodosCrud.getCliente(idcliente);
    }

    public Cliente save(Cliente client) {
        if (client.getIdClient() == null) {
            return metodosCrud.save(client);
        } else {
            Optional<Cliente> e = metodosCrud.getCliente(client.getIdClient());
            if (e.isEmpty()) {
                return metodosCrud.save(client);
            } else {
                return client;
            }
        }
    }

    public Cliente update(Cliente client) {
        if (client.getIdClient() != null) {
            Optional<Cliente> e = metodosCrud.getCliente(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getEmail() != null) {
                    e.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}

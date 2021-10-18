package co.usa.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.model.Computer;
import co.usa.reto3.repository.RepositorioComputer;

@Service
public class ServiciosComputer {
    @Autowired
    private RepositorioComputer metodosCrud;

    public List<Computer> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Computer> getComputer(int id) {
        return metodosCrud.getComputer(id);
    }

    public Computer save(Computer computer) {
        if (computer.getId() == null) {
            return metodosCrud.save(computer);
        } else {
            Optional<Computer> e = metodosCrud.getComputer(computer.getId());
            if (e.isEmpty()) {
                return metodosCrud.save(computer);
            } else {
                return computer;
            }
        }
    }

    public Computer update(Computer computer) {
        if (computer.getId() != null) {
            Optional<Computer> e = metodosCrud.getComputer(computer.getId());
            if (!e.isEmpty()) {
                if (computer.getBrand() != null) {
                    e.get().setBrand(computer.getBrand());
                }
                if (computer.getYear() != null) {
                    e.get().setYear(computer.getYear());
                }
                if (computer.getCategory() != null) {
                    e.get().setCategory(computer.getCategory());
                }
                if (computer.getName() != null) {
                    e.get().setName(computer.getName());
                }
                if (computer.getDescription() != null) {
                    e.get().setDescription(computer.getDescription());
                }

                metodosCrud.save(e.get());
                return e.get();
            } else {
                return computer;
            }
        } else {
            return computer;
        }
    }

    public boolean deleteComputer(int idcomputer) {
        Boolean aBoolean = getComputer(idcomputer).map(computer -> {
            metodosCrud.delete(computer);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
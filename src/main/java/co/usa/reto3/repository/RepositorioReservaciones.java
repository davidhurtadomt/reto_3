package co.usa.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto3.model.Reservaciones;
import co.usa.reto3.repository.crud.InterfaceReservaciones;

@Repository
public class RepositorioReservaciones {
    @Autowired
    private InterfaceReservaciones crud;

    public List<Reservaciones> getAll() {
        return (List<Reservaciones>) crud.findAll();
    }

    public Optional<Reservaciones> getReservaciones(int id) {
        return crud.findById(id);
    }

    public Reservaciones save(Reservaciones reservaciones) {
        return crud.save(reservaciones);
    }

    public void delete(Reservaciones reservaciones) {
        crud.delete(reservaciones);
    }

}

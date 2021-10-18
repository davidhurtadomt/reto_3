package co.usa.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto3.model.Mensaje;
import co.usa.reto3.repository.RepositorioMensaje;

@Service
public class ServiciosMensaje {
    @Autowired
    private RepositorioMensaje metodosCrud;

    public List<Mensaje> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Mensaje> getMensaje(int idMessage) {
        return metodosCrud.getMensaje(idMessage);
    }

    public Mensaje save(Mensaje mensaje) {
        if (mensaje.getIdMessage() == null) {
            return metodosCrud.save(mensaje);
        } else {
            Optional<Mensaje> e = metodosCrud.getMensaje((mensaje.getIdMessage()));
            if (e.isEmpty()) {
                return metodosCrud.save(mensaje);
            } else {
                return mensaje;
            }
        }
    }

    public Mensaje update(Mensaje mensaje) {
        if (mensaje.getIdMessage() != null) {
            Optional<Mensaje> e = metodosCrud.getMensaje(mensaje.getIdMessage());
            if (!e.isEmpty()) {
                if (mensaje.getMessageText() != null) {
                    e.get().setMessageText(mensaje.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return mensaje;
            }
        } else {
            return mensaje;
        }
    }

    public boolean deleteMensaje(int idMensaje) {
        Boolean aBoolean = getMensaje(idMensaje).map(mensaje -> {
            metodosCrud.delete(mensaje);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}

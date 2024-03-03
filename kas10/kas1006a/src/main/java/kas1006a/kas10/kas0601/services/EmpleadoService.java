package kas1006a.kas10.kas0601.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kas1006a.kas10.kas0601.domain.Empleado;
import kas1006a.kas10.kas0601.exceptions.NotFoundException;

@Service
public class EmpleadoService {
    private List<Empleado> repositorio = new ArrayList<>();

    public Empleado añadir(Empleado empleado) {
        repositorio.add(empleado);
        return empleado; // podría no devolver nada, o boolean, etc.
    }

    public List<Empleado> obtenerTodos() {
        return repositorio;
    }

    public Empleado obtenerPorId(long id) throws NotFoundException{
        for (Empleado empleado : repositorio)
            if (empleado.getId() == id)
                return empleado;
        //return null; // debería lanzar excepción si no encontrado
        throw new NotFoundException("Empleado no encontrado");
    }

    public Empleado editar(Empleado empleado) {
        int pos = repositorio.indexOf(empleado);
        if (pos == -1){
            return null; // debería lanzar excepción si no encontrado
        }
        repositorio.set(pos, empleado); // si lo encuentra, lo sustituye
        return empleado;
    }

    public void borrar(Long id) throws NotFoundException{
        Empleado empleado = this.obtenerPorId(id);
        if (empleado != null) {
            repositorio.remove(empleado); // podría devolver boolean
        }
    }
}

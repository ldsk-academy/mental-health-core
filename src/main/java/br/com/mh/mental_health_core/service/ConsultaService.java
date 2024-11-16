package br.com.mh.mental_health_core.service;

import br.com.mh.mental_health_core.exceptions.MentalHealthException;
import br.com.mh.mental_health_core.model.Consulta;
import br.com.mh.mental_health_core.repository.ConsultaRepository;
<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 47415dbf403402a9057af11e3d82abcd964d2eaa
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public List<Consulta> getAllConsultas() {
        List<Consulta> consultas = consultaRepository.findAll();
        if (consultas.isEmpty()) {
            throw new MentalHealthException(HttpStatus.NO_CONTENT, "Nenhuma consulta encontrada.");
        }
        return consultas;
    }

    public Consulta getConsultaById(Integer id) {
        return consultaRepository.findById(id)
<<<<<<< HEAD
                .orElseThrow(() -> new MentalHealthException(
                        HttpStatus.NOT_FOUND, 
                        "Consulta não encontrada com ID: " + id
                ));
=======
                .orElseThrow(() -> new ConsultaNotFoundException(HttpStatus.NOT_FOUND, "Consulta não encontrada com ID: " + id));
>>>>>>> 47415dbf403402a9057af11e3d82abcd964d2eaa
    }

    public Consulta saveConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void deleteConsulta(Integer id) {
<<<<<<< HEAD
        if (!consultaRepository.existsById(id)) {
            throw new MentalHealthException(
                    HttpStatus.NOT_FOUND, 
                    "Consulta não encontrada com ID: " + id
            );
        }
=======
        consultaRepository.findById(id).orElseThrow(() -> new ConsultaNotFoundException(HttpStatus.NOT_FOUND, "Consulta não encontrada com ID: " + id));
>>>>>>> 47415dbf403402a9057af11e3d82abcd964d2eaa
        consultaRepository.deleteById(id);
    }
}

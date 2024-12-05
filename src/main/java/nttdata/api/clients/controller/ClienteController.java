package nttdata.api.clients.controller;

import nttdata.api.clients.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @GetMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<?> obtenerCliente(
            @PathVariable @NotBlank @Pattern(regexp = "C|P", message = "Tipo de documento debe ser 'C' o 'P'") String tipoDocumento,
            @PathVariable @NotBlank String numeroDocumento) {

        if (!"C".equals(tipoDocumento) || !"23445322".equals(numeroDocumento)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }

        Cliente cliente = new Cliente(
                "Juan",
                "Carlos",
                "Pérez",
                "López",
                "123456789",
                "Calle 123",
                "Bogotá"
        );

        return ResponseEntity.ok(cliente);
    }
}

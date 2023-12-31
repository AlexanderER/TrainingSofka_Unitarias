package EPA.Cuenta_Bancaria_Web.Controlador;

import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Cuenta_DTO;
import EPA.Cuenta_Bancaria_Web.Modelo.M_Cuenta;
import EPA.Cuenta_Bancaria_Web.Servicio.Cuenta.I_Cuenta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("Cuentas")
public class C_Cuenta
{
    @Autowired
    @Qualifier("MONGO")
    I_Cuenta cuenta;

    @GetMapping(value = "/listar_cuentas")
    public  ResponseEntity<List<M_Cuenta_DTO>> listar_cuentas()
    {
        List<M_Cuenta_DTO> l_Cuentas = cuenta.findAll();

        return ResponseEntity.ok(l_Cuentas);
    }

    @PostMapping(value = "/Crear")
    public ResponseEntity<?> Crear_Cuenta(@Valid @RequestBody M_Cuenta_DTO p_cuenta)
    {
        M_Cuenta_DTO cuenta_Creada = cuenta.crear_Cuenta(p_cuenta);
        return ResponseEntity.ok(cuenta_Creada);
    }



}

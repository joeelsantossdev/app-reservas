# Skills y Patrones de Código del Proyecto (Java 21 + MySQL + Vue 3)

## 1. Patrón para Controladores REST (Spring Boot 3)
Todos los controladores deben seguir esta estructura base utilizando `ResponseEntity`, manejo de respuestas semánticas y la anotación `@CrossOrigin` para conectar con Vue 3 de forma local.

```java
package com.example.appreservas.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservas")
@CrossOrigin(origins = "http://localhost:5173") // Puerto por defecto de Vite/Vue 3
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<?> crearReserva(@Valid @RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO nuevaReserva = reservaService.crearReserva(dto);
        return new ResponseEntity<>(nuevaReserva, HttpStatus.CREATED);
    }
}
2. Patrón de Validación de Datos con Records (Java 21)
Aprovechar los record de Java 21 para crear DTOs inmutables, limpios y validados mediante jakarta.validation.constraints.

Java
package com.example.appreservas.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaRequestDTO(
    @NotNull(message = "El ID del usuario es obligatorio")
    Long usuarioId,
    
    @NotNull(message = "El ID de la sala es obligatorio")
    Long salaId,
    
    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha no puede ser en el pasado")
    LocalDate fecha,
    
    @NotNull(message = "La hora de inicio es obligatoria")
    LocalTime horaInicio,
    
    @NotNull(message = "La hora de fin es obligatoria")
    LocalTime horaFin
) {}
3. Patrón para Peticiones HTTP en Frontend (Vue 3 + Axios + TS)
Las llamadas a la API de MySQL en Vue 3 deben usar la sintaxis moderna de async/await, control de errores con try/catch y TypeScript para tipar la respuesta.

TypeScript
<script setup lang="ts">
import { ref, onMounted } from 'vue';
import axios from 'axios';

interface Sala {
  id: number;
  nombre: string;
  capacidad: number;
  precioHora: number;
}

const salas = ref<Sala[]>([]);
const loading = ref<boolean>(false);
const errorMsg = ref<string | null>(null);

const fetchSalas = async (): Promise<void> => {
  loading.value = true;
  try {
    const response = await axios.get<Sala[]>('http://localhost:8080/api/v1/salas');
    salas.value = response.data;
  } catch (err) {
    errorMsg.value = 'Error al cargar las salas desde la base de datos MySQL.';
    console.error(err);
  } finally {
    loading.value = false;
  }
};

onMounted(() => {
  fetchSalas();
});
</script>

---
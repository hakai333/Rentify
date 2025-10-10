package cl.MyMGroup.Rentify.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "arriendos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arriendo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaArriendo;
    private Double precioTotal;
    private String estadoArriendo;
    private Boolean requiereEntrega;
    private Boolean requiereInstalacion;
}

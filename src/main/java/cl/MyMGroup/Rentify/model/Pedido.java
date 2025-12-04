package cl.MyMGroup.Rentify.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String detalle;
    private Double total;
    private Double envio;
    private String direccion;
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado; // NUEVO CAMPO

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Pedido(String detalle, Double total, String direccion, Usuario usuario) {
        this.detalle = detalle;
        this.total = total;
        this.direccion = direccion;
        this.usuario = usuario;
        this.fecha = LocalDateTime.now();
        this.envio = calcularEnvio(total);
        this.estado = EstadoPedido.RECIBIDO;
    }

    private Double calcularEnvio(Double total){
        return 30000 + (total * 0.2);
    }

    public Double totalConEnvio(){
        return total + envio;
    }
}

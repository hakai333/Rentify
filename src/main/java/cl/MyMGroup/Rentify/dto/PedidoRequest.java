package cl.MyMGroup.Rentify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {
    private Long usuarioId;
    private String detalle;
    private Double total;
    private String direccion;
}

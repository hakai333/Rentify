package cl.MyMGroup.Rentify.controller;

import cl.MyMGroup.Rentify.dto.PedidoRequest;
import cl.MyMGroup.Rentify.model.Pedido;
import cl.MyMGroup.Rentify.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido crearPedido(@RequestBody PedidoRequest request) {
        return pedidoService.crearPedido(
                request.getUsuarioId(),
                request.getDetalle(),
                request.getTotal(),
                request.getDireccion()
        );
    }


    // Listar todos los pedidos
    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    // Listar pedidos de un usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<Pedido> listarPedidosUsuario(@PathVariable Long usuarioId) {
        return pedidoService.listarPedidosPorUsuario(usuarioId);
    }

    // Obtener pedido por ID
    @GetMapping("/{id}")
    public Pedido obtenerPedido(@PathVariable Long id) {
        return pedidoService.obtenerPedido(id);
    }

    // Eliminar pedido
    @DeleteMapping("/{id}")
    public String eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
        return "Pedido eliminado con éxito";
    }
}

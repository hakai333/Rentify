package cl.MyMGroup.Rentify.service;

import cl.MyMGroup.Rentify.model.Pedido;
import cl.MyMGroup.Rentify.model.Usuario;
import cl.MyMGroup.Rentify.repository.PedidoRepository;
import cl.MyMGroup.Rentify.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    // CREACION PEDIDO
    public Pedido crearPedido(Long usuarioId, String detalle, Double total, String direccion) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + usuarioId));

        Pedido pedido = new Pedido(detalle, total, direccion, usuario);
        return pedidoRepository.save(pedido);
    }

    // LISTAR TODOS LOS PEDIDOS
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    // LISTAR PEDIDOS DE UN CLIENTE POR SU ID
    public List<Pedido> listarPedidosPorUsuario(Long usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId);
    }

    // OBTENCION DEL PEDIDO ATRAVES DEL ID
    public Pedido obtenerPedido(Long id){
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
    }

    // ELIMINAR PEDIDO
    public void eliminarPedido(Long id){
        pedidoRepository.deleteById(id);
    }
}

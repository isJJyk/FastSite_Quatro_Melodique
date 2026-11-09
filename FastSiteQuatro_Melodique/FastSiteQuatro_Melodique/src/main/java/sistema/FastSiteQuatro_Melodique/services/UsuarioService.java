package sistema.FastSiteQuatro_Melodique.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sistema.FastSiteQuatro_Melodique.entities.Usuario;
import sistema.FastSiteQuatro_Melodique.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario usuarioCadastro(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario lerUsuario(Long usuarioId){
        return usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Não foi possível encontrar este usuário"));
    }

    @Transactional(readOnly = true)
    public List<Usuario> lerUsuarioPorNome(String login){
        List<Usuario> usuarios = usuarioRepository.findByLogin(login);
        if (usuarios.isEmpty()){
            throw new RuntimeException("Não foi possível encontrar usuários");
        }
        return usuarios;
    }

    @Transactional
    public Usuario atualizarUsuario(Long usuarioId, Usuario novosDados){
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() ->  new RuntimeException("Não foi possível encontrar este usuário"));

        usuario.setLogin(novosDados.getLogin());
        usuario.setSenha(novosDados.getSenha());
        usuario.setNome(novosDados.getNome());
        usuario.setEndereco(novosDados.getEndereco());
        usuario.setCep(novosDados.getCep());
        usuario.setNumero(novosDados.getNumero());
        usuario.setTelefone(novosDados.getTelefone());
        usuario.setObservacao(novosDados.getObservacao());

        return usuarioRepository.save(usuario);
    }
    @Transactional
    public void deletarUsuario(Long usuarioId){
        Usuario usuarioExistente = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Não foi possível encontrar este usuário"));

        usuarioRepository.delete(usuarioExistente);
    }

}

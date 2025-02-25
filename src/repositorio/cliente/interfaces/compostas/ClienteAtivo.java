package repositorio.cliente.interfaces.compostas;

import repositorio.cliente.interfaces.especificas.ClienteConsulta;
import repositorio.cliente.interfaces.especificas.ClienteManipulacao;
import repositorio.cliente.interfaces.especificas.ClienteAlteracao;

public interface ClienteAtivo extends ClienteConsulta, ClienteManipulacao, ClienteAlteracao {

}

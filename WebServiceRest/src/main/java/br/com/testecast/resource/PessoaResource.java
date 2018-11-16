package br.com.testecast.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.testecast.repository.PessoaRepository;
import br.com.testecast.repository.entity.EntidadePessoa;
import br.com.testecast.response.PessoaTO;

@Path("/rest")
public class PessoaResource {

	private final  PessoaRepository repository = new PessoaRepository();
	 
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/pessoa/save")
	public Response Cadastrar(PessoaTO pessoa){
 
		EntidadePessoa entity = new EntidadePessoa();
 
		try {
 
			entity.setNome(pessoa.getNome());
			entity.setCpf(pessoa.getCpf());
			entity.setTpLogradouro(pessoa.getTpLogradouro());
			entity.setLogradouro(pessoa.getLogradouro());
			entity.setNumero(pessoa.getNumero());
			entity.setBairro(pessoa.getBairro());
			entity.setCidade(pessoa.getCidade());
			entity.setEstado(pessoa.getEstado());
			entity.setTelefoneCelular(pessoa.getTelefoneCelular());
			entity.setTelefoneResidencial(pessoa.getTelefoneResidencial());
 
			repository.Salvar(entity);
 
			return Response.status(Status.CREATED).build();
 
		} catch (Exception e) {
 
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
 
	}
 
	/**
	 * Essse método altera uma pessoa já cadastrada
	 * **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/pessoa/alterar")
	public Response Alterar(PessoaTO pessoa){
 
		EntidadePessoa entity = new EntidadePessoa();
 
		try {
 
			entity.setIdPessoa(pessoa.getIdPessoa());
			entity.setNome(pessoa.getNome());
			entity.setCpf(pessoa.getCpf());
			entity.setTpLogradouro(pessoa.getTpLogradouro());
			entity.setLogradouro(pessoa.getLogradouro());
			entity.setNumero(pessoa.getNumero());
			entity.setBairro(pessoa.getBairro());
			entity.setCidade(pessoa.getCidade());
			entity.setEstado(pessoa.getEstado());
			entity.setTelefoneCelular(pessoa.getTelefoneCelular());
			entity.setTelefoneResidencial(pessoa.getTelefoneResidencial());
 
			repository.Alterar(entity);
 
			return Response.status(Status.ACCEPTED).build();
 
		} catch (Exception e) {
 
			return Response.status(Status.NOT_MODIFIED).build();
 
		}
 
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/pessoas")
	public Response TodasPessoas(){
		
		List<PessoaTO> pessoas =  new ArrayList<PessoaTO>();
 
		List<EntidadePessoa> listaEntityPessoas = repository.TodasPessoas();
		
		for (EntidadePessoa entity : listaEntityPessoas) {
 
			pessoas.add(new PessoaTO(	entity.getIdPessoa(),
										entity.getNome(),
										entity.getCpf(),
										entity.getTpLogradouro(),
										entity.getLogradouro(),
										entity.getNumero(),
										entity.getBairro(),
										entity.getCidade(),
										entity.getEstado(),
										entity.getTelefoneCelular(),
										entity.getTelefoneResidencial()));
		}
		
		GenericEntity<List<PessoaTO>> entity = new GenericEntity<List<PessoaTO>>(pessoas) {};
 
		if(pessoas.isEmpty()){
			return Response.status(Status.NO_CONTENT).header("Access-Control-Allow-Origin", "*").build();
		}else{
			return Response.ok(entity).header("Access-Control-Allow-Origin", "*").build();
		}
	}
 
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/pessoa/{id}")
	public Response GetPessoa(@PathParam("id") Integer codigo){
 
		EntidadePessoa entity = repository.GetPessoa(codigo);
 
		if(entity != null)
			return Response.ok(new PessoaTO(	entity.getIdPessoa(),
													entity.getNome(),
													entity.getCpf(),
													entity.getTpLogradouro(),
													entity.getLogradouro(),
													entity.getNumero(),
													entity.getBairro(),
													entity.getCidade(),
													entity.getEstado(),
													entity.getTelefoneCelular(),
													entity.getTelefoneResidencial())).build();;
 
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
 
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/pessoa/remove/{codigo}")	
	public Response Excluir(@PathParam("codigo") Integer codigo){
 
		try {
 
			repository.Excluir(codigo);
 
			return Response.ok().build();
 
		} catch (Exception e) {
 
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
 
	}
	
}

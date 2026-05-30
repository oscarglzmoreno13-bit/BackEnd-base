package com.mx.forty.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.forty.dto.vo.ColoniaBackVo;
import com.mx.forty.dto.vo.EstadoBackVo;
import com.mx.forty.dto.vo.FormaPagoBackVo;
import com.mx.forty.dto.vo.MiunicipioBackVo;
import com.mx.forty.dto.vo.PersonaBackVo;
import com.mx.forty.dto.vo.TipoFormaPagoBackVo;
import com.mx.forty.entity.Colonia;
import com.mx.forty.entity.Estado;
import com.mx.forty.entity.FormaPago;
import com.mx.forty.entity.Municipio;
import com.mx.forty.entity.Persona;
import com.mx.forty.entity.TipoFormaPago;
import com.mx.forty.repository.ColoniaRepository;
import com.mx.forty.repository.EstadoRepository;
import com.mx.forty.repository.FormaPagoRepository;
import com.mx.forty.repository.MunicipioRepository;
import com.mx.forty.repository.PersonaRepository;
import com.mx.forty.repository.TipoFormaPagoRepository;
import com.mx.forty.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	MunicipioRepository municipioRepository;
	@Autowired
	ColoniaRepository coloniaRepository;
	@Autowired
	TipoFormaPagoRepository tipoFormaPagoRepository;
	@Autowired
	FormaPagoRepository formaPagoRepository;
	@Autowired
	PersonaRepository personaRepository;
	
	@Override
	public List<EstadoBackVo> buscaEstrados() {
		// TODO Auto-generated method stub
		List<Estado> listaEdos = estadoRepository.findAll();
		List<EstadoBackVo> lista = new ArrayList<EstadoBackVo>();
		for (Estado estado : listaEdos) {
			EstadoBackVo vo = new EstadoBackVo();
			vo.setIdEstado(estado.getIdEstado());
			vo.setNombre(estado.getNombre());
			lista.add(vo);
		}
		return lista;
	}
	@Override
	public List<MiunicipioBackVo> findMcpioByIdEstado(Integer idEstado) {
		// TODO Auto-generated method stub
		List<Municipio> listaMcpio = municipioRepository.findByIdEstado(idEstado);
		List<MiunicipioBackVo> lista = new ArrayList<MiunicipioBackVo>();
		for (Municipio municipio : listaMcpio) {
			MiunicipioBackVo vo = new MiunicipioBackVo();
			vo.setIdEstado(municipio.getEstado().getIdEstado());
			vo.setIdMunicipio(municipio.getIdMunicipio());
			vo.setNombre(municipio.getNombre());
			lista.add(vo);
		}
		return lista;
	}
	@Override
	public List<ColoniaBackVo> findColoniaByIdMcpio(Integer idMcpio) {
		// TODO Auto-generated method stub
		List<Colonia> listaColonias = coloniaRepository.findByIdMcpio(idMcpio);
		List<ColoniaBackVo> lista = new ArrayList<ColoniaBackVo>();
		for (Colonia colonia : listaColonias) {
			ColoniaBackVo vo = new ColoniaBackVo();
			vo.setCp(colonia.getCodigoPostal());
			vo.setIdColonia(colonia.getIdColonia());
			vo.setIdMunicipio(colonia.getMunicipio().getIdMunicipio());
			vo.setNombre(colonia.getNombre());
			lista.add(vo);
		}
		return lista;
	}
	@Override
	public List<TipoFormaPagoBackVo> findTiposFormaPago() {
		// TODO Auto-generated method stub
		List<TipoFormaPago> lstaForma = tipoFormaPagoRepository.findAll();
		List<TipoFormaPagoBackVo> lista = new ArrayList<TipoFormaPagoBackVo>();
		for (TipoFormaPago tipoFormaPago : lstaForma) {
			TipoFormaPagoBackVo vo = new TipoFormaPagoBackVo();
			vo.setIdTipoFormaPago(tipoFormaPago.getIdTipoFormaPago());
			vo.setNombre(tipoFormaPago.getNombre());
			lista.add(vo);
		}
		return lista;
	}
	@Override
	public List<FormaPagoBackVo> findFormasPago() {
		List<FormaPago> lst = formaPagoRepository.findAll();
		List<FormaPagoBackVo> lista = new ArrayList<FormaPagoBackVo>();
		for (FormaPago formaPago : lst) {
			FormaPagoBackVo vo = new FormaPagoBackVo();
			vo.setIdFormaPago(formaPago.getIdFormaPago());
			vo.setIdTipoFormaPago(formaPago.getTipoFormaPago().getIdTipoFormaPago());
			vo.setNombre(formaPago.getNombre());
			lista.add(vo);
		}
		// TODO Auto-generated method stub
		return lista;
	}
	@Override
	public List<PersonaBackVo> findLikeNombre(String nombre) {
		// TODO Auto-generated method stub
		List<Persona> lstP = personaRepository.findLikeNombre(nombre);
		List<PersonaBackVo> lista = new ArrayList<PersonaBackVo>();
		for (Persona persona : lstP) {
			PersonaBackVo vo = personaEntityToVo(persona);
			lista.add(vo);
		}
		return lista;
	}
	
	@Override
	public List<String> finsAllCp() {
		return coloniaRepository.findDistinctCodigosPostales();
	}
	
	
	private PersonaBackVo personaEntityToVo(Persona persona) {
		PersonaBackVo vo = new PersonaBackVo();
		vo.setNombre(persona.getNombre());
		vo.setApePat(persona.getApellidoPat());
		vo.setApeMat(persona.getApellidoMat());
		vo.setIdPersona(persona.getIdPersona());
		vo.setMail(persona.getMail());
		vo.setTelefono(persona.getTelefono());
		vo.setUserName(persona.getUserName());
		return vo;
	}
	@Override
	public List<PersonaBackVo> buscaUsuarios() {
		// TODO Auto-generated method stub
		List<Persona> lst = personaRepository.buscaUsuarios();
		List<PersonaBackVo> lista = new ArrayList<PersonaBackVo>();
		for (Persona persona : lst) {
			PersonaBackVo vo = personaEntityToVo(persona);
			lista.add(vo);
		}
		return lista;
	}
	@Override
	public List<ColoniaBackVo> findColoniasByCp(String cp) {
		// TODO Auto-generated method stub
		List<Colonia> lst = coloniaRepository.findColoniasByCp(cp);
		List<ColoniaBackVo> lista = new ArrayList<ColoniaBackVo>();
		for (Colonia colonia : lst) {
			ColoniaBackVo vo = new ColoniaBackVo();
			vo.setCp(colonia.getCodigoPostal());
			vo.setIdColonia(colonia.getIdColonia());
			vo.setIdMunicipio(colonia.getMunicipio().getIdMunicipio());
			vo.setNombre(colonia.getNombre());
			vo.setIdEstado(colonia.getMunicipio().getEstado().getIdEstado());
			vo.setNombreEstado(colonia.getMunicipio().getEstado().getNombre());
			vo.setNombreMunicipio(colonia.getMunicipio().getNombre());
			lista.add(vo);
		}
		return lista;
	}
	
	
	
	
}

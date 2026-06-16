package com.mx.forty.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.forty.dto.vo.MarcaVo;
import com.mx.forty.entity.ConfiguracionVenta;
import com.mx.forty.entity.Estatus;
import com.mx.forty.entity.Marca;
import com.mx.forty.entity.Producto;
import com.mx.forty.repository.ConfiguracionVentaRepository;
import com.mx.forty.repository.DetalleComfiguracionVentaRepository;
import com.mx.forty.repository.MarcaRepository;
import com.mx.forty.repository.ProductoRepository;
import com.mx.forty.service.MarcaService;
import com.mx.forty.util.Constantes;

@Service
public class MarcaServiceImpl implements MarcaService {

	 @Autowired
	    private MarcaRepository repository;
	 @Autowired
	 private ProductoRepository productosRepository;
	 
	 @Autowired
	 private DetalleComfiguracionVentaRepository repositoryDetalle;
	 
	 @Autowired
	 private ConfiguracionVentaRepository  configuracionRepository;

	    @Override
	    public List<Marca> findAll() {
	        return repository.findAllActives();
	    }

	    @Override
	    public void save(Marca marca) {
	    	marca.setEstatus(new Estatus());
	    	marca.getEstatus().setIdEstatus(Constantes.ESTATUS_GRAL_ACTIVO);
	        repository.save(marca);
	    }

		@Override
		public void delete(MarcaVo vo) {
			// TODO Auto-generated method stub
			Marca marca = new Marca();
			marca.setClave(vo.getClave());
			marca.setIdMarca(vo.getIdMarca());
			marca.setNombre(vo.getNombre());
			marca.setEstatus(new Estatus());
			marca.getEstatus().setIdEstatus(Constantes.ESTATUS_GRAL_INACTIVO);
			repository.save(marca);
			
			List<Producto> listaProductos = productosRepository.findByMarca(marca.getIdMarca());
			for (Producto producto : listaProductos) {
				producto.getEstatus().setIdEstatus(Constantes.ESTATUS_GRAL_EN_REVISION);
				productosRepository.save(producto);
				
				List<Integer> listaCfg = repositoryDetalle.findCfgByProducto(producto.getIdProducto());
				for (Integer idCfg : listaCfg) {
					ConfiguracionVenta configuracion = configuracionRepository.findById(idCfg).get();
					configuracion.getEstatus().setIdEstatus(Constantes.ESTATUS_GRAL_EN_REVISION);
					configuracionRepository.save(configuracion);
				}
			}
			
		}
}

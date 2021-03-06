package unla.proyectos.version2.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import unla.proyectos.version2.converters.VendedorConverter;
import unla.proyectos.version2.entities.Vendedor;
import unla.proyectos.version2.models.LocalModel;
import unla.proyectos.version2.models.VendedorModel;
import unla.proyectos.version2.repositories.IVendedorRepository;
import unla.proyectos.version2.services.IVendedorService;



@Service("vendedorService")
public class VendedorService implements IVendedorService{

	@Autowired
    @Qualifier("vendedorRepository")
    private IVendedorRepository vendedorRepository;

    @Autowired
    @Qualifier("vendedorConverter")
    private VendedorConverter vendedorConverter;

    @Override
    public List<Vendedor> getAll(){
        return vendedorRepository.findAll();
    }

    @Override
    public VendedorModel findByIdPersona(long id){
        return vendedorConverter.entityToModel(vendedorRepository.findByIdPersona(id));
    }

    @Override
    public VendedorModel findByDni(Long dni){
        return vendedorConverter.entityToModel(vendedorRepository.findByDni(dni));
    }

    @Override
    public VendedorModel insert(VendedorModel vendedorModel) {
    	
    	Vendedor vendedor =  vendedorRepository.save(vendedorConverter.modelToEntity(vendedorModel));
         
        return vendedorConverter.entityToModel(vendedor);
    }
    
    
    @Override
    public List<VendedorModel> vendedoresPorLocal(LocalModel local){
    	
    	
    	List<VendedorModel> vendedores = new ArrayList<VendedorModel>();
    	
    	for(Vendedor v: getAll()) {
    		
    		
    		if(v.getLocal().getId()==local.getId()) {
    			
    			vendedores.add(vendedorConverter.entityToModel(v));
    			
    		}
    		
    	}
    	
    	return vendedores;
    }
    
    
    

    @Override
    public VendedorModel update(VendedorModel vendedorModel) {
        Vendedor vendedor = vendedorRepository.save(vendedorConverter.modelToEntity(vendedorModel));
        return vendedorConverter.entityToModel(vendedor);
    }
    

    @Override
    public boolean remove(long id){
        try{
            vendedorRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}

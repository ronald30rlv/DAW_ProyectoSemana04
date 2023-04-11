
package pe.cibertec.Ecommerce.ApiCustomer.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.Ecommerce.ApiCustomer.DAO.CustomerRepository;
import pe.cibertec.Ecommerce.ApiCustomer.Entity.Customer;

@Service
public class CustomerServiceImplement implements ICustomerService {
    @Autowired
    private CustomerRepository repository; //Esto es la inyeccion de dependencias
    
    @Override
    public List<Customer> ListadoClientes() {        
        return (List<Customer>) repository.findAll();
    }
    @Override
    public Customer BuscarXId(Long Id) {
     return repository.findById(Id).orElse(null);
    }    

    @Override
    public Customer findByEmail(String email) {
     return repository.findByEmail(email);    
    }
    /*
    @Override
    public Customer BuscarXPhone(String celular) {
       return repository.findByPhone(celular);
    }
    */

    @Override
    public Customer add(Customer customer) {
       return repository.save(customer);
    }

    @Override
    public Customer update(Long Id, Customer customer) {
        Customer customerDB=repository.findById(Id).get();//Aqui estamos trayendo los datos tal cual estan en la BD 
        customerDB.setNombre(customer.getNombre());
        customerDB.setApepaterno(customer.getApepaterno());
        customerDB.setApematerno(customer.getApematerno());
        customerDB.setEdad(customer.getEdad());
        customerDB.setSexo(customer.getSexo());
        customerDB.setCelular(customer.getCelular());
        customerDB.setEmail(customer.getEmail());
        return repository.save(customerDB);
    }

    @Override
    public void Borrar(Long Id) {
        Customer customerDB=repository.findById(Id).get();
        repository.delete(customerDB);
    }
    
    
}

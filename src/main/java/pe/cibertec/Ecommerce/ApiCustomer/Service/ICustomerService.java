package pe.cibertec.Ecommerce.ApiCustomer.Service;

import java.util.List;
import pe.cibertec.Ecommerce.ApiCustomer.Entity.Customer;

public interface ICustomerService {
    public List<Customer> ListadoClientes();
    public Customer BuscarXId(Long Id);
    
    public Customer findByEmail(String email);     
    //public Customer BuscarXPhone(String celular); 
    public Customer add(Customer customer);
    public Customer update(Long Id,Customer customer);
    public void Borrar(Long Id);
}


package pe.cibertec.Ecommerce.ApiCustomer.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.Ecommerce.ApiCustomer.Entity.Customer;
import pe.cibertec.Ecommerce.ApiCustomer.Service.ICustomerService;

@RestController //En el Browser te va a devolver una vista en formato Json, para un WebService
//@Controller //Para cuando ya tengas tus propios html
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    ICustomerService reposiCustomerService ;//Esta inyeccion de dependencia de la Interface, busca y conecta con la clase o clases de Implementacion(que es la que tiene la coneccion a la BD)
    //Ahora vamos a construir nuestros EndPoint's
    @GetMapping("/findAll")
    public List<Customer> findAll(){                
        return reposiCustomerService.ListadoClientes(); //api/customer/findAll (a esta ruta se le llama BasePath(EndPoint))
    }
    @GetMapping("/findById/{Id}")
    public Customer findById(@PathVariable Long Id){
        return reposiCustomerService.BuscarXId(Id); //api/customer/findById/2
    }
    @GetMapping("/findByEmail/{email}")
    public Customer findByEmail(@PathVariable String email){
        return reposiCustomerService.findByEmail(email); //api/customer/findByEmail/
    }
    /*
    @GetMapping("/findByPhone/{celular}")
    public Customer findByPhone(@PathVariable String celular){
        return reposiCustomerService.findByPhone(celular); //api/customer/findByPhone
    }
    */
    @PostMapping("/add") //Post es para agregar
    public Customer Agregar(@RequestBody Customer customer){
        return reposiCustomerService.add(customer);
    }
    @PutMapping("/update/{Id}") //Put es para actualizar
    public Customer Actualizar(@PathVariable Long Id,@RequestBody Customer customer){
        return reposiCustomerService.update(Id, customer);
    }
    @DeleteMapping("/delete/{Id}") //deleet es para borrar
    public void Eliminar(@PathVariable Long Id){
        reposiCustomerService.Borrar(Id);
    }
}

package pe.cibertec.Ecommerce.ApiCustomer.DAO;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pe.cibertec.Ecommerce.ApiCustomer.Entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{ //JpaReposotory<Customer, Long>, si el crud que vas a hacer tiene paginacion
    //Metodo que va a devolver el email
   Customer findByEmail(String email);
   /*@Query("Select * from customer c where c.celular=?1 and c.email=?2")
   Customer findByPhone(String celular, String email);*/
   /*
    @Query("select * from customer c where c.celular=?1")*/
   /*
   Customer findByPhone(String celular);
   */
}

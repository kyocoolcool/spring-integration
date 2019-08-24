package kyocoolcool;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


//@RepositoryDefinition(domainClass = Person.class,idClass = Integer.class)
public interface AddressRepository extends JpaRepository<Address,Integer> , JpaSpecificationExecutor<Person> ,MyRepository{
//    List<Person> getByLastName(String laseName);


}

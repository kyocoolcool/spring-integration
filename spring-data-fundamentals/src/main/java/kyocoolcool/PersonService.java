package kyocoolcool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName PersonService
 * @Description Service
 * @Author chris
 * @Date 2019-04-19 18:43
 * @Version 1.0
 **/
@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    @Transactional
    public void updatePersonEmail(String email,Integer id){
        personRepository.updatePersonEmail(email,id);
    }

    @Transactional
    public void savePersons(List<Person>persons) {
        personRepository.saveAll(persons);
    }

    @Transactional
    public void savePerson(Person person) {
        personRepository.save(person);
    }
}
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
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Transactional
    public void saveAddress(Address Address) {
        addressRepository.save(Address);
    }
}
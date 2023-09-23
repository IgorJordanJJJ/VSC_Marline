package jordan.grup.VSK_Marlin.services;



import jordan.grup.VSK_Marlin.models.Person;
import jordan.grup.VSK_Marlin.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistratinService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistratinService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Transactional
    public void register(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_EMPL");
        personRepository.save(person);
    }

    @Transactional
    public void update(Person updateperson, int id) {
        updateperson.setPassword(passwordEncoder.encode(updateperson.getPassword()));
        updateperson.setId(id);
        personRepository.save(updateperson);
    }

}

package jordan.grup.VSK_Marlin.services;


import jordan.grup.VSK_Marlin.models.Person;
import jordan.grup.VSK_Marlin.repositories.PersonRepository;
import jordan.grup.VSK_Marlin.security.PersonDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;


    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByUsername(s);
        if(((Optional<?>) person).isEmpty())
            throw new UsernameNotFoundException("User not found!");

        return new PersonDetails(person.get());
    }

    public List<Person> findAll(){return personRepository.findAll();}

    public Person findOne(int id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(Person person) {
        personRepository.save(person);
    }


    @Transactional
    public void delete(int id) {
        personRepository.deleteById(id);
    }

}

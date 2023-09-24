package jordan.grup.VSK_Marlin.services;

import jordan.grup.VSK_Marlin.models.Application;
import jordan.grup.VSK_Marlin.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class ApplicationService {


    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService( ApplicationRepository applicationRepository) {

        this.applicationRepository = applicationRepository;
    }


    public List<Application> findAll(){
        return applicationRepository.findAll();
    }




}

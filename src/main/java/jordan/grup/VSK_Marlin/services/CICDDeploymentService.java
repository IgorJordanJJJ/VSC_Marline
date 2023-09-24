package jordan.grup.VSK_Marlin.services;

import jordan.grup.VSK_Marlin.models.Application;
import jordan.grup.VSK_Marlin.models.CICDDeployment;
import jordan.grup.VSK_Marlin.repositories.CICDDeploymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CICDDeploymentService {
    private final CICDDeploymentRepository cicdDeploymentRepository;

    @Autowired
    public CICDDeploymentService(CICDDeploymentRepository cicdDeploymentRepository) {
        this.cicdDeploymentRepository = cicdDeploymentRepository;
    }

    public List<CICDDeployment> findAll(){
        return cicdDeploymentRepository.findAll();
    }

}

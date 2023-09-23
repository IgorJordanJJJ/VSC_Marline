package jordan.grup.VSK_Marlin.repositories;

import jordan.grup.VSK_Marlin.models.CICDDeployment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CICDDeploymentRepository extends JpaRepository<CICDDeployment, Integer> {
}

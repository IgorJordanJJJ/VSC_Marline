package jordan.grup.VSK_Marlin.repositories;

import jordan.grup.VSK_Marlin.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    List<Application> findById_user(int id);
}

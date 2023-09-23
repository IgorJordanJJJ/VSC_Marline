package jordan.grup.VSK_Marlin.repositories;

import jordan.grup.VSK_Marlin.models.GitRepositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitRepositoriesRepository extends JpaRepository<GitRepositories, Integer> {
}

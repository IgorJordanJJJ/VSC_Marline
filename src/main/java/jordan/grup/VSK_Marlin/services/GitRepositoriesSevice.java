package jordan.grup.VSK_Marlin.services;

import jordan.grup.VSK_Marlin.models.Application;
import jordan.grup.VSK_Marlin.models.GitRepositories;
import jordan.grup.VSK_Marlin.repositories.GitRepositoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitRepositoriesSevice {

    private final GitRepositoriesRepository gitRepositoriesRepository;

    @Autowired
    public GitRepositoriesSevice(GitRepositoriesRepository gitRepositoriesRepository) {
        this.gitRepositoriesRepository = gitRepositoriesRepository;
    }

    public List<GitRepositories> findAll(){
        return gitRepositoriesRepository.findAll();
    }

}

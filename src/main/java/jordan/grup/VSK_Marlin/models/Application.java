package jordan.grup.VSK_Marlin.models;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Application")
public class Application {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Person userowner;

    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 2, max = 100, message = "Название должно быть от 2 до 100 символов длинной")
    @Column(name = "name")
    private String name;

    @Id
    @OneToOne
    @JoinColumn(name = "id_gitrepository", referencedColumnName = "id")
    private GitRepositories gitRepositories;

    @Id
    @OneToOne
    @JoinColumn(name = "id_CI_CD", referencedColumnName = "id")
    private CICDDeployment cicdDeployment;

    public Application() {
    }

    public Application(int id, Person userowner) {
        this.id = id;
        this.userowner = userowner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getUserowner() {
        return userowner;
    }

    public void setUserowner(Person userowner) {
        this.userowner = userowner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GitRepositories getGitRepositories() {
        return gitRepositories;
    }

    public void setGitRepositories(GitRepositories gitRepositories) {
        this.gitRepositories = gitRepositories;
    }

    public CICDDeployment getCicdDeployment() {
        return cicdDeployment;
    }

    public void setCicdDeployment(CICDDeployment cicdDeployment) {
        this.cicdDeployment = cicdDeployment;
    }


}

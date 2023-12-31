package jordan.grup.VSK_Marlin.models;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов длинной")
    @Column(name ="username")
    private String username;


    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "userowner")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Application> applications;
    public Person(){
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(String username) {
        this.username = username;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {return password;}

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    @Override
    public String toString(){
        return "Person{"+
                "id ="+id+
                " username ="+username+
                "password ="+password+
                "}";
    }
}


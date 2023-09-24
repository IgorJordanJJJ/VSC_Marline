package jordan.grup.VSK_Marlin.models;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="GitRepositories")
public class GitRepositories {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 2, max = 100, message = "Название должно быть от 2 до 100 символов длинной")
    @Column(name ="name")
    private String name;


    @NotEmpty(message = "Програмный код не может быть пустым")
    @Min(value = 1, message = "Програмный код должен быть больше отдгого символа")
    @Column(name ="text_programm")
    private String textProgramm;

    @NotEmpty(message = "Выберите команду")
    @Column(name ="command")
    private String command;


    @OneToOne(mappedBy = "gitRepositories")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Application application;
    public GitRepositories() {
    }


    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public GitRepositories(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextProgramm() {
        return textProgramm;
    }

    public void setTextProgramm(String textProgramm) {
        this.textProgramm = textProgramm;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}

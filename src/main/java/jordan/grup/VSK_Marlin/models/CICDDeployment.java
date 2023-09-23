package jordan.grup.VSK_Marlin.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CICDDeployment")
public class CICDDeployment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Выберите платформу")
    @Column(name ="platform")
    private String platform;


    @Column(name ="status")
    private String status;

    @NotEmpty(message = "Выберите команду")
    @Column(name ="command")
    private String command;

    @OneToOne(mappedBy = "cicdDeployment")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Application application;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public CICDDeployment() {
    }

    public CICDDeployment(int id, String platform) {
        this.id = id;
        this.platform = platform;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}

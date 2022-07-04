package Enities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Authorizations")
public class Authorizations {
    @Id
    @Column(name = "Id")
    private int Id;
    @Column(name = "Login")
    private String Login;
    @Column(name = "Password")
    private String Password;

    public Authorizations(String Login) {
        super();
        this.Login = Login;
    }

    public Authorizations() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }


    @Override
    public String toString() {
        return "Authorizations{" +
                "Id=" + Id +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}

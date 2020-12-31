package marco.sporting.data.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ATLETA")
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    @Basic(optional = false)
    private String nome;

    @Column(name = "COGNOME")
    @Basic(optional = false)
    private String cognome;

    @Column(name = "TELEFONO")
    @Basic(optional = false)
    private Long telefono;

    @Column(name = "EMAIL")
    @Basic(optional = false)
    private String email;

    @Column(name = "USERNAME")
    @Basic(optional = false)
    private String username;

    @Column(name = "PASSWORD")
    @Basic(optional = false)
    private String password;

    @Column(name = "ADMIN")
    @Basic(optional = false)
    private boolean admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    // per essere sicuri
    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atleta atleta = (Atleta) o;
        return admin == atleta.admin && Objects.equals(id, atleta.id) && Objects.equals(nome, atleta.nome) && Objects.equals(cognome, atleta.cognome) && Objects.equals(telefono, atleta.telefono) && Objects.equals(email, atleta.email) && Objects.equals(username, atleta.username) && Objects.equals(password, atleta.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cognome, telefono, email, username, password, admin);
    }
}

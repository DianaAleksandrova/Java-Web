package bg.softuni.mobilelele.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private UserRoleName name;

    public RoleEntity() {
    }

    public UserRoleName getRole() {
        return name;
    }

    public void setRole(UserRoleName name) {
        this.name = name;
    }
}

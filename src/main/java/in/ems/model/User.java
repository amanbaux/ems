package in.ems.model;

import in.ems.utils.CommonConstants;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author Aman
 */

public class User {

    private String fullName;

    @NotNull
    @NotBlank(message = CommonConstants.NAME_CANT_BLANK)
    private String userId;

    @NotBlank(message = CommonConstants.PASS_CANT_BLANK)
    private String password;
    @NotBlank(message = CommonConstants.ROLE_CANT_BLANK)
    private Integer role;

    private Integer id;
    
    public User() {

    }

    public User(@NotNull @NotBlank(message = CommonConstants.NAME_CANT_BLANK) String userId,
            @NotBlank(message = CommonConstants.PASS_CANT_BLANK) String password,
            @NotBlank(message = CommonConstants.ROLE_CANT_BLANK) int role) {
        super();
        this.userId = userId;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}

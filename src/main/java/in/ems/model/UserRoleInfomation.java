package in.ems.model;

public class UserRoleInfomation {

	private String roleName;
	private String roleDesc;
	private int roleId;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		return "UserRoleInfomation [roleName=" + roleName + ", roleDesc=" + roleDesc + ", roleId=" + roleId + "]";
	}

}

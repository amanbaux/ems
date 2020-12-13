package in.ems.model;

public class UserRole {

	private int userId;
	private int roleId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int autogenaratedIdOfUser) {
		this.userId = autogenaratedIdOfUser;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int autogenaratedIdOfUser) {
		this.roleId = autogenaratedIdOfUser;
	}
 
	@Override
	public String toString() {
		return "UserRole [userId=" + userId + ", roleId=" + roleId + "]";
	}
}

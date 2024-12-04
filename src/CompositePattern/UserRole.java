package CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class UserRole implements LibraryRole{
	private String name;
	private List<Permissions> permissionList = new ArrayList<>();
	
	public UserRole (String name) {
		this.name = name;
	}

	@Override
	public boolean hasPermission(String task) {
		return permissionList.stream().anyMatch(permission -> permission.getTask().equalsIgnoreCase(task));
	}
	@Override
	public void runTask(String task, ActionContext context) {
		if(hasPermission(task)) {
			System.out.println(name + " performing task: " + task);
		}else{
			System.out.println(name + "  cannot perform task: " + task);
		}
	}
	@Override
	public void assignTask(String task) {
		permissionList.add(new Permissions(task));
	}
}


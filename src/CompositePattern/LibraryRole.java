package CompositePattern;

public interface LibraryRole {
	boolean hasPermission(String task);
	void runTask(String task, ActionContext context);
	void assignTask(String task);
}

package lu;
public enum A {
	BRIGHT("bright fuck");
	A(String name) {
		this.desc = name;
	}
	private final String desc;
	public String getName() {
		return this.desc;
	}
}

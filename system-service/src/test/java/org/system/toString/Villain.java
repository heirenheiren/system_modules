package org.system.toString;

class Villain {
	private String name;
	
	protected void set(String nm){
		name=nm;
	}

	public Villain(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Villain [name=" + name + "]";
	}
	
}

package pobj.micros.fs;

public class Node implements INode {
	
	private String name;
	
	public Node(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}

package pobj.micros.fs;

public class Node implements INode {
	
	private String name;
	
	@Override
	public String getName() { return name; }

	public Node(String name) {
		this.name = name;
	}
	
	public INode copy() { return new Node(name); }
}

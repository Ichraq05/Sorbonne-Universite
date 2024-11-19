package pobj.micros.fs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectoryNode extends Node implements IDirectoryNode{
	
	private Map<String,INode> dir = new HashMap<>();

	public DirectoryNode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean addChild(INode node) {
		// TODO Auto-generated method stub
		if(!(dir.containsKey(node.getName()))) {
			dir.put(node.getName(), node);
			return true;
		}
		return false;
	}

	@Override
	public INode getChild(String name) {
		// TODO Auto-generated method stub
		
		return dir.get(name);
	}

	@Override
	public List<String> getChildren() {
		// TODO Auto-generated method stub
		return new ArrayList<String>(dir.keySet());
	}
	
	

}

package pobj.micros.fs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DirectoryNode extends Node implements IDirectoryNode {

	private Map<String, INode> dir = new HashMap<>();
	
	public DirectoryNode(String name) {
		super(name);
	}
	
	@Override
	public List<String> getChildren() {
		return new LinkedList<String>(dir.keySet());
	}

	@Override
	public INode getChild(String name) {
		return dir.get(name);
	}

	@Override
	public boolean addChild(INode node) {
		if (dir.containsKey(node.getName())) return false;
		dir.put(node.getName(), node);
		return true;
	}
	
	@Override
	public IDirectoryNode copy() {
		DirectoryNode d = new DirectoryNode(getName());
		for (Map.Entry<String, INode> e : dir.entrySet()) {
			d.dir.put(e.getKey(), e.getValue().copy());
		}
		return d;
	}
}

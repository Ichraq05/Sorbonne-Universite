package pobj.micros.fs;

import java.util.List;

import pobj.micros.errors.OSError;

public class FileSystem implements IFileSystem {

	private IDirectoryNode root = new DirectoryNode("root");
	
	IDirectoryNode getRoot() {
		return root;
	}
	
	@Override
	public List<String> listDirectory(String path) throws OSError {
		return NodeUtils.findDirectory(getRoot(), path).getChildren();
	}

	@Override
	public void createDirectory(String path, String name) throws OSError {
		IDirectoryNode cur = NodeUtils.findDirectory(getRoot(), path);
		if (cur.getChild(name) != null)
			throw new OSError("invalid directory");
		cur.addChild(new DirectoryNode(name));
	}

	@Override
	public IFileNode openFile(String path,String name, int createSize) throws OSError {
		IDirectoryNode cur = NodeUtils.findDirectory(getRoot(), path);
		INode i = cur.getChild(name);
		if (i!=null) {
			if (!(i instanceof IFileNode))
				throw new OSError("invalid file");
			return (IFileNode) i;
		}
		else {
			IFileNode node = new FileNode(name, createSize);
			cur.addChild(node);
			return node;
		}
	}
	
}

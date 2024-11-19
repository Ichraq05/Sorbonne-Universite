package pobj.micros.fs;

import pobj.micros.errors.OSError;

public class NodeUtils {
	
	public static IDirectoryNode findDirectory(IDirectoryNode root, String path) throws OSError {
		IDirectoryNode cur = root;
		String[] p = path.split("/");
		for (int i = 0; i < p.length; i++) {
			if (p[i].equals("")) continue;
			INode n = cur.getChild(p[i]);
			if (n == null || !(n instanceof IDirectoryNode))
				throw new OSError("invalid path");
			cur = (IDirectoryNode) n;
		}
		return cur;		
	}
}

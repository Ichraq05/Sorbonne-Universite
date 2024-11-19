package pobj.micros.fs;

public class FileNode extends Node implements IFileNode {

	private byte[] data;
	
	public FileNode(String name, int length) {
		super(name);
		data = new byte[length];
	}
	
	@Override
	public int size() {
		return data.length;
	}

	@Override
	public int read(int pos) {
		if (pos >= 0  && pos < data.length) return data[pos];
		return 255;
	}

	@Override
	public void write(int pos, int c) {
		if (pos >= 0 && pos < data.length)
			data[pos] = (byte)c;
	}
	
	@Override
	public IFileNode copy() {
		FileNode n = new FileNode(getName(), data.length);
		for (int i = 0 ; i < data.length; i++)
			n.data[i] = data[i];
		return n;
	}

}

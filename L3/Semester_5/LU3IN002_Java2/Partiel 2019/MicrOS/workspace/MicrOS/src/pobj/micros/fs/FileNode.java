package pobj.micros.fs;

public class FileNode extends Node implements IFileNode {
	
	private byte[] data;
	
	
	public FileNode(String name, int size) {
		super(name);
		data = new byte[size];
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int read(int pos) {
		// TODO Auto-generated method stub
		if (pos >= 0  && pos < data.length) { 
			return data[pos];
		}
		return 255;
	}

	@Override
	public void write(int pos, int c) {
		// TODO Auto-generated method stub
		if (pos >= 0  && pos < data.length) { 
			data[pos] = (byte)c;
		}
	}

}

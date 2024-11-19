package pobj.micros.fs;

public class FileStream implements IStream {
	private int pos;
	private IFileNode data;
	
	public FileStream(IFileNode data) {
		this.data = data;
	}
	
	@Override
	public int read() {
		// TODO Auto-generated method stub
		return data.read(pos++);
	}

	@Override
	public void write(int c) {
		// TODO Auto-generated method stub
		data.write(pos++, c);
		
	}

	@Override
	public void seek(int pos) {
		// TODO Auto-generated method stub
		this.pos = pos;
		
	}

	@Override
	public int tell() {
		// TODO Auto-generated method stub
		return pos;
	}
	
}

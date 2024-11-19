package pobj.micros.fs;

public class FileStream implements IStream {

	private IFileNode data;
	private int pos;

	public FileStream(IFileNode data) {
		this.data = data;
	}
	
	@Override
	public int read() {
		if (pos >= data.size()) return 255;
		return data.read(pos++);
	}

	@Override
	public void write(int c) {
		if (pos < data.size()) {
			data.write(pos++,  c);
		}
	}

	@Override
	public void seek(int pos) {
		this.pos = pos;
	}

	@Override
	public int tell() {
		return pos;
	}

}

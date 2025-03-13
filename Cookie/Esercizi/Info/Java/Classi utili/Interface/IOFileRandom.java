import java.io.IOException;
import java.io.RandomAccessFile;

public interface IOFileRandom {
    public void write(RandomAccessFile raf) throws IOException;
    public void read(RandomAccessFile raf) throws IOException ;
}

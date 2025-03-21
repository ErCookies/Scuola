import java.io.IOException;
import java.io.RandomAccessFile;

public interface IOFileRandom {
    void write(RandomAccessFile raf) throws IOException;
    void read(RandomAccessFile raf) throws IOException ;
}

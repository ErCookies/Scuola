import java.io.IOException;
import java.io.RandomAccessFile;

/// Interfaccia che gestisce interazioni con un Random Access File
public interface IOFileRandom {
    /// Scrittura dell'oggetto su Random Access File raf
    /// @param raf Random Access File su cui scrivere
    /// @throws IOException Errore durante le operazioni di IO
    void write(RandomAccessFile raf) throws IOException;

    /// Lettura dell'oggetto da Random Access File raf
    /// @param raf Random Access File da cui leggere
    /// @throws IOException Errore durante le operazioni di IO
    void read(RandomAccessFile raf) throws IOException ;
}

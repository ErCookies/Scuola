/// Interface che gestisce Stringhe in formato CSV
public interface FileCSV {
    /// Scrive l'oggetto come Stringa in formato CSV
    /// @return Stringa in formato CSV
    String toCSV();

    /// Imposta gli attributi dell'oggetto da una Stringa s in formato CSV
    /// @param s Stringa in formato CSV
    void fromCSV(String s);
}

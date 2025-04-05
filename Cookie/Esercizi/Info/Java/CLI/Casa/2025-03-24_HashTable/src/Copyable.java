/// Interfaccia che fornisce un metodo di copia di un oggetto di classe E
/// @param <E> Classe dell'oggetto da copiare
public interface Copyable<E> {
    /// Metodo che restituisce una copia dell'oggetto che lo richiama
    /// @return Copia dell'oggetto di classe E
    E copy();
}

/*
    Caricare un elenco di figure geometriche a partire da un file csv (da descrivere). Ogni riga del file conterrà i dati o di un
    quadrilatero o di un triangolo (in base al valore di un item). Al termine del caricamento il programma stamperà il perimetro di
    ogni figura importata (polimorfismo!!).
    Classe Gestore: aggiunta di due metodi importazione ed esportazione di fugure geometriche.
    Interface FileCsv: da scrivere (metodi toCsv e fromCsv)
    Classe Figura: deve implementare l'interface FileCsv.
*/

public class Main {
    public static void main(String[] args) {
        Gestore g = new Gestore();
        String nF = Input.lgStr("Inserire nome file: ");
        g.importa(nF);
        System.out.println(g.elencoPer());
    }
}
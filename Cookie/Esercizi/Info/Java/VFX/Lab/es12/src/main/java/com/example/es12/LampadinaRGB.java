/*
    Scrivi il codice della classe Lampadina RGB. Una lampadina possiede un nome, si trova in uno stato
    (on/off), possiede un livello di luminosità (da 1 a 5) e una componente RGB.
    I metodi che si chiede di realizzare sono:
        - costruttore che riceve come parametro il nome della lampadina e crea
          una lampadina spenta, con luminosità 1 e coi i seguenti valori RGB (255, 255, 255);
        - accendi: accende una lampadina spenta. Imposta come valori RGB (252, 255, 202);
        - spegni: spenge una lampadina accesa;
        - SetLum: imposta la luminosità della lampadina con il valore passato come parametro
        - setRGB: ha come parametri 3 valori RGB con cui verrà impostata la componente RGB
          della lampadina
        - toCSV
        - FromCSV
*/
package com.example.es12;

import java.util.StringTokenizer;

public class LampadinaRGB implements FileCSV {
    private String name;
    private boolean stateON;
    private int lum, r, g, b;

    /// GETTER
    public String getName(){
        return this.name;
    }
    public boolean isStateON(){
        return this.stateON;
    }
    public int getLum(){
        return this.lum;
    }
    public int getR(){
        return this.r;
    }
    public int getG(){
        return this.g;
    }
    public int getB(){
        return this.b;
    }

    /// SETTER
    public void setName(String name) {
        if (name != null) {
            if (!name.isEmpty())
                this.name = name;
            else
                throw new IllegalArgumentException("Errore: stringa vuota");
        } else
            throw new NullPointerException("Puntatore a null non consentito");
    }
    public void changeState(){
        this.stateON = !this.stateON;
    }
    private void setStateON(boolean b){
        this.stateON = b;
    }
    public void setLum(int lum){
        if(lum >= 1 && lum <=5)
            this.lum = lum;
        else
            throw new IllegalArgumentException("Luminosita' non valida");
    }
    private void setR(int r){
        if(r >=0 && r <=255)
            this.r = r;
        else
            throw new IllegalArgumentException("Valore R non valido");
    }
    private void setG(int g){
        if(g >=0 && g <=255)
            this.g = g;
        else
            throw new IllegalArgumentException("Valore G non valido");
    }
    private void setB(int b){
        if(b >=0 && b <=255)
            this.b = b;
        else
            throw new IllegalArgumentException("Valore B non valido");
    }

    /// COSTRUTTORE
    public LampadinaRGB(String name) throws IllegalArgumentException, NullPointerException{
        this.setName(name);
        this.stateON = false;
        this.setLum(1);
        this.setRGB(252, 255, 202);
    }

    /// METODI
    public void setRGB(int r, int g, int b) throws IllegalArgumentException{
        this.setR(r);
        this.setG(g);
        this.setB(b);
    }
    public void accendi(){
        if(this.isStateON())
            throw new IllegalStateException("Lampadina gia' accesa");
        else{
            this.changeState();
        }
    }
    public void spegni(){
        if(this.isStateON()){
            this.changeState();
        }
        else
            throw new IllegalStateException("Lampadina gia' spenta");
    }

    /// METODI INTERFACE FILECSV
    public String toCSV(){
        String s = "";
        s = s.concat(getName() + ";");
        s = s.concat(isStateON() + ";");
        s = s.concat(getLum() + ";");
        s = s.concat(getR() + ";" + getG() + ";" + getB() + ";\n");
        return s;
    }
    public void fromCSV(String s){
        StringTokenizer toks = new StringTokenizer(s, ";");
        try {
            setName(toks.nextToken());
            setStateON(Boolean.parseBoolean(toks.nextToken()));
            setLum(Integer.parseInt(toks.nextToken()));
            setRGB(Integer.parseInt(toks.nextToken()), Integer.parseInt(toks.nextToken()), Integer.parseInt(toks.nextToken()));
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}

public class Cafe {
    //Atributos
    private String nombre;
    private int gCafe;
    private int gLeche;
    private int gCacaco;
    //costructor
    public Cafe(String _nombre,int _gCafe,int _gLeche,int _gCacaco){
        this.nombre=_nombre;
        this.gCafe=_gCafe;
        this.gLeche=_gLeche;
        this.gCacaco=_gCacaco;
        
    }
    //metodos get
    public String getNombre() {
        return nombre;
    }
    public int getgCafe() {
        return gCafe;
    }
    public int getgLeche() {
        return gLeche;
    }
    public int getgCacaco() {
        return gCacaco;
    }
    
}//fin Cafe.java

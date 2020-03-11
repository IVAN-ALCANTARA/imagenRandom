package mx.edu.tesoem.isc.niaa.imagenrandom;

public class aleatorio {
    int Imagen;
    String aleatorio;
    int sonido;


    public aleatorio(int Imagen,String aleatorio, int sonido){
        this.Imagen = Imagen;
        this.aleatorio = aleatorio;
        this.sonido = sonido;
    }

    public int getImagen() { return Imagen; }

    public String getAleatorio() { return aleatorio; }

    public int getSonido() {
        return sonido;
    }
}

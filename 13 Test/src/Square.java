
/*
Questa è la classe di esempio che viene descritta nel README.MD 
*/
public class Square {
    private double lato;

    public Square(double lato) {
        this.lato = lato;
    }

    double getLato(){
        return this.lato;
    }

    double getPerimetro() {
        return this.lato * 4;
    }

    double getArea() {
        return this.lato * this.lato;
    }
}

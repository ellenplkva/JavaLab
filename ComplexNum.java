import java.util.Scanner;
import java.lang.Math;

public class ComplexNum {
    private double valid,imag;

    public ComplexNum(double valid,double imag) {
        this.valid = valid;
        this.imag = imag;
    }

    public ComplexNum() {
        this.valid = 0;
        this.imag = 0;
    }

    public double getValid() {
        return valid;
    }

    public double getImag() {
        return imag;
    }

    public ComplexNum(ComplexNum anew) {
        this.valid = anew.valid;
        this.imag = anew.imag;
    }

    public ComplexNum SumComplexNum (ComplexNum anew) {
        var v = valid + anew.valid;
        var i = imag + anew.imag;
        return new ComplexNum(v,i);

    }

    public ComplexNum SubComplexNum (ComplexNum anew) {
        var v = valid - anew.valid;
        var i = imag - anew.imag;
        return new ComplexNum(v,i);

    }

    public ComplexNum MultiComplexNum (ComplexNum anew) {
        var v = valid * anew.valid - imag * anew.imag;
        var i = valid * anew.imag + imag * anew.valid;
        return new ComplexNum(v,i);

    }

    public ComplexNum DivComplexNum (ComplexNum anew) {
        var v = (valid * anew.valid + imag * anew.imag ) / (Math.pow(anew.valid,2)+ Math.pow(anew.imag,2));
        var i = (imag * anew.valid - valid * anew.imag) / (Math.pow(anew.valid,2)+ Math.pow(anew.imag,2));
        return new ComplexNum(v,i);

    }

    public String GetTrigForm (){
        double r = Math.sqrt(Math.pow(this.valid, 2) + Math.pow(this.imag, 2));
        if(r>0){
            double a = Math.atan(this.imag / this.valid)*180/Math.PI;
            return String.format("%.2f * ( cos( %.2f ) + i*( sin( %.2f ) )", r,a,a);
        }
        else
            return "0";
    }
    public String GetAlgForm() {
        return String.format("%.2f " + (imag == 0 ? "" : (imag < 0 ? "- " : "+ ") + "%.2f"), valid, imag < 0 ? imag * -1 : imag);
    }
    public void print() {
         if (imag > 0) {
                System.out.println(valid + " + " + imag + "i");
            }
            else if (imag < 0) {
                System.out.println(valid + " - " + Math.abs(imag) + "i");
            }
            else {
                System.out.println(valid);
            }
        }

}

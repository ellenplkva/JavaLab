public class Main {
  public static void main(String[] args) {
      var number1 = new ComplexNum(2, 1);
      var number2 = new ComplexNum(3, 4);


      number1.SumComplexNum(number2).print();
      number1.SubComplexNum(number2).print();
      number1.MultiComplexNum(number2).print();
      number1.DivComplexNum(number2).print();

      System.out.println("Тригонометрическая форма: " + number1.GetTrigForm());
      System.out.println("Алгебраическая форма: " + number1.GetAlgForm());
    
      Matrix data = new Matrix(2,2);


      data.print();
      data.set(1,1,number1);
      System.out.println("Матрица 1\n" );
      data.print();

  }
}

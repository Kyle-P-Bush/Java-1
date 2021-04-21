public class Fraction{
    private int numerator;
    private int denominator;

    //declare a contructor
    public Fraction(int numerator, int denominator){
        this.numerator = Math.abs(numerator);
        this.numerator *= (numerator* denominator >= 0) ? 1 : -1; //condensed conditional statement
        this.denominator = Math.abs(denominator);
    }

    public int getDenominator(){
        return this.denominator;
    }
    public int getNumerator(){
        return this.numerator;
    }

    // this -> (2/5) & other -> (3/7)
    public Fraction add(Fraction other){
        int numerator = this.getNumerator() * newFraction.getDenominator() + newFraction.getNumerator() * this.getDenominator();
        int denominator = this.getDenominator() * newFraction.getDenominator();

    }

    public Fraction simplify(Fraction other){
        for (int i = deonominator; i > 0; i--){
            if (numerator %i==0 && denominator %i == 0){
                numerator /=i;
                denominator /=i;
            }
        }
        return new Fraction(numerator, denominator); //creat a new objt with simplified numerator and a denominator
    }



}
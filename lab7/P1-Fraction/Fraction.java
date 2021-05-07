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
    public Fraction add(Fraction newFraction){
        int numerator = this.getNumerator() * newFraction.getDenominator() + newFraction.getNumerator() * this.getDenominator();
        int denominator = this.getDenominator() * newFraction.getDenominator();
        Fraction add = this.simplify(numerator, denominator);
        return add;
    }

    public Fraction subtract(Fraction newFraction){
        int numerator = this.getNumerator() * newFraction.getDenominator() - newFraction.getNumerator() *this.getDenominator();
        int denominator = this.getDenominator() * newFraction.getDenominator();
        Fraction difference = this.simplify(numerator, denominator);
        return difference;
    }

    public Fraction multiply(Fraction newFraction){
        int numerator = this.getNumerator() * newFraction.getNumerator();
        int denominator = this.getDenominator() * newFraction.getDenominator();
        Fraction product = this.simplify(numerator, denominator);
        return product;
    }

    public Fraction divide(Fraction newFraction){
        int numerator = this.getNumerator() * newFraction.getDenominator();
        int denominator = this.getDenominator() * newFraction.getNumerator();
        Fraction dividend = this.simplify(numerator, denominator);
        return dividend;
    }

    //example : numerator = 55 denominator = 75
    public Fraction simplify(int numerator, int denominator){
        for (int i = denominator; i > 0; i--){
            if (numerator %i==0 && denominator %i == 0){
                numerator /=i;
                denominator /=i;
            }
        }
        return new Fraction(numerator, denominator); //create a new objt with simplified numerator and a denominator
    }

    //fromat -> numerator / denominator

    @Override
    public String toString(){
        return String.format("(%d/%d)", numerator, denominator);
    }

}
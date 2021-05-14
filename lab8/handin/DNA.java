//P3 DNA
//Submitted bt Kyle Bush

public class DNA{
  
  private char[] sequence;
  public DNA(char[] seq){
    sequence=seq;
  }

  public char[] getSequence(){
     return sequence;
  }

  public DNA swap(DNA other, int swapPoint){
    String seq=toString().substring(0, swapPoint);
    seq+=other.toString().substring(swapPoint);
    return new DNA(seq.toCharArray());
  }

  public boolean equals(DNA other){
      if(sequence.length!=other.sequence.length)
      return false;
      for(int i=0; i<sequence.length; i++){
        if(sequence[i]!=other.sequence[i])
        return false;
      }
      return true;
  }

  public String toString(){
      String seq="";
      for(int i=0; i<sequence.length; i++)
      seq+=sequence[i];
      return seq;
  }
}


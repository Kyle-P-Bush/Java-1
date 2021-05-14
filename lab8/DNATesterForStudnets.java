public class DNATester{
    public static void main(String[] args){
        char[] seq1 = {'a', 't', 'c', 'g'};
        DNA first = new DNA(seq1);

        char[] seq2 = {'t', 'c', 'a', 'a'};
        DNA second = new DNA(seq2);

        System.out.println(first.equals(second));

        System.out.println(first);

        DNA third = first.swap(second, 2);

        System.out.println(third);
    }
}

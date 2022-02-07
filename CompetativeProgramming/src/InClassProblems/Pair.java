package InClassProblems;

public class Pair implements Comparable<Pair>{

    char firstValue;
    int secondValue;

    public Pair(char firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public char getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(char firstValue) {
        this.firstValue = firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }


//    private Long id;
//    private String name;
//    private LocalDate dob;
//
//    @Override
//    public int compareTo(Employee o)
//    {
//        return this.getId().compareTo( o.getId() );
//    }

    @Override
    public int compareTo(Pair p) {

        if (this.getSecondValue() > p.secondValue) {
            return 1;
        } else if ( this.getSecondValue() == p.secondValue) {
            return 0;
        } else {
            return -1;
        }

//        int a = this.getSecondValue();
//        int b = p.getSecondValue();
//
//        return a.compareTo(b);

        //return this.getSecondValue().compareTo( p.getSecondValue() );
        //return 0;
    }
}

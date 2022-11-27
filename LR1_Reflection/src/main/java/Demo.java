import lombok.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

@Getter
@EqualsAndHashCode
public class Demo {
    private int myInt;
    private final int myFinalInt;
    private float myNotInitFloat;
    public double myPublicDouble;
    private String myString;
    private List<Integer> myList;
    private Set<Integer> mySet;
    private Queue<Integer> myQueue;
    private BigDecimal myBigDecimal;

    {
        myInt= 5;
        myFinalInt = 55;
        myPublicDouble = 0.0d;
        myString = "ab";
        myList = null;
        mySet = null;
        myQueue = new PriorityQueue<>();
        myBigDecimal = new BigDecimal("100.001");
    }

    @Override
    public String toString() {
        return "-".repeat(5) +
                "\nmyInt: " +  myInt +
                "\nmyFinalInt: " + myFinalInt +
                "\nmyFloat: " + myNotInitFloat +
                "\nmyPublicDouble: " + myPublicDouble +
                "\nmyString: " + myString +
                "\nmyList: " + myList +
                "\nmySet: " + mySet +
                "\nmyQueue: " + myQueue +
                "\nmyBigDecimal: " + myBigDecimal +
                "\n" + "-".repeat(5) + "\n";
    }
}

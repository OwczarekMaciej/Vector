import java.util.List;
import java.util.Iterator;

public class Vector {

    private List<Integer> vectorValues;

    public Vector(List<Integer> vectorValues) {
        this.vectorValues = vectorValues;
    }

    public List<Integer> getValues() {
        return vectorValues;
    }

    public int getLength() {
        return this.vectorValues.size();
    }

    @Override
    public String toString() {
        Iterator<Integer> myIterator = vectorValues.iterator();
        String result = "";
        result += "[";
        while (myIterator.hasNext()) {
            result += String.valueOf(myIterator.next());
            if (myIterator.hasNext()) {
                result += ", ";
            }
        }

        result += "]";

        return result;
    }
}
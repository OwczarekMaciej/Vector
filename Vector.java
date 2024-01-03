import java.util.List;

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
}
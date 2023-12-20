import java.util.ArrayList;

public class DifferentVectorsLengthsException extends Exception {

    private ArrayList<Integer> vectorLengths;

    public DifferentVectorsLengthsException(String message, ArrayList<Integer> vectorLengths){
        super(message);
        this.vectorLengths = vectorLengths;
    }

    public ArrayList<Integer> getLengths(){
        return this.vectorLengths;
    }
}
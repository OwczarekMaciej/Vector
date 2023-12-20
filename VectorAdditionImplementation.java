import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VectorAdditionImplementation {
    public static void main(String[] args) {
        VectorAdditionImplementation vectorAdditionCalculator = new VectorAdditionImplementation();
        vectorAdditionCalculator.getVectorsAndCalculate();
    }

    public void getVectorsAndCalculate() {
        List<Vector> vectors;
        VectorUserInput vectorUserInput = new VectorUserInput();
        vectors = vectorUserInput.getVectorFromUser();
        try {
            List<Integer> summedVector = addVectors(vectors);
            writeResultToFile(summedVector, "result.txt");
        } catch (DifferentVectorsLengthsException e) {
            System.out.println(e.getMessage());
            System.out.println("Length of vectors: " + e.getLengths().toString());
            System.out.println("Re-enter vectors that you want to add.");
            getVectorsAndCalculate();
        } catch (IOException e) {
            System.out.println("Unable to save to file");
        }
    }

    public static ArrayList<Integer> getVectorsLenghts(List<Vector> vectors) {
        ArrayList<Integer> vectorlenghts = new ArrayList<>();
        Iterator<Vector> vectorItr = vectors.iterator();
        while (vectorItr.hasNext()) {
            vectorlenghts.add(vectorItr.next().getLength());
        }
        return vectorlenghts;
    }

    public static boolean areVectorsSameLenghts(List<Vector> vectors) throws DifferentVectorsLengthsException {
        int vectorLength = vectors.get(0).getLength();
        for (Vector vector : vectors) {
            if (vector.getLength() != vectorLength) {
                throw new DifferentVectorsLengthsException("Vectors have different lenghts",
                        getVectorsLenghts(vectors));
            }
        }
        return true;
    }

    public static List<Integer> addVectors(List<Vector> vectors) throws DifferentVectorsLengthsException {
        List<Integer> resultVector = new ArrayList<>();
        if (areVectorsSameLenghts(vectors)) {
            for (int i = 0; i < vectors.get(0).getLength(); i++) {
                int sum = 0;
                for (Vector vector : vectors) {
                    sum += vector.getValues().get(i);
                }
                resultVector.add(sum);
            }
        }
        return resultVector;
    }

    public static void writeResultToFile(List<Integer> finalVector, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        for (Integer value : finalVector) {
            writer.write(value + " ");
        }
        System.out.println("Vector saved to " + fileName + " file");
        writer.close();
    }
}

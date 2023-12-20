import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VectorUserInput {

    public List<Vector> getVectorFromUser() {
        List<Vector> correctVector = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter values of vector (separated by comma): ");
            String userInput = scanner.nextLine().trim();

            if (!userInput.isEmpty()) {
                String[] values = userInput.split(",");
                Vector vector = checkVectorValues(values);
                correctVector.add(vector);
            } else {
                break;
            }
        }
        return correctVector;
    }


    private Vector checkVectorValues(String[] stringUserVector) {
        List<Integer> correctValues = new ArrayList<>();
        for (String vectorValue : stringUserVector) {
            try {
                Integer correctValue = Integer.parseInt(vectorValue);
                correctValues.add(correctValue);
            } catch (Exception e) {
            }
        }
        return new Vector(correctValues);
    }
}

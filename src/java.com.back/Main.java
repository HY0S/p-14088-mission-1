import domain.Controller.CalcController;

public class Main {
    public static void main(String[] args) {
        CalcController controller = new CalcController();
        int result = controller.run();
        System.out.println(result);
    }
}

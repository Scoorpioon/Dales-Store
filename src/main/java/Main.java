import com.formdev.flatlaf.FlatLightLaf;
import view.FormPrincipal;

public class Main {
    static void main(String[] args) {
        FlatLightLaf.setup();

        FormPrincipal desk = new FormPrincipal();
        desk.setVisible(true);
    }
}
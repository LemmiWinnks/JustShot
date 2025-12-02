package Gui;

public class Main {
    Window window;
    Rocket rocket;

    public Main() {
        window = new Window();
        /* a janela JFrame que deve ter os add dos container, e não no metodo main */
        rocket = new Rocket();

        window.addContent(rocket);
        window.showElements();
    }

   static void main() {
        new Main();
    }
}


/**
 * RaymarcherRunner is the driver class where all JPanels and components
 * are initialized and instantiated.
 */
public class RaymarcherRunner extends SwingApplication {

    /**
     * Width of the JFrame.
     */
    private static final int WIDTH = 1280;

    /**
     * Height of the JFrame.
     */
    private static final int HEIGHT = 640;

    /**
     * The frames-per-second that we want this application to achieve.
     */
    private static final int TARGET_FPS = 900;

    /**
     * Title of the JFrame.
     */
    private static final String TITLE = "Raymarcher";

    public RaymarcherRunner(int width, int height, int fps, String title) {
        super(width, height, fps, title);

        // Now, instantiate and add the raymarcher panels.
        RaymarcherPanel raymarcherPanel = new RaymarcherPanel(this);
        this.addComponent(raymarcherPanel);
        this.packComponents();
        this.setVisible(true);
    }

    @Override
    public void run() {
    }

    public static void main(String[] args) {
        RaymarcherRunner runner = new RaymarcherRunner(WIDTH, HEIGHT, TARGET_FPS, TITLE);
        runner.run();
    }
}

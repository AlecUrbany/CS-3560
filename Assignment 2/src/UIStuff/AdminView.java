import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


public class TwitterFrame extends JFrame 
{
    public final int SCREEN_WIDTH = 640;

    public final int SCREEN_HEIGHT = 480;

    public final Color BACKGROUND_COLOR = Color.WHITE;

    public final String DEFAULT_FONT_NAME = "Impact";

    public final Dimension BIG_PANEL_DIMENSION = new Dimension(SCREEN_WIDTH/100, 50*SCREEN_HEIGHT/100);

    public final Dimension SMALL_PANEL_DIMENSION = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT/15);

    public TwitterFrame(String title)
    {
        super(title);
    }


    public TitledBorder createBorderTitle(String title, Color color)
    {
        return BorderFactory.createBorderTitle(
                                    BorderFactory.createLineBorder(color, 5), 
                                    title, 0, 0,
                                    new Font(DEFAULT_FONT_NAME, 0, 12));
    }


    public String getTypedText(JTextField idTextField)
    {
        String typedText = idTextField.getText();
        idTextField.setText("");

        return typedText;
    }     
}
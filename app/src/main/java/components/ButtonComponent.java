package components;

import game.androidgame2.Vector2;

/**
 * Created by eric on 11/3/14.
 */
public class ButtonComponent extends Component {
    public String name;
    public int position = 0;
    public String texture;

    public Vector2 size = new Vector2(0.1, 0.1);

    public ButtonComponent(String name) {
        this.name = name;
    }
}
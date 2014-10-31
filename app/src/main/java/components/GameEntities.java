package components;

import java.util.ArrayList;

/**
 * Created by eric on 10/30/14.
 */
public class GameEntities {

    /**
     * Construct an entity representing a troop
     * @param owner For example, Engine.TAG_PLAYER_OWNED
     * @param leader For example, Engine.TAG_LEADER
     * @return
     */
    public static Entity buildTroop(int owner, int leader) {
        Entity troop = new Entity();
        PositionComponent positionComponent = new PositionComponent();
        troop.data.put(PositionComponent.class, positionComponent);

        troop.getComponentLabeler().getLabels().add(Engine.LOGIC_TROOP_DRAW);

        troop.getTagLabeler().getLabels().add(owner);
        troop.getTagLabeler().getLabels().add(leader);

        return troop;
    }
}

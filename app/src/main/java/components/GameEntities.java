package components;

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
        troop.cData.put(PositionComponent.class, positionComponent);

        SelectionComponent selectionComponent = new SelectionComponent();
        troop.cData.put(SelectionComponent.class, selectionComponent);

        troop.getLabels().add(Entity.LOGIC_UNIT_DRAW);
        troop.getLabels().add(Entity.LOGIC_SELECTION);

        troop.getLabels().add(owner);
        troop.getLabels().add(leader);
        troop.getLabels().add(Entity.TAG_TROOP_TYPE);

        return troop;
    }

    public static Entity buildCamera() {
        Entity camera = new Entity();
        CameraSettingsComponent csm = new CameraSettingsComponent();

        camera.cData.put(CameraSettingsComponent.class, csm);

        camera.getLabels().add(Entity.LOGIC_CAMERA);

        return camera;
    }
}

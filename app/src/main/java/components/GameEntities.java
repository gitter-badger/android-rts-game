package components;

import game.androidgame2.DrawList2DItem;

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
        WorldComponent worldComponent = new WorldComponent();
        troop.cData.put(WorldComponent.class, worldComponent);

        SelectionComponent selectionComponent = new SelectionComponent();
        troop.cData.put(SelectionComponent.class, selectionComponent);
        troop.getLabels().add(Entity.NODE_SELECTION);

        DestinationComponent destinationComponent = new DestinationComponent();
        troop.cData.put(DestinationComponent.class, destinationComponent);
        troop.getLabels().add(Entity.NODE_MOVE_TOWARD_DESTINATION);

        troop.getLabels().add(Entity.NODE_TROOP_DRAWER);

        troop.getLabels().add(owner);
        troop.getLabels().add(leader);

        troop.getLabels().add(Entity.UNIT_TROOP);

        AbilityComponent ac = new AbilityComponent();
        ac.abilities.add(Abilities.SPECIAL_ATTACK);
        troop.cData.put(AbilityComponent.class, ac);

        PlayerComponent pc = new PlayerComponent();
        pc.name = "Player" + owner;
        troop.cData.put(PlayerComponent.class, pc);

        return troop;
    }

    public static Entity buildAttackButton() {
        Entity button = new Entity();

        ButtonComponent bc = new ButtonComponent(Buttons.S_ATTACK);
        bc.position = 0;
        bc.texture = DrawList2DItem.ANIMATION_BUTTONS_ATTACK;
        bc.size.y = 0.6f;

        button.cData.put(ButtonComponent.class, bc);

        button.getLabels().add(Entity.UI_BUTTON);

        return button;
    }

    public static Entity buildDefendButton() {
        Entity button = new Entity();

        ButtonComponent bc = new ButtonComponent(Buttons.DEFEND);
        bc.position = 1;
        bc.texture = DrawList2DItem.ANIMATION_BUTTONS_DEFEND;
        bc.size.y = 0.6f;

        button.cData.put(ButtonComponent.class, bc);

        button.getLabels().add(Entity.UI_BUTTON);

        return button;
    }

}

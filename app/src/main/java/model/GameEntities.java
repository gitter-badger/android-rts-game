package model;

import structure.DrawList2DItem;
import utils.MemoryPool;

/**
 * Created by eric on 10/30/14.
 */
public class GameEntities {

    public static MemoryPool<Entity> troopsMemoryPool = new MemoryPool<Entity>(Entity.class, 1024);

    /**
     * Construct an entity representing a troop
     * @return
     */
    public static Entity buildTroop() {

        //Entity troop = new Entity();
        Entity troop = troopsMemoryPool.fetchMemory();
        troop.getLabels().add(Entity.UNIT_TROOP);
//
//        PlayerComponent pc = new PlayerComponent();
//        pc.name = "default";
//        pc.team = team;
//        troop.cData.put(PlayerComponent.class, pc);

        WorldComponent worldComponent = new WorldComponent();
        troop.cData.put(WorldComponent.class, worldComponent);

        SelectionComponent selectionComponent = new SelectionComponent();
        troop.cData.put(SelectionComponent.class, selectionComponent);
        troop.getLabels().add(Entity.NODE_SELECTION);

        DestinationComponent destinationComponent = new DestinationComponent();
        troop.cData.put(DestinationComponent.class, destinationComponent);
        troop.getLabels().add(Entity.NODE_MOVE_TOWARD_DESTINATION);

        troop.getLabels().add(Entity.NODE_TROOP_DRAWER);

        AbilityComponent ac = new AbilityComponent();
        ac.abilities.add(Abilities.SPECIAL_ATTACK);
        troop.cData.put(AbilityComponent.class, ac);

        LivingComponent lc = new LivingComponent();
        troop.cData.put(LivingComponent.class, lc);
//
//        troop.getLabels().add(team);
//        troop.getLabels().add(leader);

        return troop;
    }

    public static void recycleTroop(Entity toRecycle) {
        troopsMemoryPool.recycleMemory(toRecycle);
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

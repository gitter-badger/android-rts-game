package components;

/**
 * Created by eric on 10/30/14.
 */
public class Engine {

    /**
     * Entities organized by logic-y stuff
     */
    public DenormalizedDataSet entitiesByComponents;

    /**
     * Entities organized by metadata and category-ish stuff, like troops, tanks, player type
     */
    public DenormalizedDataSet entitiesByTags;

    public Engine() {
        entitiesByComponents = new DenormalizedDataSet(16, 300);
        entitiesByTags = new DenormalizedDataSet(16, 300);
    }

    public void addEntity(Entity entity) {
        entitiesByComponents.addDenormalizable(entity.getComponentLabeler());
        entitiesByTags.addDenormalizable(entity.getTagLabeler());
    }

    public void removeEntity(Entity entity) {
        entitiesByComponents.removeDenormalizable(entity.getComponentLabeler());
        entitiesByTags.removeDenormalizable(entity.getTagLabeler());
    }
}

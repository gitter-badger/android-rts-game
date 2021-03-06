package processors;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import model.LivingComponent;
import model.Player;
import model.WorldComponent;
import model.SelectionComponent;
import structure.DrawList2DItem;
import structure.GamePool;
import structure.RewriteOnlyArray;

import model.Entity;
import structure.TemporaryDrawList2DItem;

/**
 * Created by eric on 11/3/14.
 */
public class TroopDrawerProcess {
    public static final void process(RewriteOnlyArray<DrawList2DItem> spriteAllocater,
                                     List<TemporaryDrawList2DItem> tempSprites,
                                     GamePool gamePool,
                                     Player player,
                                     double dt) {
        ArrayList<Entity> troopsToDraw = player.denorms.getListForLabel(Entity.NODE_TROOP_DRAWER);

        for (int i = 0; i < troopsToDraw.size(); i++) {
            Entity entity = troopsToDraw.get(i);
            WorldComponent wc = (WorldComponent)entity.cData.get(WorldComponent.class);
            LivingComponent lc = (LivingComponent)entity.cData.get(LivingComponent.class);

            DrawList2DItem drawItem = spriteAllocater.takeNextWritable();

            drawItem.animationName = DrawList2DItem.ANIMATION_TROOPS_IDLING;
            if (lc.hitPoints <= 0) {
                drawItem.color = Player.colorForTeam(4);
                TemporaryDrawList2DItem tempSprite = gamePool.temporaryDrawItems.fetchMemory();
                tempSprite.color = Color.argb(240, 255, 255, 255);
                tempSprite.progress.progress = 0;
                tempSprite.angle = 90;
                tempSprite.animationName = DrawList2DItem.ANIMATION_TROOPS_DYING;
                tempSprite.width = 1;
                tempSprite.height = 1;
                tempSprite.position.x = wc.pos.x;
                tempSprite.position.y = wc.pos.y;
                tempSprites.add(tempSprite);
            }
            else {
                drawItem.color = player.color();
            }
            drawItem.position.x = wc.pos.x;
            drawItem.position.y = wc.pos.y;
            drawItem.angle = (float)wc.rot.getDegrees();
            drawItem.width = 1.0f;
            drawItem.height = 1.0f;

            SelectionComponent sc = (SelectionComponent)entity.cData.get(SelectionComponent.class);

            if (sc.isSelected) {
                drawItem = spriteAllocater.takeNextWritable();
                drawItem.animationName = DrawList2DItem.ANIMATION_TROOPS_SELECTED;
                drawItem.color = player.color();
                drawItem.position.x = wc.pos.x;
                drawItem.position.y = wc.pos.y;
                drawItem.angle = (float)wc.rot.getDegrees();
                drawItem.width = 1.3f;
                drawItem.height = 1.3f;
            }
        }

    }
}

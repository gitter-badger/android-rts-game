package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by eric on 11/6/14.
 */
public class EngineLoader {

    public static boolean load(Engine engine, String mainPlayerName, String json) throws JSONException {

        JSONObject jObj = new JSONObject(json);

        engine.gameTime = jObj.getDouble("time");

        JSONArray playersArr = jObj.getJSONArray("players");

        for (int jp = 0; jp < playersArr.length(); jp++) {

            JSONObject jPlayerObj = playersArr.getJSONObject(jp);

            Player player = new Player(jPlayerObj.getString("name"));
            player.team = jPlayerObj.getInt("team");

            engine.addPlayer(player);

            if (player.name.equals(mainPlayerName)) {
                engine.currentPlayer = player;
            } else {
                // Allied or enemy team
            }

            JSONArray troopArr = jPlayerObj.getJSONArray("troop");

            for (int i = 0; i < troopArr.length(); i++) {
                JSONObject jEntity = troopArr.getJSONObject(i);

                Entity troop = GameEntities.buildTroop();

                WorldComponent pc =
                        ((WorldComponent) troop.cData.get(WorldComponent.class));
                pc.set(jEntity.getDouble("x"), jEntity.getDouble("y"));

                player.denorms.addDenormalizable(troop);
            }
        }

        return true;
    }
}

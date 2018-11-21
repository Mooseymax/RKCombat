import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.api.ui.Message;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.lang.reflect.Array;

@ScriptManifest(author = "OSRunekeep", name = "RK Combat", info = "Simple Combat", version = 0.1, logo = "")

public final class CombatMain extends Script {
    int loopNumber = 0;
    RS2Object currentTree;

    private void treeArea(RS2Object tree){
        tree.getModel().getBoundingBox(tree.getGridX(), tree.getGridY(),myPlayer().getZ());
    }

    @Override
    public final void onStart(){
        log("Welcome!");
        currentTree = getObjects().closest("Tree");
    }

    @Override
    public final int onLoop() throws InterruptedException {
        currentTree = getObjects().closest("Tree");
        log("Loop: " + loopNumber);
        loopNumber ++;
        return 100;
    }

    @Override
    public final void onExit() {
        log("Goodbye!");
    }

    @Override
    public void onMessage(Message message) throws InterruptedException {

    }

    @Override
    public void onPaint(final Graphics2D g) {
        double a = 0.5;
        double b = 0.25;

        Rectangle i = currentTree.getModel().getBoundingBox(currentTree.getGridX(), currentTree.getGridY(),myPlayer().getZ());
        Rectangle m = new Rectangle(i.x + (((int) (i.width * a))/2), i.y + (((int) (i.height * a))/2), (int) (i.width * a), (int) (i.height * a));
        Rectangle o = new Rectangle(i.x + (((int) (i.width * b))/2), i.y + (((int) (i.height * b))/2), (int) (i.width * b), (int) (i.height * b));

        g.setColor(new Color(100,0,0,50));
        g.fill(i);
        g.setColor(new Color(0,0,100,100));
        g.fill(m);
        g.setColor(new Color(0,100,0,150));
        g.fill(o);
    }

}

package View;

import World.World;

public class GraphicThread extends Thread{
    private World world;
    public GraphicThread(World world){
        this.world = world;
    }
    @Override
    public void run() {
        Graphics.run(world);
    }
}

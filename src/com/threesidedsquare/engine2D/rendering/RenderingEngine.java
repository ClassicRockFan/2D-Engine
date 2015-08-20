package com.threesidedsquare.engine2D.rendering;

import com.threesidedsquare.engine2D.object.GameObject;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

public class RenderingEngine {
    private GameCamera camera;

    public static void initGL(){
        glDisable(GL_DEPTH_TEST);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_DST_ALPHA);

    }

    public void render(ArrayList<GameObject> objects) {
        glClearColor(0, 0, 0, 1);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        if(camera != null)
            camera.tranformView();

//        Logging.printLog("Num Objects to Render - " + objects.size());

        for(GameObject object : objects) {
            object.render();
            //Logging.printLog("Rendering object - " + object.toString());
        }

        Window.update();
    }

    public static ArrayList<GameObject> sortByRenderLayer(ArrayList<GameObject> objects){
        ArrayList<GameObject> result = new ArrayList<>();
//        Logging.printLog("Objects.size() - " + objects.size());

        for(int i = 0; i < objects.size(); i++){
//            Logging.printLog("I = " + i);
            if(i == 0)
                result.add(objects.get(i));
            else{
//                Logging.printLog("Testing - " + i);
                for(int j = 0; j < result.size(); j ++){
//                    Logging.printLog("Checking - " + j);

                    float activeZ = objects.get(i).getTransform().getPosition().getZ();
                    float otherZ = result.get(j).getTransform().getPosition().getZ();

//                    Logging.printLog("ActiveZ = " + activeZ);
//                    Logging.printLog("OtherZ = " + otherZ);

                    if(activeZ > otherZ){
                        result.add(j, objects.get(i));
                        //Logging.printLog("Adding to location - " + j);
                        break;
                    }
                }

                result.add(objects.get(i));
            }

        }

        return  result;
    }

    public GameCamera getCamera() {
        return camera;
    }

    public void setCamera(GameCamera camera) {
        this.camera = camera;
        this.camera.useView();
    }
}

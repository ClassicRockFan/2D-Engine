package com.threesidedsquare.engine2D.object;

import com.threesidedsquare.engine2D.object.component.rendering.QuadRenderTexture;
import com.threesidedsquare.engine2D.rendering.TextureSheet;
import com.threesidedsquare.engine2D.rendering.Texture;

import java.util.ArrayList;

public class TextRender extends GameObject{

    private Texture texture;
    private String text;
    private float spacing;
    private float scale;

    private TextureSheet sheet;

    public TextRender(String text, float spacing, float scale){
        this("simpleFont.png", text, spacing, scale);
    }

    private TextRender(String path, String text, float spacing, float scale){
        this(new Texture(path), text, spacing, scale);
    }

    private TextRender(Texture texture, String text, float spacing, float scale) {
        this.texture = texture;
        this.text = text;
        this.sheet = new TextureSheet(texture.getPath(), 13, 3, 1, scale);
        this.spacing = spacing;
        this.scale = scale;
        load();
    }

    private void load(){
        ArrayList<String> chars = new ArrayList<>();

        float activeX = 0;
        float activeY = 0;
        float charWidth = (texture.getWidth()/13) * scale;
        float charHeight = (texture.getHeight()/3) * scale;
        charWidth += 12;
        charHeight += 12;
        String upperText = text.toUpperCase();

        for(int i = 0; i < upperText.length(); i++){
            chars.add(String.valueOf(upperText.charAt(i)));
        }

        for(String character : chars){
            if(character.equals("A")){
                float[] coords = sheet.generateTexCoords(0, 2, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("B")){
                float[] coords = sheet.generateTexCoords(1, 2, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("C")){
                float[] coords = sheet.generateTexCoords(2, 2, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("D")){
                float[] coords = sheet.generateTexCoords(3, 2, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("E")){
                float[] coords = sheet.generateTexCoords(4, 2, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("F")){
                float[] coords = sheet.generateTexCoords(5, 2, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("G")){
                float[] coords = sheet.generateTexCoords(6, 2, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("H")){
                float[] coords = sheet.generateTexCoords(7, 2, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("I")){
                float[] coords = sheet.generateTexCoords(8, 2, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("J")){
                float[] coords = sheet.generateTexCoords(9, 2, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("K")){
                float[] coords = sheet.generateTexCoords(10, 2, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("L")){
                float[] coords = sheet.generateTexCoords(11, 2, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("M")){
                float[] coords = sheet.generateTexCoords(12, 2, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("N")){
                float[] coords = sheet.generateTexCoords(0, 1, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("O")){
                float[] coords = sheet.generateTexCoords(1, 1, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("P")){
                float[] coords = sheet.generateTexCoords(2, 1, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("Q")){
                float[] coords = sheet.generateTexCoords(3, 1, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("R")){
                float[] coords = sheet.generateTexCoords(4, 1, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("S")){
                float[] coords = sheet.generateTexCoords(5, 1, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("T")){
                float[] coords = sheet.generateTexCoords(6, 1, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("U")){
                float[] coords = sheet.generateTexCoords(7, 1, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("V")){
                float[] coords = sheet.generateTexCoords(8, 1, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("W")){
                float[] coords = sheet.generateTexCoords(9, 1, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("X")){
                float[] coords = sheet.generateTexCoords(10, 1, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("Y")){
                float[] coords = sheet.generateTexCoords(11, 1, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }else if(character.equals("Z")){
                float[] coords = sheet.generateTexCoords(12, 1, true, true, true, true);
                addComponent(new QuadRenderTexture(activeX, activeY, activeX + charWidth, activeY + charHeight, coords[0], coords[1], coords[2], coords[3], texture));
            }

            activeX += (charWidth + spacing);
        }
    }

    @Override
    public void render() {

        super.render();
    }
}

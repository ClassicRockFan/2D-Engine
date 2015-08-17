package com.threesidedsquare.engine2D.core;


import org.lwjgl.BufferUtils;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

public class Util {

    public static FloatBuffer createFloatBuffer(int size) {
        return BufferUtils.createFloatBuffer(size);
    }

    public static IntBuffer createIntBuffer(int size) {
        return BufferUtils.createIntBuffer(size);
    }

    public static ByteBuffer createByteBuffer(int size) {
        return BufferUtils.createByteBuffer(size);
    }

    public static IntBuffer createFlippedBuffer(int... values) {
        IntBuffer buffer = createIntBuffer(values.length);
        buffer.put(values);
        buffer.flip();

        return buffer;
    }


    public static ByteBuffer charToByteBuffer(char[] data){

        return null;
    }

    public static String[] removeEmptyStrings(String[] data) {

        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < data.length; i++) {
            if (!data[i].equals("")) {
                result.add(data[i]);
            }
        }

        String[] res = new String[result.size()];
        result.toArray(res);

        return res;
    }

    public static int[] toIntArray(Integer[] data) {

        int[] result = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            result[i] = data[i].intValue();
        }

        return result;
    }

}

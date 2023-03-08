package org.sfml_dev.window;

import java.util.*;

import static org.sfml_dev.system.sys.new_.*;
import static org.sfml_dev.system.sys.vector.*;
import static org.sfml_dev.window.sys.SFML_Window.*;

public class VideoMode implements Comparable<VideoMode> {

    public int width;
    public int height;
    public int bitsPerPixel;
    
    public VideoMode() {
        this.width = 0;
        this.height = 0;
        this.bitsPerPixel = 0;
    }

    public VideoMode(int modeWidth, int modeHeight) {
        this(modeWidth, modeHeight, 32);
    }

    public VideoMode(int modeWidth, int modeHeight, int modeBitsPerPixel) {
        this.width = modeWidth;
        this.height = modeHeight;
        this.bitsPerPixel = modeBitsPerPixel;
    }

    public static VideoMode getDesktopMode() {
        long videoMode = operator_new(sf_VideoMode_sizeof);
        sf_VideoMode_getDesktopMode(videoMode);
        VideoMode ret = new VideoMode(
            sf_VideoMode_getWidth(videoMode),
            sf_VideoMode_getHeight(videoMode),
            sf_VideoMode_getBitsPerPixel(videoMode)
        );
        operator_delete(videoMode);
        return ret;
    }

    private static List<VideoMode> modes;

    public static List<VideoMode> getFullscreenModes() {
        // Populate the array on first call
        if (modes == null) {
            long cppModes = sf_VideoMode_getFullscreenModes();
            long begin = std_vector_sf_VideoMode_begin(cppModes);
            long end = std_vector_sf_VideoMode_end(cppModes);
            VideoMode[] modesArray = new VideoMode[(int)((end - begin) / sf_VideoMode_sizeof)];
            for (int i = 0; begin != end; begin += sf_VideoMode_sizeof, ++i) {
                modesArray[i] = new VideoMode(
                    sf_VideoMode_getWidth(begin),
                    sf_VideoMode_getHeight(begin),
                    sf_VideoMode_getBitsPerPixel(begin)
                );
            }
            modes = List.of(modesArray);
        }
        return modes;
    }

    public boolean isValid() {
        return getFullscreenModes().contains(this);
    }

    public boolean equals(Object val) {
        if (val instanceof VideoMode videoMode) {
            return (this.width        == videoMode.width)        &&
                   (this.height       == videoMode.height)       &&
                   (this.bitsPerPixel == videoMode.bitsPerPixel);
        }
        return false;
    }

    public int compareTo(VideoMode val) {
        if (this.bitsPerPixel == val.bitsPerPixel) {
            if (this.width == val.width) {
                return Integer.compare(this.height, val.height);
            }
            else {
                return Integer.compare(this.width, val.width);
            }
        }
        else {
            return Integer.compare(this.bitsPerPixel, val.bitsPerPixel);
        }
    }

    public String toString() {
        return "{width=" + width + ", height=" + height + ", bitsPerPixel=" + bitsPerPixel + "}";
    }
}

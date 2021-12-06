package es.boalis.utils.transformer;

import java.util.Map;

public class ChunkData {
    private int position;
    private String chunk;
    private String appName;
    private boolean isFirst;
    private boolean isLast;

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getChunk() {
        return chunk;
    }

    public void setChunk(String chunk) {
        this.chunk = chunk;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Override
    public String toString() {
        return "ChunkData{" +
                "position=" + position +
                ", chunk='" + chunk + '\'' +
                ", appName='" + appName + '\'' +
                ", isFirst=" + isFirst +
                ", isLast=" + isLast +
                '}';
    }
}

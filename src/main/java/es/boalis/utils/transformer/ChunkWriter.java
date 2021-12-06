package es.boalis.utils.transformer;

import java.util.Map;

public abstract class ChunkWriter {
    public void init(Map<String,String> config){

    }
    public abstract ChunkData getData(Map<String,String> map, ChunkData source);

    public ChunkData copySourceChunk(ChunkData source){
        ChunkData target = new ChunkData();
        target.setPosition(source.getPosition());
        target.setAppName(source.getAppName());
        return target;
    }
}

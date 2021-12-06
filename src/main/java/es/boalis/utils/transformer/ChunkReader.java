package es.boalis.utils.transformer;

import java.io.IOException;
import java.util.Map;

public abstract class ChunkReader {
    public void init(Map<String,String> config){

    }
    public abstract Map<String,String> getData(ChunkData data)throws IOException;

}

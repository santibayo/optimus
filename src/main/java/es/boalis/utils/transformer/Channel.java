package es.boalis.utils.transformer;

import java.io.IOException;
import java.util.Map;

public interface Channel{
    public void initResource(Map<String,String> resources) throws IOException;
    public void start() throws IOException;
    public void stop() throws IOException;
    public ChunkData readData() throws IOException;
    public void writeData(ChunkData data);

}

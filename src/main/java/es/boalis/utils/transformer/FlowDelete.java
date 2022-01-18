package es.boalis.utils.transformer;

import java.io.IOException;
import java.util.Map;

public class Flow{
    private Channel inbound;
    private Channel outbound;
    public Flow(Channel inbound, Channel outbound){
        this.inbound = inbound;
        this.outbound =outbound;
    }
    public void init (Map<String,String> config)throws IOException{

    }
    public boolean processChunk( ChunkReader r, ChunkWriter w, Transformer transformer)throws IOException{
        ChunkData readData = inbound.readData();
        if (readData.getChunk()==null){
            return false;
        }
        Map<String,String> parsedData =r.getData(readData);
        if (transformer != null) {
            Map<String, String> newData = transformer.transform(parsedData);
            parsedData = newData;
        }
        ChunkData outputData = w.getData(parsedData,readData);
        outbound.writeData(outputData);
        return true;

    }

    public Channel getInbound() {
        return inbound;
    }

    public Channel getOutbound() {
        return outbound;
    }
}

package es.boalis.utils.transformer;

import java.util.Iterator;
import java.util.Map;

public class FlowIterator {

    private Channel inbound;
    private Channel outbound;
    private ChunkReader r;
    private ChunkWriter w;
    private Transformer transformer;

    public FlowIterator(Channel inbound,Channel outbound,ChunkReader r,
                        ChunkWriter w, Transformer transformer){
        this.inbound = inbound;
        this.outbound = outbound;
        this.r = r;
        this.w = w;
        this.transformer = transformer;
    }

    public boolean hasNext() throws Exception{
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


}

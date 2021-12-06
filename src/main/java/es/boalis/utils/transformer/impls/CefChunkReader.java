package es.boalis.utils.transformer.impls;

import es.boalis.utils.transformer.ChunkData;
import es.boalis.utils.transformer.ChunkReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CefChunkReader extends ChunkReader {

    @Override
    public Map<String, String> getData(ChunkData data) throws IOException {
        String dataToParse= data.getChunk();
        if (dataToParse==null){
            return null;
        }
        Map<String,String> dataMap= new HashMap<>();
        String [] elements = dataToParse.split(" ");
        if (elements.length>0) {
            for (String element : elements) {
                String [] kvElement = element.split("=");
                if (kvElement.length == 2){
                    String kElement = kvElement[0];
                    String vElement = kvElement[1];
                    dataMap.put(kElement,vElement);
                }
            }
            return dataMap;
        }
        return null;
    }
}

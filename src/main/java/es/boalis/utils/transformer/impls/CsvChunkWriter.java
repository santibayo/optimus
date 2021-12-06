package es.boalis.utils.transformer.impls;

import es.boalis.utils.transformer.ChunkData;
import es.boalis.utils.transformer.ChunkWriter;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class CsvChunkWriter extends ChunkWriter {
    final ArrayList<String> elements=new ArrayList<>();

    @Override
    public void init(Map<String, String> config) {
        String kvFields = config.getOrDefault("fields","");
        String[] arrFields = kvFields.split(",");
        for (String kvElement: arrFields){
            elements.add(kvElement);
        }
    }

    @Override
    public ChunkData getData(Map<String, String> map, ChunkData source) {
        ChunkData target = this.copySourceChunk(source);
        Iterator<String> keys = map.keySet().iterator();
        StringWriter writer = new StringWriter();
        while(keys.hasNext()){
            String key = keys.next();
            if (map.containsKey(key)){
                String value = map.getOrDefault(key,"");
                writer.write(value);
                writer.write(",");
            }
        }
        String line =writer.toString();
        target.setChunk(line);
        return target;
    }
}

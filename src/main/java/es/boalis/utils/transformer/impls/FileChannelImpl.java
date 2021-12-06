package es.boalis.utils.transformer.impls;

import es.boalis.utils.transformer.Channel;
import es.boalis.utils.transformer.ChunkData;

import java.io.*;
import java.util.Map;

public class FileChannelImpl implements Channel {
    BufferedReader reader;
    PrintWriter writer;
    Map<String,String> config;
    int position=0;


    @Override
    public void initResource(Map<String,String> resources) throws IOException {
        config = resources;
        if (resources.containsKey("file.mode")){
            String mode = resources.get("file.mode");
            String file = resources.get("file.name");
            if (mode.equals("read")){
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            }else if (mode.equals("write")){
                writer = new PrintWriter(new FileOutputStream(file),true);
            }else{
                throw new IOException("mode not supported");
            }
        }
    }

    @Override
    public void start() throws IOException {

    }

    @Override
    public void stop() throws IOException {

    }

    @Override
    public ChunkData readData() throws IOException {
        String line = reader.readLine();
        ChunkData chunk = new ChunkData();
        chunk.setChunk(line);
        chunk.setPosition(position);
        position++;
        return chunk;
    }

    @Override
    public void writeData(ChunkData data) {
        writer.println(data.getChunk());
        position++;
    }
}

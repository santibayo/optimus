package es.boalis.utils.transformer.impls;

import es.boalis.utils.transformer.Channel;
import es.boalis.utils.transformer.ChunkData;

import java.io.IOException;
import java.util.Map;

public class PipeChannel implements Channel {

    ChunkData pipedData=null;
    @Override
    public void initResource(Map<String, String> resources) throws IOException {

    }

    @Override
    public void start() throws IOException {

    }

    @Override
    public void stop() throws IOException {

    }

    @Override
    public ChunkData readData() throws IOException {
        return this.pipedData;
    }

    @Override
    public void writeData(ChunkData data) {
        this.pipedData = data;

    }
}

package es.boalis.utils.transformer.test.basic;

import es.boalis.utils.transformer.Channel;
import es.boalis.utils.transformer.ChunkData;
import es.boalis.utils.transformer.Flow;
import es.boalis.utils.transformer.impls.CefChunkReader;
import es.boalis.utils.transformer.impls.CsvChunkWriter;
import es.boalis.utils.transformer.impls.FileChannelImpl;
import es.boalis.utils.transformer.impls.PipeChannel;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestUnit {
    @Test
    public void basicTestFlow()throws IOException {
        Map<String,String> config = new HashMap<>();
        config.put("file.mode","read");
        config.put("file.name","/home/santibayo/sample.txt");
        config.put("appname","/firewall/cef2csv");
        config.put("fields","data,data1,key");
        Channel reader = new FileChannelImpl();
        reader.initResource(config);

        Channel pipe = new PipeChannel();

        CefChunkReader deserializer = new CefChunkReader();

        CsvChunkWriter serializer = new CsvChunkWriter();
        serializer.init(config);


        Flow flow = new Flow(reader, pipe);
        flow.init(config);
        while(true) {
            boolean hasMore = flow.processChunk( deserializer, serializer, null);
            if (!hasMore){
                break;
            }else{
                System.out.println(pipe.readData());
            }
        }




    }
    @Test
    public void basicTestChannelReader()throws IOException {
        Map<String,String> config = new HashMap<>();
        config.put("file.mode","read");
        config.put("file.name","/home/santibayo/sample.txt");
        config.put("appname","/firewall/cef2csv");

        Channel channel = new FileChannelImpl();
        channel.initResource(config);
        ChunkData chunk = channel.readData();
        System.out.println(chunk);
        CefChunkReader parser = new CefChunkReader();
        System.out.println(parser.getData(chunk));
    }




}

package es.boalis.utils.transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sequence {
    private final List<Flow> flows;

    private Sequence(List<Flow> flows){
            this.flows = flows;
    }
    public static Sequence getSingle(Flow flow){
        List<Flow> flows= Arrays.asList(flow);
        Sequence seq = new Sequence(flows);
        return seq;
    }

    public static Sequence getMultiple(List<Flow> flows){
        Sequence seq = new Sequence(flows);
        return seq;
    }

    public void launch(){
        // to implement
    }






}

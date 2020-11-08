package com.coding.other;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoStacksDequeueTest {

    @Test
    public void shouldEnqueueAndOffer(){
        TwoStacksDequeue<Integer> tsd = new TwoStacksDequeue<>();
        tsd.queue(1);
        tsd.queue(2);
        tsd.queue(3);

        System.out.println(tsd.offerFirst());
        System.out.println(tsd.offerLast());
        System.out.println(tsd.offerFirst());

    }

}
package com.qiccc.evn_gather_impl;


import com.briup.smart.env.client.Gather;
import com.briup.smart.env.client.GatherImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EvnGatherImplApplicationTests {

    @Test
    public void test() throws Exception {

        Gather gather = new GatherImpl();
        gather.gather();


    }

}

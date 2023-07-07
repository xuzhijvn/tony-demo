package com.tony.other;

import com.tony.other.demo1.RpcDupliException;
import com.tony.other.demo1.RpcException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testException(){
        try {
            testHandle2();
        }catch (RpcDupliException e){
            System.out.println("RpcDupliException");
        }catch (RpcException e){
            System.out.println("RpcException");
        }
    }

    private void testHandle() throws RpcException{
        try {
            throw new RpcDupliException();
        }catch (Exception e){
            if (e instanceof RpcException){
                throw e;
            }else {
                throw new RpcException();
            }
        }
    }
    private void testHandle2() throws RpcException{
        try {
            throw new RpcException();
        }catch (Exception e){
            if (e instanceof RpcException){
                throw e;
            }else {
                throw new RpcException();
            }
        }
    }
}

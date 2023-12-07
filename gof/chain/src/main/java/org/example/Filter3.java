package org.example;

public class Filter3 implements Filter{
    @Override
    public void doFilter(Request request, FilterChain filterChain) {
        System.out.println("执行Filter3");
        request.setCount(request.getCount() + 1);

        filterChain.doFilter(request, filterChain);
    }
}

package org.example;

public class Filter1 implements Filter {
    @Override
    public void doFilter(Request request, FilterChain filterChain) {
        System.out.println("执行Filter1");

        request.setCount(request.getCount() + 1);

        filterChain.doFilter(request, filterChain);
    }
}

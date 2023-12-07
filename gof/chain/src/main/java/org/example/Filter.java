package org.example;

public interface Filter {

    void doFilter(Request request, FilterChain filterChain);
}

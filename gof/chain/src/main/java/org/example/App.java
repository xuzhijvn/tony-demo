package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Request request = new Request();

        Filter1 filter1 = new Filter1();
        Filter2 filter2 = new Filter2();
        Filter3 filter3= new Filter3();

        FilterChain filterChain = new FilterChain();

        filterChain.addFilter(filter1);
        filterChain.addFilter(filter2);
        filterChain.addFilter(filter3);

        filterChain.doFilter(request, filterChain);

    }
}

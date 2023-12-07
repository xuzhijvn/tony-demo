package org.example;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

    private int pos = 0;

    private List<Filter> filterList;

    @Override
    public void doFilter(Request request, FilterChain filterChain) {
        // 所有过滤器执行完毕
        if (pos == filterList.size()) {
            System.out.println("所有过滤器执行完毕, request = " + request);
        }else {
            filterList.get(pos++).doFilter(request, filterChain);
        }
    }

    public void addFilter(Filter filter) {
        if (filterList == null) {
            filterList = new ArrayList<>();
        }
        filterList.add(filter);
    }
}

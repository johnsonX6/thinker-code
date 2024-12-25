package com.client.reactor;

import reactor.core.publisher.Flux;

/**
 * @author hqz
 * @create 2022/8/24 13:49
 */
public class ReactorDemo {
    public static void main(String[] args) {
        Flux.range(1, 3).filter(i -> i % 2 != 0)
                .log().map(i -> i * i).subscribe(System.out::println);
    }
}

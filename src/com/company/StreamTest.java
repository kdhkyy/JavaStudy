package com.company;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    //java 8이상은 stream에서 람다를 활용할 수 있는 기술중 하나???
    // 1. 스트림 인스턴스 생성
    // 2. 가공 : filtering, mapping 등 원하는 결과를 만들어가는 중간 작업 intermediate operations
    // 3. 결과 만들기 : 최종적으로 결과를 만들어내는 작업(terminal operations)

    public static void main(String[] args) {
        Stream<String> builderStream = Stream.<String>builder().add("Eric").add("Elena").add("java").build();
        builderStream.forEach(n-> System.out.println(n));

        Stream<String> generatedStream = Stream.generate(() -> "gen").limit(4);
        generatedStream.forEach( n -> System.out.println(n));

        Map<String, Long> freq;

    }

}
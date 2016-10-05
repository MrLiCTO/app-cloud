package com.lingxin.cloud.ui.app;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface TestJdk<T> {
    <T> List<T> get(List<T> list);
}

/**
 * Created by Mr_Li on 2016/10/5.
 */
public class TestJdk8 {
    @Test
    public void testJdk() {
        int arr[] = {1, 2, 3, 4, 5, 6};
        Arrays.stream(arr).map(x -> x + 1).forEach(System.out::println);
    }


}

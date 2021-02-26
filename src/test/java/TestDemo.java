import com.andy.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/25
 * @Proposal:
 */
@Slf4j
public class TestDemo {

    public static void main(String[] args) {
        SpringApplication.run(com.andy.Application.class, args);
        int[] input = {1,2,3};
        int newlen = process(input, 4);
    }

    private static int process(int[] input, int offset) {

        Long s = System.currentTimeMillis();
        int count = 0;
        int j = offset;
        int i = 0;
        if (offset == 0) {
            return input.length;
        }
        while(count < input.length -1) {
            j = j%input.length;

            int swapTemp = input[i];
            input[i] = input[j];
            input[j] = swapTemp;

            count++;
            i = (count)%offset;
            j++;
        }

        log.info(String.valueOf(s - System.currentTimeMillis()));

        return input.length;
    }
}
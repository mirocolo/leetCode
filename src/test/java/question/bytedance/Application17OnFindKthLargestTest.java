package question.bytedance;

import junit.framework.LeetCodeTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/12/6 11:13
 */
@Fork(1)
@Threads(2)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5,time = 1,timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 100,time = 1,timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class Application17OnFindKthLargestTest extends LeetCodeTestCase<Application17OnFindKthLargest> {


    Application17OnFindKthLargest.Solution2 solution2 = instance.new Solution2();


    @Test
    @Benchmark
    public void testFindKthLargest() {
        int kthLargest = solution2.findKthLargest(new int[]{9,3,5,8,1,2,4,7,6}, 5);
        assert kthLargest == 5;
    }
}
package question.bytedance;

import junit.framework.LeetCodeTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/11/24 21:15
 */
@RunWith(Parameterized.class)
public class Application2OnNumberOfIslandsTest extends LeetCodeTestCase {
    private Application2OnNumberOfIslands app = new Application2OnNumberOfIslands();

    private char[][] gird;
    private int numOfIslands;

    public Application2OnNumberOfIslandsTest(char[][] gird, int numOfIslands) {
        this.gird = gird;
        this.numOfIslands = numOfIslands;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {
                                new char[][]{
                                        new char[]{'1','1','1','1','0'},
                                        new char[]{'1','1','0','1','0'},
                                        new char[]{'1','1','0','0','0'},
                                        new char[]{'0','0','0','0','0'}
                                },
                               1
                        },


                });
    }

    @Test
    public void mergeKLists() {
        int res = app.numIslands(gird);
        Assert.assertEquals("resUnEqual", numOfIslands, res);
    }

    @Test
    public void mergeKListsV2() {
        int res = app.numIslandsV2(gird);
        Assert.assertEquals("resUnEqual", numOfIslands, res);
    }

    @Test
    public void mergeKListsV3() {
        int res = app.numIslandsV3(gird);
        Assert.assertEquals("resUnEqual", numOfIslands, res);
    }
}
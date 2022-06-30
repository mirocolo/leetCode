package question.d;

/**
 * @Description: 整数反转
 * @Author 何鑫
 * @Date 2022/6/30 10:02
 */
public class Application7 {

    public int reverse(int x) {
        int res = 0;
        int maxJudge = Integer.MAX_VALUE/10;
        int maxNum = Integer.MAX_VALUE%10;
        int minJudge = Integer.MIN_VALUE/10;
        int minNum = Integer.MIN_VALUE%10;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            //判断是否 大于 最大32位整数

            if (res>maxJudge || (res==maxJudge && tmp>maxNum)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<minJudge || (res==minJudge && tmp<minNum)) {
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;
    }
}

package question.d;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Z字形变换
 * @Author 何鑫
 * @Date 2022/6/29 18:18
 */
public class Application6 {
    /**
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows<2){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int flag = -1;
        int i = 0;
        for (char c : s.toCharArray()) {
            if(i == 0 || i == numRows-1){
                flag = flag * -1;
            }
            rows.get(i).append(c);
            i += flag;
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            stringBuilder.append(rows.get(j));
        }
        return stringBuilder.toString();

    }
}

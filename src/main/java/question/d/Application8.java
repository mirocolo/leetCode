package question.d;

import java.util.List;
import java.util.Map;

/**
 * @Description: 字符串转换整数 (atoi)
 * @Author 何鑫
 * @Date 2022/6/30 17:41
 */
public class Application8 {


    public int myAtoi(String s) {
        AtoiMachine atoiMachine = new AtoiMachine();
        for (char c : s.toCharArray()) {
            atoiMachine.get(c);
        }
        return atoiMachine.getRes();
    }

    static class AtoiMachine {
        boolean over = false;
        int flag = 1;
        int ans = 0;
        MachineState machineState = MachineState.start;
        Map<MachineState, List<MachineState>> map = Map.of(
                MachineState.start, List.of(MachineState.start, MachineState.signed, MachineState.number, MachineState.end),
                MachineState.signed, List.of(MachineState.end, MachineState.end, MachineState.number, MachineState.end),
                MachineState.number, List.of(MachineState.end, MachineState.end, MachineState.number, MachineState.end),
                MachineState.end, List.of(MachineState.end, MachineState.end, MachineState.end, MachineState.end)

        );

        public void get(char c) {
            machineState = map.get(machineState).get(getCol(c));
            switch (machineState) {
                case signed -> flag = c == '-' ? -1 : 1;
                case number -> {
                    if (flag>0 && (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10))) {
                        ans = Integer.MAX_VALUE;
                        over = true;
                        machineState = MachineState.end;
                        break;
                    }
                    if (flag<0 && (ans > Math.abs(Integer.MIN_VALUE / 10) || (ans == Math.abs(Integer.MIN_VALUE / 10) && (c - '0') > -(Integer.MIN_VALUE % 10)))) {
                        ans = Integer.MIN_VALUE;
                        over = true;
                        machineState = MachineState.end;
                        break;
                    }
                    ans = ans * 10 + (c - '0');
                }
                default -> {}
            }
        }

        private int getCol(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }

        private int getRes(){
            if(over){
                return ans;
            }
            return flag * ans;
        }
    }

    enum MachineState {
        start, signed, number, end;
    }
}

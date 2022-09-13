import java.util.*;
import static java.lang.Math.*;


public class main{
    public static void main(String[] args) {
        Stack st = new Stack();
        Stack at = new Stack();

        String tmp = args[0];
        char[] tmp2 = tmp.toCharArray();
        int sol = 0;


        for (int i = 0; i < tmp2.length; i++) {
            int rst = 0;
            st.push(tmp2[i]);
            switch (tmp2[i]) {
                case '(': {
                    break;
                }
                case ')': {
                    String rt = "";
                    char[] rtt;
                    char ex = 0;
                    int cnt = 0;
                    int tu = 0;
                    int cnt2 = 0;
                    st.pop();
                    while (ex != '(') {
                        ex = (char) st.pop();
                        if (ex == '(')
                            break;
                        at.push(ex);
                    }

                    while (!at.empty()) {
                        rt += (char) at.pop();
                    }

                    rtt = rt.toCharArray();

                    for (int q = 0; q < rtt.length; q++) {
                        int rst2 = 0;
                        inner:
                        try {
                            for (int l = q + 2 * cnt2 + 1; l < rtt.length; l++) {
                                switch (rtt[l]) {
                                    case '*': {
                                        if (tu == 0) {
                                            rst2 = mknum(rtt, l, 1);
                                            tu = 1;
                                        }
                                        //rst2 *= rtt[l + 1] - '0';
                                        rst2 *= mknum(rtt, l, 0);
                                        if (rtt[l + 2] == '+' || rtt[l + 2] == '-')
                                            break inner;
                                        break;
                                    }
                                    case '/': {
                                        if (tu == 0) {
                                            rst2 = mknum(rtt, l, 1);
                                            tu = 1;
                                        }
                                        //rst2 /= rtt[l + 1] - '0';
                                        rst2 /= mknum(rtt, l, 0);
                                        if (rtt[l + 2] == '+' || rtt[l + 2] == '-')
                                            break inner;

                                        break;
                                    }
                                    default:
                                        break;
                                }
                                cnt2++;
                            }
                        } catch (Exception e) {
                        }
                        switch (rtt[q]) {
                            case '+': {
                                if (tu == 0) {
                                    rst2 = mknum(rtt, q, 1);
                                    tu = 2;
                                }

                                if (q - 2 <= 0 && rst2 == 0) {
                                    // rst2 += rtt[q - 1] - '0';
                                    rst2 += mknum(rtt, q, 1);
                                } else
                                    //rst2 += rtt[q + 1] - '0';
                                    rst2 += mknum(rtt, q, 0);

                                break;
                            }

                            case '-': {
                                if (tu == 0) {
                                    rst2 = mknum(rtt, q, 1);
                                    tu = 2;
                                }

                                if (q - 2 <= 0 && rst2 == 0) {
                                    // rst2= (rtt[q - 1] -'0') - rst2;
                                    rst2 = mknum(rtt, q, 1) - rst2;
                                } else
                                    // rst2 -= rtt[q + 1] - '0';
                                    rst2 -= mknum(rtt, q, 0);


                                break;
                            }
                        }

                        if (cnt >= 0) {
                            rst += rst2;
                        }
                        cnt++;
                    }

                    String tm = "" + rst;
                    char[] tm2 = tm.toCharArray();
                    sol = rst;
                    for (int c = 0; c < tm2.length; c++)
                        st.push((char) tm2[c]);
                    break;
                }
                default:
                    break;
            }
        }

        String rt = "";
        char[] rtt;
        char ex = 0;
        int cnt = 0;
        int tu = 0;
        int cnt2 = 0;
        int rst = 0;
        while (!st.empty()) {
            ex = (char) st.pop();
            at.push(ex);
        }

        while (!at.empty()) {
            rt += (char) at.pop();
        }

        rtt = rt.toCharArray();

        for (int q = 0; q < rtt.length; q++) {
            int rst2 = 0;
            inner:
            try {
                for (int l = q + 2 * cnt2 + 1; l < rtt.length; l++) {
                    switch (rtt[l]) {
                        case '*': {
                            if (tu == 0) {
                                rst2 = mknum(rtt, l, 1);
                                tu = 1;
                            }
                            //rst2 *= rtt[l + 1] - '0';
                            rst2 *= mknum(rtt, l, 0);
                            if (rtt[l + 2] == '+' || rtt[l + 2] == '-')
                                break inner;
                            break;
                        }
                        case '/': {
                            if (tu == 0) {
                                rst2 = mknum(rtt, l, 1);
                                tu = 1;
                            }
                            //rst2 /= rtt[l + 1] - '0';
                            rst2 /= mknum(rtt, l, 0);
                            if (rtt[l + 2] == '+' || rtt[l + 2] == '-')
                                break inner;

                            break;
                        }
                        default:
                            break;
                    }
                    cnt2++;
                }
            } catch (Exception e) {
            }
            switch (rtt[q]) {
                case '+': {
                    if (tu == 0) {
                        rst2 = mknum(rtt, q, 1);
                        tu = 2;
                    }

                    if (q - 2 <= 0 && rst2 == 0) {
                        // rst2 += rtt[q - 1] - '0';
                        rst2 += mknum(rtt, q, 1);
                    } else
                        //rst2 += rtt[q + 1] - '0';
                        rst2 += mknum(rtt, q, 0);

                    break;
                }

                case '-': {
                    if (tu == 0) {
                        rst2 = mknum(rtt, q, 1);
                        tu = 2;
                    }

                    if (q - 2 <= 0 && rst2 == 0) {
                        // rst2= (rtt[q - 1] -'0') - rst2;
                        rst2 = mknum(rtt, q, 1) - rst2;
                    } else
                        // rst2 -= rtt[q + 1] - '0';
                        rst2 -= mknum(rtt, q, 0);


                    break;
                }
            }

            if (cnt >= 0) {
                rst += rst2;
            }
            cnt++;
        }

        String tm = "" + rst;
        char[] tm2 = tm.toCharArray();
        sol = rst;
        for (int c = 0; c < tm2.length; c++)
            st.push((char) tm2[c]);


        System.out.println(sol);



    }

    static int mknum (char[] arr, int i, int code){
        int rst = 0;
        int i2 = i;

        if(code == 0) {
            int cnt = 0;
            try {
                while (48 <= arr[i2 + 1] && arr[i2 + 1] <= 57) {
                    cnt++;
                    i2++;
                }
            }catch (Exception e) {}
            for(int a = cnt, l = 1; a > 0 ; a--, l++)
            {
                int n2 = (int)pow(10, a - 1);
                rst += (arr[i + l] - '0') * n2;
            }
        }
        else if(code == 1){
            int cnt = 0;
            try{
                 while (48 <= arr[i2-1] && arr[i2-1] <= 57) {
                      cnt++;
                      i2--;
                 }
            }catch (Exception e){}
            for(int a = 0, l = 1; a < cnt ; a++, l++)
            {
                rst += (arr[i - l] - '0') * pow(10, a);
            }
        }
        return rst;

    }
}

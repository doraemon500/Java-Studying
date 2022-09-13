class Exercise9_5 {
    public static int count(String src, String target) {
        int count = 0; // 찾은 횟수
        int pos = 0; // 찾기 시작할 위치
        char[] a = src.toCharArray();
        char[] b = new char[target.length()];
/*
(1) . 반복문을 사용해서 아래의 과정을 반복한다
1. src  에서 target 을  pos 의 위치부터 찾는다
2. count 찾으면 1  의 값을 증가 시키고
pos 의 값을 target.length  만큼 증가시킨다
3. indexOf 의 결과가 -1 이면 반복문을 빠져나가서 count를 반환한다

*/

        
        try {
            for (; pos < src.length(); pos++) {
                for (int i = 0; i < target.length(); i++) {
                    if (a[pos] == target.charAt(0))
                        b[0] = target.charAt(0);
                    else if (a[pos] == target.charAt(i) && b[i - 1] == target.charAt(i - 1))
                        b[i] = target.charAt(i);

                    else {
                        pos -= i;
                        b = new char[target.length()];
                        break;
                    }
                    pos++;
                    if (target.equals(new String(b))) {
                        count++;
                        b = new char[target.length()];
                    }
                }

            }
        }catch (Exception e){e.printStackTrace();}
        return count;
    }
    public static void main(String[] args) {
        System.out.println(count("ABC45AB12AB345AB","AB"));
        System.out.println(count("12345","AB"));
    }
}


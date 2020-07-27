import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Hello world!");

	    int a = 500; // 쌀밥
        int[] b = {1500, 1000, 700}; // 제육, 닭갈비, 계란찜
        int[] c = {500, 300}; // 배추김치, 총각김치
        int[] resultmain = {0, 0, 0};
        int[] resultkimchi = {0, 0};

        ArrayList<Integer> mainmenu = new ArrayList<>(); // 주메뉴 가격 리스트
        ArrayList<Integer> mainmenu1 = new ArrayList<>(); // 주메뉴 가격 리스트
        ArrayList<Integer> kimchi = new ArrayList<>(); // 김치메뉴 가격 리스트
        ArrayList<Integer> kimchi1 = new ArrayList<>(); // 김치메뉴 가격 리스트
        ArrayList<Integer> total1 = new ArrayList<>(); // 총 가격 리스트
        ArrayList<Integer> total2 = new ArrayList<>(); // 총 가격일때 메뉴빈도 차이 리스트

        int L1 = 0; // 메인메뉴 경우의 수 리스트 길이
        int L2 = 0; // 김치메뉴 경우의 수 리스트 길이
        int L3 = 0; // 전체메뉴 경우의 수 리스트 길이

        ArrayList<Integer> im = new ArrayList<>();
        ArrayList<Integer> jm = new ArrayList<>(); // i와 j의 메인메뉴일때 상태
        ArrayList<Integer> km = new ArrayList<>();
        for(int i=0; i<=30; i++) {
            for(int j=0; j<=30-i; j++) {
                int k = 30 - i - j;
                mainmenu.add(b[0]*i + b[1]*j + b[2]*k);
                int[] x = {i,j,k};
                int temp = 0;
                int max = 0;
                int min = x[0];
                for(int i1=0; i1<3; i1++){
                    temp = x[i1];
                    if(temp > max){
                        max = temp;
                    }
                    if(temp < min){
                        min = temp;
                    }
                }
                mainmenu1.add(max - min);
                L1++;
                im.add(i);
                jm.add(j);
                km.add(k);
            }
        }

        ArrayList<Integer> ii = new ArrayList<>();
        ArrayList<Integer> jj = new ArrayList<>(); // i와 j의 김치메뉴일때 상태
        for(int i=0; i<=30; i++) {
            int j = 30 - i;
            kimchi.add(c[0]*i + c[1]*j);
            kimchi1.add(Math.abs(i-j));
            L2++;
            ii.add(i);
            jj.add(j);
        }

        ArrayList<Integer> iii = new ArrayList<>();
        ArrayList<Integer> jjj = new ArrayList<>(); // i와 j의 총메뉴일때 상태
        for(int i=0; i<L1; i++) {
            for(int j=0; j<L2; j++) {
                total1.add(mainmenu.get(i) + kimchi.get(j));
                total2.add(mainmenu1.get(i) + kimchi1.get(j));
                L3++;
                iii.add(i);
                jjj.add(j);
            }
        }



        int minnum = 0;
        int tempi, tempi1, tempi2, tempi3;
        int tempj, tempj1, tempj2; // 주메뉴, 김치메뉴 빈도

        while(true) {
            int min = total2.get(0);
            int temp = 0;
            for(int i1=0; i1<L3; i1++) {
                temp = total2.get(i1);
                if(temp < min){
                    min = temp;
                    minnum = i1;
                }
            }



            if(total1.get(minnum) <= 40000) {
                tempi = iii.get(minnum);
                tempj = jjj.get(minnum);
                tempi1 = im.get(tempi);
                tempi2 = jm.get(tempi);
                tempi3 = km.get(tempi);
                tempj1 = ii.get(tempj);
                tempj2 = jj.get(tempj);
                break;
            }

            total2.set(minnum, 10000);
        }

        System.out.println(tempi1 + " " + tempi2 + " " + tempi3);

    }
}


// a*30 + b[0]*x + b[1]*y + b[2]*z + c[0]*x1 + c[1]*y1
// x
// 45000에
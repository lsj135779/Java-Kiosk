package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Goods extends Menu{
    // 필드
    ArrayList<Integer> prices = new ArrayList<Integer>();
    Order order = new Order();

    // 생성자
    public Goods () {};


    // 메서드
    // 상품 추가하기 (오버로딩)
    void addGoods (String[] names, String[] explanations, int[] prices) {
        for (int i = 0; i < names.length; i++) {
            this.names.add(names[i]);
            this.explanations.add(explanations[i]);
            this.prices.add(prices[i]);
        }
    }

    // name에 스페이스 추가해서 출력하기 (오버라이딩)
    @Override
    void addSpacePrint () {
        for (int i = 0; i < this.names.size(); i++) {
            if (this.names.get(i).length() < 40) {
                String space = "";
                for (int j = 0; j < 40 - this.names.get(i).length(); j++) {
                    space += " ";
                }
                System.out.println("\u001B[35m" + (i+1) + "\u001B[0m" + ". " + this.names.get(i) + space + "\u001B[33m | \u001B[0m" + this.prices.get(i) + "원" + "\u001B[33m | \u001B[0m" + this.explanations.get(i));
            }
        }
    }

    // 선택한 상품 출력하기
    void selectGoodsPrint (int selectNum) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (selectNum > 0 && selectNum < 9) {
                String space = "";
                for (int i = 0; i < 30 - this.names.get(selectNum -1).length(); i++) {
                    space += " ";
                }
                System.out.println("\u001B[32m\"" + this.names.get(selectNum - 1) + space + " | " + this.prices.get(selectNum - 1) + "원" + " | " + this.explanations.get(selectNum - 1) + "\"\u001B[0m");
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까 \u001B[33m?\u001B[0m\n" +
                        "\u001B[35m 1. \u001B[0m확인        \u001B[35m 2. \u001B[0m취소"
                );
                break;
            } else {
                System.out.println("1~8까지 번호를 선택해주세요.");
                selectNum = sc.nextInt();
            }
        }
    }

    // 상품을 장바구니에 추가하고 완료문구 출력하기
    void putShoppingbag (String name, String explanation, int price) {
        this.order.names.add(name);
        this.order.explanations.add(explanation);
        this.order.prices.add(price);
        System.out.println(name + " 가 장바구니에 추가되었습니다.\n");
    }

}

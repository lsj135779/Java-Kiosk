package src;

import java.util.ArrayList;

public class Order {
    // 필드
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> explanations = new ArrayList<String>();
    ArrayList<Integer> prices = new ArrayList<Integer>();

    // 생성자
    public Order () {};

    // 메서드
    // 주문 목록 출력하고 주문 금액 반환하기
    int printOrderGoods () {
        int orderPrice = 0;
        for (int i = 0; i < this.names.size(); i++) {
            String space = "";
            for (int j = 0; j < 40 - this.names.get(i).length(); j++) {
                space += " ";
            }
            System.out.println(this.names.get(i) + space + "\u001B[33m | \u001B[0m" + "\u001B[31m" + this.prices.get(i) + "\u001B[0m" + "원" + "\u001B[33m | \u001B[0m" + this.explanations.get(i) + "\"\u001B[0m");
            orderPrice += this.prices.get(i);
        }
        return orderPrice;
    }

    // 진행하던 주문 취소시 주문 리스트 비우기
    void cancleOrder () {
        this.names.clear();
        this.explanations.clear();
        this.prices.clear();
    }

    // 주문 화면에서 1.주문을 선택해서 완료 화면이 나오게 하기
    void orderComplete (int waitingNum) throws InterruptedException {
        System.out.println("주문이 완료되었습니다 \u001B[33m!\u001B[0m\n");
        System.out.println("대기번호는 [ " + "\u001B[31m" + waitingNum + "\u001B[0m" + " ] 번 입니다.");
        System.out.println("(\u001B[31m3\u001B[0m초후 메뉴판으로 돌아갑니다.)");
        Thread.sleep(3000);
    }
}

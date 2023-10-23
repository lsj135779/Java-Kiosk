package src;

import java.util.ArrayList;

public class Menu {
    // 필드
    // 이름, 설명 필드를 가지고 있다.
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> explanations = new ArrayList<String>();

    // 생성자
    public  Menu () {};

    // 메서드
    // 메뉴 추가하기;
    void addMenu (String[] names, String[] explanations) {
        for (int i = 0; i < names.length; i++) {
            this.names.add(names[i]);
            this.explanations.add(explanations[i]);
        }
    }

    // name에 스페이스 추가해서 출력하기
    void addSpacePrint () {
        for (int i = 0; i < this.names.size(); i++) {
            if (this.names.get(i).length() < 20) {
                String space = "";
                for (int j = 0; j < 20 - this.names.get(i).length(); j++) {
                    space += " ";
                }
                System.out.println("\u001B[35m" + (i+1) + "\u001B[0m" + ". " + this.names.get(i) + space + "\u001B[33m | \u001B[0m" + this.explanations.get(i));
            }
        }
    }
}

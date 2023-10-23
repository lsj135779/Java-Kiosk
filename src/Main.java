package src;

import java.util.Scanner;

public class Main {
    // 전역변수
    static int waitingNum = 1;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        // 키오스크가 켜지면 대기자번호를 초기화 한다.
        waitingNum = 0;
        // 메인 메뉴판
        Goods goods = new Goods();
        mainMenu(goods);
    }

    // 메인 메뉴판 화면을 보여준다.
    public static void mainMenu (Goods goods) throws InterruptedException {
        // 메뉴 배열
        String[] menuNames = {"Hamburger", "Dessert", "Chicken ", "Beverage/Coffee"};
        String[] menuExplanations = {
                "한국인 입맛에 맞는 롯데리아 햄버거",
                "간단하게 먹을 수 있는 디저트",
                "햄버거보다 치킨이 땡길 때",
                "음식과 어울리는 음료/커피"
        };

        Menu menus = new Menu();
        menus.addMenu(menuNames, menuExplanations);
        // 메인 메뉴판 화면
        System.out.println("\u001B[32m \"롯데리아에 오신걸 환영합니다.\" \u001B[0m\n" +
                "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n" +
                "\n[ 롯데리아 MENU ]\n");
        menus.addSpacePrint();
        System.out.println("\n[ ORDER MENU ]\n" +
                "\u001B[35m5.\u001B[0m Order       \u001B[33m | \u001B[0m 장바구니를 확인 후 주문합니다.\n" +
                "\u001B[35m6.\u001B[0m Cancel      \u001B[33m | \u001B[0m 진행중인 주문을 취소합니다.");

        int selectNum = sc.nextInt();

        while (true) {
            if (selectNum > 0 && selectNum < 5) {
                selectMenu(selectNum, goods);
                break;
            } else if (selectNum == 5) {
                // Order를 선택한 경우
                selectOrder(goods);
                break;
            } else if (selectNum == 6) {
                // Cancle를 선택한 경우
                selectCancle(goods);
                break;
            } else {
                System.out.println("1~6까지 번호를 선택해주세요.");
                selectNum = sc.nextInt();
            }
        }
    }


    // 메뉴를 선택한 경우 해당 메뉴에 있는 상품들을 보여준다.
    public static void selectMenu (int selectMenu, Goods goods) throws InterruptedException {
        goods.names.clear();
        goods.explanations.clear();
        goods.prices.clear();
        // 해당 메뉴의 상품리스트를 보여주기
        switch(selectMenu) {
            case 1:
                String[] burgerNames = {"ShrimpExtremeLemonCream", "BulgogiExtremeSquid", "BulgogiBacon", "DoubleChickenBurger", "KoreanBeefBulgogi", "ShrimpBurger", "TeriBugger", "HotCrispyBurger"};
                String[] burgerExplanations = {"트렌디한 새우 요리를 새우버거에 접목! 탱글한 통새우튀김과 상큼한 레몬크림마요의 조화",
                        "롯데리아 불고기에는 한계란 없다! 대표제품과 이슈제품의 만남, 불고기버거X매콤한오징어버거",
                        "베이컨+토마토로 더욱 풍성해진 맛과 볼륨감의 불고기버거 업그레이드 한정판",
                        "두 장의 패티가 이루는 조화로운 맛에 든든함까지 추가된 더블버거 시리즈",
                        "브리오쉬번에 국내산 한우를 사용한 패티, 신선한 야채, 특제소스로 완성한 프리미엄 햄버거",
                        "새우살을 가득넣어 더 맛있어진 오리지널 새우버거",
                        "쇠고기패티에 달콤 짭짤한 데리소스를 더한 가성비 버거",
                        "닭가슴살 패티로 만든 매콤 화끈한 프리미엄 치킨버거"
                };
                int[] burgerPrices = {6900, 6900, 5800, 5500, 8400, 4700, 3300, 5900};
                goods.addGoods(burgerNames, burgerExplanations, burgerPrices);
                System.out.println("\u001B[32m \"롯데리아 Hamburger 에 오신걸 환영합니다.\" \u001B[0m\n" + "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
                goods.addSpacePrint();
                selectGoods(goods);
                break;
            case 2:
                String[] dessertNames = {"Potato", "SeasonedPotatoes", "CheeseStick", "ChickenNuggets", "WholeSquidRing", "CornSalad", "ShakeShakeChicken", "MozzaCreamCheeseBall"};
                String[] dessertExplanations = {"바로 튀겨낸 바삭바삭한 후렌치 포테이토",
                        "시즈닝(오니언, 치즈, 칠리)을 한가지를 선택해 뿌려먹는 포테이토",
                        "통모짜렐라치즈에 튀김옷을 입혀 만든 바삭하고 고소한 롯데리아 대표 디저트 메뉴",
                        "닭안심살과 닭가슴살로 만든 담백하고 촉촉한 치킨너겟 - 5조각",
                        "통오징어로 리얼한 식감과 풍미가 가득한 디저트 (잠발라야 소스 1개 기본제공) ㆍ오징어껍질이 포함되어 있습니다.",
                        "싱싱한 야채와 상큼한 드레싱이 어우러진 옥수수샐러드",
                        "시즈닝(오니언, 치즈, 칠리)을 한가지를 선택해 뿌려먹는 치킨 디저트 - 10조각",
                        "달콤하고 고소한 모짜크림치즈가 가득한 치즈볼"
                };
                int[] dessertPrices = {1800, 2300, 2400, 2700, 2600, 1900, 2900, 2300};
                goods.addGoods(dessertNames, dessertExplanations, dessertPrices);
                System.out.println("\u001B[32m \"롯데리아 Dessert 에 오신걸 환영합니다.\" \u001B[0m\n" + "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
                goods.addSpacePrint();
                selectGoods(goods);
                break;
            case 3:
                String[] chickenNames = {"FireWing", "ChickenFillet", "FamilyPack", "HalfPackOfBonelessChicken(11Pieces)", "FullPackOfBonelessChicken(22Pieces)", "ChickenHalfPack(4Pieces)", "ChickenFullPack(9Pieces)", "1 piece of chicken"};
                String[] chickenExplanations = {"담백한 맛과 매콤한 맛이 잘 조화된 특별한 타입의 치킨 ※원산지, 영양성분, 알레르기 정보는 매장 내 고지물 확인바랍니다.",
                        "담백한 안심살의 Chicken fillet와 롯데리아만의 독특한 소스가 어우러진 디저트 메뉴",
                        "신선한 치킨을 사용하여 부드럽고, 담백함과 매콤한 맛이 잘 어우러진 후라이드 치킨 ※원산지, 영양성분, 알레르기 정보는 매장 내 고지물 확인바랍니다.",
                        "바삭한 외피와 육즙 가득한 닭다리살 순살치킨 11조각 + 소스1개",
                        "바삭한 외피와 육즙 가득한 닭다리살 순살치킨 22조각 + 소스2개",
                        "신선한 치킨을 사용하여 부드럽고, 담백함과 매콤한 맛이 잘 어우러진 후라이드 치킨",
                        "신선한 치킨을 사용하여 부드럽고, 담백함과 매콤한 맛이 잘 어우러진 후라이드 치킨",
                        "담백함과 매콤한맛의 후라이드 치킨(부위랜덤)"
                };
                int[] chickenPrices = {3100, 3100, 14800, 9800, 16800, 10500, 20000, 2800};
                goods.addGoods(chickenNames, chickenExplanations, chickenPrices);
                System.out.println("\u001B[32m \"롯데리아 Chicken 에 오신걸 환영합니다.\" \u001B[0m\n" + "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
                goods.addSpacePrint();
                selectGoods(goods);
                break;
            case 4:
                String[] beveragetNames = {"Cola", "Cider", "IcedTea", "Lemonade", "Americano", "CafeLatte", "Milk", "HotChocolate"};
                String[] beverageExplanations = {"톡 쏘는 시원 상쾌한 펩시콜라",
                        "톡 쏘는 시원 청량한 칠성사이다",
                        "달콤한 복숭아 맛의 시원한 아이스 드링크",
                        "상큼한 레몬 맛과 톡 쏘는 탄산의 청량함이 느껴지는 시원한 아이스 드링크",
                        "공정무역 커피 원두를 사용한 HOT아메리카노(고카페인 함유) ※어린이,임산부,카페인 민감자는 섭취에 주의 바랍니다.",
                        "공정무역 커피로 만든 에스프레소에 우유를 넣어 만든 HOT 카페라떼 (고카페인 함유, 멸균우유사용) ※어린이,임산부,카페인 민감자는 섭취에 주의 바랍니다.",
                        "신선한 우유",
                        "달콤한 초코를 따뜻하게 즐길 수 있는 음료 *매장마다 영양성분, 알러지 정보가 상이할수 있으므로 매장내 고지물 확인 바랍니다."
                };
                int[] beveragePrices = {2000, 2000, 2300, 2700, 2500, 3000, 1500, 2500};
                goods.addGoods(beveragetNames, beverageExplanations, beveragePrices);
                System.out.println("\u001B[32m \"롯데리아 Beverage/Coffee 에 오신걸 환영합니다.\" \u001B[0m\n" + "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
                goods.addSpacePrint();
                selectGoods(goods);
                break;
            default:
                break;
        }
    }

    // 상품을 선택한 경우
    public static void selectGoods (Goods goods) throws InterruptedException {
//        Scanner sc = new Scanner(System.in);
        int selectNum = sc.nextInt();
        goods.selectGoodsPrint(selectNum);
        int selectCheckOrCancleNum = sc.nextInt();
        while (true) {
            if (selectCheckOrCancleNum == 1) {
                // 주문
                selectGoodsToShoppingbag(goods, selectNum);
                break;
            } else if (selectCheckOrCancleNum == 2) {
                // 취소
                mainMenu(goods);
                break;
            } else {
                System.out.println("1~2까지 번호를 선택해주세요.");
                selectCheckOrCancleNum = sc.nextInt();
            }
        }
    }

    // 선택한 상품을 장바구니에 추가한 경우
    public static void selectGoodsToShoppingbag (Goods goods, int selectNum) throws InterruptedException {
        String name = goods.names.get(selectNum - 1);
        String explanation = goods.explanations.get(selectNum - 1);
        int price = goods.prices.get(selectNum - 1);
        // 선택한 상품 장바구니에 넣고 추가되었다는 메세지 출력하기
        goods.putShoppingbag(name, explanation, price);
        // 메인 화면으로 이동
        mainMenu(goods);
    }

    // Order를 선택한 경우
    public static void selectOrder (Goods goods) throws InterruptedException {
//        Scanner sc = new Scanner(System.in);
        System.out.println("아래와 같이 주문 하시겠습니까\u001B[33m?\u001B[0m\n\n" +
                "[ Orders ]");
        int totalPrice = goods.order.printOrderGoods();
        System.out.println("\n[ Total ]\n" + "\u001B[31m" + totalPrice + "\u001B[0m 원\n");
        System.out.println("\u001B[35m 1. \u001B[0m주문        \u001B[35m 2. \u001B[0m메뉴판");
        int selectOrderOrMenuNum = sc.nextInt();
        while (true) {
            if (selectOrderOrMenuNum == 1) {
                // 주문
                goods.order.orderComplete(waitingNum);
                goods.order.cancleOrder();
                waitingNum++;
                mainMenu(goods);
                break;
            } else if (selectOrderOrMenuNum == 2) {
                // 메뉴판
                mainMenu(goods);
                break;
            } else {
                System.out.println("1~2까지 번호를 선택해주세요.");
                selectOrderOrMenuNum = sc.nextInt();
            }
        }
    }

    // Cancle를 선택한 경우
    public static void selectCancle (Goods goods) throws InterruptedException {
        System.out.println("진행하던 주문을 취소하시겠습니까 \u001B[33m?\u001B[0m");
        System.out.println("\u001B[35m 1. \u001B[0m확인        \u001B[35m 2. \u001B[0m취소");
        int selectCheckOrCancleNum = sc.nextInt();
        while (true) {
            if (selectCheckOrCancleNum == 1) {
                // 주문 취소
                goods.order.cancleOrder();
                mainMenu(goods);
                break;
            } else if (selectCheckOrCancleNum == 2) {
                // 취소
                mainMenu(goods);
                break;
            } else {
                System.out.println("1~2까지 번호를 선택해주세요.");
                selectCheckOrCancleNum = sc.nextInt();
            }
        }
    }
}


// 나중에 추가할 사항!!!
// 출력화면에서 숫자가 아닌 것을 입력했을 경우 Exception 처리하기
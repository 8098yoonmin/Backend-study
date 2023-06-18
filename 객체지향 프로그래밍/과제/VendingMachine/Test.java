import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*** Caffe 메뉴 ***");
		System.out.println("1. 아메리카노 - 1500원");
		System.out.println("2. 카페라떼 - 2000원");
		System.out.println("3. 모카치노 - 4000원");
		System.out.println("4. 핫초코 - 3500원");
		System.out.println("5. 아이스아메리카노 - 2000원");
		System.out.println("6. 아이스카페라떼 - 2500원");
		System.out.println("7. 아이스초코 - 4000원");
		System.out.println("8. 복숭아아이스티 - 3500원");
        
        System.out.print("위 메뉴 중 하나를 선택하세요. : ");
        String menu = sc.next();

        System.out.print("( 현금 / 신용카드 / 온라인결제 ) 중 결제 방식을 선택해주세요. : ");
        String pay = sc.next();
        System.out.print("결제 금액을 입력하세요. : ");
        int amount = sc.nextInt();


        VendingMachine machine = new ItVending();
        machine.makeDrink(menu, pay, amount);


    }
}

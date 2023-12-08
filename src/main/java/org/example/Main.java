package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<WiseSaying> wiseSayingList = new ArrayList<>();
        int id = 1;

        System.out.println("====명언 앱 ====");
        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();

            if (command.equals("종료")) {
                break;
            } else if (command.equals("입력")) {
                System.out.print("작가 : ");
                String author = sc.nextLine();
                System.out.print("명언 : ");
                String content = sc.nextLine();

                System.out.println(id + "번 명언이 입력되었습니다.");

                WiseSaying wiseSaying = new WiseSaying(id, author, content);
                wiseSayingList.add(wiseSaying);
                id++;

            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                for (WiseSaying wiseSaying : wiseSayingList) {
                    System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
                }
            } else if (command.equals("삭제")) {
                System.out.println("삭제할 번호를 입력하세요");
                int removeId = Integer.parseInt(sc.nextLine());

                for (int i = 0; i < wiseSayingList.size(); i++) {
                    if (wiseSayingList.get(i).getId() == removeId) {
                        wiseSayingList.remove(wiseSayingList.get(i));
                    }

                    System.out.println(removeId + "번 목록 삭제 되었습니다.");
                }
            } else if (command.equals("수정")) {
                System.out.println("수정할 번호를 입력하세요.");

                int modifyId = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < wiseSayingList.size(); i++) {
                    if (wiseSayingList.get(i).getId() == modifyId) {
                        WiseSaying wiseSaying = wiseSayingList.get(i);

                        System.out.println("현재 작가 : " + wiseSaying.getAuthor());
                        System.out.print("수정 작가 : ");
                        String author = sc.nextLine();
                        wiseSaying.setAuthor(author);

                        System.out.println("현재 명언 : " + wiseSaying.getContent());
                        System.out.print("수정 명언 : ");
                        String content = sc.nextLine();
                        wiseSaying.setContent(content);

                        System.out.println(modifyId + "번 수정이 완료되었습니다.");

                    }
                }
            }
        }
    }
}



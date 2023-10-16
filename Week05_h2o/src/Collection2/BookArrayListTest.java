package Collection2;
import java.util.Scanner;

public class BookArrayListTest {

    public static void main(String[] args) {
        BookArrayList bookArrayList = new BookArrayList();
        Scanner scanner = new Scanner(System.in);

        Book book1 = new Book(0001, "파우스트");
        Book book2 = new Book(0002, "황무지");
        Book book3 = new Book(0003, "변신");
        Book book4 = new Book(0004, "픽션들");
        Book book5 = new Book(0005, "롤스토이");

        bookArrayList.addBook(book1);
        bookArrayList.addBook(book2);
        bookArrayList.addBook(book3);
        bookArrayList.addBook(book4);
        bookArrayList.addBook(book5);

        bookArrayList.showAllBook(); // 전체 책 출력

        // 키보드로 위치, 책 ID, 책 제목 입력 받아서 추가
        System.out.print("추가할 도서 위치 입력: ");
        int insertIndex = scanner.nextInt();
        System.out.print("도서 ID 입력: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리
        System.out.print("도서 제목 입력: ");
        String title = scanner.nextLine();

        Book newBook = new Book(bookId, title);
        bookArrayList.insertBook(insertIndex, newBook);

        bookArrayList.showAllBook(); // 전체 책 출력

        scanner.close();
    }
}

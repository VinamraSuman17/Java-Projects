import java.util.*;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;
    public boolean setAvailable;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    // getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // setter
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

class Member {
    private String name;
    private String memberID;
    private Book[] borrowedBooks;
    private static final int MAX_BORROWED_BOOKS = 5;
    private int borrowedcount;

    // yaha se member class hai
    public Member(String name, String memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = new Book[MAX_BORROWED_BOOKS];
        this.borrowedcount = 0;
    }

    // getter
    public String getname() {
        return name;
    }

    public String getMemberId() {
        return memberID;
    }

    // methods to borrow and return books
    public boolean borrowBook(Book book) {
        if (borrowedcount < MAX_BORROWED_BOOKS && book.isAvailable()) {
            borrowedBooks[borrowedcount++] = book;
            book.setAvailable = false;
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        for (int i = 0; i < borrowedcount; i++) {
            if (borrowedBooks[i].equals(book)) {
                // shift the array to fill the gap
                for (int j = i; j < borrowedcount - 1; j++) {
                    borrowedBooks[j] = borrowedBooks[j + 1];
                }
                borrowedBooks[--borrowedcount] = null;
                book.setAvailable(true);
                return true;
            }
        }
        return false;

    }
}

// yaha se loan wali class hai
class Loan {
    private Book book;
    private Member member;
    private Date borrowDate;
    private Date returnDate;

    public Loan(Book book, Member member, Date borrowDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    public Book getBook() {
        return book;
    }

    public Member getmember() {
        return member;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    // setter
    public void setreturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}

class Library {
    private final Book[] books;
    private final Member[] members;
    private int bookCount;
    private int memberCount;
    private static final int MAX_BOOKS = 100;
    private static final int MAX_MEMBERS = 50;

    public Library() {
        books = new Book[MAX_BOOKS];
        members = new Member[MAX_MEMBERS];
        bookCount = 0;
        memberCount = 0;
    }

    public void addBook(String title, String author, String ISBN) {
        if (bookCount < MAX_BOOKS) {
            books[bookCount++] = new Book(title, author, ISBN);

        } else {
            System.out.println("cannot add more books , library is full");
        }
    }

    public void registerMember(String name, String memberID) {
        if (memberCount < MAX_MEMBERS) {
            members[memberCount++] = new Member(name, memberID);
        } else {
            System.out.println("cannot add more members , membership is full.");
        }
    }

    public boolean borrowBook(String memberID, String ISBN) {
        Member member = findMemberById(memberID);
        Book book = findBookByISBN(ISBN);

        if (member != null && book != null && book.isAvailable()) {
            return member.borrowBook(book);
        }
        return false;
    }

    public boolean returnBook(String memberId, String ISBN) {
        Member member = findMemberById(memberId);
        Book book = findBookByISBN(ISBN);

        if (member != null && book != null) {
            return member.returnBook(book);
        }
        return false;
    }

    private Book findBookByISBN(String ISBN) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getISBN().equals(ISBN)) {
                return books[i];
            }
        }
        return null;
    }

    private Member findMemberById(String memberId) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getMemberId().equals(memberId)) {
                return members[i];
            }
        }
        return null;
    }

}

public class LibrarymanagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "123456789");
        library.addBook("1984", "George Orwell", "987654321");

        // Registering members
        library.registerMember("Alice", "M001");
        library.registerMember("Bob", "M002");

        // Borrowing books
        boolean success = library.borrowBook("M001", "123456789");
        System.out.println("Borrowing successful: " + success);

        // Returning books
        success = library.returnBook("M001", "123456789");
        System.out.println("Returning successful: " + success);
    }

}

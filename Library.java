import java.util.Scanner;

class Librarymanagement{
    String[] books;
    int initialnoofbooks;
    Scanner number=new Scanner(System.in);
    int totalbook;

Librarymanagement(){
    this.books=new String[100];
    this.initialnoofbooks=0;
    this.totalbook=0;

}
    public void openLibrary(){

        System.out.println("Enter a Number for Execution");
        System.out.println("1.Available book");
        System.out.println("2.Add Book in library");

        System.out.println("3.Issued Book");
        System.out.println("4.Search Book You want");
        System.out.println("5.Exit");;
        int usernumber=number.nextInt();

        if(usernumber ==1){
            AvailableBook();
        }else if(usernumber==2){
            addBook();
        }else if(usernumber==3){
            issuedBook();
            openLibrary();
        }else if(usernumber ==4){
            searchbook();
            openLibrary();
        }else if(usernumber==5){
            number.close();
        }


    }
    public void addBook(){

        System.out.println("How many book you want to add ?");
        int bookadd=number.nextInt();
        totalbook=initialnoofbooks+bookadd;
        for(int i=initialnoofbooks;i<totalbook;i++){
            String addbook=number.next();
            this.books[i]=addbook;


        }
        initialnoofbooks=totalbook;
        System.out.println("The "+ bookadd+ " book has been added to the library");
        openLibrary();

    }
public void searchbook(){
    System.out.println("Search the book you want");
    String searchbook=number.next();
    for(int i=0;i<this.books.length;i++){
        if(searchbook.equals(this.books[i])){
            System.out.println("The book is available for issued");
            return ;
        }
    }
    System.out.println("The book is nt in library");
}







public void issuedBook(){
    System.out.println("Enter a  book you want to issue");
    String issuedbook=number.next();

    for(int i=0;i<this.books.length;i++){

        if(issuedbook.equals(this.books[i])){
            System.out.println("The book has been issued");

            this.books[i]=null;
            initialnoofbooks--;
            return;
        }
    }
    System.out.println("The book has already been issued");
    openLibrary();


}

public void AvailableBook(){

    if(initialnoofbooks == 0){
        System.out.println("There is not any book in Library");
        openLibrary();

    }
    for (String book : this.books) {
        if (book == null) {
            continue;
        }
        System.out.println("* " + book);

    }

    openLibrary();


    }
}






public class Library {

    public static void main(String[] args) {
        System.out.println("The Library has been Opened");
        Librarymanagement centralbook=new Librarymanagement();
        centralbook.openLibrary();



    }
}

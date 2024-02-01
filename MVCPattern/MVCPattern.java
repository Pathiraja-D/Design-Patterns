package MVCPattern;


     class Book{
        private String title;
        private String author;

        public String getTitle(){
            return title; 
        }

        public void setTitle(String title){
            this.title = title;
        } 

        public String getAuther(){
            return author;
        }

        public void setAuther(String author){
            this.author = author;
        }
    }

     class BookView{
        public void printBookDetails(Book book){
            System.out.println("Book title is"+book.getTitle());
            System.out.println("Book author is"+book.getAuther());
        }
    }

     class BookController{
        private Book model;
        private BookView view;

        public BookController(Book model,BookView view){
            this.model = model;
            this.view = view;
        }

        public void setBookTitle(String title){
            model.setTitle(title);
        }

        public void setBookAuthor(String author){
            model.setAuther(author);
        }

        public void updateView(){
            view.printBookDetails(model);
        }


    }

    
    public class MVCPattern{
        public static void main(String[] args){
            Book model = new Book();
            BookView view = new BookView();
            BookController controller = new BookController(model,view);

            controller.setBookTitle("Book1");
            controller.setBookAuthor("MySelf");
            controller.updateView();

        }
    }
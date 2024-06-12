package library_project;

public class books 
{
		    private int book_id;
		    private String title;
		    private int author_id;
		    private String isbn;
		    private int publication_year;
		    private boolean available;
	    
		public books() 
		{
			super();
			// TODO Auto-generated constructor stub
		}

		public books(int book_id, String title, int author_id, String isbn, int publication_year, boolean available)
		{
			super();
			this.book_id = book_id;
			this.title = title;
			this.author_id = author_id;
			this.isbn = isbn;
			this.publication_year = publication_year;
			this.available = available;
		}

		public int getBook_id() {
			return book_id;
		}

		public void setBook_id(int book_id) {
			this.book_id = book_id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getAuthor_id() {
			return author_id;
		}

		public void setAuthor_id(int author_id) {
			this.author_id = author_id;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public int getPublication_year() {
			return publication_year;
		}

		public void setPublication_year(int publication_year) {
			this.publication_year = publication_year;
		}

		public boolean isAvailable() {
			return available;
		}

		public void setAvailable(boolean available) {
			this.available = available;
		}
	    		
}

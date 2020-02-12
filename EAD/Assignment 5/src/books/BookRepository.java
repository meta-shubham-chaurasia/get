package books;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class BookRepository {
	
	List<Book> books;
	Connection con=null;

	
	public BookRepository()
	{		
		String url="jdbc:mysql://localhost:3306/books";
		String uname="root";
		String pass="root";	
		try{
		Class.forName("com.mysql.jdbc.Driver");		
		con=DriverManager.getConnection(url,uname,pass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Book> getBooks()
	{
		List<Book> books=new ArrayList<>();
		String queryToDisplayBooks="select * from book";
		try{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(queryToDisplayBooks);
		while(rs.next())
		{
			Book a=new Book();
			a.setId(rs.getInt(1));
			a.setTitle(rs.getString(2));
			a.setWriter(rs.getString(3));
			a.setPublisher(rs.getString(4));
			a.setPublishedYear(rs.getInt(5));
			
			books.add(a);
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return books; 
	}
	
	public Book getBook(String title)
	{
		String queryToDisplayBookByTitle="select * from book where title='"+title+"'";
		Book a=new Book();
		try{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(queryToDisplayBookByTitle);
		if(rs.next())
		{
			a.setId(rs.getInt(1));
			a.setTitle(rs.getString(2));
			a.setWriter(rs.getString(3));
			a.setPublisher(rs.getString(4));
			a.setPublishedYear(rs.getInt(5));			
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a; 
		
	}
	
	public Book getBookById(int id)
	{
		String queryToDisplayBookByID="select * from book where id="+id;
		Book a=new Book();
		try{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(queryToDisplayBookByID);
		if(rs.next())
		{
			a.setId(rs.getInt(1));
			a.setTitle(rs.getString(2));
			a.setWriter(rs.getString(3));
			a.setPublisher(rs.getString(4));
			a.setPublishedYear(rs.getInt(5));			
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a; 
		
	}
	
	public void create(Book a1)
	{
		String queryToCreateBook="insert into book values(?,?,?,?,?)";
		try{
			PreparedStatement st=con.prepareStatement(queryToCreateBook);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getTitle());
			st.setString(3, a1.getWriter());
			st.setString(4, a1.getPublisher());
			st.setInt(5, a1.getPublishedYear());
			
			st.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
	
	public void update(Book a1)
	{
		//String query1="update book set title=?,writer=? where id=? ";
		String queryToUpdateBook="update book set title=?,publishedyear=? where id=?";
		try{
			PreparedStatement st=con.prepareStatement(queryToUpdateBook);
			st.setString(1, a1.getTitle());
			st.setInt(2, a1.getPublishedYear());
			st.setInt(3, a1.getId());			
			st.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

	public void deleteAll() {
		String queryToDeleteBooks="delete from book";
		try{
			PreparedStatement st=con.prepareStatement(queryToDeleteBooks);
			st.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
	}

	public void deleteOne(int id) {
		String queryToDeleteBook="delete from book where id=?";
		try{
			PreparedStatement st=con.prepareStatement(queryToDeleteBook);
			st.setInt(1,id);
			st.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
	



}
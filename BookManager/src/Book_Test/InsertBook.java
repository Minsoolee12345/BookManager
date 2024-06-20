package Book_Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBook 
{
    public static void main(String arg[]) 
    {
        InsertBook insertBook = new InsertBook();
        insertBook.insertBook(1, "AAA", "AA", "A", 100);
        insertBook.insertBook(2, "BBB", "BB", "B", 200);
    }
    
    public void insertBook(int id, String name, String author, String publisher, int price) 
    {
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.getDBConnection();
        
        String sql = "INSERT INTO Book (Book_Id, Book_Name, Book_Author, Book_Publisher, Book_Price) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, author);
            pstmt.setString(4, publisher);
            pstmt.setInt(5, price);
            pstmt.executeUpdate();
            
            System.out.println("책 정보 삽입 성공");
        } 
        
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 
        
        finally 
        {
            try 
            {
                if (conn != null) conn.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }
}

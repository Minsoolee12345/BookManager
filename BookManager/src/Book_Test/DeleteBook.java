package Book_Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBook 
{
    public static void main(String arg[]) 
    {
        DeleteBook deleteBook = new DeleteBook();
        deleteBook.deleteBook(1);
    }
    
    public void deleteBook(int id)
    {
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.getDBConnection();
        
        String sql = "DELETE FROM Book WHERE Book_Id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("책 정보 삭제 성공");
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                if(conn != null) 
                {
                	conn.close();
                }
            } 
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}

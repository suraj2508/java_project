import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_layer {
			  //  --------userlogin_module--------------
	public int DAO_userlogin(Bean b11)
	{
		  try
		  {
			  Connection con = null;
			  int result;	
			  con=DB_conn.getConnection(); 
			  Statement st = con.createStatement();
			  ResultSet rs=st.executeQuery("select * from customer where username='"+b11.getUsername()+"' and password='"+b11.getPassword()+"'");
			  if(rs.next())
			  {
			  	result=rs.getInt(1);
			  }
			  else
			  {
				result=0;
			  }
			  con.close();
			  return result; 
		  }
		  catch(Exception ex)
		  {
			  System.out.println(ex.toString());
			  return 0;
		  }
	}
	
		//  --------adminlogin_module--------------
		  public int DAO_adminlogin(Bean b11)
			{
				  try
				  {
					  Connection con = null;
					  int result;
					  con=DB_conn.getConnection(); 
					  Statement st = con.createStatement();
					  ResultSet rs=st.executeQuery("select * from admin where username='"+b11.getUsername()+"' and password='"+b11.getPassword()+"'");
					  if(rs.next())
					  {
					  	result=1;
					  }
					  else
					  {
						result=0;
					  }
					  con.close();
					  return result; 
				  }
				  catch(Exception ex)
				  {
					  System.out.println(ex.toString());
					  return 0;
				  }	
			}
		  
		//  --------userregister_module--------------
				  public int DAO_userregister(Bean b11)
					{
						  try
						  {
							  Connection con = null;
							  con=DB_conn.getConnection(); 
							  int result;
							  Statement st = con.createStatement();
							  int rs=st.executeUpdate("insert into customer(username,password) values('"+b11.getUsername()+"','"+b11.getPassword()+"')");							  
							  if(rs==1)
							  {
							  	result=1;
							  }
							  else
							  {
								result=0;
							  }
							  con.close();
							  return result; 
						  }
						  catch(Exception ex)
						  {
							  System.out.println(ex.toString());
							  return 0;
						  }	
					}
				  
		//        ----------display products------------------
				  public void dao_displayall()
				  {
					  try {
						  Connection con = null;
						   con=DB_conn.getConnection(); 
						  Statement st = con.createStatement();
						  ResultSet rs=st.executeQuery("select * from mobile");
						 while(rs.next())
						  {
						  	int m_id=rs.getInt(1);
						  	String name=rs.getString(2);
						  	int price=rs.getInt(3);
						  	int stock=rs.getInt(4);
						  	System.out.println(m_id+" "+name+" "+price+" "+stock);
						  	
						  }
						  						
					} catch (Exception ex) 
					  {
						System.out.println(ex.toString());
					  }
					  
				  }
				  
					//  	---------------add to cart---------------------
					public int dao_addtocart(int c_id,int m_id)
					{
						try {
							 Connection con = null;
							  con=DB_conn.getConnection(); 
							  int result;
							  Statement st = con.createStatement();
							  int rs=st.executeUpdate("insert into buys(c_id,m_id) values('"+c_id+"','"+m_id+"')");	
							  
							  if(rs==1)
							  {
							  	result=1;
							  }
							  else
							  {
								result=0;
							  }
							  con.close();
							  return result; 
							
						} catch (Exception ex)
						{
							System.out.println(ex.toString());
							return 0;
						}
					}
					
					// -------------------- buy cart ------------------------
					public int dao_buycart(int c_id,int m_id)
					{
						try {
							 Connection con = null;
							  con=DB_conn.getConnection(); 
							  int result;
							  Statement st = con.createStatement();
							  int rs=st.executeUpdate("update mobile set stock=stock-1 where m_id='"+m_id+"' and stock>0");	
							  
							  if(rs==1)
							  {
							  	result=1;
							  }
							  else
							  {
								result=0;
							  }
							  con.close();
							  return result; 
							
						} catch (Exception ex)
						{
							System.out.println(ex.toString());
							return 0;
						}
					}
					
					// -------------------add Stock----------------------
					public int dao_addtostock(String s_name,int s_price,int s_stock)
					{
						try {
							 Connection con = null;
							  con=DB_conn.getConnection(); 
							  int result;
							  Statement st = con.createStatement();
							  int rs=st.executeUpdate("insert into mobile(m_name,price,stock) values('"+s_name+"','"+s_price+"','"+s_stock+"')");							  
							  if(rs==1)
							  {
							  	result=1;
							  }
							  else
							  {
								result=0;
							  }
							  con.close();
							  return result; 
							
						} catch (Exception ex)
						{
							System.out.println(ex.toString());
							return 0;
						}
					}
					
					//   ------------------display Stock -------------------
					public void dao_displaystock()
					  {
						  try {
							  Connection con = null;
							   con=DB_conn.getConnection(); 
							  Statement st = con.createStatement();
							  ResultSet rs=st.executeQuery("select * from mobile");
							 while(rs.next())
							  {
							  	int m_id=rs.getInt(1);
							  	String name=rs.getString(2);
							  	int price=rs.getInt(3);
							  	int stock=rs.getInt(4);
							  	System.out.println(m_id+" "+name+" "+price+" "+stock);
							  	
							  }
							  						
						} catch (Exception ex) 
						  {
							System.out.println(ex.toString());
						  }
						  
					  }
					
					//        ------------remove stock --------------------
					public int dao_removestock(int m_id,int s)
					{
						try {
							Connection con = null;
							  con=DB_conn.getConnection(); 
							  Statement st = con.createStatement();
							  int rs=st.executeUpdate("update mobile set stock=stock-'"+s+"' where m_id='"+m_id+"'");
							  int result; 
							if(rs==1)
							  {
							  	result=1;
							  }
							  else
							  {
								result=0;
							  }
							  con.close();
							  return result; 
							 
						} catch (Exception ex)
						{
							System.out.println(ex.toString());
							return 0;
						}
					}
					
					//  	---------------display cart ---------------------
					public void dao_displaycart(int c_id)
					{
						try {
							  Connection con = null;
							  con=DB_conn.getConnection(); 
							  Statement st = con.createStatement();
							  ResultSet rs=st.executeQuery("select * from buys natural join mobile where c_id='"+c_id+"'");
							  while(rs.next())
							  {
							  	int m_id=rs.getInt(1);
							  	String name=rs.getString(3);
							  	int price=rs.getInt(4);
							  	int stock=rs.getInt(5);
							  	System.out.println(m_id+" "+name+" "+price+" "+stock);
							  	
							  }
						} catch (Exception ex)
						{
							System.out.println(ex.toString());
						}	
					}
					
					//  	---------------delete from cart---------------------
					public int dao_deletefromcart(int c_id,int m_id)
					{
						try {
							int result;
							Connection con = null;
							  con=DB_conn.getConnection(); 
							  Statement st = con.createStatement();
							  int rs=st.executeUpdate("delete from buys where m_id='"+m_id+"'");
							  if(rs==1)
							  {
							  	result=1;
							  }
							  else
							  {
								result=0;
							  }
							  con.close();
							  return result; 
							 
						} catch (Exception ex)
						{
							System.out.println(ex.toString());
							return 0;
						}
					}
		  
	
}

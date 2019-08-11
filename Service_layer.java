
public class Service_layer {
	DAO_layer dao1 = new DAO_layer(); // to get the data in db
	Bean b1 = new Bean(); // access all values 
	
	//           --------userlogin_module--------------
	public int service_userlogin(String user_name,String pass)
	{
		b1.setUsername(user_name);
		b1.setPassword(pass);
		int result = 0;
		 try
		 {
			 result = dao1.DAO_userlogin(b1); 
			 return result; 
		 }
		 catch(Exception ex)
		 {
			 System.out.println(ex.toString());
			 return 0;
		 }
	}
	
	//  --------adminlogin_module--------------
	public int service_adminlogin(String u_name,String pass)
	{
		b1.setUsername(u_name);
		b1.setPassword(pass);
		int result = 0;
		try
		{
			result = dao1.DAO_adminlogin(b1); 
			return result; 
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
			return 0;
		}
	}
	
	//          --------------userregister-----------------
	public int service_useregister(String username,String password)
	{
		b1.setUsername(username);
		b1.setPassword(password);
		int result = 0;
		try
		{
			result = dao1.DAO_userregister(b1); 
			return result; 
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
			return 0;
		}
	}
	
	//          ---------------display all products---------------------
	public void service_displayall()
	{
		dao1.dao_displayall();
	}
	
	//  	---------------add to cart---------------------
	public int service_addtocart(int c_id,int m_id)
	{
		int result=dao1.dao_addtocart(c_id,m_id);
		return result;
	}
	
	//       -------------buy cart--------------
	public int service_buycart(int c_id,int m_id)
	{
		int result=dao1.dao_buycart(c_id,m_id);
		return result;
	}
	
	//  	---------------display cart ---------------------
	public void service_displaycart(int c_id)
	{
		dao1.dao_displaycart(c_id);	
	}
	
	//  	---------------delete from cart---------------------
	public int service_deletefromcart(int c_id,int m_id)
	{
		int result=dao1.dao_deletefromcart(c_id,m_id);
		return result;
	}
	
	//       ------------ add Stock ---------------
	public int service_addtostock(String s_name,int s_price,int s_stock)
	{
		int result=dao1.dao_addtostock(s_name,s_price,s_stock);
		return result;
	}
	
	//     ------------display stock-----------------
	public void service_displaystock()
	{
		dao1.dao_displaystock();
	}
	
	//      --------------remove stock -------------------
	public int service_removestock(int m_id,int s)
	{
		int result=dao1.dao_removestock(m_id,s);
		return result;
	}

}

import java.util.Scanner;

public class Controller {
	Scanner sc  = new Scanner(System.in);
	Service_layer s1= new Service_layer();	
	
	//           --------userlogin_module--------------
	public int userlogin()
	{
		System.out.println("enter user_name ");
		String user_name = sc.nextLine();
		System.out.println("enter password");
		String pass = sc.nextLine();
		int result = s1.service_userlogin(user_name,pass);
		return result;
	}
	
	// 			 --------adminlogin_module--------------
	public int adminlogin()
	{
		System.out.println("enter user_name ");
		String user_name = sc.nextLine();
		System.out.println("enter password");
		String pass = sc.nextLine();
		int result = s1.service_adminlogin(user_name,pass);
		return result;
	}
	
	//          ---------user register--------------
	public int userregister()
	{
		System.out.println("enter username");
		String username=sc.nextLine();
		System.out.println("enter password");
		String password=sc.nextLine();
		int result=s1.service_useregister(username,password);
		return result;
	}
	
	//         ------------display all mobiles-------------------
	public void displayall()
	{
		s1.service_displayall();
	}
	
	//  	---------------add to cart---------------------
	public int addtocart(int c_id)
	{
		System.out.println("enter product id");
		int m_id=sc.nextInt();
		int result=s1.service_addtocart(c_id,m_id);
		return result;
	}
	
	//      --------------buy cart--------------------------
	public int buycart(int c_id)
	{
		System.out.println("Enter product_id you want to buy");
		int m_id=sc.nextInt();
		int result=s1.service_buycart(c_id,m_id);
		return result;
	}
	
	//  	---------------display cart ---------------------
		public void displaycart(int c_id)
		{
			s1.service_displaycart(c_id);
	}
		
	//  	---------------delete from cart---------------------
	public int deletefromcart(int c_id)
	{
		System.out.println("enter product id");
		int m_id=sc.nextInt();
		int result=s1.service_deletefromcart(c_id,m_id);
		return result;
	}
	
	//       --------------Add to Stock --------------------
	public int addtostock()
	{
		System.out.println("Enter product name and price");
		String s_name=sc.nextLine();
		int s_price=sc.nextInt();
		int s_stock=sc.nextInt();
		int result=s1.service_addtostock(s_name,s_price,s_stock);
		return result;		
	}
	
	//      ---------------Display Stock ---------------
	public void displaystock()
	{
		s1.service_displaystock();
	}
	
	
	//     ---------------Remove Stock  ---------------
	public int removestock()
	{
		System.out.println("Enter stock_id to delete");
		int m_id=sc.nextInt();
		int s=sc.nextInt();
		int result=s1.service_removestock(m_id,s);
		return result;
	}
	
	public static void main(String[] args) {
		do {
			int result,result1,result2;
			Controller c1 = new Controller(); // controller object
			Scanner sc  = new Scanner(System.in);				
			System.out.println("press\n 1:user login\n 2:admin login\n 3:sign_up\n 4:exit");
			int choice = sc.nextInt();
			if(choice==4)
			{
				System.out.println("Thank You");
				break;
			}
			switch (choice) {
			case 1:
				result=c1.userlogin();
				if(result!=0)
				{
					System.out.println("login success");
					do {
						System.out.println("press\n 1:Display all mobiles\n 2:add to cart\n 3:Display mycart\n 4:remove from cart\n 5:Buy\n 6:logout ");
						int choice1 = sc.nextInt();
						if (choice1==6) {
							System.out.println("Succesfully logged out");
							break;
						}
						switch (choice1) {
						case 1:
							c1.displayall();						
							break;
						case 2:
							c1.displayall();
							result1=c1.addtocart(result);
							if(result1==1)
							{
								System.out.println("added to cart successfully");
							}
							break;
						case 3:
							c1.displaycart(result);
							break;
						case 4:
							c1.displaycart(result);
							result1=c1.deletefromcart(result);
							if(result1==1)
							{
								System.out.println("removed from cart successfully");
							}
							else
							{
								System.out.println("Nothing there");
							}
							break;
						case 5:
							c1.displayall();
							result1=c1.buycart(result);
							if(result1==1)
							{
								System.out.println("Buyed");
							}
							else
							{
								System.out.println("Out of stock");
							}
							break;
						default:
							System.out.println("Wrong no");
							break;
								
							
							}
					} while (true);
				}
				break;
			case 2:
				result=c1.adminlogin();
				if(result==1)
				{
					System.out.println("login success");
				//test
					do {
						System.out.println("press 1.Add Stock\n 2.Remove Stock\n 3.Display Stock\n 4.logout");
						int choice2 = sc.nextInt();
						if(choice2==4){
							System.out.println("Succesfully logged out");
							break;
						}
						switch(choice2){
						case 1:
							result2=c1.addtostock();
							if(result2==1)
							{
								System.out.println("added to stock");
							}
							break;
						case 2:
							c1.displaystock();
							result2=c1.removestock();
							if(result2==1)
							{
								System.out.println("removed from stock");
							}
							else
							{
								System.out.println("Nothing there");
							}
							break;
						case 3:
							c1.displaystock();
							break;
						default:
							System.out.println("Wrong no");
							break;
							
						}
						
					}while(true);
				}
				break;
			case 3:
				result=c1.userregister();
				if(result==1)
				{
					System.out.println("signup successfull");
				}
				break;
			default:
				System.out.println("Select Appropriate Field");
				break;
			}
		} while (true);
		
	}
}

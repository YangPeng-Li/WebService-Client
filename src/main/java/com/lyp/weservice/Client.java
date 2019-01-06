package com.lyp.weservice;

import java.util.List;

import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

public class Client {
	public static void main(String[] args) {
		
		HelloWorldService service = new HelloWorldService();
		HelloWorld helloWorld = service.getHelloWorldPort();
		org.apache.cxf.endpoint.Client client=ClientProxy.getClient(helloWorld);
		client.getInInterceptors().add(new LoggingInInterceptor());//Ìí¼Ó In À¹½ØÆ÷ÈÕÖ¾À¹½ØÆ÷
		client.getOutFaultInterceptors().add(new LoggingOutInterceptor());
		
		//System.out.println(helloWorld.say("Hello Lyp"));
		
	/*	User user = new User ();
		user.setUserName("java1234");
		user.setPassword("123456");
		List<Role> roleList = helloWorld.getRoleByUser(user);
		
		for (Role  role: roleList)
		{
			System.out.println(role.getId()+","+role.getRoleName());
		}*/
		MyRoleArray arry =  helloWorld.getRole();
		List<MyRole> roleList= 	arry.item;
		for (int i=0;i<roleList.size();i++)
		{
			MyRole my =  roleList.get(i);
			System.out.print(my.key+":");
			
			for  (Role r: my.getValue())
			{
				System.out.println(r.getId()+","+r.getRoleName());
			}
			System.out.println("============");
			
		}
	}
	
	
}

package com.springbook.biz.userservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.loginservice.user.UserService;
import com.springbook.biz.loginservice.user.UserVO;

public class UserServiceClient {
	public static void main(String[] args) {
		

			
			//스프링 컨에티너에있는 빈을 사용하기 위해 applicationContext.xml 가져옴
			
			AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
			
			//아까 어노테이션해놓은거 빈가져옴 타입 캐스팅..
			UserService userSerive = (UserService)container.getBean("userService");

			int seq = 0;
			String name = "";
			String id = "";
			String password ="";
			String role = "";
			Scanner sc = new Scanner(System.in);
			int i = 0;
			
		


			
		
			System.out.println("데이터 CRUD");
			
		
			
			while(i !=9) {
				UserVO Uvo = new UserVO();
				List<UserVO> userList =  null;			
				UserVO user = new UserVO();
				
				System.out.println("user: " + user.toString());
				System.out.println("Uvo:" + Uvo.toString());
				
				System.out.println("회원조회 : 1");
				System.out.println("회원 추가: 2");
				System.out.println("회원 수정 : 3");
				System.out.println("행  수정 : 4");
				System.out.println("행  삭제 : 5");
				System.out.println("종     료 : 9");
				
				System.out.println("메뉴 입력 : ");
				i= sc.nextInt();
				sc.nextLine();
				
	        switch (i) {
		        case 1:         
		            System.out.println(i + "번 메뉴 getUser");
//		            boardList = boardSerive.getBoardList();
//		            userList = userSerive.getUser();
		         
		            System.out.println("아이디 입력 >>");
		            id = sc.nextLine();
					
		    		System.out.println("비밀번호 입력 >>");
					password = sc.nextLine();
					System.out.println("입력한 id : "+ id);
					System.out.println("입력한 password : "+ password);
					
					Uvo.setId(id);
					Uvo.setPassword(password);
		            
		            user = userSerive.getUser(Uvo);
	    			System.out.println("조회한 회원--->" + user.toString());
		    	
		            System.out.println("==========================================================================================");
		            break;
		        case 2:            
		        	System.out.println(i + "번 메뉴 insertUser");
		        	

					System.out.println("아이디 입력 >>");
		            id = sc.nextLine();
		            Uvo.setId(id);
						
		    		System.out.println("비밀번호 입력 >>");
					password = sc.nextLine();
					Uvo.setPassword(password);
					
					System.out.println("이름 입력 >>");
					name= sc.nextLine();
					Uvo.setName(name);
					
					System.out.println("role 입력 >>");
					role= sc.nextLine();
					Uvo.setRole(role);
						
					
					userSerive.insertUser(Uvo);
					
					System.out.println("==========================================================================================");
		        	
		            break;
		        case 3:            // 3 인 경우
		        	System.out.println(i +" 번 메뉴 : update");
					
					System.out.println("수정할 회원 id >>");

		    		id = sc.nextLine();
		    		Uvo.setId(id);
					sc.nextLine();
					
					
					System.out.println("수정할 회원 password >>");
		    		password = sc.nextLine();
		    		Uvo.setPassword(password);
	    			
					System.out.println("수정할 회원 name >>");
		    		name = sc.nextLine();
		    		Uvo.setName(name);
					
					System.out.println("수정할 회원 id >>");

//		    		userSerive.updateUser(Uvo);
		    		System.out.println("==========================================================================================");
		    		break;
		            
		            
		        case 4:
					System.out.println(i +" 번 메뉴 : update");
					
					System.out.println("수정할 id >>");

		    		seq = sc.nextInt();
		    		Uvo.setId(id);
					sc.nextLine();
					
					
					System.out.println("비밀번호 입력");
		    		password = sc.nextLine();
		    		Uvo.setPassword(password);
	    			
		    		System.out.println("이름 입력");
		    		name = sc.nextLine();
		    		Uvo.setName(name);
					
//		    		userSerive.updateBoard(Bvo);
		    		System.out.println("==========================================================================================");
		    		break;
		    		
		        case 5:
		        	System.out.println("행  삭제 : 5");
					
					System.out.println("삭제할  글번호>>");

		    		seq = sc.nextInt();
//		    		Bvo.setSeq(seq);
					sc.nextLine();
					
//		    		boardSerive.deleteBoard(Bvo);
		    		System.out.println(seq + "행 삭제");
		    		System.out.println("==========================================================================================");

		    		break;
		        case 9:       
		            i = 9;
		            break;
		            
		            
		        }
			}
			System.out.println("종료");
			
			container.close();
		}
	
}

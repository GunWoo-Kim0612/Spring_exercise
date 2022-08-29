package com.springbook.biz.BoardService;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		

		
		//스프링 컨에티너에있는 빈을 사용하기 위해 applicationContext.xml 가져옴
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//아까 어노테이션해놓은거 빈가져옴 타입 캐스팅..
		BoardService boardSerive = (BoardService)container.getBean("BoardService");

		int seq = 0;
		String title = "";
		String content ="";
		String writer = "";
		Scanner sc = new Scanner(System.in);
		int i = 0;



		
	
		System.out.println("데이터 CRUD");
		
	
		
		while(i !=9) {
			BoardVO Bvo = new BoardVO();
			List<BoardVO> boardList =  null;			
		
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("전체조회 : 1");
			System.out.println("1행 조회 : 2");
			System.out.println("행  추가 : 3");
			System.out.println("행  수정 : 4");
			System.out.println("행  삭제 : 5");
			System.out.println("종     료 : 9");
			
			System.out.println("메뉴 입력 : ");
			i= sc.nextInt();
			sc.nextLine();
			System.out.println();
			System.out.println();
			System.out.println();
			
        switch (i) {
	        case 1:         
	        	
	        	
	            System.out.println(i + "번 메뉴 getBoardList");
//	            getBoardList 메소드 매개변수 추가함 
//	            boardList = boardSerive.getBoardList();
	            
	            System.out.println();
	            System.out.println();
	            System.out.println("##########################################################################################");
	            for(BoardVO board : boardList) {
	    			System.out.println("--->" + board.toString());
	    		}
	            System.out.println("##########################################################################################");
	            break;
	        case 2:            
	        	System.out.println(i + "번 메뉴 getBoard ");
	        	
				System.out.println("조회할 seq>>");

	    		seq = sc.nextInt();
	    		Bvo.setSeq(seq);
				sc.nextLine();
				
				Bvo = boardSerive.getBoard(Bvo);
				
				System.out.println();
				System.out.println();
	            System.out.println("##########################################################################################");
				System.out.println(Bvo.toString());
	            System.out.println("##########################################################################################");
	        	
	            break;
	        case 3:            // 3 인 경우
	    		System.out.println(i + " 번메뉴 : insert");
	    		
	    		System.out.println("제목 입력");
	    		title = sc.nextLine();
	    		Bvo.setTitle(title);

	    		
	    		//Transaction test를 위해 추가  START
//	    		System.out.println("seq 입력");
//	    		seq = sc.nextInt();
//	    		sc.nextLine();
//	    		
//	    		Bvo.setSeq(seq);
	    		//Transaction test를 위해 추가  END

	    		
	    		System.out.println("글쓴이 입력");
	    		writer = sc.nextLine();
	    		Bvo.setWriter(writer);

	    		
	    		System.out.println("본문 입력");
	    		content = sc.nextLine();
	    		Bvo.setContent(content);

	    		boardSerive.insertBoard(Bvo);
	    		System.out.println("==========================================================================================");
	            break;
	            
	            
	        case 4:
				System.out.println(i +" 번 메뉴 : update");
				
				System.out.println("수정할 글번호 >>");

	    		seq = sc.nextInt();
	    		Bvo.setSeq(seq);
				sc.nextLine();
				
				
				System.out.println("제목 입력");
	    		title = sc.nextLine();
	    		Bvo.setTitle(title);
    			
	    		System.out.println("본문 입력");
	    		content = sc.nextLine();
	    		Bvo.setContent(content);
				
	    		boardSerive.updateBoard(Bvo);
	    		System.out.println("==========================================================================================");
	    		break;
	    		
	        case 5:
	        	System.out.println("행  삭제 : 5");
				
				System.out.println("삭제할  글번호>>");

	    		seq = sc.nextInt();
	    		Bvo.setSeq(seq);
				sc.nextLine();
				
	    		boardSerive.deleteBoard(Bvo);
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

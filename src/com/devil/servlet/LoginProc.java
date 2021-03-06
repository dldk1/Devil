package com.devil.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devil.dao.UserDAO;
import com.devil.vo.UserVO;

/**
 * Servlet implementation class LoginProc
 */
@WebServlet("/LoginProc")
public class LoginProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginProc() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// userid 와 userpw를 전달받아서
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");		
		// UserVO를 전달해도 되고
		UserVO vo = new UserVO();
		vo.setEmail(email);
		vo.setPw(pw);
		String path = request.getContextPath();
		PrintWriter out=response.getWriter();
		// UserDAO 에 InsertUser 메소드를 만드거처럼
		// UserDAO 클래스 안에 InsertUser 메소드 밑에
		// GetUser 라는 메소드를 만들어서 그 메소드에서
		// DB에서 select 쿼리 문으로 아이디(이메일)과 패스워드를 검색
		// ID가 있는 사용자정보를 받아와서
		// 검색 결과를 비교해서 ID/PW 체크 후
		// 맞으면 맞다라고 하고 페이지 이동
		// 틀리면 틀리다고 하고 다시 로그인
		System.out.println("asdsa");
		try {
			if (UserDAO.GetUser(vo)) {
				// 로그인 성공
				//response.sendRedirect(path + "/main.devil");
				out.println("YES");
			
			} else {
				// 로그인 실패
				//response.sendRedirect(path + "/login.devil");
				out.println("NO");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// userid, userpw만 전달해도 되고
//		try {
//			UserDAO.GetUser(email, pw);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

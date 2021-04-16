package web_gradle_member_mgn.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_member_mgn.dto.Member;
import web_gradle_member_mgn.service.MemberService;

@WebServlet("/joinProcess")
public class JoinProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService service = new MemberService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		/*
		 * String id, String passwd, String name, int age, String gender, String email
		 */
		String id = request.getParameter("id").trim();
		String passwd = request.getParameter("pass").trim();
		String name = request.getParameter("name").trim();
		int age = Integer.parseInt(request.getParameter("age").trim());
		String gender = request.getParameter("gender").trim();
		String email = request.getParameter("email").trim();

		Member member = new Member(id, passwd, name, age, gender, email);
		System.out.println(member);
		service.InsertCustomer(member);

		System.out.println(request.getSession().getAttribute("id"));
		if (request.getSession().getAttribute("id") != null) {
			if (request.getSession().getAttribute("id").equals("admin")) {
				request.getRequestDispatcher("MemberList").forward(request, response);
			}
		} else {
			 response.sendRedirect("loginForm.jsp"); 
			 }

	}

}

package edu.cugb.xg.javaee.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cugb.xg.javaee.bean.Users;
import edu.cugb.xg.javaee.biz.UserService;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step 1 ��ȡ�û��ύ���û����Ϳ���
		String username = request.getParameter("loginName");
		String password = request.getParameter("loginPass");
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		//step 2 ���ݿ���֤�û�
		UserService userserv = new UserService();
		if(userserv.validateUser(user)){
			//��֤ͨ�� ����ת��show.jsp
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}else{
			//�������µ�¼
			response.sendRedirect("login.html");
//			request.getRequestDispatcher("login.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

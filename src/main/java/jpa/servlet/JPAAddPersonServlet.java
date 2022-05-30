package jpa.servlet;
import java.io.IOException;  
import java.util.Random;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.github.javafaker.Faker;
import jpa.entity.Person;

@WebServlet("/jpa/person/add")
public class JPAAddPersonServlet extends JPAService {
	
	private JPAService jpaService;
	
	@Override
	public void init() throws ServletException {
		jpaService = new JPAService();
	}
	
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print("<html>");
		resp.getWriter().print("<head>");
		resp.getWriter().print("</head>");
		
		String name = new Faker().name().lastName();
		int age = new Random().nextInt(30) + 10;		
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		
		jpaService.addPerson(person);
		
		resp.getWriter().print("<p />");
		resp.getWriter().print("Add ok: " + person);		
		resp.getWriter().print("</body>");
		resp.getWriter().println("</html>");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doHandle(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doHandle(req, resp);
	}	
}
package project3;

import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "Servlet_Project", urlPatterns = {"/project.html"})//value = "/Servlet_Project",
public class Servlet_Project extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("Welcome to my page.");

        out.println("<html>\n" +
                "<head>\n" +
                "    <title>Test-Template</title>\n" +
                "</head>\n");

        //end of head


        //start of body


        out.println("<body>\n" +
                "<h1>Welcome to my world</h1>\n" +
                "<table>\n" +
                "    <thead >\n" +
                "    <tr style=\"text-align:left;\">" +
                "<th>Project Code</th>\n" +
                "    <th>Project Name</th>\n" +
                "    <th>Due Dates</th>\n" +
                "    <th>Points</th>\n" +
                "    <th>isCompleted?</th>\n" +
                "</tr>" +
                "    <tbody id=\"tableBody\">\n" );

        //retrieve info from the database
        connectDB con = connectDB.getInstance();
        List<IprojectEntity> projects = con.getProjects();



        for (int i = 0; i < projects.size(); i++) {
            out.println(" <tr>\n" +
                    
                    "                        <td>"+projects.get(i).getProjectCode()+"</td>\n +" +
                    "                        <td>"+projects.get(i).getProjectName()+"</td>\n +" +
                    "                        <td>"+projects.get(i).getDueDates()+"</td>\n " +
                    "                        <td>"+projects.get(i).getPoints()+"</td>\n" +
                    "                        <td>"+projects.get(i).getIsCompleted()+"</td>\n" +
                    "                    </tr>\n ");
        }




            out.println(
                "</table>\n" +
                "\n" +
                "<button onclick=\"addProject()\">Add Project (+)</button>\n" +
                "<button onclick=\"removeProject()\">Remove Project(-)</button>\n" +
                "\n" +
                "\n" +
                "</tbody>\n" +
                "<script src=\"js/basic.js\"></script>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            String pCode = request.getParameter("code");
        String pName = request.getParameter("name");
        String pDate = request.getParameter("date");
        String pPoints = request.getParameter("points");
        String pisCompleted = request.getParameter("isCompleted");
        System.out.println(pDate +"\n\n");
        System.out.println(pDate.getClass()+"\n\n");

        System.out.println(Date.valueOf(pDate)+"\n\n");

        System.out.println(Date.valueOf(pDate).getClass());


        //add info to the database
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        IprojectEntity projects = new IprojectEntity();

        projects.setProjectCode(pCode);
        projects.setProjectName(pName);
        projects.setDueDates(Date.valueOf(pDate));
        projects.setPoints(pPoints);
        projects.setIsCompleted(pisCompleted);

        session.save(projects);
        session.getTransaction().commit();

        //ToDO:This might cause issues
        session.close();

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println( "<script>" +
                "window.location.href = \"http://localhost:8080/Project3_war_exploded/project.html\";" +
                "</script>");
        ;

        //error handling
        /*
        * try
        *
        * */
    }
}

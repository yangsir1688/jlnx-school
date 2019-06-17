package cn.javabs.school.servlet;

import cn.javabs.school.entity.User;
import cn.javabs.school.service.UserService;
import cn.javabs.school.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

    User user = new User();

    UserService userService = new UserServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request,  response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");

        String op = request.getParameter("op");
        switch (op){
            case "userLogin":
                userLogin(request,response);
                break;
            case "userLogout":
                userLogout(request,response);
                break;
            case "addUser":
                addUser(request,response);
                break;
            case "delUser":
                delUser(request,response);
                break;
            case "updateUserView":
                updateUserView(request,response);
                break;
            case "updateUser":
                updateUser(request,response);
                break;
            case "findAllUsers":
                findAllUsers(request,response);
                break;
            case "findUserByLikeName":
                findUserByLikeName(request,response);
                break;
            default:
                System.out.println("没有找到对应的参数");
        }
    }


    /**
     * 用户登录
     * @param request
     * @param response
     */
    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.userLogin(username, password);
        if (user != null){
            request.getSession().setAttribute("USER_SESSION",user);
            request.getRequestDispatcher("/admin/main.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","用户名或者密码不匹配，请核查后登录！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 用户注销
     * @param request
     * @param response
     */
    private void userLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("USER_SESSION");
        request.getRequestDispatcher("/client/index.jsp").forward(request,response);
    }

    /**
     * 添加用户
     * @param request
     * @param response
     */
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (Exception e) {
           throw  new RuntimeException(e);
        }

        int resultRows = userService.addUser(user);
        if (resultRows > 0){
            request.setAttribute("msg","用户添加成功！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","添加用户失败，请核查相关信息！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 删除用户
     * @param request
     * @param response
     */
    private void delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);
        if (userId == 1001){
            request.setAttribute("msg","该用户是超级管理员，不允许被删除！");
            request.getRequestDispatcher("/userServlet?op=findAllUsers").forward(request,response);
        }else{
            int resultRows = userService.delUser(userId);
            if (resultRows > 0){
                request.setAttribute("msg","用户删除成功！");
                request.getRequestDispatcher("/message.jsp").forward(request,response);
            }else{
                request.setAttribute("msg","删除用户失败，请核查相关信息！");
                request.getRequestDispatcher("/message.jsp").forward(request,response);
            }
        }
    }

    /**
     * 修改用户之数据回显
     * @param request
     * @param response
     */
    private void updateUserView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);
        user = userService.findUserById(userId);
        if (user != null){
            request.setAttribute("user",user);
            request.getRequestDispatcher("/admin/editUser.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","修改用户失败，请核查后登录！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 修改用户之提交数据
     * @param request
     * @param response
     */
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            System.out.println(id);
            int userId = Integer.parseInt(id);
            System.out.println(userId);
            user.setId(userId);
            BeanUtils.populate(user,request.getParameterMap());
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }

        int resultRows = userService.updateUser(user);
        if (resultRows > 0){
            request.setAttribute("msg","用户修改成功！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","修改用户失败，请核查相关信息！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 查询所有用户
     * @param request
     * @param response
     */
    private void findAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.findAllUsers();
        if (users.size()>0 && users != null){
            request.setAttribute("users",users);
            request.getRequestDispatcher("/admin/userList.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","用户查询失败！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 根据用户名称模糊查询
     * @param request
     * @param response
     */
    private void findUserByLikeName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("username:"+username+"!!!");
        List<User>  users = userService.findUserByLikeName(username);
        if (users != null){
            request.setAttribute("users",users);
            request.getRequestDispatcher("/admin/userList.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","查询用户失败，请核查后登录！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }


}

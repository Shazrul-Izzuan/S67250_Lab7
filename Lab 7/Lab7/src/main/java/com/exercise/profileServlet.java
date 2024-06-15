package com.exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Profile Servlet
 * Author: ashaz
 */
@WebServlet("/profileServlet")
public class profileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Database connection details
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/CSM3023";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "admin@123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String icno = request.getParameter("icno");
        String firstname = request.getParameter("firstname");

        Connection conn = null;
        PreparedStatement stmt = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load the JDBC driver
            Class.forName(JDBC_DRIVER);

            // Connect to the database
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare SQL query
            String sql = "INSERT INTO userprofile (username, icno, firstname) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, icno);
            stmt.setString(3, firstname);

            // Execute SQL query
            int rows = stmt.executeUpdate();

            // Generate response
            if (rows > 0) {
                out.println("<h2>Profile registered successfully!</h2>");
            } else {
                out.println("<h2>Error registering profile!</h2>");
            }

        } catch (ClassNotFoundException e) {
            out.println("<h2>JDBC Driver not found!</h2>");
            e.printStackTrace(out);
        } catch (SQLException e) {
            out.println("<h2>Database error!</h2>");
            e.printStackTrace(out);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace(out);
            }
        }
    }
}

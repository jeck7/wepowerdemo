package com.wepower.demo.utils;


import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class HttpUtils {

    public static void returnErrorMsg(String msg, HttpServletResponse resp) {
        PrintWriter pw = null;
        try {
            resp.setContentType("text/html");
            pw = resp.getWriter();
            String htmlString = "<html>" +
                    "<head>" +
                    "<title>Error</title>" +
                    "</head>" +
                    "<body>" +
                    "<h1>" + msg + "</h1>" +
                    "<body>" +
                    "</html>";
            pw.write(htmlString);
            pw.close();
        } catch (Exception e) {
            //Do nothing for now
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }


}

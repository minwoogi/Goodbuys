package com.tu.goodsbuy.util;


import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ScriptWriterUtil {

    public static void writeScript(HttpServletResponse response, String msg) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
        writer.println("<script>");
        writer.println("Swal.fire({");
        writer.println("  icon: 'success',"); // 아이콘 타입 (success, error, warning 등)
        writer.println("  title: '알림',"); // 제목
        writer.println("  text: '" + msg + "',"); // 메시지
        writer.println("})");
        writer.println("</script>");

        writer.flush();
        writer.close();
    }


    public static void writeAndRedirect(HttpServletResponse response, String msg, String path) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();

        writer.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>'");
        writer.println("<script>");
        writer.println("Swal.fire({");
        writer.println("  title: '" + msg + "',");
        writer.println("  icon: 'warning',");
        writer.println("  confirmButtonText: 'OK'");
        writer.println("}).then((result) => {");
        writer.println("  if (result.isConfirmed) {");
        writer.println("    location.href='" + path + "';");
        writer.println("  }else{");
        writer.println("    location.href='" + path + "';");
        writer.println("}});");
        writer.println("</script>");

        writer.flush();
        writer.close();

    }

    public static void writeAndRedirectWithConfirmation(HttpServletResponse response, String msg, String path) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
        writer.println("<script>");
        writer.println("Swal.fire({");
        writer.println("  title: '" + msg + "',");
        writer.println("  icon: 'warning',");
        writer.println("  showCancelButton: true,");
        writer.println("  confirmButtonText: '확인',");
        writer.println("  cancelButtonText: '취소'");
        writer.println("}).then((result) => {");
        writer.println("  if (result.isConfirmed) {");
        writer.println(" <% ArticleService.getInstance().   %>     ");
        writer.println("    location.href='" + path + "';");
        writer.println("  } else {");
        writer.println("}});");
        writer.println("</script>");

        writer.flush();
        writer.close();
    }

    public static void writeAndRedirectWithCustomLogic(HttpServletResponse response, String msg, String logic, String path) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
        writer.println("<script>");
        writer.println("Swal.fire({");
        writer.println("  title: '" + msg + "',");
        writer.println("  icon: 'warning',");
        writer.println("  showCancelButton: true,");
        writer.println("  confirmButtonText: '확인',");
        writer.println("  cancelButtonText: '취소'");
        writer.println("}).then((result) => {");
        writer.println("  if (result.isConfirmed) {");
        writer.println(logic);
        writer.println("    location.href='" + path + "';");
        writer.println("  } else {");
        writer.println("}});");
        writer.println("</script>");

        writer.flush();
        writer.close();
    }

    public static void writeSearchPrompt(HttpServletResponse response, String searchMessage, String path) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
        writer.println("<script>");
        writer.println("Swal.fire({");
        writer.println("  title: 'Search',");
        writer.println("  text: '" + searchMessage + "',");
        writer.println("  icon: 'info',");
        writer.println("  input: 'text',");
        writer.println("  inputPlaceholder: 'Enter your search query',");
        writer.println("  showCancelButton: true,");
        writer.println("  confirmButtonText: 'Search',");
        writer.println("  cancelButtonText: 'Cancel',");
        writer.println("  showLoaderOnConfirm: true,");
        writer.println("  preConfirm: (inputValue) => {");
        writer.println("    if (!inputValue) {");
        writer.println("      Swal.showValidationMessage('Please enter something');");
        writer.println("    }");
        writer.println("    return inputValue;");
        writer.println("  }");
        writer.println("}).then((result) => {");
        writer.println("  if (result.isConfirmed && result.value) {");
        writer.println("    const inputValue = result.value;");
        writer.println("    const encodedQuery = encodeURIComponent(inputValue);");
        writer.println("    location.href = '" + path + "' + encodedQuery;");
        writer.println("  } else {");
        writer.println("    location.href = '" + path + "';");
        writer.println("  }");
        writer.println("});");
        writer.println("</script>");

        writer.flush();
        writer.close();
    }


}

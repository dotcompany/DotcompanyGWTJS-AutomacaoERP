package br.com.automacao.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExportServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGetOrPost(req, resp);
	}
	
	private void doGetOrPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		ResponseBean rb = (ResponseBean) Package.receive(req.getInputStream());
//		
//		resp.setHeader("Expires", "0");
//		resp.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
//		resp.setHeader("Pragma", "public");
//		resp.setContentType("text/vnd.ms-excel");
//		resp.addHeader("Content-Disposition", "attachment;filename=Grid.xls");
//		resp.getOutputStream().write(rb.getBytes());
//		resp.getOutputStream().close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGetOrPost(req, resp);
	}
}
package com.ddc.common.demo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ddc.authority.dubbo.service.IUserService;
import com.ddc.authority.dubbo.vo.ResponseVo;
import com.ddc.authority.dubbo.vo.UserVo;

public class BaseController {

	@Autowired
	protected IUserService userService ;

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;

	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {

		String scheme = request.getHeader("X-Forwarded-Proto");
		String base = (null == scheme ? "http" : scheme) + "://" + request.getServerName()
				+ request.getContextPath();
		this.request = request;
		this.request.setAttribute("base",base);
		this.response = response;
		this.session = request.getSession();
	}

	protected UserVo getUser() {
		Object sessionId = request.getSession().getAttribute("sessionId") ;
		ResponseVo vo = userService.getUserInfo(String.valueOf(sessionId));
		return (UserVo)vo.getData();
	}

}

package com.ddc.common.demo.common;

import com.ddc.common.demo.vo.ResultViewObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;

/**
 * @Description: 异常处理器
 * @author harry.zhang
 * @CreateDate:	2018年3月25日
 * @version 1.0
 */
@RestControllerAdvice
public class WebExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResultViewObject handleException(Exception e){
		ResultViewObject resultVO = new ResultViewObject();
		resultVO.setRows(new ArrayList<>());
		resultVO.setTotal(0);
		resultVO.setCode(1);
		resultVO.setDefaultMessage("服务器异常");
		return resultVO;
	}
	
}

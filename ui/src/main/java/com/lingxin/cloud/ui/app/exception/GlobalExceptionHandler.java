package com.lingxin.cloud.ui.app.exception;

import com.alibaba.fastjson.JSON;
import com.lingxin.cloud.app.common.result.JsonReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mr_Li on 2016/9/24.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    public String save(Model model, HttpServletRequest request, Exception e) {
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setCode(JsonReturn.ERROR_CODE);
        jsonReturn.setMsg("访问uri:" + request.getRequestURI() + "时,系统出故障了...正在检修中....");
        jsonReturn.setData(e.getMessage() + "--------" + JSON.toJSONString(e.getStackTrace()));
        model.addAttribute("errorInfo", jsonReturn);
        logger.info(JSON.toJSONString(jsonReturn));
        return "error";
    }
}

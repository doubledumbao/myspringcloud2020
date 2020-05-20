package com.example.springcloud.common;

import com.alibaba.fastjson.JSON;
import com.example.springcloud.entity.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@ControllerAdvice
public class CommonExceptionAdvice {


    @ExceptionHandler(Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

        /** 构建向前端响应的消息对象**/
        CommonResult errMsg = new CommonResult(400,e.getMessage());
        /** 构建视图，将消息对象以JSON形式发出**/
        ModelAndView mav = new ModelAndView();
        View view = new AbstractView() {
            @Override
            protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
                PrintWriter out = httpServletResponse.getWriter();
                out.print(JSON.toJSONString(errMsg));
            }
        };
        mav.setView(view);
        return mav;
    }
}

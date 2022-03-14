package hello.exception.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        log.info("call resolver", ex);

        try {
            if(ex instanceof IllegalArgumentException) {
                log.info("IllegalArgumentException resolver to 400");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
                return new ModelAndView();
            }
        } catch (IOException e) {
            log.error("resolver ex", e);
        }

        // 반환값에 따른 동작 방식
        // 빈 ModelAndView : 뷰를 렌더링하지 않고 정상 흐름으로 서블릿이 리턴
        // ModelAndView 지정 : View, Model등의 정보를 지정해서 반환하면 뷰를 렌더링
        // null : 다음 ExceptionResolver를 찾아서 실행. 만약 처리할 수 있는 ExceptionResolver가 없으면 예외 처리가 안되고, 기존에 발생한 예외를 서블릿 밖으로 던짐
        return null;
    }
}

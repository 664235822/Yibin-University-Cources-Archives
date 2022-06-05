package interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/*
*     自定义拦截器类需要实现HandlerInterceptor接口或继承HandlerInterceptorAdapter类，
* */
public class MyInteceptor implements HandlerInterceptor{
	/**
	 * 重写preHandle方法在请求发生前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle方法在请求发生前执行");
		return true;
	}
	/**
	 * 重写postHandle方法在请求完成后执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle方法在请求完成后执行");
	}
}

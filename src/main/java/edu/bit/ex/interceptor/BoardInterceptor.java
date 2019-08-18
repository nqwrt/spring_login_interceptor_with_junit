package edu.bit.ex.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.bit.ex.vo.MemberVO;

public class BoardInterceptor extends HandlerInterceptorAdapter{

	// preHandle() : ��Ʈ�ѷ����� ���� ����Ǵ� �޼���
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	    throws Exception {
		System.out.println("preHandle ����");
		// session ��ü�� ������
        HttpSession session = request.getSession();
        
        // loginó���� ����ϴ� ����� ������ ��� �ִ� ��ü�� ������
        MemberVO member = (MemberVO) session.getAttribute("member");
          
        if ( member == null ){
            // �α����� �ȵǾ� �ִ� ���������� �α��� ������ �ٽ� ��������(redirect)
            response.sendRedirect(request.getContextPath());
            
            return false; // ���̻� ��Ʈ�ѷ� ��û���� ���� �ʵ��� false�� ��ȯ��
        }
          
        // preHandle�� return�� ��Ʈ�ѷ� ��û uri�� ���� �ǳ� �ȵǳĸ� �㰡�ϴ� �ǹ���
        // ���� true���ϸ� ��Ʈ�ѷ� uri�� ���� ��.
        return true;        
	}

	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
		 	super.postHandle(request, response, handler, modelAndView);
		 	System.out.println("postHandle ����");
	}

}

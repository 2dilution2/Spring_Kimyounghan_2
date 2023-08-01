package hello.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class OrderServiceTest {

	AppConfig appConfig = new AppConfig();
	
	MemberService memberService = appConfig.memberService();
	OrderService orderService = appConfig.orderService();
//	MemberService memberService = new MemberServiceImpl();
//	OrderService orderService = new OrderServiceImpl();
	
	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "itemA", Grade.VIP); 
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
	
}

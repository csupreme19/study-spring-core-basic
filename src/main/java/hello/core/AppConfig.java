package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final ApplicationContext ac;

    @PostConstruct
    public void init() {
        System.out.println(ac);
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository()");
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService()");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("call AppConfig.orderService()");
        return new OrderServiceImpl(memberRepository, discountPolicy);
    }

}

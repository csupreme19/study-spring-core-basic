package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 회원은 10% 할인이 적용되어야한다.")
    public void discount_vip() throws Exception {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        int discountPrice = discountPolicy.discount(member, 10000);

        // then
        assertThat(discountPrice).as("정률 할인 금액이어야한다.").isEqualTo(10000 * 10 / 100);
    }

    @Test
    @DisplayName("일반 회원은 할인 되지 않는다.")
    public void discount_basic() throws Exception {
        // given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        // when
        int discountPrice = discountPolicy.discount(member, 10000);

        // then
        assertThat(discountPrice).as("할인 금액이 0이어야한다.").isEqualTo(0);
    }

}
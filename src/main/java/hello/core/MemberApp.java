package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberApp {

    private static final Logger log = LoggerFactory.getLogger(MemberApp.class);

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        log.info("findMember={}", findMember);
        log.info("member={}", member);
    }
}

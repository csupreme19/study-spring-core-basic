package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static ThreadLocal<Map<Long, Member>> threadLocalStore = new ThreadLocal<>();

    public MemoryMemberRepository() {
        threadLocalStore.set(new HashMap<>());
    }

    @Override
    public void save(Member member) {
        threadLocalStore.get().put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return threadLocalStore.get().get(memberId);
    }
}

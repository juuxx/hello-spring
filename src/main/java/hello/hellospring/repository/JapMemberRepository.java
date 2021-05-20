package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JapMemberRepository implements MemberRepository {
    private final EntityManager em;

    public JapMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) { //pk 기반이 아닌 나머지는 jpql 작성해야함
       List<Member> result =  em.createQuery("select m from Member m where m.name = :name", Member.class)
                                .setParameter("name", name)
                                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) //엔티티 자체를 조회
                .getResultList(); //cmd + opt + n -> inline 단축키
    }
}

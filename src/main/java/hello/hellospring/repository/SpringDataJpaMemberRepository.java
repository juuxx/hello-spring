package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    //JPQL select m from Member m where m.name = ? <- JPQL을 자동으로 생성해줌
    @Override
    Optional<Member> findByName(String name);  //테스트
}

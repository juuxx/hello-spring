package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //스프링 컨테이너가 컨트롤러 객체를 생성해서 스프링에 넣어둠. 스프링이 관리함.
public class MemberController {
    //private final MemberService memberService = new MemberService();
    //여러군데서 다 가져다 쓸 수 있는데 여러개 생성할 필요 없고 하나만 생성해서 공용으로 쓰면 됨
    private final  MemberService memberService;

    @Autowired //스프링 컨테이너에 있는 memberService를 Controller에 연결해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

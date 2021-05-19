package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.MemberForm;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //스프링 컨테이너가 컨트롤러 객체를 생성해서 스프링에 넣어둠. 스프링이 관리함.
public class MemberController {
    //private final MemberService memberService = new MemberService();
    //여러군데서 다 가져다 쓸 수 있는데 여러개 생성할 필요 없고 하나만 생성해서 공용으로 쓰면 됨
    private final MemberService memberService;

    @Autowired //스프링 컨테이너에 있는 memberService를 Controller에 연결해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") //url에 직접 치는 건 get 방식 (조회할 때 사용)
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") //form 같은 곳에 넣어서 저장할때 -> post
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("members")
    public String List(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

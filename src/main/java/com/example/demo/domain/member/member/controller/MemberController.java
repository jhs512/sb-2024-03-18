package com.example.demo.domain.member.member.controller;

import com.example.demo.global.rq.Rq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberController {
    private final Rq rq;

    @GetMapping("/dump")
    @ResponseBody
    public Map<String, Object> showDump() {
        return rq.getSessionAttrs();
    }

    @GetMapping("/login")
    @ResponseBody
    public String login() {
        return """
                <form method="POST">
                    <div>
                        <label>아이디</label>
                        <input type="text" name="username">
                    </div>
                    <div>
                        <label>비밀번호</label>
                        <input type="password" name="password">
                    </div>
                    <div>
                        <button type="submit">로그인</button>
                    </div>
                </form>
                """;
    }
}

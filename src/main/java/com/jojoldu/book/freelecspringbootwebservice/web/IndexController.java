package com.jojoldu.book.freelecspringbootwebservice.web;

import com.jojoldu.book.freelecspringbootwebservice.config.auth.LoginUser;
import com.jojoldu.book.freelecspringbootwebservice.config.auth.dto.SessionUser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;

    @GetMapping("/api/v1/loginUser")
    @ResponseBody
    public ResponseEntity<SessionUser> sessionUserResponseEntity(@LoginUser SessionUser user) {
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
}

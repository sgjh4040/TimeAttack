package kr.co.timeattack.web.account;

import kr.co.timeattack.web.account.dto.AccountDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;

    @GetMapping("/account/list")
    public ModelAndView page(
//            @RequestParam("page") int page,
//            @RequestParam("page") int size,
//            @RequestParam("sort") Stirng[] sort

    @PageableDefault(size = 10, sort = "username", direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView mv = new ModelAndView("account/list");
        Page page = accountService.page(pageable);
        mv.addObject("page", page);
        return mv;
    }


    @GetMapping("/account")
    public ModelAndView account() {
        ModelAndView mv = new ModelAndView("account/list");
        List<AccountDto> list = accountService.list();
        mv.addObject("accounts", list);
        return mv;
    }

    @PostMapping("/account")
    public ModelAndView create(AccountDto dto) {
        ModelAndView mv = new ModelAndView("redirect:/account");
        accountService.create(dto);
        return mv;
    }

}



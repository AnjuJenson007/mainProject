package com.main.project.java.Controller;

import com.main.project.java.Entity.Account;
import com.main.project.java.Entity.User;
import com.main.project.java.Repository.AccountRepository;
import com.main.project.java.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/showAccountForm")
    public String show(Model model) {
        Account account =new Account();
        List<User> user = userRepository.findAll();
            model.addAttribute("userList", user);
            model.addAttribute("account", account);
        return "addAccount";
    }


    @PostMapping("/saveAccount")
    public String saveAccount(Account account) {
        accountRepository.save(account);
        return "redirect:/accountList";
    }

    @GetMapping("/accountList")
    public String AccountList(Model model) {

        List<Account> account = accountRepository.findAll();
        model.addAttribute("account", account);
        return "account";
    }

    @GetMapping("/showAccountFormForUpdate/{id}")
    public String showAccountFormForUpdate(@PathVariable(value = "id") int accountId, Model model) {
        Account account = accountRepository.findById(accountId).get();
        List<User> user = userRepository.findAll();
        model.addAttribute("userList", user);
        model.addAttribute("account", account);
        return "updateAccount";
    }

    @GetMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable(value = "id") int accountId) {
        this.accountRepository.deleteById(accountId);
        return "redirect:/accountList";
    }
}


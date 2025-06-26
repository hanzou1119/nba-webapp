package com.example.nba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.nba.model.Player;
import com.example.nba.service.PlayerService;

@Controller
public class PlayerController {

    private final PlayerService service;

    @Autowired       //(DI)依存性注入のアノテーション
    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping("/players")   //MVCで使われるアノテーション　GETされた時に呼ばれる　HTTPのGETリクエストを処理するメソッドを指定する
    public String listPlayers(Model model) {
        model.addAttribute("players", service.findAll());
        return "list";  // templates/list.html を表示
    }
    @GetMapping("/players/new")
    public String showForm(Model model) {
        model.addAttribute("player", new Player());
        return "form";
    }

    @PostMapping("/players") //POSTされた時に呼ばれる
    public String addPlayer(@ModelAttribute Player player) {
        service.save(player); // サービス経由で保存
        return "redirect:/players"; // 一覧へ戻す
    }
    @GetMapping("/players/{id}")
    public String showDetail(@org.springframework.web.bind.annotation.PathVariable Integer id, Model model) {
        Player player = service.findById(id);
        model.addAttribute("player", player);
        return "detail"; // ← templates/detail.html を表示
    }
    @GetMapping("/players/edit/{id}")
    public String showEditForm(@org.springframework.web.bind.annotation.PathVariable Integer id, Model model) {
        Player player = service.findById(id);
        model.addAttribute("player", player);
        return "form"; // templates/form.html に遷移（新規登録と共通）
    }
    
    
}



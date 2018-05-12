package com.ctu.tqsang.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ctu.tqsang.domain.Categoryquestion;
import com.ctu.tqsang.service.CategoryService;
import com.ctu.tqsang.service.QuestionService;
import com.ctu.tqsang.service.TagService;
import com.ctu.tqsang.service.UserService;
import com.ctu.tqsang.util.Const;

@Controller
public class AppCategoryController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private QuestionService questionService;

    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private TagService tagService;
	
	@GetMapping("/category/{id}/{slug}")
    public String category(Model model, @PathVariable String slug, @PathVariable int id) {
        // Check category exist
        List<Categoryquestion> categories = categoryService.findAll();
        Categoryquestion currentCategory = null;
        for (Categoryquestion category : categories) {
            if (category.getId() == id) {
                currentCategory = category;
                break;
            }
        }
        
        if (currentCategory == null) {
            return "404";
        } else {
        	model.addAttribute("categories", categories);
            model.addAttribute("topUsers", userService.findTopPoint(5));
            model.addAttribute("tags", tagService.findAllApp());
            model.addAttribute("questions", questionService.findAllByCategory(id, 1, Const.QUESTION_PER_PAGE));
            model.addAttribute("currentCategory", currentCategory);
            return "category";
        }
    }

    @GetMapping("/loadMoreByCategory")
    public ModelAndView loadMoreByCategory(Model model, @RequestParam int id, @RequestParam int page) {
        if (page != 1) {
            page = (page - 1) * Const.QUESTION_PER_PAGE + 1;
        }
        
        model.addAttribute("questions", questionService.findAllByCategory(id, page, Const.QUESTION_PER_PAGE));
        return new ModelAndView("questions_fragment");
    }
	
}

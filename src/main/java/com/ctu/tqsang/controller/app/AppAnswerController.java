package com.ctu.tqsang.controller.app;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ctu.tqsang.domain.Answer;
import com.ctu.tqsang.domain.CustomUserDetails;
import com.ctu.tqsang.domain.Question;
import com.ctu.tqsang.domain.User;
import com.ctu.tqsang.domain.Vote;
import com.ctu.tqsang.service.AnswerService;
import com.ctu.tqsang.service.CategoryService;
import com.ctu.tqsang.service.QuestionService;
import com.ctu.tqsang.service.TagService;
import com.ctu.tqsang.service.UserService;
import com.ctu.tqsang.service.VoteService;
import com.ctu.tqsang.util.Const;

@Controller
public class AppAnswerController {
		
	@Autowired
    private UserService userService;
	
	@Autowired
    private QuestionService questionService;

	@Autowired
    private AnswerService answerService;
	
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private TagService tagService;
    
    @Autowired
    private VoteService voteService;
	
	@PostMapping("/question/{idqs}/answer/post")
    public String post(@Valid Answer answer, @PathVariable("idqs") int idqs, BindingResult result, 
    		Model model, RedirectAttributes redirect) {
        Question question = questionService.findOne(idqs);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("topUsers", userService.findTopPoint(5));
        model.addAttribute("tags", tagService.findAllApp());
        model.addAttribute("question", question);
        
        System.out.println("AppAnswerControll: " + answer.getContent());
        
        if (result.hasErrors()) {
            redirect.addFlashAttribute("error", "Answer content is required");
        } else {
        	answer.setQuestion(question);
            answerService.create(answer);
            redirect.addFlashAttribute("success", "Your answer posted");
        }

        return "redirect:/question/" + question.getId() + "/" + question.getSlug();
    }
	
	@GetMapping("/answer/setbest")
	public String setBest(@RequestParam("qid") int qid, @RequestParam("slug") String slug, 
						  @RequestParam("aid") int aid, @RequestParam("uid") int uid) {
		answerService.setBest(qid, aid, uid);
		return "redirect:/question/" + qid + "/" + slug;
	}
	
	/*
	 * aid: answer ID
	 * uid: the owner ID of answer 
	 */
	@GetMapping("/answer/vote")
	@ResponseBody
	public String vote(@RequestParam("aid") int aid, @RequestParam("uid") int uid, 
					   @RequestParam("action") String action) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof CustomUserDetails) {
			Answer answer = answerService.findOneNoFetch(aid);
			User currentUser = ((CustomUserDetails) principal).getUser();
			Vote vote = voteService.findOne(aid, currentUser.getId());
			if (vote == null) {
				voteService.create(new Vote(answer, currentUser));
        	  
				if (action.equals("like")) {
					answerService.upVotes(aid);
					userService.upPoint(uid, Const.VOTE_POINT);
				} else {
					answerService.downVotes(aid);
					userService.downPoint(uid, Const.VOTE_POINT);
				}
        	  
				return "success";
			} else {
				return "voted";
			}
		} 
      
		return "error";
	}
}

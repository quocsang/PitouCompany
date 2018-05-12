package com.ctu.tqsang.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ctu.tqsang.domain.Categoryquestion;
import com.ctu.tqsang.service.CategoryService;

@Component
public class CategoryValidator implements Validator {
	
	@Autowired
	private CategoryService categoryService;

	@Override
	public boolean supports(Class<?> cls) {
		return Categoryquestion.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Categoryquestion category = (Categoryquestion) o;
		
		// Unique category
        Categoryquestion dbCategory = categoryService.findOne(category.getName());
        if (dbCategory != null && dbCategory.getId() != category.getId()) {
            errors.rejectValue("name", "Unique.category.name");
        }
	}
	
}

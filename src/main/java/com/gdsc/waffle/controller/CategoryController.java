package com.gdsc.waffle.controller;

import com.gdsc.waffle.dto.CategoryDto;
import com.gdsc.waffle.service.CategoryService;
import io.swagger.annotations.SwaggerDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SwaggerDefinition
@EnableSwagger2
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> findAll(){
        return categoryService.findAll();
    }


}
package com.gdsc.waffle.controller;

import com.gdsc.waffle.dto.CategoryDto;
import com.gdsc.waffle.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@Api(tags = "카테고리 컨트롤러")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    @ApiOperation(value = "카테고리 목록 전체 조회", notes = "가장 첫 번째로 보여지는 화면")
    public List<CategoryDto> findAll(){
        return categoryService.findAll();
    }


}
package com.gdsc.waffle.service;

import com.gdsc.waffle.dto.CategoryDto;
import com.gdsc.waffle.entity.CategoryEntity;
import com.gdsc.waffle.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto findById(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 카테고리가 존재하지 않습니다."));
        return entityToDto(categoryEntity);
    }

    @Override
    public List<CategoryDto> findAll() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        ArrayList<CategoryDto> categoryDtos = new ArrayList<>();

        for (CategoryEntity categoryEntity : categoryEntities)  categoryDtos.add(entityToDto(categoryEntity));

        return categoryDtos;
    }
}

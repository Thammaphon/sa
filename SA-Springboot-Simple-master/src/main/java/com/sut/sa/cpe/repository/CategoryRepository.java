package com.sut.sa.cpe.repository;

import com.sut.sa.cpe.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByCategoryname(String categoryname);
}
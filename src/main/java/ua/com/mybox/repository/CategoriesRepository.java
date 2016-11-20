package ua.com.mybox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.mybox.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

}

package com.example.Test.repos;

import com.example.Test.model.movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface movieRepos extends JpaRepository<movie, Long> {
}

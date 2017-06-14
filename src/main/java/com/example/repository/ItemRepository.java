package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Items;

public interface ItemRepository extends JpaRepository<Items, Integer> {

}

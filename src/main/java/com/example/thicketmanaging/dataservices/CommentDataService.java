package com.example.thicketmanaging.dataservices;


import com.example.thicketmanaging.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentDataService {

    private final CommentRepository commentRepository;

    public CommentDataService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }



}

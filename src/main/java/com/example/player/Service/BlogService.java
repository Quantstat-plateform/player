package com.example.player.Service;





import com.example.player.Entity.Blog;
import com.example.player.Repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepo blogRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Long id, Blog blogDetails) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));

        blog.setTitle(blogDetails.getTitle());
        blog.setDate(blogDetails.getDate());
        blog.setDescription(blogDetails.getDescription());
        blog.setImageUrl(blogDetails.getImageUrl());

        return blogRepository.save(blog);
    }

    public void deleteBlog(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
        blogRepository.delete(blog);
    }
}

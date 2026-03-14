package com.example.thicketmanaging.controllers;


import com.example.thicketmanaging.dataservices.ProjectDataService;
import com.example.thicketmanaging.entities.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ticket-groups")
public class TicketGroupController {

    private final ProjectDataService projectService;

    public TicketGroupController(ProjectDataService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllTicketGroups() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Optional<Project> getTicketGroupById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping
    public Project createTicketGroup(@RequestBody Project group) {
        return projectService.createProject(group);
    }

    @PutMapping("/{id}")
    public Optional<Project> updateTicketGroup(@PathVariable Long id, @RequestBody Project group) {
        return projectService.updateProject(id, group);
    }

    @DeleteMapping("/{id}")
    public void deleteTicketGroup(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}
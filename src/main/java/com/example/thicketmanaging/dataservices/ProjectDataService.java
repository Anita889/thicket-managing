package com.example.thicketmanaging.dataservices;

import com.example.thicketmanaging.entities.Project;
import com.example.thicketmanaging.repositories.ProjectRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectDataService {

    private final ProjectRepository projectRepository;

    public ProjectDataService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public Optional<Project> updateProject(Long id, Project group) {
        Project project = projectRepository.findById(id).get();
        project.setDescription(group.getDescription());
        project.setName(group.getName());
        projectRepository.save(project);
        return Optional.of(project);
    }
}

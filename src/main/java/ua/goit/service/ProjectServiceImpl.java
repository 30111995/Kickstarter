package ua.goit.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.goit.dao.ProjectDao;
import ua.goit.model.Project;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ProjectServiceImpl implements ProjectService {

  private final ProjectDao projectDao;

  @Autowired
  public ProjectServiceImpl(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  @Override
  public void add(Project entity) {
    projectDao.add(entity);
  }

  @Override
  public Project getById(Integer id) {
    Project project = projectDao.getById(id);
    Hibernate.initialize(project.getCategory());
    Hibernate.initialize(project.getCommentList());
    Hibernate.initialize(project.getPostList());
    Hibernate.initialize(project.getLikeList());
    Hibernate.initialize(project.getUsers());
    return project;
  }

  @Override
  public List<Project> getByUserId(Integer id) {
    return projectDao.getProjectsByUserId(id);
  }

  @Override
  public List<Project> getAll() {
    return projectDao.getAll();
  }

  @Override
  public void update(Project entity) {
    projectDao.update(entity);
  }

  @Override
  public void remove(Integer id) {
    projectDao.remove(id);
  }

  @Override
  public List<Project> getProjectsByCategoryId(Integer categoryId) {    
    List<Project> listProject = projectDao.getProjectsByCategoryId(categoryId);
    List<Project> projectEntity = new ArrayList<>();
    for(Project p:listProject) {
      projectEntity.add(this.getById(p.getId()));
    }
    return projectEntity;
  }
}

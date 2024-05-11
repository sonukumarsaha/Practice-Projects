package com.sonuprojects.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonuprojects.binding.Course;
import com.sonuprojects.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public String upsert(Course course) {
		courseRepo.save(course);
		return "Success";
	}

	@Override
	public Course getById(Integer cid) {
		Optional<Course> findById = courseRepo.findById(cid);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepo.findAll();
	}

	@Override
	public String deleteById(Integer cid) {

		if (courseRepo.existsById(cid)) {
			courseRepo.deleteById(cid);
			return "Delete Success";
		} else {
			return "No Record Found";
		}
	}

}

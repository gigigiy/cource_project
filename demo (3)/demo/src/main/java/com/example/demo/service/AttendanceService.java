package com.example.demo.service;

import com.example.demo.model.Class;
import com.example.demo.model.Student;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Регистрация студента на занятие
    public void registerStudentToClass(Long studentId, Long classId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Class clazz = classRepository.findById(classId).orElseThrow(() -> new RuntimeException("Class not found"));

        clazz.getStudents().add(student);
        classRepository.save(clazz);
    }
}
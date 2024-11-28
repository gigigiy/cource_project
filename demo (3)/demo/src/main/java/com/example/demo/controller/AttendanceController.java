package com.example.demo.controller;

import com.example.demo.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestParam Long studentId, @RequestParam Long classId) {
        try {
            attendanceService.registerStudentToClass(studentId, classId);
            return ResponseEntity.ok("Student registered successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
package com.serverrest15.serverrest15

import org.springframework.web.bind.annotation.*


@RestController
class StudentController(private val studentRepository : StudentRepository) {

    @GetMapping("/students")
    fun getAllStudents() : List<Student> {
        return studentRepository.findAll()
    }

    @PostMapping("/student")
    fun insertStudent(@RequestBody student : Student){
        studentRepository.save(student)
    }

    @GetMapping("/student/{id}")
    fun getStudent(@PathVariable id : Long) : Student {
        return studentRepository.findById(id).get()
    }

    @DeleteMapping("/student/{id}")
    fun deleteStudent(@PathVariable id : Long){
        studentRepository.deleteById(id)
    }
}
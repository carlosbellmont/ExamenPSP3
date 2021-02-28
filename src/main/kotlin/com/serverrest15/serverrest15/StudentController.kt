package com.serverrest15.serverrest15

import org.springframework.web.bind.annotation.*


@RestController
class StudentController(private val studentRepository : StudentRepository) {

    @GetMapping("/students")
    fun getAllStudents() : List<Student> {
        Thread.sleep(1000)
        return studentRepository.findAll()
    }

    @PostMapping("/student")
    fun insertStudent(@RequestBody student : Student){
        Thread.sleep(1000)
        studentRepository.save(student)
    }

    @GetMapping("/student/{id}")
    fun getStudent(@PathVariable id : Long) : Student {
        Thread.sleep(1000)
        return studentRepository.findById(id).get()
    }

    @DeleteMapping("/student/{id}")
    fun deleteStudent(@PathVariable id : Long){
        Thread.sleep(1000)
        studentRepository.deleteById(id)
    }
}
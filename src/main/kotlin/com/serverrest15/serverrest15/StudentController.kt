package com.serverrest15.serverrest15

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.springframework.web.bind.annotation.*


@RestController
class StudentController(private val studentRepository : StudentRepository) {

    @GetMapping("/students")
    fun getAllStudents() : List<Student> {
        val list = studentRepository.findAll()
        return list
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
        GlobalScope.launch {
            delay(1000)
            studentRepository.deleteById(id)
        }
    }
}
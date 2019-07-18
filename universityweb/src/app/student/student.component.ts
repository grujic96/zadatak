import { Component, OnInit } from '@angular/core';
import { Student} from '../_models/student';
import { StudentService } from '../_services/student.service';
import {NgbModal, NgbModalRef, NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import {NgbDateParserFormatter} from '@ng-bootstrap/ng-bootstrap';
import { College } from '../_models/college';
import { CollegeService } from '../_services/college.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
colleges: College[];
college = new College();
students: Student[];
student = new Student();
date: NgbDateStruct;

  constructor(private studentService: StudentService, private collegeService: CollegeService, private parserFormatter: NgbDateParserFormatter) { 
    
  }

  ngOnInit() {
    if(this.college.id === null){
      this.getAllStudents();
    } else {
      this.getStudentsByCollegeId('1');
    }
    this.getAllColleges();
    
  }

  getAllStudents(): void{
    this.studentService.getStudents()
    .subscribe((studentsData) => {this.students = studentsData, console.log(studentsData)});
  }

  getAllColleges(): void{
    this.collegeService.getColleges()
    .subscribe((collegeData) => {this.colleges = collegeData, console.log(collegeData)});
  }

  getStudentsByCollegeId(collegeId: string): void {
    this.collegeService.getStudentsByCollegeId(collegeId)
    .subscribe((studentsData) => {this.students = studentsData, console.log(studentsData)});

  }
  addStudent(): void{
    this.student.birthDate = this.parserFormatter.format(this.date);
    this.studentService.addStudent(this.student)
    .subscribe((response) => {console.log(response)}, (error) => {
      console.log(error);
      this.reset();
      this.getAllStudents();
    });
  }

  private reset(){
    this.student.id = null;
    this.student.name = null;
    this.student.lastname = null;
    this.student.jmbg = null;
    this.student.birthDate = null;
    this.student.address = null;
    this.student.email = null;
    this.student.phoneNumber = null;
    this.college = null;
    this.date = null;
  }

  deleteStudent(bookId: string){
    this.studentService.deleteStudent(bookId)
    .subscribe((response) => { 
      console.log(response);
      this.getAllStudents();
    }, (error) => {
      console.log(error);
      this.getAllStudents();
    });
  }

  getStudentById(studentId: string){
    this.studentService.getStudentById(studentId)
      .subscribe((studentData) => {this.student = studentData; this.date = this.parserFormatter.parse(this.student.birthDate); (error) =>{
        console.log(error);
      }
    });

  }

  onChange(newValue) {
    console.log(newValue);
    this.collegeService.getCollegeById(newValue)
    .subscribe((collegeData) => {this.college = collegeData; (error) =>{
      console.log(error);
    }
  });
    this.getStudentsByCollegeId(newValue);
  }

}

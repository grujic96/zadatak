import {HttpClient, HttpErrorResponse, HttpRequest, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../_models/student';
import {map} from 'rxjs/operators';
import { BlockingProxy } from 'blocking-proxy';
import { College } from '../_models/college';


@Injectable()
export class StudentService{

    constructor(private http: HttpClient){

    }

    getStudents(): Observable<Student[]>{
        return this.http.get('http://localhost:8080/universityapi/api/students/')
        .pipe(map(res => <Student[]> res));
    }

    addStudent(student: Student){
        let body = JSON.stringify(student);
        console.log(body);
        console.log(JSON.parse(JSON.stringify(student))
        );
        if(student.id) { 
            return this.http.put('http://localhost:8080/universityapi/api/student/' + student.id, JSON.parse(JSON.stringify(student)));
        }
        else{
        return this.http.post('http://localhost:8080/universityapi/api/student', JSON.parse(JSON.stringify(student)));
        }

    }

    deleteStudent(studentId: string) {
        return this.http.delete('http://localhost:8080/universityapi/api/student/' + studentId);
    }

    getStudentById(studentId: string): Observable<Student>{
        return this.http.get('http://localhost:8080/universityapi/api/student/' + studentId)
        .pipe(map(res => <Student> res));
    }

}
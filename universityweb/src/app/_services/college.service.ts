import {HttpClient, HttpErrorResponse, HttpRequest, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../_models/student';
import {map} from 'rxjs/operators';
import { BlockingProxy } from 'blocking-proxy';
import { College } from '../_models/college';


@Injectable()
export class CollegeService{

    constructor(private http: HttpClient){

    }

    getColleges(): Observable<College[]>{
        return this.http.get('http://localhost:8080/universityapi/api/colleges/')
        .pipe(map(res => <College[]> res));
    }

    getCollegeById(collegeId: string): Observable<College>{
        return this.http.get('http://localhost:8080/universityapi/api/college/' + collegeId)
        .pipe(map(res => <College> res));
    }

    getStudentsByCollegeId(collegeId: string): Observable<Student[]>{
        return this.http.get('http://localhost:8080/universityapi/api/college/' + collegeId + '/students')
        .pipe(map(res => <Student[]> res));
    }
}
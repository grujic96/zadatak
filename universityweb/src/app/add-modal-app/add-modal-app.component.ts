import { Component, OnInit, Output } from '@angular/core';
import { NgModalModule} from "ng-modal";
import { Student} from '../_models/student';
import { StudentService } from '../_services/student.service';
import {NgbDateParserFormatter} from '@ng-bootstrap/ng-bootstrap';
import { College } from '../_models/college';
import { CollegeService } from '../_services/college.service';
import { StudentComponent } from '../student/student.component';
import { EventEmitter } from 'events';


@Component({ 
  providers: [StudentService, CollegeService],
  selector: 'app-add-modal-app',
  templateUrl: './add-modal-app.component.html',
  styleUrls: ['./add-modal-app.component.css']
})
export class AddModalAppComponent implements OnInit {
show: Boolean;
student: Student;
  constructor(private studentService: StudentService, private collegeService: CollegeService, private parserFormatter: NgbDateParserFormatter) { 
    
  }

  @Output() dontShowModal = new EventEmitter();

  ngOnInit() {
  }

  showModal(): void{

    this.dontShowModal.emit("" + false);
  }

}

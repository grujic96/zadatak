import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentComponent } from './student/student.component';
import { StudentService } from './_services/student.service';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CollegeService } from './_services/college.service';
import { AddModalAppComponent } from './add-modal-app/add-modal-app.component';


@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    AddModalAppComponent
  ],
  imports: [
    NgbModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [StudentService,CollegeService],
  bootstrap: [AppComponent]
})
export class AppModule { }

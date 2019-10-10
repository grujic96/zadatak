import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddModalAppComponent } from './add-modal-app.component';

describe('AddModalAppComponent', () => {
  let component: AddModalAppComponent;
  let fixture: ComponentFixture<AddModalAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddModalAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddModalAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

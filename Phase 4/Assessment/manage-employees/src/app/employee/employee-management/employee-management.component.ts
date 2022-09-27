import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/app/_models';
import { EmployeeService } from 'src/app/_services';

@Component({
  selector: 'app-employee-management',
  templateUrl: './employee-management.component.html'
})
export class EmployeeManagementComponent implements OnInit {
  employeeId: number;
  employeeForm: FormGroup;
  submitted = false;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeForm = this.formBuilder.group({
      id: [{value: null, disabled: true}],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required]
    });
    this.employeeId = Number(this.route.snapshot.params['id']) || null!;
    if(this.employeeId){
      this.patchEmployeeForm(this.employeeId)
    }
  }

  patchEmployeeForm(id: number){
    this.employeeService.get(id).subscribe(employee => this.employeeForm.patchValue(employee))
  }

  get f() { return this.employeeForm.controls; }

  saveEmployee() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.employeeForm.invalid) {
      return;
    }

    if(this.f['id']?.value){
      this.employeeService.update(this.f['id'].value, {
        firstName: this.f['firstName'].value,
        lastName: this.f['lastName'].value,
        email: this.f['email'].value,
        id: this.f['id'].value
      }).subscribe();
    }else{ 
    this.employeeService.add({
      firstName: this.f['firstName'].value,
      lastName: this.f['lastName'].value,
      email: this.f['email'].value,
      id: null!
    }).subscribe();
  }
    this.router.navigate(['/']);
  }

  backToEmployeesList() {
    this.router.navigate(['/']);
  }

  deleteEmployee(){
    this.employeeService.delete(this.employeeId).subscribe();
    this.router.navigate(['/']);
  }

}

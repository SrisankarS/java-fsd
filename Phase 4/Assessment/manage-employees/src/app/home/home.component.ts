import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

import { Employee, User } from '../_models';
import { EmployeeService, AuthenticationService } from '../_services';

@Component({ templateUrl: 'home.component.html' })
export class HomeComponent implements OnInit {
    currentUser: User;
    employees: Employee[];

    constructor(
        private authenticationService: AuthenticationService,
        private employeeService: EmployeeService,
        private router: Router
    ) {
        this.currentUser = this.authenticationService.currentUserValue;
    }

    ngOnInit() {
        this.loadAllEmployees();
    }

    addNewEmployee(){
        this.router.navigate(['/employee-view']);
    }

    viewEmployeeDetails(id: number){
        this.router.navigate([`/employee-view/${id}`]);
    }

    deleteEmployee(id: number) {
        this.employeeService.delete(id)
            .pipe(first())
            .subscribe(() => this.loadAllEmployees());
    }

    private loadAllEmployees() {
        this.employeeService.getAll()
            .subscribe(employees => this.employees = employees);
    }
}
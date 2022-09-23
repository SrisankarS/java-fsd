import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Employee  } from '../_models';

@Injectable({ providedIn: 'root' })
export class EmployeeService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Employee[]>(`http://localhost:3000/employees`);
    }

    get(id: number) {
        return this.http.get<Employee[]>(`http://localhost:3000/employees/${id}`);
    }

    add(employee: Employee) {
        return this.http.post(`http://localhost:3000/employees`, employee);
    }

    update(id: number, employee: Employee) {
        return this.http.put(`http://localhost:3000/employees/${id}`, employee);
    }

    delete(id: number) {
        return this.http.delete(`http://localhost:3000/employees/${id}`);
    }
}
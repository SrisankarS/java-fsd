import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from '../_models';

@Injectable({ providedIn: 'root' })
export class UserService {
    private readonly serviceUrl: string = 'http://localhost:8080/AadhaarApp';
    constructor(private http: HttpClient) { }

    register(user: User) {
        return this.http.post(`${this.serviceUrl}/citizens`, user);
    }
}
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { User } from '../_models';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;

    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')!));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    login(username: any, password: any) {
        return this.http.get<any>(`http://localhost:3000/users?username=${username}&password=${password}`)
            .pipe(map(users => {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                if(users.length > 0 ){
                    localStorage.setItem('currentUser', JSON.stringify(users[0]));
                    this.currentUserSubject.next(users[0]);
                    return users[0];
                }else {
                    throw Error("Username password invalid")
                }
                
            }));
    }

    logout() {
        // remove user from local storage and set current user to null
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null!);
        
    }
}
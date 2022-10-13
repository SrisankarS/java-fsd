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

    login(mobileNumber: any, password: any) {
        return this.http.post<any>(`http://localhost:8080/AadhaarApp/login`, {"mobileNo": mobileNumber, "password": password})
            .pipe(map(res => {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                if(res.message == "Login Success" ){
                    return this.setUserInStorage(res.user, res.authorizationToken);
                }else {
                    throw Error("Username password is invalid")
                }
            }));
    }

    setUserInStorage(newUser: User, token: string) {
        let user = {...newUser, token: token};
        localStorage.setItem('currentUser', JSON.stringify(user));
        this.currentUserSubject.next(user);
        return user;
    }

    logout() {
        // remove user from local storage and set current user to null
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null!);
    }
}
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {AadhaarCard, User} from '../_models';
import {catchError} from "rxjs/operators";
import {AlertService} from "./alert.service";
import {AuthenticationService} from "./authentication.service";
import {Router} from "@angular/router";
import {throwError} from "rxjs";
import {AadhaarResponse} from "../_models/aadhaarResponse";

@Injectable({providedIn: 'root'})
export class CardService {
    private readonly serviceUrl: string = 'http://localhost:8080/AadhaarApp/aadhaarCard';

    constructor(private http: HttpClient,
                private authenticationService: AuthenticationService,
                private router: Router,
                private alertService: AlertService) {
    }

    get(token: string) {
        const httpOptions = {
            headers: new HttpHeaders({
                authorization: token
            })
        };
        return this.http.get<AadhaarResponse>(`${this.serviceUrl}`, httpOptions)
            .pipe(catchError(err => this.errorHandler(err)));
    }

    pending(token: string) {
        const httpOptions = {
            headers: new HttpHeaders({
                authorization: token
            })
        };
        return this.http.get<AadhaarCard[]>(`${this.serviceUrl}/pending`, httpOptions)
            .pipe(catchError(err => this.errorHandler(err)));
    }

    update(user: User, token: string) {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                authorization: token
            })
        };
        return this.http.put<AadhaarResponse>(`${this.serviceUrl}/update`, user, httpOptions)
            .pipe(catchError(err => this.errorHandler(err)));
    }

    duplicate(token: string) {
        const httpOptions = {
            headers: new HttpHeaders({
                authorization: token
            })
        };
        return this.http.get<AadhaarResponse>(`${this.serviceUrl}/duplicate`)
            .pipe(catchError(err => this.errorHandler(err)));
    }

    apply(token: string) {
        const httpOptions = {
            headers: new HttpHeaders({
                authorization: token
            })
        };
        return this.http.get<AadhaarResponse>(`${this.serviceUrl}/apply`)
            .pipe(catchError(err => this.errorHandler(err)))
    }

    approve(aadhaarId: number, token: string) {
        const httpOptions = {
            headers: new HttpHeaders({
                authorization: token
            })
        };
        return this.http.get<AadhaarResponse>(`${this.serviceUrl}/approve?aadhaarRequestId=${aadhaarId}`)
            .pipe(catchError(err => this.errorHandler(err)))
    }

    errorHandler(err: any) {
        this.alertService.clear();
        if (err == 'Token provided with the request is invalid') {
            this.alertService.error(err, true);
            this.authenticationService.logout();
            this.router.navigate(['/login']);
        }
        return throwError(() => err || "server error.");
    }
}
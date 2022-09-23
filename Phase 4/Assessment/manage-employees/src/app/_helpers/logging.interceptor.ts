import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

import { AuthenticationService } from '../_services';

@Injectable()
export class LoggingInterceptor implements HttpInterceptor {
    constructor(private authenticationService: AuthenticationService) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(
            tap(
                response => console.log(response), 
                error => console.log(`request errored out with message ${error.message}`)
            ));
    }
}
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

// used to create fake backend
import { fakeBackendProvider } from './_helpers';

import { AppRoutingModule } from './app-routing.module';
import { JwtInterceptor, ErrorInterceptor } from './_helpers';
import { AppComponent } from './app.component';
import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { AlertComponent } from './_components';
import { LoggingInterceptor } from './_helpers/logging.interceptor';
import { EmployeeManagementComponent } from './employee/employee-management/employee-management.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';


@NgModule({
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        HttpClientModule,
        AppRoutingModule
    ],
    declarations: [
        AppComponent,
        HomeComponent,
        LoginComponent,
        AlertComponent,
        EmployeeManagementComponent,
        ChangepasswordComponent,
   
    ],
    providers: [
        { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
        { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
        { provide: HTTP_INTERCEPTORS, useClass: LoggingInterceptor, multi: true },

        // provider used to create fake backend
        // fakeBackendProvider
    ],
    bootstrap: [AppComponent]
})
export class AppModule { };
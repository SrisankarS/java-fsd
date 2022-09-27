import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../_models';
import { AlertService, UserService, AuthenticationService, EmployeeService } from '../_services';

@Component({
    selector: 'app-changepassword',
    templateUrl: './changepassword.component.html',
    styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {
    updatePasswordForm: FormGroup;
    oldPassword: FormControl;
    newPassword: FormControl;
    cnewPassword: FormControl;
    currentUser: User;


    private userService: UserService;
    
    constructor(
        private fb: FormBuilder, private acct: UserService, private authenticationService: AuthenticationService, private router: Router,private alertService: AlertService) { }

    ngOnInit(): void {
        this.oldPassword = new FormControl('', [Validators.required]);
        this.newPassword = new FormControl('', [Validators.required, Validators.maxLength(15), Validators.minLength(8)]);
        this.cnewPassword = new FormControl('', [Validators.required]);
        this.currentUser = this.authenticationService.currentUserValue;
        this.updatePasswordForm = this.fb.group({
            oldPassword: this.oldPassword,
            newPassword: this.newPassword,
            cnewPassword: this.cnewPassword
        });
    }
    onSubmit() {
       
        console.log("Password", this.updatePasswordForm.value)
        console.log("Username", this.currentUser)
        if (this.updatePasswordForm.value) {
            const { cnewPassword, newPassword } = this.updatePasswordForm.value;
            const { id } = this.currentUser;
            console.log("Password", cnewPassword, newPassword);
            if (cnewPassword !== newPassword) {
                this.alertService.error("Password mismatch");
            } else {
                console.log("Password matched");
                this.acct.update(id, {
                    ...this.currentUser,
                    password: newPassword
                }).subscribe();
                this.alertService.success('Password changed successful, Kindly login again', true);

                this.authenticationService.logout();
                this.router.navigate(['/login']);

            }

        }
       
    }

}



import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AlertService, AuthenticationService, CardService} from "../_services";
import {User} from "../_models";

@Component({
  selector: 'app-aadhaar-details',
  templateUrl: './aadhaar-details.component.html'
})
export class AadhaarDetailsComponent implements OnInit {
  updateForm: FormGroup;
  loading = false;
  submitted = false;
  currentUser: User;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private alertService: AlertService,
              private authenticationService: AuthenticationService,
              private cardService: CardService) {
    this.currentUser = this.authenticationService.currentUserValue;
  }

  ngOnInit(): void {
    this.updateForm = this.formBuilder.group({
      dob: [this.currentUser.dob, Validators.required],
      address: [this.currentUser.address, Validators.required],
      mobileNo: [this.currentUser.mobileNo, [Validators.required, Validators.pattern("^([6-9]{1})([0-9]{9})$")]]
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.updateForm.controls; }

  onSubmit() {
    this.submitted = true;

    // reset alerts on submit
    this.alertService.clear();

    // stop here if form is invalid
    if (this.updateForm.invalid) {
      return;
    }
    this.loading = true;
    this.cardService.update(this.updateForm.value,this.currentUser.token).subscribe(data => {
          this.authenticationService.setUserInStorage(data.aadhaarCard.user, this.currentUser.token);
          this.alertService.success('Aadhaar details updated successful', true);
          this.router.navigate(['/']);
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
        });
  }

}

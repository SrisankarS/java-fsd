import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {User} from '../_models';
import {AlertService, AuthenticationService, CardService} from '../_services';
import {AadhaarCard} from "../_models";

@Component({templateUrl: 'home.component.html'})
export class HomeComponent implements OnInit {
    currentUser: User;
    card: AadhaarCard;
    pendingCards: AadhaarCard[];

    constructor(
        private authenticationService: AuthenticationService,
        private cardService: CardService,
        private alertService: AlertService,
        private router: Router
    ) {
        this.currentUser = this.authenticationService.currentUserValue;
    }

    ngOnInit() {
        if(this.currentUser.admin) {
            this.fetchPendingAadhaarApplications();
        }else {
            this.fetchAadhaarDetails();
        }
    }

    updateAadhaar() {
        this.router.navigate(['/update-aadhaar']);
    }

    applyAadhaar() {
        this.alertService.clear();
        this.cardService.apply(this.currentUser.token)
            .subscribe(res => {
                this.card = res.aadhaarCard;
                this.alertService.success(res.message);
            });
    }

    duplicateAadhaar(){
        this.cardService.duplicate(this.currentUser.token)
            .subscribe(res => {
                this.card = res.aadhaarCard;
                this.alertService.success(res.message);
            });
    }

    approveAadhaar(aadhaarId: number){
        this.cardService.approve(aadhaarId, this.currentUser.token)
            .subscribe(res => {
                this.alertService.success(`${res.message} for user ${res.aadhaarCard.user.name}`);
                this.fetchPendingAadhaarApplications();
            });
    }

    private fetchAadhaarDetails() {
        this.cardService.get(this.currentUser.token)
            .subscribe(res => this.card = res.aadhaarCard);
    }

    private fetchPendingAadhaarApplications(){
        this.cardService.pending(this.currentUser.token)
            .subscribe(cards => this.pendingCards = cards);
    }
}
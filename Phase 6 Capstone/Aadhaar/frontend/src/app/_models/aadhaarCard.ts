import {User} from "./user";

export class AadhaarCard {
    id: number;
    status: string;
    aadhaarNumber: number;
    issueDate: string;
    user: User;
}
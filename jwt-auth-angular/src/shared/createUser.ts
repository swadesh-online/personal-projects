import { Role } from "./role";

export class createUser{

  userId : number;
  emailId : string;
  password : string;
  role : Role;

  constructor(userId : number, emailId : string, password : string, role : Role){

    this.userId = userId;
    this.emailId = emailId;
    this.password = password;
    this.role = role;
  }
}

export class UserDTO{

  userId : number;
  name : string;
  dateOfCreation : Date;
  timeOfCreation : string;

  constructor(userId: number, name : string, dateOfCreation : Date, timeOfCreation : string){

    this.userId = userId;
    this.name = name;
    this.dateOfCreation = dateOfCreation;
    this.timeOfCreation = timeOfCreation;
  }
}

import { DatePipe, Time } from '@angular/common';
import { Component } from '@angular/core';
import { UserService } from 'src/shared/services/user.service';
import { UserDTO } from 'src/shared/UserDTO';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'date-time-ui';

  date!: Date;
  time: string ='';

  user!: UserDTO;

  constructor(private userServ : UserService){

  }

  ngOnInit(){


  }

  checkDate(){

       this.time = new DatePipe('en-US').transform(new Date(), 'yyyy-MM-ddTHH:mm:ss') || '';

      this.user = new UserDTO(45, 'Swadesh', this.date, this.time);

      console.log(this.user);

      this.userServ.getUserObj(this.user).subscribe(resp=>{
        console.log('Returned object from backend : ', resp);

        const formattedTime = new DatePipe('en-Us').transform(resp.timeOfCreation, 'yyyy');
        console.log("formatted : ", formattedTime)
      })
    }



}

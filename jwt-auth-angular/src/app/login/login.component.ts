import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/shared/user';
import { AuthService } from '../../shared/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form !: FormGroup

  user : User;
  constructor(private fb : FormBuilder,
    private authService : AuthService,
    private toasterService : ToastrService,
    private router: Router,) {
    this.user = new User('','');

    sessionStorage.clear();
    }

  ngOnInit(): void {

    this.form = new FormGroup({
      username: new FormControl(''),
      password: new FormControl(''),
    });
  }

  submit(){

  this.user = this.form.value;
    this.authService.login(this.user).subscribe(()=>{


     console.log("logged in");

     this.toasterService.success('Logged in');
     this.router.navigateByUrl('/home');

    },(error)=>{

      this.toasterService.error('Wrong credentials');
    }

    )
  }

  getMessage() : void {

    this.authService.getMessage().subscribe(resp=>{
      console.log(resp);
    });

  }


}

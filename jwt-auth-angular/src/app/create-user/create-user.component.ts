import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/shared/auth.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  createUserForm : FormGroup;
  constructor(private authService : AuthService,
    private router : Router,
    private toastrService : ToastrService) {
    this.createUserForm = new FormGroup({
      emailId: new FormControl(''),
      password: new FormControl(''),
      role : new FormControl('CANDIDATE')
    });
  }

  ngOnInit(): void {

    this.authService.getLoggedInUser().subscribe(resp=>{
      if(resp){
      if(resp.role == 'CANDIDATE'){
        this.toastrService.error('Restricted Access');
        this.router.navigateByUrl('/home');
      }
    }},(error)=>{
      this.toastrService.error('Restricted Access');
      this.router.navigateByUrl('/home');
    }
    )


  }

  submit(){

    this.authService.createUser(this.createUserForm.value).subscribe(resp=>{
      console.log('saved user ', resp);
      this.toastrService.success('User created successfully');
      this.createUserForm.reset();
    })

  }

}

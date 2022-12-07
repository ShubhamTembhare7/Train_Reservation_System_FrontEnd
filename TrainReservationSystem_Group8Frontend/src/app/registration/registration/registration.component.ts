import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { CommonService } from 'src/app/shared/common.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  loginform: FormGroup;
  // user=new User();
  constructor(public rt:Router, public fb: FormBuilder,public commonService:CommonService) { }

  
  ngOnInit(): void {
    this.loginform=this.fb.group({
      id:0,
      firstName:'',
      lastName:'',
      email:['',Validators.required],
      userName:'',
      password:['', Validators.required],
      mobileNumber:'',
      dateOfBirth:'',
      gender:''
    
    });
  }

  registerUserData(user:User){
     if(user.id==0)
     {
      console.log(user)
       this.commonService.addUserRegistration(user).subscribe();
       
       this.rt.navigate(["login"]);
      //  window.location.reload();
     }else
     {
       this.commonService.updateData(user).subscribe();
       
       this.rt.navigate(["admin"]);
     }
  }
 

}

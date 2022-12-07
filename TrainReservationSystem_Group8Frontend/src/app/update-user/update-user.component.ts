import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { CommonService } from '../shared/common.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  constructor(public fb: FormBuilder,public commonService:CommonService,public rt:Router) { }

  registerForm:FormGroup
  
  ngOnInit(): void {
    this.registerForm=this.fb.group({
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

  updateData(user:User){

    if(user.id==0)
    {
      this.commonService.addUserRegistration(user).subscribe();
      
      this.rt.navigate(["login"]);
     //  window.location.reload();
    }else
      {
        this.commonService.updateData(user).subscribe();
        
        this.rt.navigate(["admin"]);
        //  window.location.reload();
      }
    
  }
}
